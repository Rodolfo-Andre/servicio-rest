package com.proyecto.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.proyecto.dao.PlatoRepository;
import com.proyecto.entity.Plato;

@Service
public class PlatoService {
  @Autowired
  PlatoRepository platoRepository;

  public List<Plato> obtenerTodo() {
    return platoRepository.findAll();
  }

  public Plato obtenerPorId(Integer p) {
    return platoRepository.findById(p).orElse(null);
  }

  public void agregar(Plato p) {
    platoRepository.save(p);
  }

  public void actualizar(Plato p) {
    platoRepository.save(p);
  }

  public void eliminar(Integer id) {
    platoRepository.deleteById(id);
  }

  public int obtenerTamanoDetalleComandaDePlato(Integer id) {
    Plato plato = platoRepository.findById(id).orElse(null);
    int tamanoDetalleComanda = 0;

    if (plato == null) {
      return 0;
    }

    tamanoDetalleComanda = plato.getListaDetalleComanda().size();

    return tamanoDetalleComanda;
  }

  public List<Plato> obtenerPlatoByCategoriId(Integer idCategoria) {
    return platoRepository.findPlatoByCategoriaId(idCategoria);
  }
}
