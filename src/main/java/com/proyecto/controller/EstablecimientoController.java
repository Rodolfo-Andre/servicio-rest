package com.proyecto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
  public void agregar(
      @RequestBody Establecimiento establecimiento) {
    establecimientoService.agregar(establecimiento);
    System.out.println("xd" + establecimiento.getDireccionestablecimiento());
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
    model.addAttribute("listestablecimiento", establecimientoService.obtenerTodo());

    return "pages/establecimiento";
  }

}
