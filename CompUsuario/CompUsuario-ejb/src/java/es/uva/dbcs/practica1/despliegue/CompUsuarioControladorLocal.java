/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uva.dbcs.practica1.despliegue;

import es.uva.dbcs.practica1.dominio.Empleado;
import es.uva.dbcs.practica1.dominio.Empresa;
import es.uva.dbcs.practica1.dominio.Usuario;
import javax.ejb.Local;

/**
 *
 * @author Javier
 */
@Local
public interface CompUsuarioControladorLocal {

    void create(Usuario usuario);

    Usuario retrieve(String id);

    void update(Usuario usuario);

    void delete(Usuario usuario);

    Empresa getEmpresa(String nifcif);

    Empleado getEmpleado(String nifcif);
    
}
