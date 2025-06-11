package com.dam;

import java.util.*;

public class ProductManagement {
    static Scanner sc = new Scanner(System.in);
    private List<Candle> candles = new ArrayList<>();
    private HashMap<Candle, String> candlesOrder;

    // Y Tambien se puede implementar ver stock
    public void adminStockMenu(Map<String, Candle> invent){
        int option;
        String codeCandle;
        Candle candle = null;
        int count;

        do {
            System.out.println(" Stock Candles: ");
            System.out.println("0. EXIT  ");
            System.out.println("1. Add candles ");
            System.out.println("2. Substract candles ");
            option = sc.nextInt();
            sc.nextLine();

            switch (option){
                case 1:
                    System.out.println("Code candle: ");
                    // mostrar opcioensde velas
                    codeCandle = sc.nextLine();
                    if(invent.containsKey(codeCandle)){
                        System.out.println("Tell me how many candles you want to add: ");
                        count = sc.nextInt();
                        sc.nextLine();
                        Candle c = invent.get(codeCandle);
                        candle.AnyadirCantidad(count);
                        System.out.println("Candle successfully");
                    } else {
                        System.out.println("Incorrect code candle");
                    }
                case 2:
                    reduceCandle(candlesOrder);
            }
        } while(option != 0) ;
    }

    //Reduce the candle
    public void reduceCandle(HashMap<Candle, String> candlesOrder)
    {
        if(candlesOrder==null)
        {
            System.out.println("No exist order");
            return;
        }
        System.out.println("Write the candle's code:");
        String codeCandle= sc.nextLine();
        //Check if exist
        Candle candle=verifyCandle(candlesOrder,codeCandle);
        candlesOrder.remove(candle);
    }

    public Candle verifyCandle(HashMap<Candle, String> candlesOrder,String codeCandle)
    {
        for (Candle candle : candlesOrder.keySet()) {
            if (codeCandle.equals(candle.getCandleCode())) {
                return candle;
            }
        }
        return null;
    }
}
