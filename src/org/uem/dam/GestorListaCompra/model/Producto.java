package org.uem.dam.GestorListaCompra.model;

public class Producto {
    private String nombre;
    private int cantidad;
    private String uds;

    public Producto(String nombre, int cantidad, String uds) {
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.uds = uds;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return String.format("%s (%s %s)", nombre, cantidad, uds);
    }
}
