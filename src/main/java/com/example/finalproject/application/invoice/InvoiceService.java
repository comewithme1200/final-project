package com.example.finalproject.application.invoice;

import com.example.finalproject.application.invoiceDetail.InvoiceDetailCreateParam;
import com.example.finalproject.core.invoice.Invoice;
import com.example.finalproject.core.invoice.InvoiceRepository;
import com.example.finalproject.core.invoiceDetail.InvoiceDetail;
import com.example.finalproject.core.invoiceDetail.InvoiceDetailRepository;
import com.example.finalproject.core.user.User;
import com.example.finalproject.core.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    public InvoiceResponse confirmTicket(InvoiceCreateParam invoiceCreateParam) {
        Optional<User> user = userRepository.findById(invoiceCreateParam.getUser_id());

        InvoiceResponse invoiceResponse = new InvoiceResponse(user, invoiceCreateParam.getInvoiceDetailCreateParams());
        Invoice invoice = new Invoice(0, invoiceCreateParam.getUser_id());
        invoiceRepository.save(invoice);
        List<InvoiceDetail> invoiceDetailList = new ArrayList<>();
        for (InvoiceDetailCreateParam createParam :invoiceCreateParam.getInvoiceDetailCreateParams()) {
            InvoiceDetail invoiceDetail = new InvoiceDetail(invoice.getId(), createParam.getPremiere_id(), createParam.getSeat_id(), createParam.getPrice());
            invoiceDetailList.add(invoiceDetail);
        }
        invoiceDetailRepository.save(invoiceDetailList);
        return invoiceResponse;
    }
}
