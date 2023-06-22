package com.proyecto.entity;

import jakarta.persistence.*;
import java.util.*;
import com.fasterxml.jackson.annotation.*;

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

  @OneToMany(mappedBy = "categoriaPlato")
  @JsonIgnore
  private List<Plato> listaPlato;

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

public List<Plato> getListaPlato() {
    return listaPlato;
  }

  public void setListaPlato(List<Plato> listaPlato) {
    this.listaPlato = listaPlato;
  }

  public static String generarIdCategoriaPlato(List<CategoriaPlato> listaCategoriaPlato) {
    if (listaCategoriaPlato.isEmpty())
      return "CP-01";

    String ultimoId = listaCategoriaPlato.get(listaCategoriaPlato.size() - 1).getId();

    int numero = Integer.parseInt(String.join("", ultimoId.split("CP-")));

    return "CP-" + String.format("%02d", numero + 1);
  }
}
