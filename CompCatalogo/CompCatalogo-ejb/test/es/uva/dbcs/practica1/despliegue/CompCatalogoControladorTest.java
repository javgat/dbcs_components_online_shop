/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uva.dbcs.practica1.despliegue;

import es.uva.dbcs.practica1.dominio.Configuracionpc;
import java.util.Arrays;
import java.util.List;
import javax.ejb.embeddable.EJBContainer;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 *
 * @author cevp
 */
public class CompCatalogoControladorTest {
    
    static EJBContainer container;
    
    public CompCatalogoControladorTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        try {
            container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        } catch (Exception e) {
            System.out.println("ERROR" + e.toString());
            fail("Fallo al crear el contenedor embebido");
        }
    }
    
    @AfterClass
    public static void tearDownClass() {
        container.close();
    }
    

    /**
     * Test of getCatalogo method, of class CompCatalogoControlador.
     */
    @Test
    public void testGetCatalogo() throws Exception {
        System.out.println("getCatalogo");
        //EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        CompCatalogoControladorRemote instance = (CompCatalogoControladorRemote)container.getContext().lookup("java:global/classes/CompCatalogoControlador");
        List<Configuracionpc> result = instance.getCatalogo();
        int expResult = 3;
        assertEquals(expResult, result.get(0).getVelocidadcpu());  // velocidad CPU
        String expResult2 = "AMD"; // Tipo CPU
        assertEquals(expResult2, result.get(0).getTipocpu().getNombretipocpu());
        expResult = 11; // precio
        assertEquals(expResult, (int) result.get(0).getDescripcioncomponenteCollection().iterator().next()/*.get(0)*/.getPrecio());
        //container.close();
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of addConfiguracion method, of class CompCatalogoControlador.
     */
    //@Ignore
    @Test
    public void testAddConfiguracion_NoErr() throws Exception {
        System.out.println("addConfiguracion Sin error");
        List<Integer> descripcion = Arrays.asList(111,888,999,444,555,666);
        //EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        CompCatalogoControladorRemote instance = (CompCatalogoControladorRemote)container.getContext().lookup("java:global/classes/CompCatalogoControlador");
        Boolean result = instance.addConfiguracion(12, 12, 12, 12, 12, (short) 1, descripcion);
        assertTrue(result);
        //container.close();
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
    @Test
    public void testAddConfiguracion_Err_TipoCPU() throws Exception {
        System.out.println("addConfiguracion Sin error");
        List<Integer> descripcion = Arrays.asList(111,888,999,444,555,666);
        //EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        CompCatalogoControladorRemote instance = (CompCatalogoControladorRemote)container.getContext().lookup("java:global/classes/CompCatalogoControlador");
        Boolean result = instance.addConfiguracion(12, 12, 12, 12, 12, (short) 8, descripcion);
        assertFalse(result);
        //container.close();
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
    @Test
    public void testAddConfiguracion_Err_Descr() throws Exception {
        System.out.println("addConfiguracion Sin error");
        List<Integer> descripcion = Arrays.asList(111,0,999,444,555,666);
        //EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        CompCatalogoControladorRemote instance = (CompCatalogoControladorRemote)container.getContext().lookup("java:global/classes/CompCatalogoControlador");
        Boolean result = instance.addConfiguracion(12, 12, 12, 12, 12, (short) 1, descripcion);
        assertFalse(result);
        //container.close();
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of editConfiguracion method, of class CompCatalogoControlador.
     */
    //@Ignore
    @Test
    public void testEditConfiguracion_NoErr_Valor() throws Exception {
        System.out.println("editConfiguracion");
        //EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        CompCatalogoControladorRemote instance = (CompCatalogoControladorRemote)container.getContext().lookup("java:global/classes/CompCatalogoControlador");
        Boolean result = instance.editConfiguracion(2222, 4, 0, 0, 4, 0, (short) 0);
        assertTrue(result);
        //container.close();
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
    @Test
    public void testEditConfiguracion_NoErr_CPU() throws Exception {
        System.out.println("editConfiguracion");
        //EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        CompCatalogoControladorRemote instance = (CompCatalogoControladorRemote)container.getContext().lookup("java:global/classes/CompCatalogoControlador");
        Boolean result = instance.editConfiguracion(3333, 0, 0, 0, 0, 0, (short) 2);
        assertTrue(result);
        //container.close();
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
    @Test
    public void testEditConfiguracion_Err_IdConf() throws Exception {
        System.out.println("editConfiguracion");
        //EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        CompCatalogoControladorRemote instance = (CompCatalogoControladorRemote)container.getContext().lookup("java:global/classes/CompCatalogoControlador");
        Boolean result = instance.editConfiguracion(8888, 4, 0, 0, 4, 0, (short) 0);
        assertFalse(result);
        //container.close();
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
    @Test
    public void testEditConfiguracion_Err_IdCPU() throws Exception {
        System.out.println("editConfiguracion");
        //EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        CompCatalogoControladorRemote instance = (CompCatalogoControladorRemote)container.getContext().lookup("java:global/classes/CompCatalogoControlador");
        Boolean result = instance.editConfiguracion(2222, 0, 0, 0, 0, 0, (short) 8);
        assertFalse(result);
        //container.close();
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getPrecioTotal method, of class CompCatalogoControlador.
     */
    //@Ignore
    @Test
    public void testGetPrecioTotal_NoErr() throws Exception {
        System.out.println("getPrecioTotal");
        int idConfiguracion = 1111;
        //EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        CompCatalogoControladorRemote instance = (CompCatalogoControladorRemote)container.getContext().lookup("java:global/classes/CompCatalogoControlador");
        float expResult = 6422.0F;
        float result = instance.getPrecioTotal(idConfiguracion);
        assertEquals(expResult, result, 0.0);
        //container.close();
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
    @Test
    public void testGetPrecioTotal_Err() throws Exception {
        System.out.println("getPrecioTotal");
        int idConfiguracion = 8888;
        //EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        CompCatalogoControladorRemote instance = (CompCatalogoControladorRemote)container.getContext().lookup("java:global/classes/CompCatalogoControlador");
        float expResult = -1.0F;
        float result = instance.getPrecioTotal(idConfiguracion);
        assertEquals(expResult, result, 0.0);
        //container.close();
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
