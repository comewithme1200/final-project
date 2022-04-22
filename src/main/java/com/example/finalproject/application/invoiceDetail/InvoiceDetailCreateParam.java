package com.example.finalproject.application.invoiceDetail;

import com.example.finalproject.core.invoiceDetail.InvoiceDetail;
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

    public InvoiceDetailCreateParam fromInvoiceDetail(InvoiceDetail invoiceDetail) {
        return new InvoiceDetailCreateParam(
          invoiceDetail.getPremiere_id(),
          invoiceDetail.getSeat_id(),
          invoiceDetail.getPrice()
        );
    }
}
