package org.uem.dam.GestorListaCompra.view;

import javax.swing.*;

public class ProductoSlot extends JPanel {
    private JPanel prodSlot;
    private JCheckBox slotSelChck;
    private JLabel prodName;

    public ProductoSlot(String nombre) {
        prodName.setText(nombre);
        setVisible(true);
    }


}
