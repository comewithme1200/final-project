package com.example.finalproject.api;

import com.example.finalproject.application.invoice.InvoiceCreateParam;
import com.example.finalproject.application.invoice.InvoiceResponse;
import com.example.finalproject.application.invoice.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/invoice")
public class InvoiceApi {

    @Autowired
    InvoiceService invoiceService;

    @PostMapping
    public InvoiceResponse confirmTicket(@RequestBody InvoiceCreateParam invoiceCreateParam) {
        return invoiceService.confirmTicket(invoiceCreateParam);
    }
}
