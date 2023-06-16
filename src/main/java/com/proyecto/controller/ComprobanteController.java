package com.proyecto.controller;

import com.proyecto.entity.Caja;
import com.proyecto.entity.Cliente;
import com.proyecto.entity.Comanda;
import com.proyecto.entity.Comprobante;
import com.proyecto.entity.DetalleComprobante;
import com.proyecto.entity.EstadoComanda;
import com.proyecto.entity.MetodoPago;
import com.proyecto.entity.TipoComprobante;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.proyecto.service.ClienteService;
import com.proyecto.service.ComandaService;
import com.proyecto.service.ComprobanteService;
import com.proyecto.service.EmpleadoService;
import com.proyecto.service.TipoComprobanteService;

@Controller
@RequestMapping(value = "/configuracion/comprobante")
public class ComprobanteController {

  @Autowired
  TipoComprobanteService tipoComprobanteService;

  @Autowired
  ClienteService clienteService;

  @Autowired
  ComandaService comandaService;

  @Autowired
  EmpleadoService empleadoService;

  @Autowired
  ComprobanteService comprobanteService;


}