package com.proyecto.entity;

import java.util.*;
import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;

@Entity
@Table(name = "EMPLEADO")
public class Empleado {
  @Id
  private Integer id;

  private String nombre;

  private String apellido;

  private String telefono;

  private String dni;

  @Column(name = "FECHA_REGISTRO")
  private String fechaRegistro;

  @ManyToOne
  @JoinColumn(name = "CARGO_ID")
  private Cargo cargo;

  @OneToMany(mappedBy = "empleado")
  @JsonIgnore
  private List<Comanda> listaComanda;

  @OneToMany(mappedBy = "empleado")
  @JsonIgnore
  private List<Comprobante> listaComprobante;

  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "USUARIO_ID")
  private Usuario usuario;

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

  public String getApellido() {
    return apellido;
  }

  public void setApellido(String apellido) {
    this.apellido = apellido;
  }

  public String getTelefono() {
    return telefono;
  }

  public void setTelefono(String telefono) {
    this.telefono = telefono;
  }

  public String getDni() {
    return dni;
  }

  public void setDni(String dni) {
    this.dni = dni;
  }

  public String getFechaRegistro() {
    return fechaRegistro;
  }

  public void setFechaRegistro(String fechaRegistro) {
    this.fechaRegistro = fechaRegistro;
  }

  public Cargo getCargo() {
    return cargo;
  }

  public void setCargo(Cargo cargo) {
    this.cargo = cargo;
  }

  public List<Comanda> getListaComanda() {
    return listaComanda;
  }

  public void setListaComanda(List<Comanda> listaComanda) {
    this.listaComanda = listaComanda;
  }

  public List<Comprobante> getListaComprobante() {
    return listaComprobante;
  }

  public void setListaComprobante(List<Comprobante> listaComprobante) {
    this.listaComprobante = listaComprobante;
  }

  public Usuario getUsuario() {
    return usuario;
  }

  public void setUsuario(Usuario usuario) {
    this.usuario = usuario;
  }
}
