/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uva.dbcs.practica1.despliegue;

import es.uva.dbcs.practica1.dominio.Configuracionpc;
import es.uva.dbcs.practica1.dominio.Cpu;
import es.uva.dbcs.practica1.dominio.Descripcioncomponente;
import es.uva.dbcs.practica1.persistencia.ConfiguracionpcFacadeLocal;
import java.util.Collection;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Javier
 */
@Stateless
public class CompCatalogoControlador implements CompCatalogoControladorRemote {
    @EJB
    private ConfiguracionpcFacadeLocal cpcF;

    @Override
    public List<Configuracionpc> getCatalogo() {
        return cpcF.findAll();
    }

    @Override
    public Boolean addConfiguracion(int velCPU, int capRAM, int velTarGraf,
            int memTarGraf, short idTipoCPU, java.util.List<Integer> idsDescrComp) {
        Configuracionpc conf = new Configuracionpc();
        conf.setVelocidadcpu(velCPU);
        conf.setCapacidadram(capRAM);
        conf.setVelocidadtarjetagrafica(velTarGraf);
        conf.setMemoriatarjetagrafica(memTarGraf);
        conf.setTipocpu(new Cpu(idTipoCPU));
        //FALTA ESTO EL METODO ESTA SIN ACABAR
        conf.setDescripcioncomponenteCollection(null);
        cpcF.create(conf);
        return null;
    }

    @Override
    public Boolean editConfiguracion(int idConfiguracion, int velCPU, int capRAM,
            int capDD, double velTarGraf, int memTarGraf, short idTipoCPU) {
        return null;
    }

    @Override
    public float getPrecioTotal(int idConfiguracion) {
        Configuracionpc conf = cpcF.find(idConfiguracion);
        float precio = -1.0F;
        if(conf!=null){
            Collection<Descripcioncomponente> col = conf.getDescripcioncomponenteCollection();
            precio = 0.0F;
            for(Descripcioncomponente d : col){
                precio+=d.getPrecio();
            }
        }
        return precio;
    }
    
}
