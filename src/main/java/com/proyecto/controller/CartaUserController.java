package com.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.proyecto.service.*;

@Controller
@RequestMapping(value = "/configuracion/carta-user")
public class CartaUserController {
  @Autowired
  CategoriaPlatoService categoriaPlatoService;
  @Autowired
  PlatoService platoService;

  @GetMapping(value = "")
  public String index(Model model) {
    model.addAttribute("listaCategoriaPlato", categoriaPlatoService.obtenerTodo());
    model.addAttribute("listaPlato", platoService.obtenerTodo());

    System.out.println("cantidad " + platoService.obtenerTodo().size());
    return "pages/carta-user";
  }
}
