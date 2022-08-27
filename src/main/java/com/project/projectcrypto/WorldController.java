package com.project.projectcrypto;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;




public class WorldController implements Initializable {

    ObservableList<String> stockList = FXCollections.observableArrayList("TSLA","AAPL","MSFT","F","HPQ","GOOG");

    @FXML
    private Button aboutUsButton;

    @FXML
    private AnchorPane anchorPane;

    @FXML
    private BorderPane borderPaneMain;

    @FXML
    private Button contactUsButton;

    @FXML
    private Button portfolioButton;

    @FXML
    private VBox vBoxSide;

    @FXML
    private Button worldButton;

    @FXML
    private ComboBox<String> stockComboBox;

    @FXML
    private Text feedLine1;

    @FXML
    private TextField feedLine2;

    @FXML
    private Text feedLine3;

    @FXML
    private TextField feedLine4;

    @FXML
    private Text feedline5;

    @FXML
    private TextField feedline6;

    @FXML
    private Text feedline7;

    @FXML
    private TextField feedline8;



    @FXML
    void ABOUTUS(MouseEvent event) {

        loadPage("ABOUTUS");
    }

    @FXML
    void CONTACTUS(MouseEvent event) {

        loadPage("CONTACTUS");
    }

    @FXML
    void PORTFOLIO(MouseEvent event) {

        loadPage("PORTFOLIO");
    }

    @FXML
    void WORLD(MouseEvent event) {

        borderPaneMain.setCenter(anchorPane);
    }

    @FXML
    void TRADE(MouseEvent event) {

        loadPage("TRADE");
    }

    private void loadPage(String page) {
        Parent root = null;

        try {
            root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(page + ".fxml")));

        } catch (IOException e) {
            e.printStackTrace();
        }

        borderPaneMain.setCenter(root);
    }

    @FXML
    void stockSelection(ActionEvent event) {

        if (stockComboBox.getSelectionModel().getSelectedIndex() == 0){
            loadPage("TSLA");

        }
        else if (stockComboBox.getSelectionModel().getSelectedIndex() == 1){
            loadPage("AAPL");
        }
        else if (stockComboBox.getSelectionModel().getSelectedIndex() == 2){
            loadPage("MSFT");
        }
        else if (stockComboBox.getSelectionModel().getSelectedIndex() == 3){
            loadPage("F");
        }
        else if (stockComboBox.getSelectionModel().getSelectedIndex() == 4){
            loadPage("HPQ");
        }
        else
            loadPage("GOOG");
    }


    private String newsSetter(int n) {
        String line = null;
        try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\HPP\\ProjectCrypto\\src\\main\\resources\\com\\project\\projectcrypto\\NEWS.txt"))) {
            for (int i = 0; i < n; i++)
                br.readLine();
            line = br.readLine();

        } catch (IOException e) {
            System.out.println(e);
        }
        return line;
    }




    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        stockComboBox.setItems(stockList);
        feedLine1.setText(newsSetter(67));
        feedLine2.setText(newsSetter(68));
        feedLine3.setText(newsSetter(69));
        feedLine4.setText(newsSetter(70));

        feedline5.setText(newsSetter(72));
        feedline6.setText(newsSetter(73));
        feedline7.setText(newsSetter(74));
        feedline8.setText(newsSetter(75));

    }
}