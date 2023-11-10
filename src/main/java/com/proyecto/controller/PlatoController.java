package com.proyecto.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.proyecto.entity.*;
import com.proyecto.service.PlatoService;

@RestController
@RequestMapping(value = "/configuracion/plato")
class PlatoRestController {
  @Autowired
  PlatoService platoService;

  @GetMapping(value = "/lista")
  public List<Plato> lista() {
    return platoService.obtenerTodo();
  }

  @PostMapping(value = "/registrar")
  public void registrar(@RequestBody Plato plato) {
    platoService.agregar(plato);
  }

  @PutMapping(value = "/actualizar")
  public void actualizar(@RequestBody Plato plato) {
    platoService.actualizar(plato);
  }

  @DeleteMapping(value = "/eliminar/{codigo}")
  public void eliminar(@PathVariable("codigo") Integer cod) {
    platoService.eliminar(cod);
  }
}

@Controller
@RequestMapping(value = "/configuracion/plato")
class PlatoController {
  @Autowired
  PlatoService platoService;

  @GetMapping(value = "")
  public String index(Model model) {
    model.addAttribute("listaPlato", platoService.obtenerTodo());
    return "pages/plato";
  }
}
