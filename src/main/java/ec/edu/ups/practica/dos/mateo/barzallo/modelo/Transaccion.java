/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.practica.dos.mateo.barzallo.modelo;

/**
 *
 * @author SOPORTETICS
 */
public class Transaccion {

    private Producto producto;
    private int cantidad;
    private double total;

    public Transaccion(Producto producto, int cantidad) {
        this.producto = producto;
        this.cantidad = cantidad;
        this.total = calcularTotal();
    }

    public Producto getProducto() {
        return producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public double getTotal() {
        return total;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    private double calcularTotal() {
        return producto.getPrecio() * cantidad;
    }
}
