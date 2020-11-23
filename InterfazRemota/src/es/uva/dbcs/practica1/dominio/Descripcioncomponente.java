/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uva.dbcs.practica1.dominio;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Javier Gatón Herguedas y Javier Moro García
 */
@Entity
@Table(name = "DESCRIPCIONCOMPONENTE")
@NamedQueries({
    @NamedQuery(name = "Descripcioncomponente.findAll", query = "SELECT d FROM Descripcioncomponente d"),
    @NamedQuery(name = "Descripcioncomponente.findByIddescripcion", query = "SELECT d FROM Descripcioncomponente d WHERE d.iddescripcion = :iddescripcion"),
    @NamedQuery(name = "Descripcioncomponente.findByMarca", query = "SELECT d FROM Descripcioncomponente d WHERE d.marca = :marca"),
    @NamedQuery(name = "Descripcioncomponente.findByModelo", query = "SELECT d FROM Descripcioncomponente d WHERE d.modelo = :modelo"),
    @NamedQuery(name = "Descripcioncomponente.findByPrecio", query = "SELECT d FROM Descripcioncomponente d WHERE d.precio = :precio"),
    @NamedQuery(name = "Descripcioncomponente.findByCaracteristicastecnicas", query = "SELECT d FROM Descripcioncomponente d WHERE d.caracteristicastecnicas = :caracteristicastecnicas")})
public class Descripcioncomponente implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "IDDESCRIPCION")
    private Integer iddescripcion;
    @Basic(optional = false)
    @Column(name = "MARCA")
    private String marca;
    @Column(name = "MODELO")
    private String modelo;
    @Column(name = "PRECIO")
    private Integer precio;
    @Column(name = "CARACTERISTICASTECNICAS")
    private String caracteristicastecnicas;
    @ManyToMany(mappedBy = "descripcioncomponenteCollection", fetch=FetchType.EAGER)
    private Collection<Configuracionpc> configuracionpcCollection;
    @JoinColumn(name = "TIPO", referencedColumnName = "IDTIPOCOMPONENTE")
    @ManyToOne(optional = false, fetch=FetchType.EAGER)
    private Tipocomponente tipo;

    public Descripcioncomponente() {
    }

    public Descripcioncomponente(Integer iddescripcion) {
        this.iddescripcion = iddescripcion;
    }

    public Descripcioncomponente(Integer iddescripcion, String marca) {
        this.iddescripcion = iddescripcion;
        this.marca = marca;
    }

    public Integer getIddescripcion() {
        return iddescripcion;
    }

    public void setIddescripcion(Integer iddescripcion) {
        this.iddescripcion = iddescripcion;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Integer getPrecio() {
        return precio;
    }

    public void setPrecio(Integer precio) {
        this.precio = precio;
    }

    public String getCaracteristicastecnicas() {
        return caracteristicastecnicas;
    }

    public void setCaracteristicastecnicas(String caracteristicastecnicas) {
        this.caracteristicastecnicas = caracteristicastecnicas;
    }

    public Collection<Configuracionpc> getConfiguracionpcCollection() {
        return configuracionpcCollection;
    }

    public void setConfiguracionpcCollection(Collection<Configuracionpc> configuracionpcCollection) {
        this.configuracionpcCollection = configuracionpcCollection;
    }

    public Tipocomponente getTipo() {
        return tipo;
    }

    public void setTipo(Tipocomponente tipo) {
        this.tipo = tipo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iddescripcion != null ? iddescripcion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Descripcioncomponente)) {
            return false;
        }
        Descripcioncomponente other = (Descripcioncomponente) object;
        if ((this.iddescripcion == null && other.iddescripcion != null) || (this.iddescripcion != null && !this.iddescripcion.equals(other.iddescripcion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "es.uva.dbcs.practica1.dominio.Descripcioncomponente[ iddescripcion=" + iddescripcion + " ]";
    }
    
}
