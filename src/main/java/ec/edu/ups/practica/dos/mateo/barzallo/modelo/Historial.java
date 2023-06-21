/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.practica.dos.mateo.barzallo.modelo;

import java.util.Stack;

/**
 *
 * @author SOPORTETICS
 */
public class Historial {
    private Stack<Transaccion> transacciones;

    public Historial() {
        transacciones = new Stack<>();
    }

    public void agregarTransaccion(Transaccion transaccion) {
        transacciones.push(transaccion);
    }

    public void mostrarHistorial() {
        for (Transaccion transaccion : transacciones) {
            System.out.println("Producto: " + transaccion.getProducto().getNombre());
            System.out.println("Cantidad: " + transaccion.getCantidad());
            System.out.println("Total: " + transaccion.getTotal());
            System.out.println("-----------------------");
        }
    }

}
