package com.proyecto.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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
  private SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");

  @GetMapping(value = "")
  public String index(Model model) {
    List<Comprobante> lista = comprobanteService.getAll().stream().map(c -> {
      try {
        Date fechaEmision;
        fechaEmision = format.parse(c.getFechaEmision());
        c.setFechaEmision(format.format(fechaEmision));
      } catch (ParseException e) {
        e.printStackTrace();
      }

      return c;
    }).toList();

    model.addAttribute("listar", lista);
    return "pages/caja-registradora";
  }
}