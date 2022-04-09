package org.uem.dam.GestorListaCompra.control;

import org.uem.dam.GestorListaCompra.view.ListaCompraWindow;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ListaCompraController implements ActionListener {
    private ListaCompraWindow window;

    public ListaCompraController(ListaCompraWindow window) {
        this.window = window;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        // TODO filterEvents
    }
}
