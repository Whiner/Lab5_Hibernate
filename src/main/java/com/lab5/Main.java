package com.lab5;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws IOException {
        Parent root = FXMLLoader.load(new URL("fxml/main_page.fxml"));
        primaryStage.setTitle("Лаба 5");
        primaryStage.setScene(new Scene(root));
//        primaryStage.setMinHeight(780);
//        primaryStage.setMinWidth(1200);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }

//    public static void main(String[] args) {
//        Client client = new Client();
//        client.setArrivalDate(new Date(2018, 1, 21));
//        client.setDepartureDate(new DepartureDate(new Date(2018, 10, 30), client));
//        client.setPib("Лолетс");
//        client.setPassportNumber("ВТ654321");
//        client.setPayment(new Payment(new Date(), "Наличка", "Жадный козел", client));
//        client.setPhoneNumber(Long.valueOf("8252525252"));

//        try (Dao clientIntegerDao = new Dao()) {
//            List<EntityInDb> all = clientIntegerDao.findAll(Client.class);
//            for (EntityInDb entity : all) {
//                if (entity instanceof Client) {
//                    System.out.println(((Client) entity).getPassportNumber());
//                }
//            }
//        }
//    }


}
