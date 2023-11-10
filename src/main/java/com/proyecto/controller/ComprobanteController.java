package com.proyecto.controller;

import java.text.*;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.proyecto.entity.*;
import com.proyecto.service.*;

@RestController
@RequestMapping(value = "/configuracion/comprobante")
class ComprobanteRestController {
  @Autowired
  ComprobanteService comprobanteService;

  @Autowired
  ComandaService comandaService;

  @PostMapping(value = "/registrar")
  public void registrar(@RequestBody Comprobante comprobante) {
    Comanda comanda = comandaService.obtenerPorId(comprobante.getComanda().getId());

    EstadoComanda estadoComanda = new EstadoComanda();
    estadoComanda.setId(2);
    comanda.setEstadoComanda(estadoComanda);
    comandaService.actualizar(comanda);

    comprobanteService.registrar(comprobante);
  }
}

@Controller
@RequestMapping(value = "/configuracion/comprobante")
class ComprobanteController {
  @Autowired
  ComprobanteService comprobanteService;
  private SimpleDateFormat formatEntrada = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
  private SimpleDateFormat formatSalida = new SimpleDateFormat("yyyy/MM/dd HH:mm");

  @GetMapping(value = "")
  public String index(Model model) {
    List<Comprobante> lista = comprobanteService.getAll().stream().map(c -> {
      try {
        Date fechaEmision;
        fechaEmision = formatEntrada.parse(c.getFechaEmision());
        c.setFechaEmision(formatSalida.format(fechaEmision));
      } catch (ParseException e) {
        e.printStackTrace();
      }

      return c;
    }).toList();

    model.addAttribute("listar", lista);
    return "pages/caja-registradora";
  }
}