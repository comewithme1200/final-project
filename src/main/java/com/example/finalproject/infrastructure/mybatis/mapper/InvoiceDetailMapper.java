package com.example.finalproject.infrastructure.mybatis.mapper;

import com.example.finalproject.core.invoiceDetail.InvoiceDetail;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface InvoiceDetailMapper {
    void save(@Param("invoiceDetails") List<InvoiceDetail> invoiceDetailList);
}
