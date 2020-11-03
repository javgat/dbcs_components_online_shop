/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uva.dbcs.practica1.despliegue;

import es.uva.dbcs.practica1.dominio.Configuracionpc;
import java.util.List;
import javax.ejb.Stateless;

/**
 *
 * @author Javier
 */
@Stateless
public class CompCatalogoControlador implements CompCatalogoControladorRemote {

    @Override
    public List<Configuracionpc> getCatalogo() {
        return null;
    }

    @Override
    public Boolean addConfiguracion(int velCPU, int capRAM, int velTarGraf,
            int memTarGraf, short idTipoCPU, java.util.List<Integer> idsDescrComp) {
        return null;
    }

    @Override
    public Boolean editConfiguracion(int idConfiguracion, int velCPU, int capRAM,
            int capDD, double velTarGraf, int memTarGraf, short idTipoCPU) {
        return null;
    }

    @Override
    public float getPrecioTotal(int idConfiguracion) {
        return 0.0F;
    }
    
}
