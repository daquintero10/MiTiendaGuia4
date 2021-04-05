package mitienda.interfaz;

import mitienda.Producto;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class editarProducto {
    private JButton cargar;
    private JButton editar;
    private JTextField id;
    private JTextField nombre;
    private JTextField cantidad;
    private JTextField precio;
    private JPanel panelEditar;

    public editarProducto() {
        cargar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Producto prod = new Producto();
                int resp = 0;
                try {
                    resp = prod.existeID(Integer.parseInt(id.getText()));
                } catch (SQLException throwables) {

                }
                if ( resp == 1){
                    try {
                        nombre.setText(prod.encontrarNombre(Integer.parseInt(id.getText())));
                    } catch (SQLException throwables) {

                    }
                    try {
                        //
                        cantidad.setText(String.valueOf(prod.encontrarCantidad(Integer.parseInt(id.getText()))));
                    } catch (SQLException throwables) {

                    }
                    try {
                        precio.setText(String.valueOf(prod.encontrarPrecio(Integer.parseInt(id.getText()))));
                    } catch (SQLException throwables) {

                    }
                }else{
                    JOptionPane.showMessageDialog(null, "Error: No existe ningun" +
                            " producto con el ID ingresado");
                    id.setText("");
                    nombre.setText("");
                    cantidad.setText("");
                    precio.setText("");
                }
            }
        });
        editar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(id.getText().equalsIgnoreCase("") || nombre.getText().equalsIgnoreCase("") ||
                        cantidad.getText().equalsIgnoreCase("") ||
                        precio.getText().equalsIgnoreCase("") ){
                    JOptionPane.showMessageDialog(null, "Error: Ingrese el ID del producto y" +
                            " oprima el botón cargar, luego si modifique la información para editar y presione editar");
                    id.setText("");
                    nombre.setText("");
                    cantidad.setText("");
                    precio.setText("");
                }else{
                    int idb = Integer.parseInt(id.getText());
                    String n = nombre.getText();
                    int q = Integer.parseInt(cantidad.getText());
                    double p = Double.parseDouble(precio.getText());
                    Producto pr = new Producto();
                    try {
                        pr.editarProducto(idb, n, q, p);
                    } catch (SQLException throwables) {

                    }
                }
                id.setText("");
                nombre.setText("");
                cantidad.setText("");
                precio.setText("");
                JOptionPane.showMessageDialog(null, "Se ha editado la infomación del producto" +
                        " de manera exitosa");
            }
        });
    }

    public JPanel getPanelEditar() {
        return panelEditar;
    }
}
