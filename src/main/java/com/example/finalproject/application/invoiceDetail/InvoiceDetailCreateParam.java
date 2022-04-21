package com.example.finalproject.application.invoiceDetail;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InvoiceDetailCreateParam {
    private String premiere_id;
    private String seat_id;
    private long price;
}
