/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uva.dbcs.practica1.despliegue;

import es.uva.dbcs.practica1.dominio.Usuario;
import es.uva.dbcs.practica1.persistencia.UsuarioFacadeLocal;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Javier
 */
@Stateless
public class CompUsuarioControlador implements CompUsuarioControladorLocal {
    @EJB
    private UsuarioFacadeLocal uF;

    @Override
    public void create(Usuario usuario) {
        uF.create(usuario);
    }

    @Override
    public Usuario retrieve(int id) {
        return uF.find(id);
    }

    @Override
    public void update(Usuario usuario) {
        uF.edit(usuario);
    }

    @Override
    public void delete(Usuario usuario) {
        uF.remove(usuario);
    }
    
}
