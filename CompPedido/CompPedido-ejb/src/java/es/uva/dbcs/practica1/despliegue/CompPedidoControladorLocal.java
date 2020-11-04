/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uva.dbcs.practica1.despliegue;

import javax.ejb.Remote;

/**
 *
 * @author Javier
 */
@Remote
public interface CompPedidoControladorLocal {

    float importeAbonar(String nifcif);

    Boolean addPedido(int cantidad, int idConfiguracion, String nifcif);

    Boolean delPedido(int idConfiguracion, String nifcif);
    
}
