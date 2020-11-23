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
 * @author Javier Gatón Herguedas y Javier Moro García
 */
@Remote
public interface CompCatalogoControladorRemote {
    /**
     * Devolverá una lista con todas las configuraciones de PC de que se dispone
     * @return lista con las configuraciones guardadas
     */
    List<Configuracionpc> getCatalogo();
    
    /**
     * 
     * @param velCPU velocidad de la CPU
     * @param capRAM capacidad de la memoria ram
     * @param capDD capacidad del disco duro
     * @param velTarGraf velocidad tarjeta gráfica
     * @param memTarGraf memoria tarjeta gráfica
     * @param idTipoCPU
     * @param idsDescrComp 
     * @return devolerá true si la operación se ha realizado correctamente
     *         y false si ha habido algún error
     */
    Boolean addConfiguracion(int velCPU, int capRAM, int capDD, int velTarGraf, int memTarGraf, short idTipoCPU, java.util.List<Integer> idsDescrComp);

    /**
     * Modificará la configuración correspondiente al id insertado según las 
     * especificaciones que se quieran modificar. Si el valor está a 0 entonces
     * no se producirá modificacion en ese parámetro
     * @param idConfiguracion
     * @param velCPU velocidad de la CPU
     * @param capRAM capacidad de la memoria ram
     * @param capDD capacidad del disco duro
     * @param velTarGraf velocidad tarjeta gráfica
     * @param memTarGraf memoria tarjeta gráfica
     * @param idTipoCPU
     * @return devolerá true si la operación se ha realizado correctamente
     *         y false si ha habido algún error
     */
    Boolean editConfiguracion(int idConfiguracion, int velCPU, int capRAM, int capDD, int velTarGraf, int memTarGraf, short idTipoCPU);
    
    /**
     * Devuelve en formato float el precio final de una
     * determinada configuración, la pasada como argumento.
     * @param idConfiguracion
     * @return devolerá true si la operación se ha realizado correctamente
     *         y false si ha habido algún error
     */
    float getPrecioTotal(int idConfiguracion);
    
}
