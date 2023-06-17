package com.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.proyecto.service.*;

@Controller
@RequestMapping(value = "/configuracion/comprobante")
public class ComprobanteController {
  @Autowired
  ComprobanteService comprobanteService;

  @GetMapping(value = "")
  public String index(Model model) {
    model.addAttribute("listar", comprobanteService.getAll());
    return "pages/caja-registradora";
  }
}