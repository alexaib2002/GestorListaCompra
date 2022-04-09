package org.uem.dam.GestorListaCompra.model;

import java.util.ArrayList;

public class ListaCompra {
    private ArrayList<Producto> listaProductos;

    public ListaCompra() {
        initAttr();
    }

    public void addProducto(Producto producto) {
        listaProductos.add(producto);
    }

    public void rmProducto(int index) {
        listaProductos.remove(index);
    }

    private void initAttr() {
        this.listaProductos = new ArrayList<>();
    }
}
