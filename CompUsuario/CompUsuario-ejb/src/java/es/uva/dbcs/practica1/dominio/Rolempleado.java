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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Javier Gatón Herguedas y Javier Moro García
 */
@Entity
@Table(name = "ROLEMPLEADO")
@NamedQueries({
    @NamedQuery(name = "Rolempleado.findAll", query = "SELECT r FROM Rolempleado r"),
    @NamedQuery(name = "Rolempleado.findByIdrol", query = "SELECT r FROM Rolempleado r WHERE r.idrol = :idrol"),
    @NamedQuery(name = "Rolempleado.findByNombrerol", query = "SELECT r FROM Rolempleado r WHERE r.nombrerol = :nombrerol")})
public class Rolempleado implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDROL")
    private Short idrol;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "NOMBREROL")
    private String nombrerol;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "rol", fetch=FetchType.EAGER)
    private Collection<Empleado> empleadoCollection;

    public Rolempleado() {
    }

    public Rolempleado(Short idrol) {
        this.idrol = idrol;
    }

    public Rolempleado(Short idrol, String nombrerol) {
        this.idrol = idrol;
        this.nombrerol = nombrerol;
    }

    public Short getIdrol() {
        return idrol;
    }

    public void setIdrol(Short idrol) {
        this.idrol = idrol;
    }

    public String getNombrerol() {
        return nombrerol;
    }

    public void setNombrerol(String nombrerol) {
        this.nombrerol = nombrerol;
    }

    public Collection<Empleado> getEmpleadoCollection() {
        return empleadoCollection;
    }

    public void setEmpleadoCollection(Collection<Empleado> empleadoCollection) {
        this.empleadoCollection = empleadoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idrol != null ? idrol.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Rolempleado)) {
            return false;
        }
        Rolempleado other = (Rolempleado) object;
        if ((this.idrol == null && other.idrol != null) || (this.idrol != null && !this.idrol.equals(other.idrol))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "es.uva.dbcs.practica1.dominio.Rolempleado[ idrol=" + idrol + " ]";
    }
    
}
