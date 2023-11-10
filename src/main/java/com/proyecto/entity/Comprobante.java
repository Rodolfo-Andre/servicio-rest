package com.proyecto.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "COMPROBANTE")
public class Comprobante {
  @Id
  private Integer id;

  @Column(name = "FECHA_EMISION")
  private String fechaEmision;

  @Column(name = "PRECIO_TOTAL_PEDIDO")
  private double precioTotalPedido;

  @Column(name = "IGV_TOTAL")
  private double igv;

  @Column(name = "SUB_TOTAL")
  private double subTotal;

  @Column(name = "DESCUENTO_TOTAL")
  private double descuento;

  private String nombreCliente;

  @ManyToOne
  @JoinColumn(name = "METODO_PAGO_ID")
  private MetodoPago metodopago;

  @ManyToOne
  @JoinColumn(name = "TIPO_COMPROBANTE_ID")
  private TipoComprobante tipoComprobante;

  @ManyToOne
  @JoinColumn(name = "EMPLEADO_ID")
  private Empleado empleado;

  @OneToOne
  @JoinColumn(name = "COMANDA_ID")
  private Comanda comanda;

  @ManyToOne
  @JoinColumn(name = "CAJA_ID")
  private Caja caja;

  public String getNombreCliente() {
    return nombreCliente;
  }

  public void setNombreCliente(String nombreCliente) {
    this.nombreCliente = nombreCliente;
  }

  public MetodoPago getMetodopago() {
    return metodopago;
  }

  public void setMetodopago(MetodoPago metodopago) {
    this.metodopago = metodopago;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getFechaEmision() {
    return fechaEmision;
  }

  public void setFechaEmision(String fechaEmision) {
    this.fechaEmision = fechaEmision;
  }

  public double getPrecioTotalPedido() {
    return precioTotalPedido;
  }

  public void setPrecioTotalPedido(double precioTotalPedido) {
    this.precioTotalPedido = precioTotalPedido;
  }

  public double getIgv() {
    return igv;
  }

  public void setIgv(double igv) {
    this.igv = igv;
  }

  public double getSubTotal() {
    return subTotal;
  }

  public void setSubTotal(double subTotal) {
    this.subTotal = subTotal;
  }

  public double getDescuento() {
    return descuento;
  }

  public void setDescuento(double descuento) {
    this.descuento = descuento;
  }

  public TipoComprobante getTipoComprobante() {
    return tipoComprobante;
  }

  public void setTipoComprobante(TipoComprobante tipoComprobante) {
    this.tipoComprobante = tipoComprobante;
  }

  public Empleado getEmpleado() {
    return empleado;
  }

  public void setEmpleado(Empleado empleado) {
    this.empleado = empleado;
  }

  public Comanda getComanda() {
    return comanda;
  }

  public void setComanda(Comanda comanda) {
    this.comanda = comanda;
  }

  public Caja getCaja() {
    return caja;
  }

  public void setCaja(Caja caja) {
    this.caja = caja;
  }
}
