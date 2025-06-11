import com.dam.Candle;
import com.dam.Client;
import com.dam.Fragance;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GestionMenuTest {
    @Test
    public void homeSessionClientTest() throws Exception {
        Client c = new Client("Juan",
                "Diaz", "juan.diaz@gmail.com", "12345");

        //   List<Client> clients = List.of(c);
        //  Client client = Client.homeSessionCustomer(clients, "jorgeReyes@gmail.com", "Contraseña$");
    }
    // registro test
    @Test
    public void homeSessionAdminTest() throws Exception {
        //Admin a = new Admin("juanReyes@OnFire.com", "1234","00000F");
    }

    @Test
    public void addCountCandlesTest(){
        Fragance frangance = new Fragance("Lavanda", "F01","Francia vela con aroma a lavanda");
        Candle candle = new Candle("Vela relax", "Descripcion larga",
                "Descripcion corta",frangance, 15.00, "C001");
        assertEquals(0, candle.getAmount());
        // Add 3 candles
        candle.AnyadirCantidad(3);
        assertEquals(3, candle.getAmount());
        candle.AnyadirCantidad(0);
        assertEquals(5, candle.getAmount());
        candle.AnyadirCantidad(-1);
        assertEquals(4, candle.getAmount());
    }

    @Test
    public void reduceCount()
    {
        Fragance frangance = new Fragance("Lavanda", "F01","Francia vela con aroma a lavanda");
        Candle candle = new Candle("Vela relax", "Descripcion larga",
                "Descripcion corta",frangance, 15.00, "C001");
        assertEquals(0, candle.getAmount());
        //Reduce candle
        candle.RestarCantidad(3);
        assertEquals(3, candle.getAmount());
    }
}