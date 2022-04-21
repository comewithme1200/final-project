package com.example.finalproject.infrastructure.repository;

import com.example.finalproject.core.invoice.Invoice;
import com.example.finalproject.core.invoice.InvoiceRepository;
import com.example.finalproject.infrastructure.mybatis.mapper.InvoiceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MyBatisInvoiceRepository implements InvoiceRepository {

    @Autowired
    InvoiceMapper invoiceMapper;

    @Override
    public void save(Invoice invoice) {
        invoiceMapper.save(invoice);
    }
}
