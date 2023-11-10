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
@RequestMapping(value = "/configuracion/comanda")
class ComandaRestController {
  @Autowired
  ComandaService comandaService;
  @Autowired
  DetalleComandaService detalleComandaService;
  @Autowired
  MesaService mesaService;

  @PostMapping(value = "/registrar")
  public void registrar(@RequestBody Comanda comanda) {
    Comanda comandaAgregada = new Comanda();
    comandaAgregada.setCantidadAsientos(comanda.getCantidadAsientos());
    comandaAgregada.setEmpleado(comanda.getEmpleado());
    comandaAgregada.setEstadoComanda(comanda.getEstadoComanda());
    comandaAgregada.setFechaEmision(comanda.getFechaEmision());
    comandaAgregada.setMesa(comanda.getMesa());
    comandaAgregada.setPrecioTotal(comanda.getPrecioTotal());

    comandaService.agregar(comandaAgregada);

    comanda.getListaDetalleComanda().forEach(dc -> {
      dc.setComanda(comandaAgregada);
      detalleComandaService.registrar(dc);
    });

    Mesa mesa = mesaService.obtenerPorId(comanda.getMesa().getId());
    mesa.setEstado("Ocupado");
    mesaService.actualizar(mesa);
  }

  @PutMapping(value = "/actualizar/{codigo}")
  public void actualizar(@PathVariable("codigo") Integer codigo, @RequestBody Comanda comanda) {
    List<DetalleComanda> listaDetalleComandaSinActualizar = detalleComandaService.findByComandaId(codigo);
    List<DetalleComanda> listaDetalleComandaNueva = comanda.getListaDetalleComanda().stream().map(dc -> {
      if (dc.getId() != null && dc.getId() == 0) {
        dc.setId(null);
      }
      return dc;
    }).toList();

    // Actualizar o eliminar detalle comanda existente
    listaDetalleComandaSinActualizar.forEach(detalleComandaExistente -> {
      DetalleComanda detalleComanda = listaDetalleComandaNueva.stream()
          .filter(dc -> dc.getPlato().getId().equals(detalleComandaExistente.getPlato().getId()))
          .findFirst()
          .orElse(null);

      if (detalleComanda == null) {
        detalleComandaService.eliminar(detalleComandaExistente.getId());
      } else {
        if (detalleComanda.getId() != null && detalleComanda.getId() != 0) {
          detalleComanda.setComanda(comanda);
          detalleComandaService.actualizar(detalleComanda);
        }
      }
    });

    // Registrar nuevos detalles de la comanda
    listaDetalleComandaNueva.forEach(nuevoDetalleComanda -> {
      boolean existeDetalleComanda = listaDetalleComandaSinActualizar.stream()
          .anyMatch(detalleComandaExistente -> detalleComandaExistente.getPlato().getId()
              .equals(nuevoDetalleComanda.getPlato().getId()));

      if (!existeDetalleComanda) {
        nuevoDetalleComanda.setComanda(comanda);
        detalleComandaService.registrar(nuevoDetalleComanda);
      }
    });

    comandaService.actualizar(comanda);
  }

  @PutMapping(value = "/actualizar-estado/{codigo}")
  public void actualizar(@PathVariable("codigo") int codigo) {
    Comanda comanda = comandaService.obtenerPorId(codigo);
    EstadoComanda estadoComanda = new EstadoComanda();

    estadoComanda.setId(2);
    comanda.setEstadoComanda(estadoComanda);
    comandaService.actualizar(comanda);
  }

  @DeleteMapping(value = "/eliminar/{codigo}")
  public void eliminar(@PathVariable("codigo") int codigo) {
    Comanda comanda = comandaService.obtenerPorId(codigo);

    Mesa mesa = mesaService.obtenerPorId(comanda.getMesa().getId());
    mesa.setEstado("Libre");
    mesaService.actualizar(mesa);

    comanda.getListaDetalleComanda().forEach(dc -> detalleComandaService.eliminar(dc.getId()));
    comandaService.eliminar(codigo);
  }
}

@Controller
@RequestMapping(value = "/configuracion/comanda")
class ComandaController {
  @Autowired
  ComandaService comandaService;
  private SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
  private SimpleDateFormat formatEntrada = new SimpleDateFormat("dd/MM/yyyy");

  @GetMapping(value = "")
  public String index(Model model) {
    List<Comanda> listaComanda = comandaService.obtenerTodo().stream().map(c -> {
      try {
        Date fechaEmision;
        fechaEmision = formatEntrada.parse(c.getFechaEmision());
        c.setFechaEmision(format.format(fechaEmision));
      } catch (ParseException e) {
        e.printStackTrace();
      }

      return c;
    }).toList();

    model.addAttribute("listaComanda", listaComanda);
    return "pages/comanda";
  }
}
