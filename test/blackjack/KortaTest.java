package blackjack;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class KortaTest {
    
    public KortaTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of tuzas method, of class Korta.
     */
    @Test
    public void testTuzas() {
        System.out.println("tuzas");
        Korta instance = null;
        boolean expResult = false;
        boolean result;
        
        result = Korta.tuzas();
        
        assertEquals(expResult, result);
    }

    /**
     * Test of verte method, of class Korta.
     */
    @Test
    public void testVerte() {
        System.out.println("verte");
        Korta instance = null;
        int expResult = 0;
        int result = instance.verte();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }    
}
