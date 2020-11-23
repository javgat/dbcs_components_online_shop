/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uva.dbcs.practica1.persistencia;

import es.uva.dbcs.practica1.dominio.Pedidopc;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Javier Gatón Herguedas y Javier Moro García
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

    @Override
    public List<Pedidopc> pedidosNif(String nifcif) {
        Query query = em.createNamedQuery("Pedidopc.findByEncargadopor");
        query.setParameter("encargadopor", nifcif);
        List<Pedidopc> peds = query.getResultList();
        return peds;
    }
    
    @Override
    public Pedidopc getPedidoNifId(String nifcif, int idConfig){
        Query query = em.createNamedQuery("Pedidopc.findByEncargadoConfig");
        query.setParameter("encargadopor", nifcif);
        query.setParameter("configuracionsolicitada", idConfig);
        Pedidopc ped = (Pedidopc) query.getResultList().get(0);
        return ped;
    }
    
}
