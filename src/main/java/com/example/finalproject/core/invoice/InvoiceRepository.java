package com.example.finalproject.core.invoice;

import org.springframework.stereotype.Repository;


public interface InvoiceRepository {
    void save(Invoice invoice);
}
