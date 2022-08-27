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


public class AAPLController implements Initializable{

    @FXML
    private Text f29;

    @FXML
    private TextField f30;

    @FXML
    private Text f31;

    @FXML
    private TextField f32;

    @FXML
    private Text f33;

    @FXML
    private TextField f34;

    @FXML
    private Text f35;

    @FXML
    private TextField f36;

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

        f29.setText(newsSetter(56));
        f30.setText(newsSetter(57));
        f31.setText(newsSetter(58));
        f32.setText(newsSetter(59));

        f33.setText(newsSetter(61));
        f34.setText(newsSetter(62));
        f35.setText(newsSetter(63));
        f36.setText(newsSetter(64));

        CSVReader csv = new CSVReader("AAPL.csv");

        high.setText("$" + csv.high);
        low.setText("$"+ csv.low);
        open.setText("$"+ csv.open);
        current_price.setText("$"+ csv.current_price);


        DATE d1 = new DATE();
        date.setText(d1.datecalculator());
    }
}
