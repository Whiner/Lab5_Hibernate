package com.lab5;

import com.lab5.db.dao.Dao;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/main_page.fxml"));
        primaryStage.setTitle("Лаба 5");
        primaryStage.setScene(new Scene(root));
//        primaryStage.setMinHeight(780);
//        primaryStage.setMinWidth(1200);
        primaryStage.show();
        primaryStage.setResizable(false);
        primaryStage.setOnCloseRequest(event -> Dao.getInstance().close());
    }


    public static void main(String[] args) {
//        Client client = new Client();
//        client.setArrivalDate(new Date(2018, 1, 21));
//        client.setDepartureDate(new DepartureDate(new Date(2018, 10, 30), client));
//        client.setFio("21221");
//        client.setPassportNumber("1212121");
//        client.setPayment(new Payment(new Date(), "2525252", "75675272", client));
//        client.setPhoneNumber(Long.valueOf("52525252"));
//        Dao clientIntegerDao = new Dao();
//        clientIntegerDao.save(client);
        launch(args);
    }


}
