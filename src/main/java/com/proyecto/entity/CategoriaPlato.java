package com.proyecto.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "CATEGORIA_PLATO")
public class CategoriaPlato {
  @Id
  private Integer id;

  private String categoria;

  public CategoriaPlato() {
  }

  public CategoriaPlato(Integer id, String nombre) {
    this.id = id;
    this.categoria = nombre;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getCategoria() {
    return categoria;
  }

  public void setCategoria(String categoria) {
    this.categoria = categoria;
  }
}
