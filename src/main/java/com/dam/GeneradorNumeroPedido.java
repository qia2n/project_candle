package com.dam;

/**Clase encargada de generar el codigo del pedido*/
public class GeneradorNumeroPedido {
    private static GeneradorNumeroPedido instancia;
    private int contador = 0;
    // en el constructor no se pone nada, por que no estamos guardando nada
    // se encarga de generar el número y ya
    private GeneradorNumeroPedido(){}
    public static synchronized  GeneradorNumeroPedido getInstancia() {
        if ( instancia == null){
            instancia = new GeneradorNumeroPedido();
        }
        return instancia;
    }
    // Esto da el nuevo el proximo número de pedido
    public synchronized String generarNumeroPedido() {
        contador++;
        return String.format("PED-%04d", contador); // EJEMPLO: PED-0001
    }
}
