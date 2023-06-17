package com.proyecto.entity;

import jakarta.persistence.*;
import java.util.*;
import com.fasterxml.jackson.annotation.*;

@Entity
@Table(name = "ESTABLECIMIENTO")
public class Establecimiento {
  @Id
  public String id;

  private String nombre;

  private String telefono;

  private String direccion;

  private String ruc;

  @OneToMany(mappedBy = "establecimiento")
  @JsonIgnore
  private List<Caja> listaCaja;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public String getTelefono() {
    return telefono;
  }

  public void setTelefono(String telefono) {
    this.telefono = telefono;
  }

  public String getDireccion() {
    return direccion;
  }

  public void setDireccion(String direccion) {
    this.direccion = direccion;
  }

  public String getRuc() {
    return ruc;
  }

  public void setRuc(String ruc) {
    this.ruc = ruc;
  }

  public List<Caja> getListaCaja() {
    return listaCaja;
  }

  public void setListaCaja(List<Caja> listaCaja) {
    this.listaCaja = listaCaja;
  }
}
