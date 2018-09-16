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



}
