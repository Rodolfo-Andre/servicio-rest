package com.proyecto.entity;

import jakarta.persistence.*;
import java.util.*;
import com.fasterxml.jackson.annotation.*;

@Entity
@Table(name = "ESTABLECIMIENTO")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Establecimiento {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  private String nomEstablecimiento;

  private String telefonoestablecimiento;

  private String direccionestablecimiento;

  private String rucestablecimiento;

  @OneToMany(mappedBy = "establecimiento")
  @JsonIgnore
  private List<Caja> listaCaja;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getNomEstablecimiento() {
    return nomEstablecimiento;
  }

  public void setNomEstablecimiento(String nomEstablecimiento) {
    this.nomEstablecimiento = nomEstablecimiento;
  }

  public String getTelefonoestablecimiento() {
    return telefonoestablecimiento;
  }

  public void setTelefonoestablecimiento(String telefonoestablecimiento) {
    this.telefonoestablecimiento = telefonoestablecimiento;
  }

  public String getDireccionestablecimiento() {
    return direccionestablecimiento;
  }

  public void setDireccionestablecimiento(String direccionestablecimiento) {
    this.direccionestablecimiento = direccionestablecimiento;
  }

  public String getRucestablecimiento() {
    return rucestablecimiento;
  }

  public void setRucestablecimiento(String rucestablecimiento) {
    this.rucestablecimiento = rucestablecimiento;
  }

  public List<Caja> getListaCaja() {
    return listaCaja;
  }

  public void setListaCaja(List<Caja> listaCaja) {
    this.listaCaja = listaCaja;
  }

}
