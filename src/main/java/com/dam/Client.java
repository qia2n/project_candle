package com.dam;

import java.util.ArrayList;
import java.util.List;

public class Client extends Usuario{
    //private String name;
    private String surname;
    private String address;
    private int phoneNumber;
    private String postalCode;
    private String province;
    private String locality;
    private List<Order> ordersClient;

    public Client(String name, String surname, String email, String passWord) {
        super(email, passWord, name);
        this.surname = surname;
        ordersClient = new ArrayList<>();
    }
    /*
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }*/

    public String getLocality() {
        return locality;
    }

    public void setLocality(String locality) {
        this.locality = locality;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
    public List<Order> getOrdersClient()
    {
        return ordersClient;
    }

    public void setNewOrderInList(Order o){
        ordersClient.add(o);
    }
    @Override
    public String toString()
    {
        return "Client: " + name + " " + surname +
                "\nEmail: " + email +
                "\nAdress: " + address +
                "\nPhone: " + phoneNumber +
                "\nOrders: " + ordersClient.size();
    }
}
