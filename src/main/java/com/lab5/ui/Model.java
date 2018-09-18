package com.lab5.ui;

import com.lab5.db.dao.Dao;
import com.lab5.db.entities.Client;
import com.lab5.db.entities.EntityInDb;

import java.util.ArrayList;
import java.util.List;

public class Model {

    private Dao dao = Dao.getInstance();

    List<TableClient> getTableClients() {
        List<Client> allClients = getAllClients();
        List<TableClient> tableClients = new ArrayList<>();
        for (Client client : allClients) {
            tableClients.add(new TableClient(client));
        }
        return tableClients;
    }

    private List<Client> getAllClients() {
        List<Client> clients = new ArrayList<>();
        List<EntityInDb> all = dao.findAll(Client.class);
        for (EntityInDb entity : all) {
            if (entity instanceof Client) {
                clients.add((Client) entity);
            }
        }

        return clients;
    }

    void del(TableClient client) {
        dao.delete(client.getClient());
    }

    void closeDao() {
        dao.close();
    }

}
