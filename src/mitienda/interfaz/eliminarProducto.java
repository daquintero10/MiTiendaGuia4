package mitienda.interfaz;

import mitienda.Producto;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class eliminarProducto {
    private JButton cargar;
    private JButton eliminar;
    private JTextField precio;
    private JTextField cantidad;
    private JTextField nombre;
    private JPanel panelEliminar;
    private JTextField id;


    public eliminarProducto() {
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
                            "producto con el ID ingresado");
                    id.setText("");
                    nombre.setText("");
                    cantidad.setText("");
                    precio.setText("");
                }
            }
        });
        eliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(id.getText().equalsIgnoreCase("") ){
                    JOptionPane.showMessageDialog(null, "Error: Ingrese el ID del producto " +
                            "que desea eliminar, y luego si presione la tecla Eliminar");
                    id.setText("");
                    nombre.setText("");
                    cantidad.setText("");
                    precio.setText("");
                }else{
                    int idb = Integer.parseInt(id.getText());
                    Producto pr = new Producto();
                    try {
                        pr.eliminarProducto(idb);
                    } catch (SQLException throwables) {

                    }
                }
                id.setText("");
                nombre.setText("");
                cantidad.setText("");
                precio.setText("");
                JOptionPane.showMessageDialog(null, "El producto se ha eliminado" +
                        " de manera exitosa");

            }
        });
    }

    public JPanel getPanelEliminar() {
        return panelEliminar;
    }
}
