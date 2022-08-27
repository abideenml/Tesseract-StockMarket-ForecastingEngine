package com.project.projectcrypto;

import java.io.IOException;

public abstract class Trade {
    String ticker;
    int quantity;
    String ordertype;
    String side;

    public Trade(){
        this("",0,"","");
    }

    public Trade(String ticker, int quantity, String ordertype, String side) {
        setTicker(ticker);
        setQuantity(quantity);
        setOrdertype(ordertype);
        setSide(side);

    }

    public String getTicker() {
        return ticker;
    }

    public void setTicker(String ticker) {
        this.ticker = ticker;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getOrdertype() {
        return ordertype;
    }

    public void setOrdertype(String ordertype) {
        this.ordertype = ordertype;
    }

    public String getSide() {
        return side;
    }

    public void setSide(String side) {
        this.side = side;
    }

    abstract void Buy()throws IOException, InterruptedException;
    abstract void Sell()throws IOException, InterruptedException;

}
