package org.uem.dam.GestorListaCompra.main;

import org.uem.dam.GestorListaCompra.control.ListaCompraController;
import org.uem.dam.GestorListaCompra.model.Producto;
import org.uem.dam.GestorListaCompra.view.ListaCompraWindow;

public class GestorListaCompra {
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                ListaCompraWindow window = new ListaCompraWindow();
                ListaCompraController controller = new ListaCompraController(window);
                window.setController(controller);
                window.setVisible(true);
            }
        });
    }
}
