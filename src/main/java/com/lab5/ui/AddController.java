package com.lab5.ui;

import com.lab5.db.dao.Dao;
import com.lab5.db.entities.Client;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.time.ZoneId;
import java.util.Date;

public class AddController {

    @FXML
    private ComboBox<String> payFormCB;

    @FXML
    private TextField passportTB;

    @FXML
    private TextArea noteTF;

    @FXML
    private TextField fullNameTB;

    @FXML
    private DatePicker payDateDP;

    @FXML
    private DatePicker arrDateDP;

    @FXML
    private Button addButton;

    @FXML
    private DatePicker depDateDP;

    @FXML
    private TextField phoneTB;

    public void initComboBox() {
        payFormCB.getItems().clear();
        payFormCB.getItems().addAll("Наличка", "Карта", "Android Pay", "Apple Pay");
    }

    public void setOnButtonAction() {
        addButton.setOnAction(event -> {
            if (fullNameTB.getText().equals("") ||
                    passportTB.getText().equals("") ||
                    phoneTB.getText().equals("") ||
                    arrDateDP.getValue() == null ||
                    depDateDP.getValue() == null ||
                    payDateDP.getValue() == null ||
                    payFormCB.getValue() == null) {
                MessageBox.information("Заполните все поля плз");
            } else {
                Client client = new Client(
                        fullNameTB.getText(),
                        passportTB.getText(),
                        Long.valueOf(phoneTB.getText()),
                        Date.from(arrDateDP.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant()),
                        Date.from(depDateDP.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant()),
                        payFormCB.getValue(),
                        Date.from(payDateDP.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant()),
                        noteTF.getText()
                );
                Dao.getInstance().save(client);
                MessageBox.information("Тупа отдуши сохранено");
                fullNameTB.clear();
                passportTB.clear();
                phoneTB.clear();
                arrDateDP.setValue(null);
                depDateDP.setValue(null);
                payDateDP.setValue(null);
                noteTF.clear();
            }
        });
    }

    @FXML
    void initialize() {
        initComboBox();
        setOnButtonAction();
    }

}