/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uva.dbcs.practica1.despliegue;

import es.uva.dbcs.practica1.dominio.Empleado;
import es.uva.dbcs.practica1.dominio.Empresa;
import javax.ejb.embeddable.EJBContainer;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author cevp
 */
public class CompUsuarioControladorTest {

    static EJBContainer container;

    public CompUsuarioControladorTest() {
    }

    @BeforeClass
    public static void setUpClass() {
        try {
            container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        } catch (Exception e) {
            System.out.println("Error al crear el contenedor embebido " + e.toString());
            fail("Fallo al crear el contenedor embebido");
        }
    }

    @AfterClass
    public static void tearDownClass() {
        container.close();
    }

    /**
     * Test of getEmpresa method, of class CompUsuarioControlador.
     */
    @Test
    public void testGetEmpresa_NULL() throws Exception {
        System.out.println("getEmpresa: no existe");
        String nifcif = "NoExiste";
        //EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        CompUsuarioControladorLocal instance = (CompUsuarioControladorLocal) container.getContext().lookup("java:global/classes/CompUsuarioControlador");
        Empresa expResult = null;
        Empresa result = instance.getEmpresa(nifcif);
        assertEquals("Empresa no existe",expResult, result);
        //container.close();
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
    @Test
    public void testGetEmpresa_NoNULL() throws Exception {
        System.out.println("getEmpresa: existe");
        String nifcif = "111111U";
        //EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        CompUsuarioControladorLocal instance = (CompUsuarioControladorLocal) container.getContext().lookup("java:global/classes/CompUsuarioControlador");
        Short expResult = 1;
        Empresa result = instance.getEmpresa(nifcif);
        assertEquals("Empresa existe y es cliente",expResult, result.getEscliente());
        //container.close();
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getEmpleado method, of class CompUsuarioControlador.
     */
    @Test
    public void testGetEmpleado_NULL() throws Exception {
        System.out.println("getEmpleado: no existe");
        String nifcif = "NoExiste";
        //EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        CompUsuarioControladorLocal instance = (CompUsuarioControladorLocal) container.getContext().lookup("java:global/classes/CompUsuarioControlador");
        Empleado expResult = null;
        Empleado result = instance.getEmpleado(nifcif);
        assertEquals("Empleado no existe",expResult, result);
        //container.close();
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
    @Test
    public void testGetEmpleado_NoNULL_rol() throws Exception {
        System.out.println("getEmpleado: existe y es GerenteVentas");
        String nifcif = "444444U";
        //EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        CompUsuarioControladorLocal instance = (CompUsuarioControladorLocal) container.getContext().lookup("java:global/classes/CompUsuarioControlador");
        String expResult = "GerenteVentas";
        Empleado result = instance.getEmpleado(nifcif);
        assertEquals("Empleado es GerenteVentas",expResult, result.getRol().getNombrerol());
        //container.close();
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
    @Test
    public void testGetEmpleado_NoNULL_password() throws Exception {
        System.out.println("getEmpleado: existe y comprobamos su password");
        String nifcif = "222222U";
        //EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        CompUsuarioControladorLocal instance = (CompUsuarioControladorLocal) container.getContext().lookup("java:global/classes/CompUsuarioControlador");
        String expResult = "222";
        Empleado result = instance.getEmpleado(nifcif);
        assertEquals("Empleado es GerenteVentas",expResult, result.getUsuario().getPassword());
        //container.close();
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

}
