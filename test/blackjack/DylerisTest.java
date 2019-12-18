package blackjack;

import static junit.framework.Assert.assertEquals;
import org.junit.Test;
import org.junit.*;

public class DylerisTest {
    
    @Test
    public void testGaliTraukti() {
        Dyleris instance = new Dyleris();
        boolean expResult = true;
        boolean result = instance.galiTraukti();
        assertEquals(expResult, result);
    }
    
}
