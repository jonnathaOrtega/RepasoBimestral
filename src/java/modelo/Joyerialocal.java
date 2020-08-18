/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author CRISTINA CALLE
 */
@Entity
@Table(name = "joyerialocal")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Joyerialocal.findAll", query = "SELECT j FROM Joyerialocal j")
    , @NamedQuery(name = "Joyerialocal.findByNombre", query = "SELECT j FROM Joyerialocal j WHERE j.nombre = :nombre")
    , @NamedQuery(name = "Joyerialocal.findByUbicacion", query = "SELECT j FROM Joyerialocal j WHERE j.ubicacion = :ubicacion")
    , @NamedQuery(name = "Joyerialocal.findByDireccion", query = "SELECT j FROM Joyerialocal j WHERE j.direccion = :direccion")
    , @NamedQuery(name = "Joyerialocal.findByNomEncargado", query = "SELECT j FROM Joyerialocal j WHERE j.nomEncargado = :nomEncargado")
    , @NamedQuery(name = "Joyerialocal.findByDimension", query = "SELECT j FROM Joyerialocal j WHERE j.dimension = :dimension")
    , @NamedQuery(name = "Joyerialocal.findByCiudad", query = "SELECT j FROM Joyerialocal j WHERE j.ciudad = :ciudad")})
public class Joyerialocal implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nombre")
    private String nombre;
    @Size(max = 45)
    @Column(name = "ubicacion")
    private String ubicacion;
    @Size(max = 45)
    @Column(name = "direccion")
    private String direccion;
    @Size(max = 45)
    @Column(name = "nom_encargado")
    private String nomEncargado;
    @Column(name = "dimension")
    private Integer dimension;
    @Size(max = 45)
    @Column(name = "ciudad")
    private String ciudad;
    
    

    public Joyerialocal() {
    }

    public Joyerialocal(String nombre) {
        this.nombre = nombre;
    }

    public Joyerialocal(String nombre, String ubicacion, String direccion, String nomEncargado, Integer dimension, String ciudad) {
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.direccion = direccion;
        this.nomEncargado = nomEncargado;
        this.dimension = dimension;
        this.ciudad = ciudad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getNomEncargado() {
        return nomEncargado;
    }

    public void setNomEncargado(String nomEncargado) {
        this.nomEncargado = nomEncargado;
    }

    public Integer getDimension() {
        return dimension;
    }

    public void setDimension(Integer dimension) {
        this.dimension = dimension;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nombre != null ? nombre.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Joyerialocal)) {
            return false;
        }
        Joyerialocal other = (Joyerialocal) object;
        if ((this.nombre == null && other.nombre != null) || (this.nombre != null && !this.nombre.equals(other.nombre))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Joyerialocal[ nombre=" + nombre + " ]";
    }
    
}
