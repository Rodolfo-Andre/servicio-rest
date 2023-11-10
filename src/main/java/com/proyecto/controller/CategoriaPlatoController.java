package com.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.proyecto.entity.CategoriaPlato;
import com.proyecto.service.CategoriaPlatoService;

@RestController
@RequestMapping(value = "/configuracion/categoriaPlato")
public class CategoriaPlatoController {
  @Autowired
  CategoriaPlatoService categoriaPlatoService;

  @PostMapping(value = "/registrar")
  public void registrar(@RequestBody CategoriaPlato cate) {
    categoriaPlatoService.agregar(cate);
  }

  @PutMapping(value = "/actualizar")
  public void actualizar(@RequestBody CategoriaPlato cate) {
    categoriaPlatoService.actualizar(cate);
  }

  @DeleteMapping(value = "/eliminar/{codigo}")
  public void eliminar(@PathVariable("codigo") Integer cod) {
    categoriaPlatoService.eliminar(cod);
  }

  @Controller
  @RequestMapping(value = "/configuracion/categoriaPlato")
  class EmpleadoController {
    @Autowired
    CategoriaPlatoService categoriaPlatoService;

    @GetMapping(value = "")
    public String index(Model model) {
      model.addAttribute("listaCategoriaPlato", categoriaPlatoService.obtenerTodo());
      return "pages/categoria-plato";
    }
  }
}
