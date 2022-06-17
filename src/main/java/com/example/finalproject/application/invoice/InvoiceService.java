package com.example.finalproject.application.invoice;

import com.example.finalproject.application.invoiceDetail.InvoiceDetailCreateParam;
import com.example.finalproject.application.invoiceDetail.TicketInfo;
import com.example.finalproject.application.premiere.PremiereService;
import com.example.finalproject.application.room.RoomInfo;
import com.example.finalproject.core.cinemas.Cinemas;
import com.example.finalproject.core.cinemas.CinemasRepository;
import com.example.finalproject.core.invoice.Invoice;
import com.example.finalproject.core.invoice.InvoiceRepository;
import com.example.finalproject.core.invoiceDetail.InvoiceDetail;
import com.example.finalproject.core.invoiceDetail.InvoiceDetailRepository;
import com.example.finalproject.core.movies.Movies;
import com.example.finalproject.core.movies.MoviesRepository;
import com.example.finalproject.core.premiere.Premiere;
import com.example.finalproject.core.premiere.PremiereRepository;
import com.example.finalproject.core.rooms.RoomRepository;
import com.example.finalproject.core.seats.Seats;
import com.example.finalproject.core.seats.SeatsRepository;
import com.example.finalproject.core.user.User;
import com.example.finalproject.core.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class InvoiceService {

    @Autowired
    InvoiceDetailRepository invoiceDetailRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    InvoiceRepository invoiceRepository;

    @Autowired
    PremiereRepository premiereRepository;

    @Autowired
    MoviesRepository moviesRepository;

    @Autowired
    SeatsRepository seatsRepository;

    @Autowired
    RoomRepository roomRepository;

    @Autowired
    CinemasRepository cinemasRepository;

    public InvoiceResponse confirmTicket(InvoiceCreateParam invoiceCreateParam) {
        Optional<User> user = userRepository.findById(invoiceCreateParam.getUser_id());
        Invoice invoice = new Invoice(0, invoiceCreateParam.getUser_id(), new Date());
        invoiceRepository.save(invoice);
        InvoiceResponse invoiceResponse = new InvoiceResponse(user, invoice, invoiceCreateParam.getInvoiceDetailCreateParams());
        List<InvoiceDetail> invoiceDetailList = new ArrayList<>();
        for (InvoiceDetailCreateParam createParam :invoiceCreateParam.getInvoiceDetailCreateParams()) {
            InvoiceDetail invoiceDetail = new InvoiceDetail(invoice.getId(), createParam.getPremiere_id(), createParam.getSeat_id(), createParam.getPrice());
            invoiceDetailList.add(invoiceDetail);
        }
        invoiceDetailRepository.save(invoiceDetailList);
        return invoiceResponse;
    }

    public InvoiceResponse getInvoiceAndRelevant(String invoice_id, String user_id) {
        Optional<User> user = userRepository.findById(user_id);
        Invoice invoice = invoiceRepository.getInvoiceAndRelevant(invoice_id);
        List<InvoiceDetail> invoiceDetailList = invoiceDetailRepository.getInvoiceAndRelevant(invoice_id);
        List<InvoiceDetailCreateParam> invoiceDetailCreateParams = new ArrayList<>();
        for (InvoiceDetail invoiceDetail : invoiceDetailList) {
            InvoiceDetailCreateParam invoiceDetailCreateParam = new InvoiceDetailCreateParam();
            invoiceDetailCreateParams.add(invoiceDetailCreateParam.fromInvoiceDetail(invoiceDetail));
        }
        InvoiceResponse invoiceResponse = new InvoiceResponse(user, invoice, invoiceDetailCreateParams);
        return invoiceResponse;
    }

    public String updateInvoiceStatus(InvoiceUpdateParam invoiceUpdateParam) {
        invoiceRepository.updateInvoiceStatus(invoiceUpdateParam);
        return "Success";
    }

    public String deleteInvoiceAndRelevant(String invoice_id) {
        invoiceRepository.deleteInvoiceAndRelevant(invoice_id);
        invoiceDetailRepository.deleteInvoiceAndRelevant(invoice_id);
        return "Success";
    }

    public List<InvoiceHistory> getBuyHistory(User user) {
        List<Invoice> invoiceList = invoiceRepository.getInvoiceByUser(user.getId());
        List<InvoiceHistory> invoiceHistoryList = new ArrayList<>();
        for (Invoice invoice : invoiceList) {
            List<InvoiceDetail> invoiceDetailList = invoiceDetailRepository.getInvoiceAndRelevant(invoice.getId());
            int totalPrice = invoiceDetailRepository.getTotalMoneyByInvoiceId(invoice.getId());
            Premiere premiere = premiereRepository.getPremiereById(invoiceDetailList.get(0).getPremiere_id());
            Movies movie = moviesRepository.findById(premiere.getMovie_id());
            invoiceHistoryList.add(new InvoiceHistory(invoice.getId(), movie.getMovie_name(), movie.getImage_path(), invoice.getCreated_date(), premiere.getEnd_time(),totalPrice));
        }
        return invoiceHistoryList;
    }

    public List<TicketInfo> getTicket(String invoice_id) {
        List<InvoiceDetail> invoiceDetailList = invoiceDetailRepository.getInvoiceAndRelevant(invoice_id);
        List<TicketInfo> ticketInfoList = new ArrayList<>();
        for (InvoiceDetail invoiceDetail : invoiceDetailList) {
            Seats seat_name = seatsRepository.getSeatNameById(invoiceDetail.getSeat_id());
            Premiere premiere = premiereRepository.getPremiereById(invoiceDetail.getPremiere_id());
            Movies movies = moviesRepository.findById(premiere.getMovie_id());
            RoomInfo roomInfo = roomRepository.findRoomById(premiere.getRoom_id());
            Cinemas cinema = cinemasRepository.getCinemaByRoomId(premiere.getRoom_id());
            ticketInfoList.add(new TicketInfo(cinema.getCinema_name(), movies.getMovie_name(), premiere.getStart_time(), roomInfo.getRoom_name(), seat_name.getRows_alphabet()+seat_name.getNumber()));
        }

        return ticketInfoList;
    }
}
