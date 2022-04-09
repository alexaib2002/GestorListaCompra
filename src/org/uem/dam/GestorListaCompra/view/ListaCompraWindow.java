package org.uem.dam.GestorListaCompra.view;

import org.uem.dam.GestorListaCompra.control.ListaCompraController;
import org.uem.dam.GestorListaCompra.model.Locale;
import org.uem.dam.GestorListaCompra.model.Producto;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;

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
    private JComboBox unitCBox;
    private JButton confAddProdButton;
    private JLabel prodNameLbl;
    private JLabel prodCantLbl;
    private JLabel errLbl;
    private JTextArea tipsTxtArea;
    private JCheckBox setSelMult;

    private DefaultListModel<String> prodListModel;
    private SpinnerNumberModel cantSpinnerModel;
    private DefaultComboBoxModel<String> unitBoxModel;

    private ListaCompraController controller;

    public ListaCompraWindow() {
        initComponents();
    }

    public void setController(ListaCompraController controller) {
        this.controller = controller;
        initListener();
    }

    public void setVisibleAddMenu(boolean visible) {
        addProdPanel.setVisible(visible);
        // actualizar tamaño ventana
        updateSize();
    }

    public ArrayList<String> getProdValues() {
        return new ArrayList<String>(Arrays.asList(
                prodNameTxt.getText(),
                cantSpinner.getValue().toString(),
                unitCBox.getModel().getSelectedItem().toString()
        ));
    }

    public DefaultListModel<String> getProdListModel() {
        return prodListModel;
    }

    public JList getProdList() {
        return prodList;
    }

    public void addNewProd(Producto producto) {
        prodListModel.addElement(producto.toString());
    }

    public void showErrorMssg(String err) {
        errLbl.setText(err);
        updateSize();
    }

    private void initComponents() {
        setContentPane(mainPane);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle(Locale.WIN_TITLE);
        prodList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        setVisibleAddMenu(false);
        initModels();
        bindTextStrings();
        updateSize();
    }

    private void initModels() {
        // init lista
        prodListModel = new DefaultListModel<String>();
        prodList.setModel(prodListModel);

        // init spinner
        cantSpinnerModel = new SpinnerNumberModel();
        cantSpinnerModel.setMaximum(500);
        cantSpinnerModel.setMinimum(1);
        cantSpinnerModel.setValue(1);
        cantSpinner.setModel(cantSpinnerModel);

        // init combobox
        unitBoxModel = new DefaultComboBoxModel<String>();
        unitBoxModel.addAll(Arrays.asList(
                Locale.CBOX_KG,
                Locale.CBOX_GR,
                Locale.CBOX_L,
                Locale.CBOX_UD
        ));
        unitBoxModel.setSelectedItem(Locale.CBOX_UD);
        unitCBox.setModel(unitBoxModel);
    }

    private void bindTextStrings() {
        tipsTxtArea.setText(Locale.TIPS_TXT);

        setSelMult.setText(Locale.CHK_SET_MULT);
        addButton.setText(Locale.BTN_ADD_ITEM);
        remButton.setText(Locale.BTN_REM_ITEM);
        selallButton.setText(Locale.BTN_SELALL_ITEM);
        confAddProdButton.setText(Locale.BTN_CADD_ITEM);

        prodNameLbl.setText(Locale.LB_PNAME);
        prodCantLbl.setText(Locale.LB_PCANT);
        errLbl.setText("");
    }

    private void initListener() {
        assert controller != null : "Controller no puede ser null";
        addButton.addActionListener(controller);
        selallButton.addActionListener(controller);
        remButton.addActionListener(controller);
        confAddProdButton.addActionListener(controller);
    }

    private void updateSize() {
        pack();
        setMinimumSize(this.getSize());
    }

}
