/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates   
 * and open the template in the editor.
 */
package es.uva.dbcs.practica1.dominio;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Javier Gatón Herguedas y Javier Moro García
 */
@Entity
@Table(name = "PEDIDOPC")
@NamedQueries({
    @NamedQuery(name = "Pedidopc.findAll", query = "SELECT p FROM Pedidopc p"),
    @NamedQuery(name = "Pedidopc.findByIdpedido", query = "SELECT p FROM Pedidopc p WHERE p.idpedido = :idpedido"),
    @NamedQuery(name = "Pedidopc.findByCantidadsolicitada", query = "SELECT p FROM Pedidopc p WHERE p.cantidadsolicitada = :cantidadsolicitada"),
    @NamedQuery(name = "Pedidopc.findByConfiguracionsolicitada", query = "SELECT p FROM Pedidopc p WHERE p.configuracionsolicitada = :configuracionsolicitada"),
    @NamedQuery(name = "Pedidopc.findByEncargadopor", query = "SELECT p FROM Pedidopc p WHERE p.encargadopor = :encargadopor"),
    @NamedQuery(name = "Pedidopc.findByEncargadoConfig", query = "SELECT p FROM Pedidopc p WHERE p.encargadopor = :encargadopor AND p.configuracionsolicitada = :configuracionsolicitada")})
public class Pedidopc implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDPEDIDO")
    private Integer idpedido;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CANTIDADSOLICITADA")
    private int cantidadsolicitada;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CONFIGURACIONSOLICITADA")
    private int configuracionsolicitada;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 9)
    @Column(name = "ENCARGADOPOR")
    private String encargadopor;
    @JoinColumn(name = "ESTADO", referencedColumnName = "IDESTADOVENTA")
    @ManyToOne(optional = false)
    private Estadoventapcs estado;

    public Pedidopc() {
    }

    public Pedidopc(Integer idpedido) {
        this.idpedido = idpedido;
    }

    public Pedidopc(Integer idpedido, int cantidadsolicitada, int configuracionsolicitada, String encargadopor) {
        this.idpedido = idpedido;
        this.cantidadsolicitada = cantidadsolicitada;
        this.configuracionsolicitada = configuracionsolicitada;
        this.encargadopor = encargadopor;
    }

    public Integer getIdpedido() {
        return idpedido;
    }

    public void setIdpedido(Integer idpedido) {
        this.idpedido = idpedido;
    }

    public int getCantidadsolicitada() {
        return cantidadsolicitada;
    }

    public void setCantidadsolicitada(int cantidadsolicitada) {
        this.cantidadsolicitada = cantidadsolicitada;
    }

    public int getConfiguracionsolicitada() {
        return configuracionsolicitada;
    }

    public void setConfiguracionsolicitada(int configuracionsolicitada) {
        this.configuracionsolicitada = configuracionsolicitada;
    }

    public String getEncargadopor() {
        return encargadopor;
    }

    public void setEncargadopor(String encargadopor) {
        this.encargadopor = encargadopor;
    }

    public Estadoventapcs getEstado() {
        return estado;
    }

    public void setEstado(Estadoventapcs estado) {
        this.estado = estado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idpedido != null ? idpedido.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pedidopc)) {
            return false;
        }
        Pedidopc other = (Pedidopc) object;
        if ((this.idpedido == null && other.idpedido != null) || (this.idpedido != null && !this.idpedido.equals(other.idpedido))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "es.uva.dbcs.practica1.dominio.Pedidopc[ idpedido=" + idpedido + " ]";
    }
    
}
