package com.proyecto.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.proyecto.dao.EstablecimientoRepository;
import com.proyecto.entity.Establecimiento;

@Service
public class EstablecimientoService {
  @Autowired
  private EstablecimientoRepository establecimientoRepository;

  public List<Establecimiento> obtenerTodo() {
    return establecimientoRepository.findAll();
  }

  public void agregar(Establecimiento e) {
    establecimientoRepository.save(e);
  }

  public void actualizar(Establecimiento e) {
    establecimientoRepository.save(e);
  }

  public void eliminar(Integer id) {
    establecimientoRepository.deleteById(id);
  }

  public long obtenerTamano() {
    return establecimientoRepository.count();
  }

  public Establecimiento obterporId(Integer id) {
    return establecimientoRepository.findById(id).orElse(null);
  }
}
