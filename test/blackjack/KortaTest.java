package blackjack;

import static junit.framework.Assert.assertEquals;
import org.junit.Test;
import org.junit.*;

public class KortaTest {
    
    @Test
    
    public void testTuzas() {
        Korta korta = new Korta(9);
        boolean expResult = false;
        boolean result = korta.tuzas();
        assertEquals(expResult, result);
    }

    @Test
    public void testVerte() {
        Korta korta = new Korta(9);
        int expResult = 10;
        int result = korta.verte();
        assertEquals(expResult, result);
    }    
}
