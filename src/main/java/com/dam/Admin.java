package com.dam;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Admin extends Usuario {
    private String companyKey;
    public static final String FILENAME = "src/admin.txt";
    public Admin(String email, String passWord, String name, String companyKey){
        super(email, passWord, name);
        this.companyKey = companyKey;
    }

    public Admin(String companyKey, String passWord) {
        super("", passWord, "");
        this.companyKey = companyKey;
    }
    public String getCompanyKey(){return companyKey;}
    @Override
    public String AFichero(){
        return super.AFichero() + ";" +  companyKey;
    }

    @Override
    public String ToString(){
        return super.ToString() + " Company key: " + companyKey;
    }
    public static void showClients(List<Client>clientes)
    {
        System.out.println("List of clients: ");
        for(Client c : clientes)
        {
            System.out.println(c);
            System.out.println("------------");
        }
    }
    public static void showOrders(List<Client> clientes)
    {
        for(Client c : clientes)
        {
            System.out.println("Client: " + c.getName());
            System.out.println("Email: " + c.getEmail());
            System.out.println("Pedidos: ");
            for (Order o: c.getOrdersClient())
            {
                System.out.println(o);
            }
            System.out.println("==========");
        }
    }

    public static void showCandle(List<Candle>candles)
    {
        for(Candle c:candles)
        {
            System.out.println("Name:"+c.getName()+"("+c.getCandleCode()+")");
            System.out.println("shortDescp:"+c.getShortDescp());
            System.out.println("CandleFragrance:"+c.getCandleFragrance());
            System.out.println("Price:"+c.getPrice());
        }
    }

    //LoadAdmin
    public static List<Admin>LoadAdmin()
    {
        List<Admin>admins=new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(FILENAME))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] parts = linea.split(";");
                if (parts.length >= 4) {
                    String email = parts[0];
                    String contrasenya = parts[1];
                    String nombre = parts[2];
                    String companyKey = parts[3];

                    Admin admin = new Admin(email, contrasenya, nombre, companyKey);

                    admins.add(admin);
                }
            }
        }
        catch(IOException e)
        {
            System.err.println("Error:"+e.getMessage());
        }
        return admins;
    }

    //Save Admin
    public static void saveAdmin(List<Admin>admins)throws IOException
    {
        BufferedWriter writer=new BufferedWriter(new FileWriter(FILENAME));

        for(Admin a:admins)
        {
            writer.write(a.AFichero());
            writer.newLine();
        }
        writer.close();
    }
}
