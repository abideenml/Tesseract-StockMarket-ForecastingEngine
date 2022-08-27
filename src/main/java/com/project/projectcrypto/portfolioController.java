package com.project.projectcrypto;

import javafx.beans.binding.Bindings;
import javafx.beans.property.Property;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;

import java.io.*;
import java.net.URL;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.ResourceBundle;
import java.util.Scanner;

public class portfolioController implements Initializable {

    public static final int daysReq = 0;
    public static final int profitReq = 0;

    ordersReader ord = new ordersReader();


    @FXML
    private TableColumn<Portfolio, String> cost;

    @FXML
    private TextField no_of_days;

    @FXML
    private TableColumn<Portfolio, String> order_type;

    @FXML
    private TableColumn<Portfolio, String> quantity;

    @FXML
    private TextField req_profit;

    @FXML
    private Button submit;

    @FXML
    private TableView<Portfolio> table;

    @FXML
    private TableColumn<Portfolio, String> ticker;

    @FXML
    private TextField preferredStock;

    public portfolioController() throws IOException {
    }


    void checkFields(){
        if(req_profit.getText().trim().equals("") && no_of_days.getText().trim().equals("") ) {

            submit.disableProperty().bind(req_profit.textProperty().isEmpty());
            submit.disableProperty().bind(no_of_days.textProperty().isEmpty());
            submit.disableProperty().bind(Bindings.or(no_of_days.textProperty()
                    .lessThanOrEqualTo(String.valueOf(daysReq)),req_profit.textProperty().
                    lessThanOrEqualTo(String.valueOf(profitReq))));

        }
    }

    @FXML
    void onButtonSubmit(ActionEvent event) {


        try {

                int req = Integer.parseInt(req_profit.getText());
                int days = Integer.parseInt(no_of_days.getText());
                ratereader fetchrates = new ratereader();
                double ratetsla = fetchrates.getRatetsla();
                double rateaapl = fetchrates.getRateaapl();
                double ratemsft = fetchrates.getRatemsft();
                double ratef = fetchrates.getRatef();
                double ratehpq = fetchrates.getRatehpq();
                double rategoog = fetchrates.getRategoog();

                profitprediction profit = new profitprediction(req, days);
                profit.setRate(ratetsla);
                boolean tslaresult = profit.profitcalculator();
                profit.setRate(rateaapl);
                boolean aaplresult = profit.profitcalculator();
                profit.setRate(ratemsft);
                boolean msftresult = profit.profitcalculator();
                profit.setRate(ratef);
                boolean fresult = profit.profitcalculator();
                profit.setRate(ratehpq);
                boolean hpqresult = profit.profitcalculator();
                profit.setRate(rategoog);
                boolean googresult = profit.profitcalculator();
                if (tslaresult == true) {
                    preferredStock.setText("Tesla profit predicted");
                }
                if (aaplresult == true) {
                    preferredStock.setText("Apple profit predicted");
                }
                if (msftresult == true) {
                    preferredStock.setText("Msft profit predicted");
                }
                if (fresult == true) {
                    preferredStock.setText("F profit predicted");
                }
                if (hpqresult == true) {
                    preferredStock.setText("HP profit predicted");
                }
                if (googresult == true) {
                    preferredStock.setText("GOOG profit predicted");
                }


            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (NumberFormatException e) {
                System.err.println("Enter valid no.");
            } catch (InputMismatchException e) {
                System.err.println("Enter digits only");
            }
        }



    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //set up the columns in the table
        ticker.setCellValueFactory(new PropertyValueFactory<Portfolio, String>("ticker"));
        quantity.setCellValueFactory(new PropertyValueFactory<Portfolio, String>("quantity"));
        order_type.setCellValueFactory(new PropertyValueFactory<Portfolio, String>("order_type"));
        cost.setCellValueFactory(new PropertyValueFactory<Portfolio, String>("cost"));

        //load dummy data
        try {
            table.setItems(getPortfolio());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        //Update the table to allow for the first and last name fields
        //to be editable
        table.setEditable(true);
        ticker.setCellFactory(TextFieldTableCell.forTableColumn());
        quantity.setCellFactory(TextFieldTableCell.forTableColumn());
        order_type.setCellFactory(TextFieldTableCell.forTableColumn());
        cost.setCellFactory(TextFieldTableCell.forTableColumn());

        //This will allow the table to select multiple rows at once
        table.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);


        checkFields();

    }

    public ObservableList<Portfolio>  getPortfolio() throws IOException {
        ObservableList<Portfolio> portfolio = FXCollections.observableArrayList();

        System.out.println(ord.size);
        for (int i = 0; i < ord.size; i++) {
            portfolio.add(new Portfolio(ord.ticker[i],ord.quantity[i],ord.order_type, ord.cost[i]));
        }

        return portfolio;
    }

}