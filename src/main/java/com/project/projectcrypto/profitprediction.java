package com.project.projectcrypto;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class profitprediction {
    double rate;
    double requiredprofit;
    String stock;
    int days;
    double ratetsla;
    double rateaapl;
    double ratemsft;
    double ratef;
    double ratehpq;
    double rategoog;


    profitprediction(){
        this(100,100);
    }

    profitprediction(double requiredprofit){
        this(requiredprofit,30);
    }

    profitprediction(double requiredprofit, int days){

        setDays(days);
        setRequiredprofit(requiredprofit);
    }


    public double getRequiredprofit() {
        return requiredprofit;
    }

    public void setRequiredprofit(double requiredprofit) {
        this.requiredprofit = requiredprofit;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }


    public String getStock() {
        return stock;
    }

    public void setStock(String stock) {
        this.stock = stock;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    boolean profitcalculator(){
        double currentprof=0;
        for(int i=0;i<getDays()+1;i++){
            currentprof = currentprof+(100*getRate());
        }
        if(currentprof>=getRequiredprofit()){
            return true;
        }
        else
            return false;
    }


}
class ratereader{
    double ratetsla;
    double rateaapl;
    double ratemsft;
    double ratef;
    double ratehpq;
    double rategoog;
    public double getRatetsla() {
        return ratetsla;
    }

    public void setRatetsla(double ratetsla) {
        this.ratetsla = ratetsla;
    }

    public double getRateaapl() {
        return rateaapl;
    }

    public void setRateaapl(double rateaapl) {
        this.rateaapl = rateaapl;
    }

    public double getRatemsft() {
        return ratemsft;
    }

    public void setRatemsft(double ratemsft) {
        this.ratemsft = ratemsft;
    }

    public double getRatef() {
        return ratef;
    }

    public void setRatef(double ratef) {
        this.ratef = ratef;
    }

    public double getRatehpq() {
        return ratehpq;
    }

    public void setRatehpq(double ratehpq) {
        this.ratehpq = ratehpq;
    }

    public double getRategoog() {
        return rategoog;
    }

    public void setRategoog(double rategoog) {
        this.rategoog = rategoog;
    }
    Scanner sc = new Scanner(new File("src/main/java/com/project/projectcrypto/rates.txt"));
    ratereader() throws FileNotFoundException {
        setRatetsla(sc.nextDouble());
        setRateaapl(sc.nextDouble());
        setRatemsft(sc.nextDouble());
        setRatef(sc.nextDouble());
        setRatehpq(sc.nextDouble());
        setRategoog(sc.nextDouble());
    }
}
