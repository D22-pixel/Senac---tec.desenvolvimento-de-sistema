/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package sistemaimpostos;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Denise
 */
public class ImpostoPisTest {
    
    public ImpostoPisTest() {
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
     * Test of getValorDebito method, of class ImpostoPis.
     */
    @Test
    public void testGetValorDebito() {
        System.out.println("getValorDebito");
        ImpostoPis instance = null;
        double expResult = 0.0;
        double result = instance.getValorDebito();
        assertEquals(expResult, result, 0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getValorCredito method, of class ImpostoPis.
     */
    @Test
    public void testGetValorCredito() {
        System.out.println("getValorCredito");
        ImpostoPis instance = null;
        double expResult = 0.0;
        double result = instance.getValorCredito();
        assertEquals(expResult, result, 0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setValorDebito method, of class ImpostoPis.
     */
    @Test
    public void testSetValorDebito() {
        System.out.println("setValorDebito");
        double valorDebito = 0.0;
        ImpostoPis instance = null;
        instance.setValorDebito(valorDebito);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setValorCredito method, of class ImpostoPis.
     */
    @Test
    public void testSetValorCredito() {
        System.out.println("setValorCredito");
        double valorCredito = 0.0;
        ImpostoPis instance = null;
        instance.setValorCredito(valorCredito);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of calcularImposto method, of class ImpostoPis.
     */
    @Test
    public void testCalcularImposto() {
        System.out.println("calcularImposto");
        ImpostoPis instance = null;
        double expResult = 0.0;
        double result = instance.calcularImposto();
        assertEquals(expResult, result, 0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDetalhesCalculo method, of class ImpostoPis.
     */
    @Test
    public void testGetDetalhesCalculo() {
        System.out.println("getDetalhesCalculo");
        ImpostoPis instance = null;
        String expResult = "";
        String result = instance.getDetalhesCalculo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
