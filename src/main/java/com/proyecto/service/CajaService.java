package com.proyecto.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.proyecto.dao.CajaRepository;
import com.proyecto.entity.Caja;

@Service
public class CajaService {
  @Autowired
  private CajaRepository cajarepository;

  public List<Caja> obtenerTodo() {
    return cajarepository.findAll();
  }

  public void agregar(Caja c) {
    cajarepository.save(c);
  }

  public void actualizar(Caja c) {
    Caja cajaExistente = cajarepository.findById(c.getId()).orElse(null);
    if (cajaExistente != null) {
      cajaExistente.setEstablecimiento(c.getEstablecimiento());
      cajarepository.save(cajaExistente);
    }
  }

  public void eliminar(Integer id) {
    cajarepository.deleteById(id);
  }

  public long obtenerTamano() {
    return cajarepository.count();
  }
}
