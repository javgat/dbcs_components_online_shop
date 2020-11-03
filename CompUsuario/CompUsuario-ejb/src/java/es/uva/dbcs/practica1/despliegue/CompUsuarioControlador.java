/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uva.dbcs.practica1.despliegue;

import es.uva.dbcs.practica1.dominio.Empleado;
import es.uva.dbcs.practica1.dominio.Empresa;
import es.uva.dbcs.practica1.dominio.Usuario;
import es.uva.dbcs.practica1.persistencia.EmpresaFacadeLocal;
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
    private EmpresaFacadeLocal eF;
    @EJB
    private UsuarioFacadeLocal uF;

    @Override
    public void create(Usuario usuario) {
        uF.create(usuario);
    }

    @Override
    public Usuario retrieve(String id) {
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

    @Override
    public Empresa getEmpresa(String nifcif) {
        /*Empresa emp = null;
        Usuario u = uF.find(nifcif);
        if(u!=null)
            emp = u.getEmpresa();
        return emp;*/
        return eF.find(nifcif);
    }

    @Override
    public Empleado getEmpleado(String nifcif) {
        Empleado emp = null;
        Usuario u = uF.find(nifcif);
        if(u!=null)
            emp = u.getEmpleado();
        return emp;
    }
    
    
    
}
