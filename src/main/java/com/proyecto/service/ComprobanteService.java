package com.proyecto.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.proyecto.dao.ComprobanteRepository;
import com.proyecto.entity.Comprobante;

@Service
public class ComprobanteService {
  @Autowired
  private ComprobanteRepository repository;

  public Comprobante registrar(Comprobante d) {
    return repository.save(d);
  }

  public void actualizar(Comprobante d) {
    repository.save(d);
  }

  public void eliminar(Integer id) {
    repository.deleteById(id);
  }

  public Comprobante findById(int id) {
    return repository.findById(id).orElse(null);
  }

  public List<Comprobante> getAll() {
    return repository.findAll();
  }

  public List<Object[]> generarReporte() {
    return repository.generarReporteDelDia();
  }
}
