package com.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.proyecto.entity.MetodoPago;
import com.proyecto.service.MetodoPagoService;

@RestController
@RequestMapping(value = "/configuracion/metodo-pago")
class MetodoPagoRestController {
  @Autowired
  MetodoPagoService MetodoPagoService;

  @PostMapping(value = "/registrar")
  public void agregar(@RequestBody MetodoPago metodo) {
    MetodoPagoService.agregar(metodo);
  }

  @PutMapping(value = "/actualizar")
  public void actualizar(@RequestBody MetodoPago meto) {
    MetodoPagoService.actualizar(meto);

  }

  @DeleteMapping(value = "/eliminar/{codigo}")
  public void eliminar(@PathVariable("codigo") Integer cod) {
    MetodoPagoService.eliminar(cod);
  }
}

@Controller
@RequestMapping(value = "/configuracion/metodo-pago")
public class MetodoPagoController {
  @Autowired
  MetodoPagoService metodoPagoService;

  @GetMapping(value = "")
  public String index(Model model) {
    model.addAttribute("listaMetodoPago", metodoPagoService.obtenerTodo());
    return "pages/metodo-pago";
  }
}
