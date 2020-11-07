/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uva.dbcs.practica1.despliegue;

import es.uva.dbcs.practica1.dominio.Empleado;
import es.uva.dbcs.practica1.dominio.Empresa;
import javax.ejb.Local;

/**
 *
 * @author Javier
 */
@Local
public interface CompUsuarioControladorLocal {

    /**
     * Obtiene una Entity de tipo Empresa a partir del identificador del usuario
     * @param nifcif nif del usuario
     * @return 
     */
    Empresa getEmpresa(String nifcif);
    
    /**
     * Obtiene una Entity de tipo Empleado a partir del identificado del usuario
     * @param nifcif nif del usuario
     * @return 
     */
    Empleado getEmpleado(String nifcif);
    
}
