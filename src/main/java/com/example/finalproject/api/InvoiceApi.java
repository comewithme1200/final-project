package com.example.finalproject.api;

import com.example.finalproject.application.invoice.*;
import com.example.finalproject.application.invoiceDetail.TicketInfo;
import com.example.finalproject.core.invoiceDetail.InvoiceDetail;
import com.example.finalproject.core.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/invoice")
public class InvoiceApi {

    @Autowired
    InvoiceService invoiceService;

    @PostMapping
    public InvoiceResponse confirmTicket(@RequestBody InvoiceCreateParam invoiceCreateParam) {
        return invoiceService.confirmTicket(invoiceCreateParam);
    }

    @GetMapping
    public InvoiceResponse getInvoiceAndRelevant(@RequestBody String invoice_id, String user_id) {
        return invoiceService.getInvoiceAndRelevant(invoice_id, user_id);
    }

    @GetMapping("/history")
    public List<InvoiceHistory> getBuyHistoryOfUser(@AuthenticationPrincipal User user) {
        return invoiceService.getBuyHistory(user);
    }

    @GetMapping("/getTicket")
    public List<TicketInfo> getTicket(@RequestParam String invoice_id) {
        return invoiceService.getTicket(invoice_id);
    }

    @PutMapping
    public String updateInvoiceStatus(@RequestBody InvoiceUpdateParam invoiceUpdateParam) {
        return invoiceService.updateInvoiceStatus(invoiceUpdateParam);
    }

    @DeleteMapping
    public String deleteInvoiceAndRelevant(@RequestBody String invoice_id) {
        StringBuffer sb = new StringBuffer(invoice_id);
        sb.delete(invoice_id.length() - 1, invoice_id.length());
        sb.delete(0, 1);
        return invoiceService.deleteInvoiceAndRelevant(sb.toString());
    }
}
