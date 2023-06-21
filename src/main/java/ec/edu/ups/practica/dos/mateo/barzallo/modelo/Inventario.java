/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.practica.dos.mateo.barzallo.modelo;

import ec.edu.ups.practica.dos.mateo.barzallo.listaenlazada.ListaEnlazadaGenerico;

/**
 *
 * @author SOPORTETICS
 */
public class Inventario {
    ListaEnlazadaGenerico<Producto> listaProductos;

    public Inventario() {
        listaProductos = new ListaEnlazadaGenerico<>();
    }
    
    public void agregarProducto(Producto producto){
        listaProductos.agregar(producto);
    }
     public void mostrarInventario() {
        for (int i = 0; i < listaProductos.getTamaño(); i++) {
            Producto producto = listaProductos.getElementoByIndice(i);
            System.out.println("Nombre: " + producto.getNombre());
            System.out.println("Código: " + producto.getCodigo());
            System.out.println("Precio: " + producto.getPrecio());
            System.out.println("Cantidad Disponible: " + producto.getCantidadDisponible());
            System.out.println("-----------------------");
        }
    }

    public Producto buscarProductoPorCodigo(int codigo) {
        for (int i = 0; i < listaProductos.getTamaño(); i++) {
            Producto producto = listaProductos.getElementoByIndice(i);
            if (producto.getCodigo() == codigo) {
                return producto;
            }
        }
        return null; 
    }
       public void actualizarCantidadProducto(int codigo, int cantidad) {
        Producto producto = buscarProductoPorCodigo(codigo);
        if (producto != null) {
            int stockActual = producto.getCantidadDisponible();
            int nuevoStock = stockActual + cantidad;
            producto.setCantidadDisponible(nuevoStock);
            System.out.println("Stock actualizado exitosamente.");
        } else {
            System.out.println("El producto no se encuentra en el inventario.");
        }
    }
}
