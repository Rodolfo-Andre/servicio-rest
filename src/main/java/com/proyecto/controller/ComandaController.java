package com.proyecto.controller;

import java.util.List;
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
	Comanda c = new Comanda();
	c.setCantidadAsientos(comanda.getCantidadAsientos());
	c.setEmpleado(comanda.getEmpleado());
	c.setEstadoComanda(comanda.getEstadoComanda());
	c.setFechaEmision(comanda.getFechaEmision());
	c.setMesa(comanda.getMesa());
	c.setPrecioTotal(comanda.getPrecioTotal());
    Comanda comandaAgregada = comandaService.agregar(c);
    
    comanda.getListaDetalleComanda().forEach(dc -> {
      dc.setComanda(comandaAgregada);
      detalleComandaService.registrar(dc);
    });

    Mesa mesa = mesaService.obtenerPorId(comanda.getMesa().getId());
    mesa.setEstado("Ocupado");
    mesaService.actualizar(mesa);
  }

  @PutMapping(value = "/actualizar")
  public void actualizar(@RequestBody Comanda comanda) {
    List<DetalleComanda> listaDetalleComandaSinActualizar = detalleComandaService.findByComandaId(comanda.getId());
    List<DetalleComanda> listaDetalleComandaNueva = comanda.getListaDetalleComanda();

    // Actualizar o eliminar detalle comanda existente
    listaDetalleComandaSinActualizar.forEach(detalleComandaExistente -> {
      DetalleComanda detalleComanda = listaDetalleComandaNueva.stream()
          .filter(dc -> dc.getPlato().getId().equals(detalleComandaExistente.getPlato().getId()))
          .findFirst()
          .orElse(null);

      if (detalleComanda == null) {
        detalleComandaService.eliminar(detalleComandaExistente.getId());
      } else {
        detalleComandaService.actualizar(detalleComanda);
      }
    });

    // Registrar nuevos detalles de la comanda
    listaDetalleComandaNueva.forEach(nuevoDetalleComanda -> {
      boolean existeDetalleComanda = listaDetalleComandaSinActualizar.stream()
          .anyMatch(detalleComandaExistente -> detalleComandaExistente.getPlato().getId()
              .equals(nuevoDetalleComanda.getPlato().getId()));

      if (!existeDetalleComanda) {
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
    comanda.getListaDetalleComanda().forEach(dc -> detalleComandaService.eliminar(dc.getId()));
    comandaService.eliminar(codigo);
  }
}

@Controller
@RequestMapping(value = "/configuracion/comanda")
class ComandaController {
  @Autowired
  ComandaService comandaService;

  @GetMapping(value = "")
  public String index(Model model) {
    model.addAttribute("listaComanda", comandaService.obtenerTodo());
    return "pages/comanda";
  }
}
