package com.example.finalproject.core.invoice;


import com.example.finalproject.application.invoice.InvoiceUpdateParam;

public interface InvoiceRepository {
    void save(Invoice invoice);

    Invoice getInvoiceAndRelevant(String invoice_id);

    void updateInvoiceStatus(InvoiceUpdateParam invoiceUpdateParam);

    void deleteInvoiceAndRelevant(String invoice_id);
}
