/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uva.dbcs.practica1.despliegue;

import es.uva.dbcs.practica1.dominio.Estadoventapcs;
import es.uva.dbcs.practica1.dominio.Pedidopc;
import es.uva.dbcs.practica1.persistencia.PedidopcFacadeLocal;
//import es.uva.dbcs.practica1.despliegue.CompCatalogoControladorRemote;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Javier Gatón Herguedas y Javier Moro García
 */
@Stateless
public class CompPedidoControlador implements CompPedidoControladorLocal {
    @EJB
    private PedidopcFacadeLocal ppF;    
    
    @EJB
    private CompCatalogoControladorRemote cccR;
    
    @Override
    public float importeAbonar(String nifcif) {
        try{
            // La siguiente operacion que se ejecuta es por una namedquery, tal y como se indica en el enunciado
            // Se puede comprobar en PedidopcFacadeLocal
            List<Pedidopc> peds = ppF.pedidosNif(nifcif);
            float precio = 0.0F;
            if(peds.isEmpty())
                return -1.0F; 
            //Se suman todos los precios de los componentes de los pedidos del usuario
            for(Pedidopc ped : peds){
                if(ped.getEstado().getNombreestadoventa().equals("Completado"))
                    precio+= cccR.getPrecioTotal(ped.getConfiguracionsolicitada())*ped.getCantidadsolicitada();
            }
            return precio;
        }catch(Exception e){
            System.err.println(e);
            return -1.0F;
        }
    }

    /*
    * Obtiene la nueva id valida para un pedido
    */
    private int newPedidoId(){
        List<Pedidopc> peds = ppF.findAll();
        int id = 0;
        //Busqueda de un nuevo id valido para la base de datos
        for(Pedidopc ped:peds){
            if (id <= ped.getIdpedido())
                id=ped.getIdpedido()+1;
        }
        return id;
    }
    
    
    @Override
    public Boolean addPedido(int cantidad, int idConfiguracion, String nifcif) {
        int id = newPedidoId();
        Pedidopc ped = new Pedidopc(id, cantidad, idConfiguracion, nifcif);
        ped.setEstado(new Estadoventapcs((short)1));
        try{
            ppF.create(ped);
        }catch(Exception e){
            System.err.println("ERROR ADDPEDIDO "+e);
            return false;
        }
        return true;
    }

    @Override
    public Boolean delPedido(int idConfiguracion, String nifcif) {
        try{
            // La siguiente operacion que se ejecuta es por una namedquery, tal y como se indica en el enunciado
            // Se puede comprobar en PedidopcFacadeLocal
            Pedidopc ped = ppF.getPedidoNifId(nifcif, idConfiguracion);
            ppF.remove(ped);
        }catch(Exception e){
            System.err.println(e);
            return false;
        }
        return true;
    }

    
}
