package com.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.proyecto.entity.*;
import com.proyecto.service.EmpleadoService;
import com.proyecto.service.UsuarioService;
import com.proyecto.utils.ServicioCorreo;
import java.util.concurrent.CompletableFuture;

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
    System.out.println("LA CONTRASEÑA GENERADA ES: " + empleado.getUsuario().getContrasena());
    /*CompletableFuture
    .runAsync(() -> {
      try {
        ServicioCorreo.enviarMensaje(empleado.getUsuario().getCorreo(),
            "Tu contraseña para acceder a nuestra plataforma es: " +  empleado.getUsuario().getContrasena(),
            "Bienvenido al aplicativo de comandas");
      } catch (Exception e2) {
        e2.printStackTrace();
      }
    });*/

  }

  @PutMapping(value = "/actualizar")
  public void actualizar(@RequestBody Empleado emple) {
    System.out.println("ACSAD" + emple);
    empleadoService.actualizar(emple);
  }

  @DeleteMapping(value = "/eliminar/{codigo}")
  public void eliminar(@PathVariable("codigo") Integer cod) {
    System.out.println("ACSAD");
    empleadoService.eliminar(cod);
  }
}

@Controller
@RequestMapping(value = "/configuracion/empleado")
class EmpleadoController {
  @Autowired
  EmpleadoService empleadoService;

  @GetMapping(value = "")
  public String index(Model model) {
    model.addAttribute("listar", empleadoService.listarEmpleado());
    return "pages/empleado";
  }

}
