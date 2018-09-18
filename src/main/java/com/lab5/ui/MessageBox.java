package com.lab5.ui;

import com.lab5.db.utils.HibernateSessionFactoryUtil;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

public class MessageBox {
    public static void error(String errorText) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Ошибка");
        alert.setContentText(errorText);
        alert.showAndWait();
    }

    public static void criticalError(String errorText) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Критическая ошибка");
        alert.setContentText(errorText);
        alert.showAndWait();
        HibernateSessionFactoryUtil.getSessionFactory().close();
        System.exit(-1);
    }

    public static void information(String infoText) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Внимание!");
        alert.setContentText(infoText);
        alert.showAndWait();
    }


    public static ButtonType confirmation(String text) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Подтверждение");
        alert.setHeaderText("Вы уверены?");
        alert.setContentText(text);
        return alert.showAndWait().get();
    }
}