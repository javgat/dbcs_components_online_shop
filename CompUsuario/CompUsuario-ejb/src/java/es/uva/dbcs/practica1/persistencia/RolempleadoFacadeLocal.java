/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uva.dbcs.practica1.persistencia;

import es.uva.dbcs.practica1.dominio.Rolempleado;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Javier Gatón Herguedas y Javier Moro García
 */
@Local
public interface RolempleadoFacadeLocal {

    void create(Rolempleado rolempleado);

    void edit(Rolempleado rolempleado);

    void remove(Rolempleado rolempleado);

    Rolempleado find(Object id);

    List<Rolempleado> findAll();

    List<Rolempleado> findRange(int[] range);

    int count();
    
}
