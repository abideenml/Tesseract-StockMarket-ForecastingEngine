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


public class GOOGController implements Initializable{


    @FXML
    private Text f13;

    @FXML
    private TextField f14;

    @FXML
    private Text f15;

    @FXML
    private TextField f16;

    @FXML
    private Text f17;

    @FXML
    private TextField f18;

    @FXML
    private Text f19;

    @FXML
    private TextField f20;

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

        f13.setText(newsSetter(12));
        f14.setText(newsSetter(13));
        f15.setText(newsSetter(14));
        f16.setText(newsSetter(15));

        f17.setText(newsSetter(17));
        f18.setText(newsSetter(18));
        f19.setText(newsSetter(19));
        f20.setText(newsSetter(20));

        CSVReader csv = new CSVReader("GOOG.csv");

        high.setText("$" + csv.high);
        low.setText("$"+ csv.low);
        open.setText("$"+ csv.open);
        current_price.setText("$"+ csv.current_price);

        DATE d1 = new DATE();
        date.setText(d1.datecalculator());

    }
}
