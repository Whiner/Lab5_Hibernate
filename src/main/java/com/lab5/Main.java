package com.lab5;

import com.lab5.dao.Dao;
import com.lab5.entities.Client;

import java.io.IOException;
import java.util.List;

public class Main {

    public static void main(String[] args) {
//        Client client = new Client();
//        client.setArrivalDate(new Date(2018, 1, 21));
//        client.setDepartureDate(new DepartureDate(new Date(2018, 10, 30), client));
//        client.setPib("Лолетс");
//        client.setPassportNumber("ВТ654321");
//        client.setPayment(new Payment(new Date(), "Наличка", "Жадный козел", client));
//        client.setPhoneNumber(Long.valueOf("8252525252"));

        try (Dao<Client, Integer> clientIntegerDao = new Dao<>()) {
            List all = clientIntegerDao.findAll();
            System.out.println(all);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
