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
import java.util.ArrayList;
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

    private Integer newIdConfig(){
        List<Configuracionpc> cat = getCatalogo();
        int id = 0;
        for(Configuracionpc c:cat){
            if (id <= c.getIdconfiguracion())
                id=c.getIdconfiguracion()+1;
        }
        return id;
    }
    
    @Override
    public Boolean addConfiguracion(int velCPU, int capRAM, int capDD, int velTarGraf,
            int memTarGraf, short idTipoCPU, java.util.List<Integer> idsDescrComp) {
        Integer idConfig = newIdConfig();
        Configuracionpc conf = new Configuracionpc(idConfig);
        conf.setVelocidadcpu(velCPU);
        conf.setCapacidadram(capRAM);
        conf.setCapacidaddd(capDD);
        conf.setVelocidadtarjetagrafica(velTarGraf);
        conf.setMemoriatarjetagrafica(memTarGraf);
        conf.setTipocpu(new Cpu(idTipoCPU));
        Collection<Descripcioncomponente> descrs = new ArrayList();
        for(Integer i : idsDescrComp){
            descrs.add(new Descripcioncomponente(i));
        }
        conf.setDescripcioncomponenteCollection(descrs);
        try{
            cpcF.create(conf);
        }catch(Exception e){
            return false;
        }
        return true;
    }

    @Override
    public Boolean editConfiguracion(int idConfiguracion, int velCPU, int capRAM,
            int capDD, int velTarGraf, int memTarGraf, short idTipoCPU) {
        Configuracionpc conf = cpcF.find(idConfiguracion);
        if(conf!=null){
            if(velCPU!=0)
                conf.setVelocidadcpu(velCPU);
            if(capRAM!=0)
                conf.setCapacidadram(capRAM);
            if(capDD!=0)
                conf.setCapacidaddd(capDD);
            if(velTarGraf!=0)
                conf.setVelocidadtarjetagrafica(velTarGraf);
            if(memTarGraf!=0)
                conf.setMemoriatarjetagrafica(memTarGraf);
            if(idTipoCPU!=0)
                conf.setTipocpu(new Cpu(idTipoCPU));
            try{
                cpcF.edit(conf);
            }catch(Exception e){
                return false;
            }
            return true;
        }
        return false;
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
