package com.proyecto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.proyecto.entity.Mesa;
import com.proyecto.entity.UsuarioDetallesCustom;
import com.proyecto.interfaces.UsuarioActual;
import com.proyecto.service.MesaService;

@RestController
@RequestMapping(value = "/configuracion/mesa")
public class MesaController {
  @Autowired
  MesaService mesaService;
  
  @GetMapping(value ="/lista", produces = MediaType.APPLICATION_JSON_VALUE)
  public List<Mesa> lista(){
	  return mesaService.obtenerTodo();
  }

  
  @GetMapping(value = "/obtener")
  @ResponseBody
  public List<Mesa> getMesas(@UsuarioActual UsuarioDetallesCustom usuario) {
    if (usuario.getUsuario().getEmpleado().getCargo().getNombre().equals("ROLE_COCINERO")) {
      return mesaService.obtenerPorEstado("Ocupado");
    }
    return mesaService.obtenerTodo();
  }

  @GetMapping(value = "/obtener/{id}")
  @ResponseBody
  public Mesa buscarPorId(@PathVariable Integer id) {
    return mesaService.obtenerPorId(id);
  }

  @PostMapping(value = "/grabar")
  public String grabar(RedirectAttributes redirect, @RequestParam("quantityChairs") int sillas) {
    try {
      Mesa mesa = new Mesa();
      mesa.setCantidadAsientos(sillas);
      mesa.setEstado("Libre");
      mesaService.agregar(mesa);
      redirect.addFlashAttribute("mensaje", "Mesa registrada correctamente");
      redirect.addFlashAttribute("tipo", "success");
    } catch (Exception e) {
      e.printStackTrace();
      redirect.addFlashAttribute("mensaje", "Error al registrar mesa");
      redirect.addFlashAttribute("tipo", "error");
    }

    return "redirect:/configuracion/mesa";
  }

  @PostMapping(value = "/actualizar")
  public String actualizar(RedirectAttributes redirect, @RequestParam("id") int id,
      @RequestParam("quantityChairs") int sillas) {
    try {
      Mesa mesa = mesaService.obtenerPorId(id);
      mesa.setCantidadAsientos(sillas);

      mesaService.actualizar(mesa);
      redirect.addFlashAttribute("mensaje", "Mesa actualizada correctamente");
      redirect.addFlashAttribute("tipo", "success");
    } catch (Exception e) {
      e.printStackTrace();
      redirect.addFlashAttribute("mensaje", "Error al actualizar mesa");
      redirect.addFlashAttribute("tipo", "error");
    }

    return "redirect:/configuracion/mesa";
  }

  @PostMapping(value = "/eliminar")
  public String eliminar(RedirectAttributes redirect, @RequestParam("id") int id) {
    try {
      mesaService.eliminar(id);
      redirect.addFlashAttribute("mensaje", "Mesa eliminada correctamente");
      redirect.addFlashAttribute("tipo", "success");
    } catch (Exception e) {
      e.printStackTrace();
      redirect.addFlashAttribute("mensaje", "Error al eliminar mesa");
      redirect.addFlashAttribute("tipo", "error");
    }

    return "redirect:/configuracion/mesa";
  }

  @GetMapping(value = "/obtener-tamano-comanda-por-mesa/{id}")
  @ResponseBody
  public int obtenerTamanoComandaDeMesa(@PathVariable int id) {
    return mesaService.obtenerTamanoComandaDeMesa(id);
  }
}
