package com.dam;
import java.util.*;

public class Main {
    Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        List<Admin> admins = new ArrayList<>();
        GestionMenu g = new GestionMenu();
        g.CargarDatos();
        GestionMenu.opcionMenuBienvenida opcion1;
        GestionMenu.opcionMenuCliente opcionC;
        List<Client>client=new ArrayList<>();
        Admin admin1 = new Admin("Jorge.Reyes@OnFire.com","$1Contraseña1$","Jorge Reyes",
                "PIN01");

        while(true){
            do{
                ///
                opcion1 = g.MenuBienvenida();
                switch(opcion1)
                {
                    case REGISTRARSE:
                        g.Registrarse();
                        break;
                    case INICIARSESION:
                        g.IniciarSesion();
                        break;
                    case SALIR:
                        System.out.println("Thanks for your visit");
                        break;
                    default:
                        System.out.println("Choose an option from the menu!!");
                }
            }while(opcion1 != GestionMenu.opcionMenuBienvenida.SALIR);

            do{
                opcionC = g.MenuCliente();
                switch(opcionC)
                {
                    case MENUCARRITO:
                        g.menuCarrito();
                        break;
                    case VERPEDIDOS:
                        if(g.clienteSesionActual!=null)
                        {
                            g.verPedido(g.clienteSesionActual);
                        }
                        else{
                            System.out.println("You need login in first");
                            opcionC=GestionMenu.opcionMenuCliente.SALIR;
                        }
                        break;
                    case VERVELAS:
                        g.verListadoVelas();
                        break;
                    case SALIR:
                        System.out.println("Thanks for your visit");
                        break;
                    default:
                        System.out.println("Choose an option from the menu!!");
                }
            }while(opcionC != GestionMenu.opcionMenuCliente.SALIR);
        }
    }
}
