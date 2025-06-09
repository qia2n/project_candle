import com.dam.Client;
import org.junit.Test;

import static org.junit.Assert.*;

public class ClientTest {
    //Test name
    @Test
    public  void getName() {
        Client c=new Client("Juan","S","123456789@gmail.com","12345");
        assertNotNull(c.getName());
        assertEquals("Juan", c.getName());
    }

    //Test email
    @Test
    public void emailValido()
    {
        assertFalse(Client.emailValido("1234567"));
        assertTrue(Client.emailValido("1234567@gmail.com"));
    }
}

