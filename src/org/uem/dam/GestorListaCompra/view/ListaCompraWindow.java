package org.uem.dam.GestorListaCompra.view;

import org.uem.dam.GestorListaCompra.control.ListaCompraController;
import org.uem.dam.GestorListaCompra.model.Producto;

import javax.swing.*;

public class ListaCompraWindow extends JFrame {
    private JPanel mainPane;
    private JPanel centeredPanel;
    private JList prodList;
    private JButton addButton;
    private JButton remButton;
    private JButton selallButton;
    private JPanel addProdPanel;
    private JTextField prodNameTxt;
    private JSpinner cantSpinner;
    private JComboBox comboBox1;
    private JButton confAddProd;

    private DefaultListModel<ProductoSlot> prodListModel;

    private ListaCompraController controller;

    public ListaCompraWindow() {
        initComponents();
    }

    public void setController(ListaCompraController controller) {
        this.controller = controller;
    }

    public void addNewProd(Producto producto) {
        System.out.printf("Insertando nuevo producto %s\n", producto.getNombre());
        prodListModel.addElement(new ProductoSlot(producto.getNombre()));

    }

    private void initComponents() {
        setContentPane(mainPane);
        prodListModel = new DefaultListModel<ProductoSlot>();
        prodList.setModel(prodListModel);

        pack();
        setMinimumSize(this.getSize());
    }
}
