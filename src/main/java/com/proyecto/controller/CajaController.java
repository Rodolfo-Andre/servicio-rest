package com.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.proyecto.entity.Caja;
import com.proyecto.service.*;

@RestController
@RequestMapping(value = "/configuracion/caja")
class CajaRestController {
  @Autowired
  CajaService cajaservice;

  @Autowired
  EstablecimientoService establecimientoService;

  @PostMapping(value = "/registrar")
  public void registrar(@RequestBody Caja caja) {
    cajaservice.agregar(caja);
  }

  @PutMapping(value = "/actualizar")
  public void actualizar(@RequestBody Caja caja) {
    cajaservice.actualizar(caja);

  }

  @DeleteMapping(value = "/eliminar/{codigo}")
  public void eliminar(@PathVariable("codigo") Integer cod) {
    cajaservice.eliminar(cod);
  }
}

@Controller
@RequestMapping(value = "/configuracion/caja")
class CajaController {
  @Autowired
  CajaService cajaService;

  @GetMapping(value = "")
  public String index(Model model) {
    model.addAttribute("listaCaja", cajaService.obtenerTodo());

    return "pages/caja";
  }
}
