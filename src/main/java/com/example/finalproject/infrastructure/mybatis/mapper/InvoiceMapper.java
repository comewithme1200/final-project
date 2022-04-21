package com.example.finalproject.infrastructure.mybatis.mapper;

import com.example.finalproject.core.invoice.Invoice;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface InvoiceMapper {
    void save(@Param("invoice") Invoice invoice);
}
