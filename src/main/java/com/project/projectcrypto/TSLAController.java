package com.project.projectcrypto;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class TSLAController implements Initializable{



    @FXML
    private Text feedLine5;

    @FXML
    private TextField feedLine6;

    @FXML
    private Text feedLine7;

    @FXML
    private TextField feedLine8;

    @FXML
    private Text feedLine9;

    @FXML
    private TextField feedLine10;

    @FXML
    private Text feedLine11;

    @FXML
    private TextField feedLine12;

    @FXML
    private Label high;

    @FXML
    private Label low;

    @FXML
    private Label open;

    @FXML
    private Label current_price;

    @FXML
    private Label date;


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

        feedLine5.setText(newsSetter(1));
        feedLine6.setText(newsSetter(2));
        feedLine7.setText(newsSetter(3));
        feedLine8.setText(newsSetter(4));

        feedLine9.setText(newsSetter(6));
        feedLine10.setText(newsSetter(7));
        feedLine11.setText(newsSetter(8));
        feedLine12.setText(newsSetter(9));

        CSVReader csv = new CSVReader("TSLA.csv");

        high.setText("$" + csv.high);
        low.setText("$"+ csv.low);
        open.setText("$"+ csv.open);
        current_price.setText("$"+ csv.current_price);

        DATE d1 = new DATE();
        date.setText(d1.datecalculator());

    }
}
