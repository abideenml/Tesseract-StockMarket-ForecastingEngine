package com.project.projectcrypto;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.input.MouseEvent;
import java.io.IOException;
import java.net.URL;
import java.util.Formatter;
import java.util.ResourceBundle;

public class TRADEController implements Initializable{

    @FXML
    private Button dealInButton;

    @FXML
    private ComboBox<String> action;

    @FXML
    private ComboBox<String> ticker;
    @FXML
    private ComboBox<String> quantity;

    @FXML
    private ComboBox<String> order_type;

    void checkFields() {
        if (action.getSelectionModel().getSelectedItem() == null) {
            dealInButton.disableProperty().bind(action.getSelectionModel().selectedItemProperty().isNull());
            dealInButton.disableProperty().bind(ticker.getSelectionModel().selectedItemProperty().isNull());
            dealInButton.disableProperty().bind(quantity.getSelectionModel().selectedItemProperty().isNull());
            dealInButton.disableProperty().bind(order_type.getSelectionModel().selectedItemProperty().isNull());

        }
    }


    @FXML
    void controlTrade(MouseEvent event) throws IOException, InterruptedException {

        Formatter output;

        String Action = action.getValue();
        String Ticker = ticker.getValue();
        String Quantity = quantity.getValue();
        String Type = order_type.getValue();

        int q = Integer.parseInt(Quantity);

        if (Action.equals("buy")){
            System.out.println("buy done");
            output = new Formatter("buy.txt");
            output.format("%s\n%s\n%s\n%s",Ticker,Quantity,Type,Action);
            output.close();
            buy b1 = new buy(Ticker,q,Type,Action);
            b1.Buy();
        }
        else{
            output = new Formatter("sell.txt");
            output.format("%s\n%s\n%s\n%s",Ticker,Quantity,Type,Action);
            output.close();
            sell s1 = new sell(Ticker,q,Type,Action);
            s1.Sell();
            System.out.println("buy done");
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ticker.setItems(FXCollections.observableArrayList("AAPL", "TSLA", "GOOG", "FORD", "HPCO", "MSFT"));
        quantity.setItems(FXCollections.observableArrayList("1", "2", "3", "4", "5", "6", "7", "8", "9", "10"));
        action.setItems(FXCollections.observableArrayList("buy", "sell"));
        order_type.setItems(FXCollections.observableArrayList("market", "limit"));

        checkFields();
    }
}
