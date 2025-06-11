package com.dam;

public class Candle {
    private String name;
    private String longDescrp;
    private String shortDescp;
    private Fragance candleFragrance;
    private double price;
    private String candleCode;
    private int amount=0;

    public Candle(String name, String longDescrp, String shortDescp, Fragance candleFragrance, double price, String candleCode) {
        this.name = name;
        this.longDescrp = longDescrp;
        this.shortDescp = shortDescp;
        this.candleFragrance = candleFragrance;
        this.price = price;
        this.candleCode = candleCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLongDescrp() {
        return longDescrp;
    }

    public void setLongDescrp(String longDescrp) {
        this.longDescrp = longDescrp;
    }

    public String getShortDescp() {
        return shortDescp;
    }

    public void setShortDescp(String shortDescp) {
        this.shortDescp = shortDescp;
    }

    public Fragance getCandleFragrance() {
        return candleFragrance;
    }

    public void setCandleFragrance(Fragance candleFragrance) {
        this.candleFragrance = candleFragrance;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCandleCode() {
        return candleCode;
    }

    public void setCandleCode(String candleCode) {
        this.candleCode = candleCode;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    //Añadir y Restar Velas

    public void AnyadirCantidad(int n){
        amount = amount + n;
    }

    public void RestarCantidad(int n){
        amount = amount - n;
    }

    public String ToString() {
        return name + " (" + shortDescp + ") Unidades: " + amount;
    }
    public String AFichero() {
        return candleCode + ";" + name + ";" + shortDescp + ";" + longDescrp + ";"
                + price + ";" + candleFragrance.getID();
    }

    
}
