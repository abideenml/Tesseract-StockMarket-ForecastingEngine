package com.project.projectcrypto;

public class Portfolio {

    private String ticker;
    private String quantity;
    private String order_type;
    private String cost;

    public Portfolio() {

    }

    public Portfolio(String ticker, String quantity, String order_type, String cost) {
        setCost(cost);
        setQuantity(quantity);
        setTicker(ticker);
        setOrder_type(order_type);
    }

    public String getTicker() {
        return ticker;
    }

    public void setTicker(String ticker) {
        this.ticker = ticker;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getOrder_type() {
        return order_type;
    }

    public void setOrder_type(String order_type) {
        this.order_type = order_type;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }
}
