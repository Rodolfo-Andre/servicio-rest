package com.proyecto.db;

import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import com.proyecto.entity.*;
import com.proyecto.service.*;

@Component
public class DatabaseLoader implements CommandLineRunner {
  @Autowired
  private UsuarioService usuarioService;
  @Autowired
  private CargoService cargoService;
  @Autowired
  private MetodoPagoService metodoPagoService;
  // @Autowired
  // private CategoriaPlatoService categoriaPlatoService;
  @Autowired
  private EstadoComandaService estadoComandaService;
  @Autowired
  private TipoComprobanteService tipoComprobanteService;
  @Autowired
  private EstablecimientoService establecimientoService;
  @Autowired
  private CajaService cajaService;

  @Override
  public void run(String... args) throws Exception {
    Date fechaActual = new Date();
    String formato = "dd/MM/yyyy";
    SimpleDateFormat sdf = new SimpleDateFormat(formato);
    String fechaString = sdf.format(fechaActual);

    if (establecimientoService.obtenerTamano() == 0) {
      Establecimiento establecimiento = new Establecimiento();
      establecimiento.setId(1);
      establecimiento.setDireccionestablecimiento("Av.Izaguirre");
      establecimiento.setNomEstablecimiento("Sangunchería Wong");
      establecimiento.setTelefonoestablecimiento("942850902");
      establecimiento.setRucestablecimiento("20217382809");

      establecimientoService.agregar(establecimiento);
    }

    if (cajaService.obtenerTamano() == 0) {
      Caja caja = new Caja();
      caja.setId(1);

      Establecimiento establecimiento = new Establecimiento();
      establecimiento.setId(1);

      cajaService.agregar(caja);
    }

    if (cargoService.obtenerTamano() == 0) {
      cargoService.agregar(new Cargo("ADMINISTRADOR"));
      cargoService.agregar(new Cargo("MESERO"));
      cargoService.agregar(new Cargo("CAJERO"));
      cargoService.agregar(new Cargo("GERENTE"));
    }

    if (metodoPagoService.obtenerTamano() == 0) {
      metodoPagoService.agregar(new MetodoPago(1, "En efectivo"));
      metodoPagoService.agregar(new MetodoPago(2, "BCP"));
      metodoPagoService.agregar(new MetodoPago(3, "BBVA"));
      metodoPagoService.agregar(new MetodoPago(4, "Scotiabank"));
      metodoPagoService.agregar(new MetodoPago(5, "Interbank"));
    }

    /*
     * if (categoriaPlatoService.obtenerTamano() == 0) {
     * categoriaPlatoService.agregar(new CategoriaPlato(1, "Bebidas"));
     * categoriaPlatoService.agregar(new CategoriaPlato(2, "Hamburguesas"));
     * categoriaPlatoService.agregar(new CategoriaPlato(3, "Postres"));
     * categoriaPlatoService.agregar(new CategoriaPlato(4, "Sopas"));
     * }
     */

    if (estadoComandaService.obtenerTamano() == 0) {
      estadoComandaService.agregar(new EstadoComanda("Generado"));
      estadoComandaService.agregar(new EstadoComanda("Pagado"));
    }

    if (tipoComprobanteService.obtenerTamano() == 0) {
      tipoComprobanteService.agregar(new TipoComprobante("Nota de Venta"));
      tipoComprobanteService.agregar(new TipoComprobante("Boleta"));
    }

    if (usuarioService.obtenerTamano() == 0) {
      Cargo administrador = cargoService.obtenerPorNombre("ADMINISTRADOR");

      Usuario usuarioAdministrador = new Usuario();
      usuarioAdministrador.setId(1);
      usuarioAdministrador.setCorreo("admin@admin.com");
      usuarioAdministrador.setContrasena("admin");

      Empleado empleadoAdministrador = new Empleado();
      empleadoAdministrador.setId(1);
      empleadoAdministrador.setNombre("Admin");
      empleadoAdministrador.setApellido("Admin");
      empleadoAdministrador.setDni("77777777");
      empleadoAdministrador.setTelefono("923123123");

      empleadoAdministrador.setFechaRegistro(fechaString);
      empleadoAdministrador.setUsuario(usuarioAdministrador);
      empleadoAdministrador.setCargo(administrador);

      usuarioAdministrador.setEmpleado(empleadoAdministrador);

      usuarioService.agregar(usuarioAdministrador);

      /* ------------------------------------------------------------- */

      Cargo mesero = cargoService.obtenerPorNombre("MESERO");

      Usuario usuarioMesero = new Usuario();
      usuarioMesero.setId(2);
      usuarioMesero.setCorreo("mesero@mesero.com");
      usuarioMesero.setContrasena("mesero");

      Empleado empleadoMesero = new Empleado();
      empleadoMesero.setId(2);
      empleadoMesero.setNombre("Mesero");
      empleadoMesero.setApellido("Mesero");
      empleadoMesero.setDni("66666666");
      empleadoMesero.setTelefono("985737523");
      empleadoMesero.setUsuario(usuarioMesero);
      empleadoMesero.setCargo(mesero);
      empleadoMesero.setFechaRegistro(fechaString);
      usuarioMesero.setEmpleado(empleadoMesero);

      usuarioService.agregar(usuarioMesero);

      /* ------------------------------------------------------------- */

      Cargo cajero = cargoService.obtenerPorNombre("CAJERO");

      Usuario usuarioCajero = new Usuario();
      usuarioCajero.setId(3);
      usuarioCajero.setCorreo("cajero@cajero.com");
      usuarioCajero.setContrasena("cajero");

      Empleado empleadoCajero = new Empleado();
      empleadoCajero.setId(3);
      empleadoCajero.setNombre("Cajero");
      empleadoCajero.setApellido("Cajero");
      empleadoCajero.setDni("55555555");
      empleadoCajero.setTelefono("985743657");
      empleadoCajero.setFechaRegistro(fechaString);
      empleadoCajero.setUsuario(usuarioCajero);
      empleadoCajero.setCargo(cajero);

      usuarioCajero.setEmpleado(empleadoCajero);

      usuarioService.agregar(usuarioCajero);

      /* ------------------------------------------------------------- */

      Cargo gerente = cargoService.obtenerPorNombre("GERENTE");

      Usuario usuarioGerente = new Usuario();
      usuarioGerente.setId(4);
      usuarioGerente.setCorreo("gerente@gerente.com");
      usuarioGerente.setContrasena("gerente");

      Empleado empleadoGerente = new Empleado();
      empleadoGerente.setId(4);
      empleadoGerente.setNombre("Gerente");
      empleadoGerente.setApellido("Gerente");
      empleadoGerente.setDni("33333333");
      empleadoGerente.setTelefono("985684839");
      empleadoGerente.setFechaRegistro(fechaString);
      empleadoGerente.setUsuario(usuarioGerente);
      empleadoGerente.setCargo(gerente);

      usuarioGerente.setEmpleado(empleadoGerente);

      usuarioService.agregar(usuarioGerente);
    }
  }
}
