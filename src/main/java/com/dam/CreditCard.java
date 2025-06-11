package com.dam;

import java.util.Calendar;

public class CreditCard {
    private String cardNum;
    private Calendar fechaCaducidad;
    private String nombreTitular;
    private String CVV;

    public CreditCard(String cardNum, Calendar fechaCaducidad, String nombreTitular, String CVV) {
        this.cardNum = cardNum;
        this.fechaCaducidad = fechaCaducidad;
        this.nombreTitular = nombreTitular;
        this.CVV = CVV;
    }

    public String getCardNum() {
        return cardNum;
    }

    public void setCardNum(String cardNum) {
        this.cardNum = cardNum;
    }

    public String getCVV() {
        return CVV;
    }

    public void setCVV(String CVV) {
        this.CVV = CVV;
    }

    public String getNombreTitular() {
        return nombreTitular;
    }

    public void setNombreTitular(String nombreTitular) {
        this.nombreTitular = nombreTitular;
    }

    public Calendar getFechaCaducidad() {
        return fechaCaducidad;
    }

    public void setFechaCaducidad(Calendar fechaCaducidad) {
        this.fechaCaducidad = fechaCaducidad;
    }
}
