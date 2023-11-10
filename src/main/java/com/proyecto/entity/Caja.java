package com.proyecto.entity;

import jakarta.persistence.*;
import java.util.*;
import com.fasterxml.jackson.annotation.*;

@Entity
@Table(name = "CAJA")
public class Caja {
  @Id
  private Integer id;

  @ManyToOne
  @JoinColumn(name = "ESTABLECIMIENTO_ID")
  private Establecimiento Establecimiento;

  @OneToMany(mappedBy = "caja")
  @JsonIgnore
  private List<Comprobante> listaComprobante;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Establecimiento getEstablecimiento() {
    return Establecimiento;
  }

  public void setEstablecimiento(Establecimiento establecimiento) {
    Establecimiento = establecimiento;
  }

  public List<Comprobante> getListaComprobante() {
    return listaComprobante;
  }

  public void setListaComprobante(List<Comprobante> listaComprobante) {
    this.listaComprobante = listaComprobante;
  }
}
