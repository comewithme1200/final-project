package com.example.finalproject.application.invoice;

import com.example.finalproject.application.invoiceDetail.InvoiceDetailCreateParam;
import com.example.finalproject.core.invoiceDetail.InvoiceDetail;
import com.example.finalproject.core.user.User;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.Optional;

@Data
@AllArgsConstructor
public class InvoiceResponse {
    private Optional<User> user;
    private List<InvoiceDetailCreateParam> invoiceDetailCreateParams;
}
