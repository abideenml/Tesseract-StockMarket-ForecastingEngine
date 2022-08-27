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


public class FController implements Initializable{

    @FXML
    private Text f37;

    @FXML
    private TextField f38;

    @FXML
    private Text f39;

    @FXML
    private TextField f40;

    @FXML
    private Text f41;

    @FXML
    private TextField f42;

    @FXML
    private Text f43;

    @FXML
    private TextField f44;

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

        f37.setText(newsSetter(34));
        f38.setText(newsSetter(35));
        f39.setText(newsSetter(36));
        f40.setText(newsSetter(37));

        f41.setText(newsSetter(39));
        f42.setText(newsSetter(40));
        f43.setText(newsSetter(41));
        f44.setText(newsSetter(42));

        CSVReader csv = new CSVReader("F.csv");

        high.setText("$" + csv.high);
        low.setText("$"+ csv.low);
        open.setText("$"+ csv.open);
        current_price.setText("$"+ csv.current_price);

        DATE d1 = new DATE();
        date.setText(d1.datecalculator());

    }
}
