package com.proyecto.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "CATEGORIA_PLATO")
public class CategoriaPlato {
  @Id
  private String id;

  private String categoria;

  public CategoriaPlato() {
  }

  public CategoriaPlato(String id, String nombre) {
    this.id = id;
    this.categoria = nombre;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getCategoria() {
    return categoria;
  }

  public void setCategoria(String categoria) {
    this.categoria = categoria;
  }

}
