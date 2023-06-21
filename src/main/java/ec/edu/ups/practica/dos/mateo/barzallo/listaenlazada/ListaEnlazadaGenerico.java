/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.practica.dos.mateo.barzallo.listaenlazada;

/**
 *
 * @author SOPORTETICS
 */
public class ListaEnlazadaGenerico<T> {

    private NodoGenerico<T> cabeza;
    private int tamaño;

    public void agregar(T elemento) {
        NodoGenerico<T> nuevo = new NodoGenerico(elemento);
        if (cabeza == null) {
            cabeza = nuevo;
        } else {
            NodoGenerico<T> ultimoNodo = obtenerUltimo();
            ultimoNodo.setSiguiente(nuevo);
        }
        tamaño++;
    }

    public NodoGenerico<T> obtenerUltimo() {
        NodoGenerico<T> actual = cabeza;
        while (actual.getSiguiente() != null) {
            actual = actual.getSiguiente();
        }
        return actual;
    }

    public T getElementoByIndice(int index) {
        NodoGenerico<T> actual = cabeza;
        for (int i = 0; i < index; i++) {
            actual = actual.getSiguiente();
        }
        return actual.getElemento();
    }

    public void deleteByIndice(int indice) {
        if (indice == 0) {
            cabeza = cabeza.getSiguiente();
        } else {
            NodoGenerico<T> anterior = obtenerNodoByIndice(indice - 1);
            NodoGenerico<T> nodoActual = anterior.getSiguiente();
            anterior.setSiguiente(nodoActual.getSiguiente());
        }
        tamaño--;
    }

    public NodoGenerico<T> obtenerNodoByIndice(int indice) {
        NodoGenerico<T> actual = cabeza;
        for (int i = 0; i < indice; i++) {
            actual = actual.getSiguiente();
        }
        return actual;
    }

    public NodoGenerico<T> getCabeza() {
        return cabeza;
    }

    public void setCabeza(NodoGenerico<T> cabeza) {
        this.cabeza = cabeza;
    }

    public int getTamaño() {
        return tamaño;
    }

    public void setTamaño(int tamaño) {
        this.tamaño = tamaño;
    }

}
