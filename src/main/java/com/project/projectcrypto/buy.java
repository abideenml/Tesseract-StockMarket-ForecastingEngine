package com.project.projectcrypto;
import java.io.*;

public class buy extends Trade {

    buy(String ticker, int quantity, String ordertype, String side){
        super(ticker,quantity,ordertype,side);
    }

    public void Buy() throws IOException, InterruptedException{
        try {
            String s = null;

            Process p = Runtime.getRuntime().exec("python C:\\Users\\HPP\\ProjectCrypto\\src\\main" +
                    "\\java\\com\\project\\projectcrypto\\buy.py");
            BufferedReader in = new BufferedReader(new InputStreamReader(p.getInputStream()));
            while((s = in.readLine()) != null){
                System.out.println(s);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    public void Sell(){}
}
