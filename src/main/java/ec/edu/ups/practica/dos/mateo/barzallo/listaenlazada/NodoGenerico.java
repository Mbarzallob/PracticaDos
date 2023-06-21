/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.practica.dos.mateo.barzallo.listaenlazada;

/**
 *
 * @author SOPORTETICS
 */
public class NodoGenerico<T> {

    private T elemento;
    private NodoGenerico<T> siguiente;

    public NodoGenerico(T elemento) {
        this.elemento = elemento;

    }

    public T getElemento() {
        return elemento;
    }

    public void setElemento(T elemento) {
        this.elemento = elemento;
    }

    public NodoGenerico<T> getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoGenerico<T> siguiente) {
        this.siguiente = siguiente;
    }

    
}
