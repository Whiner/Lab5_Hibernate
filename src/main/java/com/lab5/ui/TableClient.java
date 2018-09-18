package com.lab5.ui;

import com.lab5.db.entities.Client;
import lombok.Data;

import java.util.Date;

@Data
public class TableClient {

    private String fio;
    private String passportNumber;
    private Long phoneNumber;
    private Date arrivalDate;
    private Date departureDate;
    private Date paymentDate;
    private String form;
    private String note;

    private Client client;

    public TableClient(Client client) {
        this.client = client;
        fio = client.getFio();
        passportNumber = client.getPassportNumber();
        phoneNumber = client.getPhoneNumber();
        arrivalDate = client.getArrivalDate();
        departureDate = client.getDepartureDate().getDate();
        paymentDate = client.getPayment().getDate();
        form = client.getPayment().getForm();
        note = client.getPayment().getNote();
    }

    public TableClient() {
    }

    public TableClient(String fio, String passportNumber, Long phoneNumber, Date arrivalDate, Date departureDate, Date paymentDate, String form, String note) {
        this.fio = fio;
        this.passportNumber = passportNumber;
        this.phoneNumber = phoneNumber;
        this.arrivalDate = arrivalDate;
        this.departureDate = departureDate;
        this.paymentDate = paymentDate;
        this.form = form;
        this.note = note;
    }
}
