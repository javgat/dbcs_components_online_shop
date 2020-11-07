/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uva.dbcs.practica1.dominio;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Javier
 */
@Entity
@Table(name = "CPU")
@NamedQueries({
    @NamedQuery(name = "Cpu.findAll", query = "SELECT c FROM Cpu c"),
    @NamedQuery(name = "Cpu.findByIdtipocpu", query = "SELECT c FROM Cpu c WHERE c.idtipocpu = :idtipocpu"),
    @NamedQuery(name = "Cpu.findByNombretipocpu", query = "SELECT c FROM Cpu c WHERE c.nombretipocpu = :nombretipocpu")})
public class Cpu implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "IDTIPOCPU")
    private Short idtipocpu;
    @Basic(optional = false)
    @Column(name = "NOMBRETIPOCPU")
    private String nombretipocpu;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipocpu", fetch=FetchType.EAGER)
    private Collection<Configuracionpc> configuracionpcCollection;

    public Cpu() {
    }

    public Cpu(Short idtipocpu) {
        this.idtipocpu = idtipocpu;
    }

    public Cpu(Short idtipocpu, String nombretipocpu) {
        this.idtipocpu = idtipocpu;
        this.nombretipocpu = nombretipocpu;
    }

    public Short getIdtipocpu() {
        return idtipocpu;
    }

    public void setIdtipocpu(Short idtipocpu) {
        this.idtipocpu = idtipocpu;
    }

    public String getNombretipocpu() {
        return nombretipocpu;
    }

    public void setNombretipocpu(String nombretipocpu) {
        this.nombretipocpu = nombretipocpu;
    }

    public Collection<Configuracionpc> getConfiguracionpcCollection() {
        return configuracionpcCollection;
    }

    public void setConfiguracionpcCollection(Collection<Configuracionpc> configuracionpcCollection) {
        this.configuracionpcCollection = configuracionpcCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtipocpu != null ? idtipocpu.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cpu)) {
            return false;
        }
        Cpu other = (Cpu) object;
        if ((this.idtipocpu == null && other.idtipocpu != null) || (this.idtipocpu != null && !this.idtipocpu.equals(other.idtipocpu))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "es.uva.dbcs.practica1.dominio.Cpu[ idtipocpu=" + idtipocpu + " ]";
    }
    
}
