package com.example.finalproject.core.invoiceDetail;

import java.util.List;

public interface InvoiceDetailRepository {
    void save(List<InvoiceDetail> invoiceDetailList);

    List<InvoiceDetail> getInvoiceAndRelevant(String invoice_id);

    void deleteInvoiceAndRelevant(String invoice_id);
}
