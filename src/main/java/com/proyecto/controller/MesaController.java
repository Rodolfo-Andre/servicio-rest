package com.proyecto.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.proyecto.entity.Mesa;
import com.proyecto.service.MesaService;

@RestController
@RequestMapping(value = "/configuracion/mesa")
class MesaRestController {
  @Autowired
  MesaService mesaService;

  @GetMapping(value = "/lista")
  public List<Mesa> lista() {
    return mesaService.obtenerTodo();
  }
  
  @PostMapping(value = "/grabar")
  public void grabar(@RequestBody Mesa mesa) {
    mesaService.agregar(mesa);
  }

  @PutMapping(value = "/actualizar")
  public void actualizar(@RequestBody Mesa mesa) {
    mesaService.actualizar(mesa);
  }

  @DeleteMapping(value = "/eliminar/{codigo}")
  public void eliminar(@PathVariable("codigo") Integer cod) {
    mesaService.eliminar(cod);
  }
}

@Controller
@RequestMapping(value = "/configuracion/mesa")
class MesaController {
  @Autowired
  MesaService mesaService;

  @GetMapping(value = "")
  public String index(Model model) {
    model.addAttribute("listaMesas", mesaService.obtenerTodo());
    return "pages/mesas";
  }
}




































