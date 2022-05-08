package com.example.finalproject.infrastructure.mybatis.mapper;

import com.example.finalproject.application.invoice.InvoiceUpdateParam;
import com.example.finalproject.core.invoice.Invoice;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface InvoiceMapper {
    void save(@Param("invoice") Invoice invoice);

    Invoice getInvoiceAndRelevant(@Param("id") String invoice_id);

    void  updateInvoiceStatus(@Param("invoice") InvoiceUpdateParam invoiceUpdateParam);

    void delete(@Param("id") String invoice_id);
}
