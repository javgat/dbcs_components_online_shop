/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uva.dbcs.practica1.persistencia;

import es.uva.dbcs.practica1.dominio.Descripcioncomponente;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Javier
 */
@Local
public interface DescripcioncomponenteFacadeLocal {

    void create(Descripcioncomponente descripcioncomponente);

    void edit(Descripcioncomponente descripcioncomponente);

    void remove(Descripcioncomponente descripcioncomponente);

    Descripcioncomponente find(Object id);

    List<Descripcioncomponente> findAll();

    List<Descripcioncomponente> findRange(int[] range);

    int count();
    
}
