package org.uem.dam.GestorListaCompra.model;

import java.util.ArrayList;

public class ListaCompra {
    private ArrayList<Producto> listaProductos;

    public ListaCompra() {
        initAttr();
    }

    public void addProducto(Producto producto) {
        listaProductos.add(producto);
        dbgShow();
    }

    public void rmProducto(int index) {
        listaProductos.remove(index);
        dbgShow();
    }

    public ArrayList<Producto> toArrayList() {
        return listaProductos;
    }

    private void initAttr() {
        this.listaProductos = new ArrayList<>();
    }

    private void dbgShow() {
        System.out.println(listaProductos.toString());;
    }
}
