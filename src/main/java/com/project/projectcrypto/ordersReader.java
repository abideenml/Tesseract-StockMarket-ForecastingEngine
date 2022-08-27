package com.project.projectcrypto;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class ordersReader {
    public String order_type = "Market";
    public String[] quantity = new String[10];
    public String[] ticker = new String[10];
    public String[] cost = new String[10];
    public int size = 0;

    public ordersReader() throws IOException {
        getOrders();
    }

    public void getOrders() throws IOException {
        File f = new File("C:\\Users\\HPP\\ProjectCrypto\\orders.txt");
        Path path = Path.of("C:\\Users\\HPP\\ProjectCrypto\\orders.txt");
        int count = -1;
        Scanner sc = new Scanner(f);
        while(sc.hasNextLine()) {
            sc.nextLine();
            count++;
        }
        sc.close();
        int k = 0;

        for (int i = 0; i <= count; i += 4) {
            for (int j = i; j < i + 3; j++) {
                if (j == i + 1)
                    ticker[k] = Files.readAllLines(path).get(j);
                else if (j == i + 2)
                    quantity[k] = Files.readAllLines(path).get(j);



            }
            CSVReader cst = new CSVReader (ticker[k] + ".csv");
            cost[k] = cst.current_price;
            System.out.println("Cost:" + cost[k]);
            System.out.println("Order Type: " + order_type);
            System.out.println("Quantity: " + quantity[k]);
            System.out.println("Ticker: " + ticker[k]);
            k++;
            size++;
        }

    }

}
