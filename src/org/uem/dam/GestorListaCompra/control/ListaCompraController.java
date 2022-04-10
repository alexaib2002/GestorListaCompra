package org.uem.dam.GestorListaCompra.control;

import org.uem.dam.GestorListaCompra.model.Locale;
import org.uem.dam.GestorListaCompra.model.Producto;
import org.uem.dam.GestorListaCompra.view.ListaCompraWindow;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class ListaCompraController implements ActionListener {
    private ListaCompraWindow window;

    public ListaCompraController(ListaCompraWindow window) {
        this.window = window;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        // resetear ultimo error mostrado
        window.showErrorMssg("");
        window.setVisibleAddMenu(false);

        String cmd = actionEvent.getActionCommand();

        switch (cmd) {
            case Locale.BTN_ADD_ITEM:
                showAddProdMenu();
                break;
            case Locale.BTN_REM_ITEM_SINGLE:
            case Locale.BTN_REM_ITEM_MULTI:
                remProducto();
                break;
            case Locale.BTN_SELALL_ITEM:
                selAllProducto();
                break;
            case Locale.BTN_CADD_ITEM:
                confirmAddProducto();
                break;
            case Locale.BTN_HELP:
                toggleHelp();
                break;
            case Locale.CHK_SET_MULT:
                changeSelectionMode();
                break;
            default:
                System.out.println(String.format("[ ATENCIÓN ] Evento '%s' desconocido, no será gestionado", cmd));
        }
    }

    private void showAddProdMenu() {
        window.setVisibleAddMenu(true);
    }

    private void remProducto() {
        List<String> selProds = window.getProdList().getSelectedValuesList();
        for (String prod: selProds) {
            window.getProdListModel().removeElement(prod);
            System.out.println(String.format("Eliminando producto %s", prod));
        }
    }

    private void selAllProducto() {
        int[] idxs = new int[window.getProdListModel().size()];
        for (int i = 0; i < window.getProdListModel().size(); i++) {
            idxs[i] = i;
        }
        window.getProdList().setSelectedIndices(idxs);
        System.out.println("Todos los productos seleccionados por petición");
    }

    private void confirmAddProducto() {
        ArrayList<String> productoAttrs = window.getProdValues();
        if (!productoAttrs.get(0).isEmpty() || !productoAttrs.get(0).isBlank()) { // comprobar si el nombre esta vacio
            System.out.printf("Insertando nuevo producto %s\n", productoAttrs.get(0));
            for (Object producto: window.getProdListModel().toArray() // buscar si hay algun elemento con el mismo nombre en la lista
                 ) {
                if (producto instanceof String) {
                    if (((String) producto).contains(productoAttrs.get(0))) {
                        window.getProdListModel().removeElement(producto); // si existe, se asume que el usuario quiere actualizar sus datos
                        System.out.println(String.format(
                                "[ ATENCIÓN ] El producto ya existe. Actualizando producto %s", productoAttrs.get(0))
                        );
                    }
                }
            }
            window.addNewProd(new Producto(
                    productoAttrs.get(0),
                    Integer.parseInt(productoAttrs.get(1)),
                    productoAttrs.get(2)
            ));
        } else {
            window.showErrorMssg(Locale.ERR_STR_EMPTY);
            System.out.println("Inserción denegada");
        }
    }

    private void toggleHelp() {
        window.setVisibleTipsPanel(!window.getTipsPanel().isVisible());
    }

    private void changeSelectionMode() {
        switch (window.getSelectionMode()) {
            case ListSelectionModel.SINGLE_SELECTION:
                System.out.println("Modo de selección multiple");
                window.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
                break;
            case ListSelectionModel.MULTIPLE_INTERVAL_SELECTION:
                System.out.println("Modo de selección unico");
                window.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
                break;
        }
    }
}
