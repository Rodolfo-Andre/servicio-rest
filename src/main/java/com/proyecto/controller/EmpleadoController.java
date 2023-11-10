package com.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.proyecto.entity.*;
import com.proyecto.service.*;
import java.text.SimpleDateFormat;
import java.util.*;

@RestController
@RequestMapping(value = "/configuracion/empleado")
class EmpleadoRestController {
  @Autowired
  EmpleadoService empleadoService;
  @Autowired
  UsuarioService usuarioService;

  @PostMapping(value = "/registrar")
  public void registrar(@RequestBody Empleado empleado) {
    empleadoService.registrar(empleado);
  }

  @PutMapping(value = "/actualizar")
  public void actualizar(@RequestBody Empleado emple) {
    empleadoService.actualizar(emple);
  }

  @DeleteMapping(value = "/eliminar/{codigo}")
  public void eliminar(@PathVariable("codigo") Integer cod) {
    empleadoService.eliminar(cod);
  }
}

@Controller
@RequestMapping(value = "/configuracion/empleado")
class EmpleadoController {
  @Autowired
  EmpleadoService empleadoService;
  private SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
  private SimpleDateFormat formatEntrada = new SimpleDateFormat("dd/MM/yyyy");

  @GetMapping(value = "")
  public String index(Model model) {
    List<Empleado> listaEmpleado = empleadoService.listarEmpleado().stream().map(e -> {
      try {
        Date fechaRegistro;

        fechaRegistro = formatEntrada.parse(e.getFechaRegistro());
        e.setFechaRegistro(format.format(fechaRegistro));
      } catch (Exception err) {
        err.printStackTrace();
      }

      return e;
    }).toList();

    model.addAttribute("listar", listaEmpleado);
    return "pages/empleado";
  }
}
