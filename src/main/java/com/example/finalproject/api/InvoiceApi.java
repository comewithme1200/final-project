package com.example.finalproject.api;

import com.example.finalproject.application.invoice.InvoiceCreateParam;
import com.example.finalproject.application.invoice.InvoiceResponse;
import com.example.finalproject.application.invoice.InvoiceService;
import com.example.finalproject.application.invoice.InvoiceUpdateParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PutMapping
    public String updateInvoiceStatus(@RequestBody InvoiceUpdateParam invoiceUpdateParam) {
        return invoiceService.updateInvoiceStatus(invoiceUpdateParam);
    }

    @DeleteMapping
    public String deleteInvoiceAndRelevant(@RequestBody String invoice_id) {
        return invoiceService.deleteInvoiceAndRelevant(invoice_id);
    }
}
