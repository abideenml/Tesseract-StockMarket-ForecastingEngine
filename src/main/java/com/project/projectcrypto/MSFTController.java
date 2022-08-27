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


public class MSFTController implements Initializable{

    @FXML
    private Text f21;

    @FXML
    private TextField f22;

    @FXML
    private Text f23;

    @FXML
    private TextField f24;

    @FXML
    private Text f25;

    @FXML
    private TextField f26;

    @FXML
    private Text f27;

    @FXML
    private TextField f28;

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

        f21.setText(newsSetter(23));
        f22.setText(newsSetter(24));
        f23.setText(newsSetter(25));
        f24.setText(newsSetter(26));

        f25.setText(newsSetter(28));
        f26.setText(newsSetter(29));
        f27.setText(newsSetter(30));
        f28.setText(newsSetter(31));

        CSVReader csv = new CSVReader("MSFT.csv");

        high.setText("$" + csv.high);
        low.setText("$"+ csv.low);
        open.setText("$"+ csv.open);
        current_price.setText("$"+ csv.current_price);

        DATE d1 = new DATE();
        date.setText(d1.datecalculator());

    }
}
