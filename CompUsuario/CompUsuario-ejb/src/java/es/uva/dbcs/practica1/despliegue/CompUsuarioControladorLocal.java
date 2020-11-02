/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uva.dbcs.practica1.despliegue;

import es.uva.dbcs.practica1.dominio.Usuario;
import javax.ejb.Local;

/**
 *
 * @author Javier
 */
@Local
public interface CompUsuarioControladorLocal {

    void create(Usuario usuario);

    Usuario retrieve(int id);

    void update(Usuario usuario);

    void delete(Usuario usuario);
    
}
