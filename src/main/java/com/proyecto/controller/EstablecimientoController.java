package com.proyecto.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.proyecto.entity.Establecimiento;
import com.proyecto.service.EstablecimientoService;

@RestController
@RequestMapping(value = "/configuracion/establecimiento")
class EstablecimientoRestController {
  @Autowired
  EstablecimientoService establecimientoService;

  @GetMapping(value = "/lista")
  public List<Establecimiento> listar() {
    return establecimientoService.obtenerTodo();
  }

  @PostMapping(value = "/grabar")
  public void agregar(@RequestBody Establecimiento establecimiento) {
    establecimientoService.agregar(establecimiento);
  }

  @PutMapping(value = "/actualizar")
  public void actualizar(@RequestBody Establecimiento establecimiento) {
    establecimientoService.actualizar(establecimiento);
  }

  @DeleteMapping(value = "/eliminar/{codigo}")
  public void eliminar(@PathVariable("codigo") Integer cod) {
    establecimientoService.eliminar(cod);
  }
}

@Controller
@RequestMapping(value = "/configuracion/establecimiento")
class EstablecimientoController {
  @Autowired
  EstablecimientoService establecimientoService;

  @GetMapping(value = "")
  public String index(Model model) {
    model.addAttribute("listaEstablecimiento", establecimientoService.obtenerTodo());

    return "pages/establecimiento";
  }
}
