package com.lab5.db.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class Client implements EntityInDb {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String fio;

    private String passportNumber;

    private Long phoneNumber;

    private Date arrivalDate;

    @OneToOne(mappedBy = "client", cascade = CascadeType.ALL)
    private DepartureDate departureDate;

    @OneToOne(mappedBy = "client", cascade = CascadeType.ALL)
    private Payment payment;

    public Client() {
    }

    public Client(String fio, String passportNumber, Long phoneNumber, Date arrivalDate) {
        this.fio = fio;
        this.passportNumber = passportNumber;
        this.phoneNumber = phoneNumber;
        this.arrivalDate = arrivalDate;
    }

    public Client(String fio, String passportNumber, Long phoneNumber, Date arrivalDate, DepartureDate departureDate, Payment payment) {
        this.fio = fio;
        this.passportNumber = passportNumber;
        this.phoneNumber = phoneNumber;
        this.arrivalDate = arrivalDate;
        this.departureDate = departureDate;
        this.payment = payment;
    }

    public Client(
            String fio,
            String passportNumber,
            Long phoneNumber,
            Date arrivalDate,
            Date departureDate,
            String paymentForm,
            Date paymentDate,
            String paymentNote) {
        this.fio = fio;
        this.passportNumber = passportNumber;
        this.phoneNumber = phoneNumber;
        this.arrivalDate = arrivalDate;
        this.departureDate = new DepartureDate(departureDate, this);
        this.payment = new Payment(paymentDate, paymentForm, paymentNote, this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        final Client client = (Client) o;

        if (!id.equals(client.id)) return false;
        if (fio != null ? !fio.equals(client.fio) : client.fio != null) return false;
        if (passportNumber != null ? !passportNumber.equals(client.passportNumber) : client.passportNumber != null)
            return false;
        if (phoneNumber != null ? !phoneNumber.equals(client.phoneNumber) : client.phoneNumber != null) return false;
        return arrivalDate != null ? arrivalDate.equals(client.arrivalDate) : client.arrivalDate == null;
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + (fio != null ? fio.hashCode() : 0);
        result = 31 * result + (passportNumber != null ? passportNumber.hashCode() : 0);
        result = 31 * result + (phoneNumber != null ? phoneNumber.hashCode() : 0);
        result = 31 * result + (arrivalDate != null ? arrivalDate.hashCode() : 0);
        return result;
    }
}
