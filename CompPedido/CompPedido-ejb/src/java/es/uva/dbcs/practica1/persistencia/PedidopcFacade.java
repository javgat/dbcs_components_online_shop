/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uva.dbcs.practica1.persistencia;

import es.uva.dbcs.practica1.dominio.Pedidopc;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Javier
 */
@Stateless
public class PedidopcFacade extends AbstractFacade<Pedidopc> implements PedidopcFacadeLocal {
    @PersistenceContext(unitName = "CompPedido-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PedidopcFacade() {
        super(Pedidopc.class);
    }
    
}
