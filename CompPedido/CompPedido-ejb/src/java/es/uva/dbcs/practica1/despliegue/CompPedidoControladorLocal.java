/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uva.dbcs.practica1.despliegue;

import javax.ejb.Remote;

/**
 *
 * @author Javier Gatón Herguedas y Javier Moro García
 */
@Remote
public interface CompPedidoControladorLocal {
    /**
     * Devuelve el importe a abonar por los pedidos completados, solo 
     * los completados, del usuario introducido como argumento
     * @param nifcif nif del usuario
     * @return 
     */
    float importeAbonar(String nifcif);

    /**
     * Añadirá un nuevo pedido a la base de datos con la configuracion deseada,
     * su cantidad y el identificador del usuario
     * @param cantidad 
     * @param idConfiguracion
     * @param nifcif nif del usuario
     * @return 
     */
    Boolean addPedido(int cantidad, int idConfiguracion, String nifcif);

    /**
     * Borrara el pedido asociado al usuario y su configuarion
     * @param idConfiguracion
     * @param nifcif nif del usuario
     * @return 
     */
    Boolean delPedido(int idConfiguracion, String nifcif);
    
}
