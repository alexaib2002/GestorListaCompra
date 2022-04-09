package org.uem.dam.GestorListaCompra.model;

public class Producto {
    private String nombre;
    private int cantidad;
    private int uds; // FIXME uds no es un entero, es String

    public Producto(String nombre, int cantidad, int uds) {
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.uds = uds;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return nombre + " ( cant: " + cantidad + ", uds: " + uds+ ")";
    }
}
