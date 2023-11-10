package com.proyecto.entity;

public class PlatoComanda {
  private Integer id;
  private int cantidad;
  private String observacion;

  public PlatoComanda() {
  }

  public PlatoComanda(Integer id, int cantidad) {
    this.id = id;
    this.cantidad = cantidad;
  }

  public Integer getId() {
    return this.id;
  }

  public int getCantidad() {
    return this.cantidad;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public void setCantidad(int cantidad) {
    this.cantidad = cantidad;
  }

  public String getObservacion() {
    return this.observacion;
  }

  public void setObservacion(String observacion) {
    this.observacion = observacion;
  }
}
