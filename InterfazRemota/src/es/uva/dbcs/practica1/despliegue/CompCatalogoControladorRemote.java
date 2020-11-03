/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uva.dbcs.practica1.despliegue;

import es.uva.dbcs.practica1.dominio.Configuracionpc;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author Javier
 */
@Remote
public interface CompCatalogoControladorRemote {

    List<Configuracionpc> getCatalogo();

    Boolean addConfiguracion(int velCPU, int capRAM, int velTarGraf, int memTarGraf, short idTipoCPU, java.util.List<Integer> idsDescrComp);

    Boolean editConfiguracion(int idConfiguracion, int velCPU, int capRAM, int capDD, double velTarGraf, int memTarGraf, short idTipoCPU);

    float getPrecioTotal(int idConfiguracion);
    
}
