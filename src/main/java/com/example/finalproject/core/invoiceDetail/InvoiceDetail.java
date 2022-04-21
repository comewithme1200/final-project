package com.example.finalproject.core.invoiceDetail;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
public class InvoiceDetail {
    private String id;
    private String invoice_id;
    private String premiere_id;
    private String seat_id;
    private long price;

    public InvoiceDetail(String invoice_id, String premiere_id, String seat_id, long price) {
        this.id = UUID.randomUUID().toString();
        this.invoice_id = invoice_id;
        this.premiere_id = premiere_id;
        this.seat_id = seat_id;
        this.price = price;
    }
}
