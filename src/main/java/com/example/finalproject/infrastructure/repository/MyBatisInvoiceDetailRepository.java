package com.example.finalproject.infrastructure.repository;

import com.example.finalproject.core.invoiceDetail.InvoiceDetail;
import com.example.finalproject.core.invoiceDetail.InvoiceDetailRepository;
import com.example.finalproject.infrastructure.mybatis.mapper.InvoiceDetailMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MyBatisInvoiceDetailRepository implements InvoiceDetailRepository {

    @Autowired
    InvoiceDetailMapper invoiceDetailMapper;

    @Override
    public void save(List<InvoiceDetail> invoiceDetailList) {
        invoiceDetailMapper.save(invoiceDetailList);
    }
}
