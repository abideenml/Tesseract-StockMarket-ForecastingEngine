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


public class HPQController implements Initializable{

    @FXML
    private Text f45;

    @FXML
    private TextField f46;

    @FXML
    private Text f47;

    @FXML
    private TextField f48;

    @FXML
    private Text f49;

    @FXML
    private TextField f50;

    @FXML
    private Text f51;

    @FXML
    private TextField f52;

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

        f45.setText(newsSetter(45));
        f46.setText(newsSetter(46));
        f47.setText(newsSetter(47));
        f48.setText(newsSetter(48));

        f49.setText(newsSetter(50));
        f50.setText(newsSetter(51));
        f51.setText(newsSetter(52));
        f52.setText(newsSetter(53));

        CSVReader csv = new CSVReader("HPQ.csv");

        high.setText("$" + csv.high);
        low.setText("$"+ csv.low);
        open.setText("$"+ csv.open);
        current_price.setText("$"+ csv.current_price);

        DATE d1 = new DATE();
        date.setText(d1.datecalculator());

    }
}
