/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.practica.dos.mateo.barzallo.controlador;

import ec.edu.ups.practica.dos.mateo.barzallo.modelo.Historial;
import ec.edu.ups.practica.dos.mateo.barzallo.modelo.Inventario;
import ec.edu.ups.practica.dos.mateo.barzallo.modelo.Producto;
import ec.edu.ups.practica.dos.mateo.barzallo.modelo.Transaccion;
import ec.edu.ups.practica.dos.mateo.barzallo.vista.Vista;

/**
 *
 * @author SOPORTETICS
 */
public class Controlador {

    private Vista vista;
    private Inventario inventario;
    private Historial historialVentas;

    public Controlador() {
        vista = new Vista();
        inventario = new Inventario();
        historialVentas = new Historial();
    }

    public void iniciar() {
        vista.mostrarMenu();
    }

    public void agregarProducto() {
        System.out.println("======== Agregar Producto ========");
        System.out.print("Nombre: ");
        String nombre = vista.leerLinea();
        System.out.print("Código: ");
        int codigo = vista.leerEntero();
        System.out.print("Precio: ");
        double precio = vista.leerDouble();
        System.out.print("Cantidad disponible: ");
        int cantidadDisponible = vista.leerEntero();

        Producto producto = new Producto(nombre, codigo, precio, cantidadDisponible);
        inventario.agregarProducto(producto);

        System.out.println("Producto agregado exitosamente.");
        System.out.println("-----------------------");
    }

    public void realizarVenta() {
        System.out.println("======== Realizar Venta ========");
        System.out.print("Código del producto: ");
        int codigo = vista.leerEntero();
        System.out.print("Cantidad: ");
        int cantidad = vista.leerEntero();

        Producto producto = inventario.buscarProductoPorCodigo(codigo);
        if (producto != null) {
            int stockDisponible = producto.getCantidadDisponible();
            if (cantidad > stockDisponible) {
                System.out.println("No hay suficiente stock disponible para esa cantidad.");
            } else {
                double total = producto.getPrecio() * cantidad;

                inventario.actualizarCantidadProducto(codigo, -cantidad);

                Transaccion transaccion = new Transaccion(producto, cantidad);
                historialVentas.agregarTransaccion(transaccion);

                System.out.println("Venta realizada exitosamente.");
                System.out.println("Total: $" + total);
            }
        } else {
            System.out.println("Producto no encontrado en el inventario.");
        }
        System.out.println("-----------------------");
    }

    public void mostrarInventario() {
        System.out.println("======== Inventario ========");
        inventario.mostrarInventario();
        System.out.println("-----------------------");
    }

    public void mostrarHistorialVentas() {
        System.out.println("======== Historial de Ventas ========");
        historialVentas.mostrarHistorial();
        System.out.println("-----------------------");
    }
}
