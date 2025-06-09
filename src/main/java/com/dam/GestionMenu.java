package com.dam;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class GestionMenu {
    Scanner sc = new Scanner(System.in);
    private static List<Candle> stockCandles =  new ArrayList<>();
    private static Fragance[] stockFragances = new Fragance[100];
    //En cada posicion de esa lista se va a guardar un objeto vela (Se usara en la primera opcion de "Mostrar velas")
    private final List<Client> clientsApp = new ArrayList<>();
    private final List<Admin> adminsApp = new ArrayList<>();
    private final List<Candle> Carrito =  new ArrayList();
    Client clienteSesionActual;

    enum opcionMenuBienvenida { SALIR, INICIARSESION, REGISTRARSE }
    enum opcionMenuCliente { SALIR, MENUCARRITO, VERPEDIDOS, VERVELAS }
    enum opcionMenuAdmin {}
    enum opcionMenuCarrito { SALIRCARRITO, AÑADIRVELAS, QUITARVELAS, CONFIRMARCOMPRA }
    enum opcionMenuVelasDetallado { SALIRMENU, AÑADIRVELASCARRITO }

    public void CargarDatos() {
        stockFragances = getFragances();
        stockCandles = RellenarVelas();
        //Cargar Users from File
        //Cargar Pedidos from File
        //velasInventario
    }

    public static Fragance[] getFragances() {
        stockFragances[0] = new Fragance("Lavanda", "0001LA",
                "Fresco olor a lavanda, hecho 100% de la flor");
        stockFragances[1] = new Fragance("Chocolate", "0002CH",
                "Dulce olor al chocolate con leche");
        stockFragances[2] = new Fragance("Brisa Campesina", "0003BR",
                "Fresco olor al campo alicantino, 0% polucion");
        stockFragances[3] = new Fragance("Vainilla", "0004VA",
                "Fresco y dulce olor a Vainilla, igualito al helado");
        stockFragances[4] = new Fragance("Eucalipto", "0005EU",
                "Fresco olor a lavanda, hecho 100% de la flor");
        return stockFragances;
    }

    public List<Candle> RellenarVelas(){
        Fragance[] fragances = getFragances();
        stockCandles.add(new Candle("Brisa en el Campo",
                "La brisa de olor que te deja esta vela se puede relacionar\n" +
                "a aquel sentimiento que sentias al salir al campo despues\n" +
                "de dormir en casa de tu abuela en la cañada y respirar ese \n" +
                "aire nocturno sin polución, simplemente epico.",
                "Como no olvidar ese olor a campo por la noche",
                fragances[2], 8.50, "0101BR"));
        stockCandles.add(new Candle("Cacao Intenso",
                "Cacao Intenso está hecha para los amantes del chocolate.\n" +
                        "Su fragancia rica y cremosa evoca una taza de chocolate caliente, \n" +
                        "con notas de cacao amargo, azúcar morena y un toque de vainilla.\n" +
                        "Ideal para ambientes acogedores y momentos dulces",
                "Vela cálida y reconfortante con aroma de chocolate oscuro.",
                fragances[1], 8.50, "0102CH"));
        stockCandles.add(new Candle("Eucalipto Fresco",
                "Diseñada para despejar la mente y el ambiente, “Eucalipto Fresco”\n" +
                        "combina eucalipto natural con un ligero toque de menta y romero.\n" +
                        "Esta vela purifica el aire, estimula la respiración y es ideal para\n" +
                        "baños o espacios de meditación.",
                "Aroma refrescante con eucalipto puro y menta.",
                fragances[4], 8.50, "0103EU"));
        stockCandles.add(new Candle("Esencia de Vainilla",
                "Suave y envolvente, esta vela ofrece una experiencia olfativa cálida\n" +
                        "y familiar. La vainilla pura se mezcla con notas de crema y caramelo,\n" +
                        "creando una atmósfera relajante y hogareña. Perfecta para salas, dormitorios\n" +
                        "o como fondo neutro y elegante.",
                "Aroma clásico y dulce con vainilla natural.",
                fragances[3], 8.50, "0104VA"));
        stockCandles.add(new Candle("Lavanda Silvestre",
                "Inspirada en campos de lavanda al atardecer, esta vela aporta calma\n" +
                        "y equilibrio. Las notas florales de lavanda se fusionan con un\n" +
                        "fondo suave de salvia y musgo, creando una atmósfera ideal para\n" +
                        "descansar o antes de dormir.",
                "Fragancia relajante de lavanda con notas herbales.",
                fragances[0], 8.50, "0102CH"));
        return stockCandles;
    }

    //MenuBienvenida
    public opcionMenuBienvenida MenuBienvenida(){
        int seleccion;
        boolean norepetir = false;
        do {
            System.out.println("---BIENVENIDO A ONFIRE---");
            System.out.println(" 1. Iniciar Sesion");
            System.out.println(" 2. Registrarse");
            System.out.println(" 0. Salir");
            System.out.println("-------------------------");
            System.out.println("---¿Que quieres hacer?---");
            seleccion = sc.nextInt();
            if(seleccion == 1 || seleccion == 2 || seleccion == 0){
                norepetir = true;
            }
        }while(!norepetir);
        return opcionMenuBienvenida.values()[seleccion];
    }

    //Iniciar Session
    public void IniciarSesion(){
        String email,passWord;
        Client c=null;
        boolean passwordCorrect = false;

        sc.nextLine();

        System.out.println("Please enter email");
         email = sc.nextLine();
            //Check email
        if (!Usuario.emailValido(email)) {
            System.out.println("Invalid email format.");
            return;
        }

        for (Client client : clientsApp)
        {
            if (client.getEmail().equalsIgnoreCase(email)) {
                c = client;
                break;
            }
        }
        if (c==null) {
            System.out.println("User doesn't exist");
            return;
        }

        do {
            System.out.println("Please enter password");
            passWord = sc.nextLine();
            if (passWord.equals(c.getPassWord())) {
                clienteSesionActual = c;
                passwordCorrect = true;
                System.out.println("Bienvenido " + c.getName());

            } else {
                System.out.println("Incorrect password");
            }
        } while (!passwordCorrect);
    }



    public void Registrarse(){
        sc.nextLine();
        System.out.print("Name: ");
        String name = sc.nextLine();
        System.out.print("Surname: ");
        String surname = sc.nextLine();
        String email;

        do{
            System.out.print("Email: ");
            email=sc.nextLine();

            if(!Usuario.emailValido(email))
            {
                System.out.println("Invalid Email,Try again...");
            }
        }while(!Usuario.emailValido(email));

        System.out.print("Password: ");
        String password = sc.nextLine();
        Client c = new Client(name, surname, email, password);
        clientsApp.add(c);
        clienteSesionActual = c;
        System.out.println("Bienvenido " + name);
    }


    //Opcion ver velas
    public opcionMenuVelasDetallado MenuVelasDetallada(Candle c) {
        int seleccion;
        boolean norepetir = false;
        do {
            System.out.println("-   -¿QUE QUIERES HACER?-   -");
            System.out.println(" 1. Añadir la vela al carrito");
            System.out.println(" 0. Salir al menu");
            System.out.println("-------------------------");
            try{
                seleccion = sc.nextInt();
                sc.nextLine();
                if (seleccion == 1 || seleccion == 0) {
                    norepetir = true;
                }
                else{System.out.println("Opcion invalid.Try again...");}
             }
            catch (InputMismatchException e){
                sc.nextLine();
                seleccion=-1;
            }
        }
        while (!norepetir);
        return opcionMenuVelasDetallado.values()[seleccion];
    }

    public void AñadirVelaCarrito(Candle c){
        System.out.println("¿Cuantas de estas velas quieres?");
        c.AnyadirCantidad(sc.nextInt());
        Carrito.add(c);
    }

    public void SalirAMenuVelas(){
        verListadoVelas();
    }

    public void verVelaPagina(int seleccion){
        Candle v = stockCandles.get(seleccion);
        System.out.println("Nombre: " + v.getName());
        System.out.println(v.getLongDescrp());
        System.out.println("Precio: " + v.getPrice());
        opcionMenuVelasDetallado opcion=MenuVelasDetallada(v);
        switch(opcion) {
            case AÑADIRVELASCARRITO:
                AñadirVelaCarrito(v);
                break;
            case SALIRMENU:
                SalirAMenuVelas();
                break;
        }
    }

    public void verListadoVelas(){
        if(stockCandles.isEmpty()){
            System.out.println("The are currently no candles available");
            return;
        }
        System.out.println("- - -VELAS AROMATICAS- - -");
        for (int i = 0; i < stockCandles.size(); i++) {
            Candle v = stockCandles.get(i);
            System.out.println((i + 1) + ". " + v.getName() + " "
                    + v.getShortDescp());
        }
        System.out.println("--------------------------");
        System.out.println("--¿Que vela quieres ver?--");
        int seleccion = sc.nextInt()-1;
        verVelaPagina(seleccion);
    }
    //--------------

    //Menu Cliente
    public opcionMenuCliente MenuCliente(){
        int seleccion;
        boolean norepetir = false;
        do {
            System.out.println("-   -   -ONFIRE!-   -   -");
            System.out.println(" 1. Menu del carrito");
            System.out.println(" 2. Ver mis pedidos");
            System.out.println(" 3. Ver el listado de velas");
            System.out.println(" 0. Salir");
            System.out.println("-------------------------");
            System.out.println("---¿Que quieres hacer?---");
            seleccion = sc.nextInt();
            if(seleccion == 1 || seleccion == 2 || seleccion == 3 || seleccion == 0){
                norepetir = true;
            }
        }while(!norepetir);
        return opcionMenuCliente.values()[seleccion];
    }
    //----------------------------------

    //Opcion VerCarrito
    public void verCarrito(){
        System.out.println("--------------------------");
        int contador = 1;
        if(Carrito.isEmpty())
        {
            System.out.println("The cart is empty");
            return;
        }

            System.out.println("The cart have "+Carrito.size()+" candles");
            System.out.println("---YOUR CART---");

            for(Candle c : Carrito){
            System.out.println(contador + ". " +
                    c.getName() + "; " + c.getShortDescp() + "; "
                    + c.getAmount());
             contador++;
            }
        System.out.println("All :"+CalculateTotalPrice()+"eur.");
        System.out.println("-------------------------");

    }

    public void verPedido(Client cliente)
    {
        List<Order> orders = cliente.getOrdersClient();
        if(orders.isEmpty()){ // si no hay pedidos
            System.out.println("You not have orders");
        } else {
            System.out.println(" Your orders: ");
            for(Order order: orders){
               System.out.println(order);
            }
        }
    }
    public void menuCarrito() {

        opcionMenuCarrito opcion;
        do {
            System.out.println("-   -   -CARRITO-   -   -");
            verCarrito();
            System.out.println("---¿Que quieres hacer?---");
            System.out.println("1. Add candles");
            System.out.println("2. Reduce candles");
            System.out.println("3.Confirm purchase");
            System.out.println("0.Exist");
            System.out.println("-------------------------");
            try {

                int seleccion = sc.nextInt();
                sc.nextLine();
                opcion = opcionMenuCarrito.values()[seleccion];
                switch (opcion) {
                    case AÑADIRVELAS:
                        añadirVelas();
                        break;
                    case QUITARVELAS:
                        quitarVelas();
                        break;
                    case CONFIRMARCOMPRA:
                        confirmarCompra();
                        break;
                    case SALIRCARRITO:
                        return;
                    default:
                        System.out.println("Opcion invalid");
                }
            }
            catch(InputMismatchException |ArrayIndexOutOfBoundsException e)
            {
                System.out.println(("Error:Enter number valid please"));
            }
        } while (true) ;

    }

    public void añadirVelas() {
        verCarrito();
        System.out.println("-¿De cual quieres añadir?- (Number)");
        Candle c = Carrito.get(sc.nextInt()-1);
        System.out.println("-¿Cuantas quieres añadir?-");
        c.AnyadirCantidad(sc.nextInt());
    }

    public void quitarVelas() {
        verCarrito();
        System.out.println("-¿De cual quieres quitar?- (Number)");
        Candle c = Carrito.get(sc.nextInt()-1);
        System.out.println("-¿Cuantas quieres quitar?-");
        c.RestarCantidad(sc.nextInt());
    }

    public void confirmarCompra(){
        if(clienteSesionActual.getAddress() == ""){
            System.out.println("Phone Number: ");
            clienteSesionActual.setPhoneNumber(sc.nextInt());
            System.out.println("Postal Code: ");
            clienteSesionActual.setPostalCode(sc.nextLine());
            System.out.println("Province: ");
            clienteSesionActual.setProvince(sc.nextLine());
            System.out.println("Locality: ");
            clienteSesionActual.setLocality(sc.nextLine());
            System.out.println("Address: ");
            clienteSesionActual.setAddress(sc.nextLine());
        }

        System.out.println("---CreditCard Information---");
        String cardNum, CVV, titularName;
        Calendar expirationDate;
        boolean todoCorrecto = true;
        do{
            System.out.println("Credit Card Number: ");
            cardNum = sc.nextLine();
            System.out.println("CVV: ");
            CVV = sc.nextLine();

            if(cardNum.length() != 20 && CVV.length() != 3){
                System.out.println("Invalid Information");
                todoCorrecto = false;
            }
            else{
                todoCorrecto = true;
            }
        } while(!todoCorrecto);


        System.out.println("Titular's name: ");
        titularName = sc.nextLine();

        System.out.println("Expiration Date: ");
        FillDate();
        ConfirmarPedido();
    }

    public double CalculateTotalPrice(){
        double totalPrice = 0;
        for(Candle c : Carrito){
            totalPrice = c.getPrice() * c.getAmount();
        }

        return totalPrice;
    }

    public void ConfirmarPedido(){
        System.out.println("Are you sure of your purchase?(Y/N)");
        boolean letraCorrecta = false;
        do {
            if (sc.nextLine().equals("Y")) {
                letraCorrecta = true;
                System.out.println("Su pedido le llegara pronto");
                System.out.println("Gracias por su compra!");
                Calendar fechaHoraActual = Calendar.getInstance();
                clienteSesionActual.setNewOrderInList(new Order(CalculateTotalPrice(),
                        fechaHoraActual, clienteSesionActual ));
                Carrito.clear();
                System.out.println("Order confirmed");

            } else if (sc.nextLine().equals("N")) {
                letraCorrecta = true;
                System.out.println("Tomese su tiempo no importa");
                System.out.println("Gracias por confiar en nosotros!");
                menuCarrito();
            } else {
                System.out.println("Intente poner la letra indicada, por favor");
            }
        }while(!letraCorrecta);
    }

    //--------------------------------------------

    //--------------------------------------------

    public void FillDate(){
        LocalDate date;

        try{
            String input = sc.nextLine();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

            date = LocalDate.parse(input, formatter);

        } catch (Exception e) {
            System.out.println("Invalid Date");
            System.out.println();
            FillDate();
        }
    }


    //Search Client
    public static Client SearchClient(List<Usuario>usuarios, String email)
    {
        Client cliente=null;

        for(Usuario u:usuarios)
        {
            if(u instanceof Client) //Check if is type of client
            {
                Client c=(Client) u;
                if(email.equals(c.getEmail()))
                {
                    cliente=c;
                }
            }
        }
        return  cliente;
    }

    //Search Order
    public static List<Order>searchOrder(List<Order>orders,String email)
    {
        List<Order>orderClient=null;
        for(Order o:orders)
        {
            if(o.getClient().getEmail().equals(email))//Check if the email is same
            {
                orderClient.add(o);
            }
        }
        return orderClient;
    }

    //Search Fragance
    public static Fragance searchFragance(List<Fragance>fragances,String id)
    {
        for(Fragance f:fragances)
        {
            if(f.getID().equals(id))
            {
                return f;
            }
        }
        //if not found
        return null;
    }


    //List candle
    public static void ListCandle(List<Candle> stockCandles)
    {
        Scanner sc = new Scanner(System.in);
        int position=0;
        //List<Candle>candleInCart=new ArrayList<>();

        do {
            for (Candle c : stockCandles) {
                System.out.println("------List of Candle-----");
                System.out.println(c.ToString());
                System.out.println("Write the position of candle for add to cart");
                position=sc.nextInt();
            }
        }
        while(position!=0);

    }

}


