package org.uem.dam.GestorListaCompra.control;

import org.uem.dam.GestorListaCompra.model.Locale;
import org.uem.dam.GestorListaCompra.model.Producto;
import org.uem.dam.GestorListaCompra.view.ListaCompraWindow;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ListaCompraController implements ActionListener {
    private ListaCompraWindow window;

    public ListaCompraController(ListaCompraWindow window) {
        this.window = window;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        // resetear ultimo error mostrado
        window.showErrorMssg("");

        String cmd = actionEvent.getActionCommand();

        switch (cmd) {
            case Locale.BTN_ADD_ITEM:
                showAddProdMenu();
                break;
            case Locale.BTN_REM_ITEM:
                remProducto();
                break;
            case Locale.BTN_SELALL_ITEM:
                selAllProducto();
                break;
            case Locale.BTN_CADD_ITEM:
                confirmAddProducto();
                break;
            default:
                System.out.println(String.format("[Controller] Cannot handle event %s", cmd));
        }
    }

    private void showAddProdMenu() {
        window.setVisibleAddMenu(true);
    }

    private void remProducto() {
        // TODO Eliminar objeto seleccionado
    }

    private void selAllProducto() {
        // TODO Seleccionar todos los objetos de la lista
    }

    private void confirmAddProducto() {
        ArrayList<String> productoAttrs = window.getProdValues();
        if (!productoAttrs.get(0).isEmpty() || !productoAttrs.get(0).isBlank()) { // comprobar si el nombre esta vacio
            for (Object producto: window.getProdListModel().toArray() // buscar si hay algun elemento con el mismo nombre en la lista
                 ) {
                if (producto instanceof String) {
                    if (((String) producto).contains(productoAttrs.get(0))) {
                        window.getProdListModel().removeElement(producto); // si existe, se asume que el usuario quiere actualizar sus datos
                        System.out.println(String.format("Actualizando producto %s", productoAttrs.get(0)));
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
        }
    }
}
