package com.proyecto.entity;

import jakarta.persistence.*;
import java.util.*;
import com.fasterxml.jackson.annotation.*;

@Entity
@Table(name = "PLATO")
public class Plato {
  @Id
  private Integer id;

  private String nombre;

  @Column(name = "PRECIO_PLATO")
  private double precioPlato;

  @OneToMany(mappedBy = "plato")
  @JsonIgnore
  private List<DetalleComanda> listaDetalleComanda;

  @ManyToOne
  @JoinColumn(name = "CATEGORIA_PLATO_ID")
  private CategoriaPlato categoriaPlato;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public double getPrecioPlato() {
    return precioPlato;
  }

  public void setPrecioPlato(double precioPlato) {
    this.precioPlato = precioPlato;
  }

  public List<DetalleComanda> getListaDetalleComanda() {
    return listaDetalleComanda;
  }

  public void setListaDetalleComanda(List<DetalleComanda> listaDetalleComanda) {
    this.listaDetalleComanda = listaDetalleComanda;
  }

  public CategoriaPlato getCategoriaPlato() {
    return categoriaPlato;
  }

  public void setCategoriaPlato(CategoriaPlato categoriaPlato) {
    this.categoriaPlato = categoriaPlato;
  }
}