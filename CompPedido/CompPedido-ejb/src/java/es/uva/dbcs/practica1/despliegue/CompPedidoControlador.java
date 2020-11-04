/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uva.dbcs.practica1.despliegue;

import es.uva.dbcs.practica1.dominio.Pedidopc;
import es.uva.dbcs.practica1.persistencia.PedidopcFacadeLocal;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Javier
 */
@Stateless
public class CompPedidoControlador implements CompPedidoControladorRemote {
    @EJB
    private PedidopcFacadeLocal ppF;    
    
    
    
    @Override
    public float importeAbonar(String nifcif) {
        List<Pedidopc> peds = ppF.pedidosNif(nifcif);
        float precio = 0.0F;
        
        for(Pedidopc ped : peds){
            precio+= 0;
        }
        return 0.0F;
    }

    @Override
    public Boolean addPedido(int cantidad, int idConfiguracion, String nifcif) {
        int id = 0;
        Pedidopc ped = new Pedidopc(id, cantidad, idConfiguracion, nifcif);
        try{
            ppF.create(ped);
        }catch(Exception e){
            System.out.println(e);
            return false;
        }
        return true;
    }

    @Override
    public Boolean delPedido(int idConfiguracion, String nifcif) {
        return null;
    }

    
}
