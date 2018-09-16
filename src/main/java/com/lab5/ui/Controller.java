package com.lab5.ui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.List;

public class Controller {

    private Model model = new Model();

    @FXML
    private Button delButton;

    @FXML
    private Button addButton;

    @FXML
    private TableView<TableClient> table;


    public void createTable() {
        TableColumn fioColumn = new TableColumn("Full name");
        fioColumn.setCellValueFactory(new PropertyValueFactory<>("fio"));

        TableColumn phoneColumn = new TableColumn("Phone");
        phoneColumn.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));

        TableColumn passportColumn = new TableColumn("Passport");
        passportColumn.setCellValueFactory(new PropertyValueFactory<>("passportNumber"));

        TableColumn arrColumn = new TableColumn("ArrDate");
        arrColumn.setCellValueFactory(new PropertyValueFactory<>("arrivalDate"));

        TableColumn depColumn = new TableColumn("DepDate");
        depColumn.setCellValueFactory(new PropertyValueFactory<>("departureDate"));

        TableColumn paymentDateColumn = new TableColumn("PaymentDate");
        paymentDateColumn.setCellValueFactory(new PropertyValueFactory<>("paymentDate"));

        TableColumn paymentFormColumn = new TableColumn("PaymentForm");
        paymentFormColumn.setCellValueFactory(new PropertyValueFactory<>("form"));

        TableColumn noteColumn = new TableColumn("Note");
        noteColumn.setCellValueFactory(new PropertyValueFactory<>("note"));

        table.getColumns().clear();
        table.getColumns().addAll(
                fioColumn,
                phoneColumn,
                passportColumn,
                arrColumn,
                depColumn,
                paymentDateColumn,
                paymentFormColumn,
                noteColumn);
    }

    public void refreshTableFromDb() {
        table.getItems().clear();
        List<TableClient> tableClients = model.getTableClients();
        ObservableList<TableClient> tableTaskStruct = FXCollections.observableArrayList();
        tableClients.addAll(tableTaskStruct);
        table.getItems().addAll(tableClients);
    }

    @FXML
    void initialize() {
        createTable();
        refreshTableFromDb();
    }
}
