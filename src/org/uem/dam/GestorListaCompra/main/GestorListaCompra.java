package org.uem.dam.GestorListaCompra.main;

import org.uem.dam.GestorListaCompra.control.ListaCompraController;
import org.uem.dam.GestorListaCompra.model.ListaCompra;
import org.uem.dam.GestorListaCompra.view.ListaCompraWindow;

public class GestorListaCompra {
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> { // Runable es interfaz funcional reemplazable por lambda, no es necesario crear objeto anonimo
            ListaCompraWindow window = new ListaCompraWindow();
            ListaCompraController controller = new ListaCompraController(
                    window,
                    new ListaCompra()
            );
            window.setController(controller);
            window.setVisible(true);
        });
    }
}
