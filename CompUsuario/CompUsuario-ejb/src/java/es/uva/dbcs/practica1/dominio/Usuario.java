/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uva.dbcs.practica1.dominio;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Javier
 */
@Entity
@Table(name = "USUARIO")
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u"),
    @NamedQuery(name = "Usuario.findByNifcif", query = "SELECT u FROM Usuario u WHERE u.nifcif = :nifcif"),
    @NamedQuery(name = "Usuario.findByNombre", query = "SELECT u FROM Usuario u WHERE u.nombre = :nombre"),
    @NamedQuery(name = "Usuario.findByDireccionpostal", query = "SELECT u FROM Usuario u WHERE u.direccionpostal = :direccionpostal"),
    @NamedQuery(name = "Usuario.findByDireccionelectronica", query = "SELECT u FROM Usuario u WHERE u.direccionelectronica = :direccionelectronica"),
    @NamedQuery(name = "Usuario.findByTelefono", query = "SELECT u FROM Usuario u WHERE u.telefono = :telefono"),
    @NamedQuery(name = "Usuario.findByPassword", query = "SELECT u FROM Usuario u WHERE u.password = :password")})
public class Usuario implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 9)
    @Column(name = "NIFCIF")
    private String nifcif;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "NOMBRE")
    private String nombre;
    @Size(max = 30)
    @Column(name = "DIRECCIONPOSTAL")
    private String direccionpostal;
    @Size(max = 30)
    @Column(name = "DIRECCIONELECTRONICA")
    private String direccionelectronica;
    @Size(max = 9)
    @Column(name = "TELEFONO")
    private String telefono;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "PASSWORD")
    private String password;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "usuario")
    private Empleado empleado;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "usuario")
    private Empresa empresa;

    public Usuario() {
    }

    public Usuario(String nifcif) {
        this.nifcif = nifcif;
    }

    public Usuario(String nifcif, String nombre, String password) {
        this.nifcif = nifcif;
        this.nombre = nombre;
        this.password = password;
    }

    public String getNifcif() {
        return nifcif;
    }

    public void setNifcif(String nifcif) {
        this.nifcif = nifcif;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccionpostal() {
        return direccionpostal;
    }

    public void setDireccionpostal(String direccionpostal) {
        this.direccionpostal = direccionpostal;
    }

    public String getDireccionelectronica() {
        return direccionelectronica;
    }

    public void setDireccionelectronica(String direccionelectronica) {
        this.direccionelectronica = direccionelectronica;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nifcif != null ? nifcif.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.nifcif == null && other.nifcif != null) || (this.nifcif != null && !this.nifcif.equals(other.nifcif))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "es.uva.dbcs.practica1.dominio.Usuario[ nifcif=" + nifcif + " ]";
    }
    
}
