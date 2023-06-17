package com.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.proyecto.entity.Comprobante;
import com.proyecto.service.*;

@RestController
@RequestMapping(value = "/configuracion/comprobante")
class ComprobanteRestController {
  @Autowired
  ComprobanteService comprobanteService;

  @PostMapping(value = "/registrar")
  public void registrar(@RequestBody Comprobante comprobante) {
    comprobanteService.registrar(comprobante);
  }
}

@Controller
@RequestMapping(value = "/configuracion/comprobante")
class ComprobanteController {
  @Autowired
  ComprobanteService comprobanteService;

  @GetMapping(value = "")
  public String index(Model model) {
    model.addAttribute("listar", comprobanteService.getAll());
    return "pages/caja-registradora";
  }
}