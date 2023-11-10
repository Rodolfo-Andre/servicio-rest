package com.proyecto.entity;

import jakarta.persistence.*;
import java.util.*;
import com.fasterxml.jackson.annotation.*;

@Entity
@Table(name = "METODO_PAGO")
public class MetodoPago {
  @Id
  private Integer id;

  private String nombreMetodoPago;

  public List<Comprobante> getListComprobante() {
    return listComprobante;
  }

  public void setListComprobante(List<Comprobante> listComprobante) {
    this.listComprobante = listComprobante;
  }

  @OneToMany(mappedBy = "metodopago")
  @JsonIgnore
  private List<Comprobante> listComprobante;

  public MetodoPago() {
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getNombreMetodoPago() {
    return nombreMetodoPago;
  }

  public void setNombreMetodoPago(String nombreMetodoPago) {
    this.nombreMetodoPago = nombreMetodoPago;
  }

  public void setMetodo(String metodo) {
    this.nombreMetodoPago = metodo;
  }

  public MetodoPago(Integer id, String nombreMetodoPago) {
    this.id = id;
    this.nombreMetodoPago = nombreMetodoPago;
  }
}
