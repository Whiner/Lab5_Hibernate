package com.lab5.ui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

public class MainController {

    private Model model = new Model();

    @FXML
    private Button delButton;

    @FXML
    private Button addButton;

    @FXML
    private TableView<TableClient> table;


    private void setOnButtonsAction() {
        delButton.setOnAction(event -> {
            if (MessageBox.confirmation("Удалить клиента и все его данные?") == ButtonType.OK) {
                TableClient selectedItem = table.getSelectionModel().getSelectedItem();
                model.del(selectedItem);
                refreshTableFromDb();
            }
        });
        addButton.setOnAction(event -> {
            Parent secondaryLayout;

            Scene secondScene;
            try {
                secondaryLayout = FXMLLoader.load(getClass().getResource("/fxml/add.fxml"));
                secondScene = new Scene(secondaryLayout);
                Stage newWindow = new Stage();
                newWindow.setTitle("Добавить");
                newWindow.setScene(secondScene);
                newWindow.initModality(Modality.WINDOW_MODAL);

                newWindow.setResizable(false);
                newWindow.show();
                newWindow.setOnCloseRequest(event1 -> refreshTableFromDb());
            } catch (IOException e) {
                MessageBox.error(e.toString());
            }
        });

    }

    private void createTable() {
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

    private void refreshTableFromDb() {
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
        setOnButtonsAction();
    }
}
