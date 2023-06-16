package com.proyecto.controller;

import java.text.SimpleDateFormat;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.proyecto.entity.*;
import com.proyecto.service.*;

@RestController
@RequestMapping(value = "/configuracion/comanda")
class ComandaRestController {
  @Autowired
  ComandaService comandaService;
  @Autowired
  MesaService mesaService;
  @Autowired
  PlatoService platoService;
  @Autowired
  DetalleComandaService detalleComandaService;
  @Autowired
  EmpleadoService empleadoService;

}
@Controller
@RequestMapping(value = "/configuracion/comanda")

class ComandaController{
	 @Autowired
	  ComandaService comandaService;
	 
	 @GetMapping(value = "")
	  public String index(Model model) {
	    model.addAttribute("listaComanda", comandaService.obtenerTodo());
	    return "pages/comanda";
	  }

}




