package com.project.projectcrypto;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.*;
import java.util.Scanner;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("WORLD.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Image image = new Image("C:\\Users\\HPP\\ProjectCrypto\\src\\main\\resources\\com\\project\\projectcrypto\\tesseract.png");
        stage.getIcons().add(image);
        stage.setTitle("TESSERACT");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) throws FileNotFoundException {

        launch();

    }
}



