package com.example.finalproject.application.invoice;

import com.example.finalproject.application.invoiceDetail.InvoiceDetailCreateParam;
import com.example.finalproject.core.invoiceDetail.InvoiceDetail;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InvoiceCreateParam {
    private String user_id;
    private List<InvoiceDetailCreateParam> invoiceDetailCreateParams;
}
