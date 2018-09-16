package com.lab5.ui;

import com.lab5.db.dao.Dao;
import com.lab5.db.entities.Client;
import com.lab5.db.entities.EntityInDb;

import java.util.ArrayList;
import java.util.List;

public class Model {

    public List<TableClient> getTableClients() {
        List<Client> allClients = getAllClients();
        List<TableClient> tableClients = new ArrayList<>();
        for (Client client : allClients) {
            tableClients.add(new TableClient(client));
        }
        return tableClients;
    }

    public List<Client> getAllClients() {
        List<Client> clients = new ArrayList<>();
        try (Dao clientIntegerDao = new Dao()) {
            List<EntityInDb> all = clientIntegerDao.findAll(Client.class);
            for (EntityInDb entity : all) {
                if (entity instanceof Client) {
                    clients.add((Client) entity);
                }
            }
        }
        return clients;
    }

}
