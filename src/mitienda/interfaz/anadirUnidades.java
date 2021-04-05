package mitienda.interfaz;

import mitienda.Producto;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class anadirUnidades {
    private JButton cargar;
    private JButton anadir;
    private JTextField id;
    private JTextField nombre;
    private JTextField cantidad;
    private JPanel panelAnadir;


    public anadirUnidades() {
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
                }else{
                    JOptionPane.showMessageDialog(null, "Error: No existe ningun" +
                            "producto con el ID ingresado");
                    id.setText("");
                    nombre.setText("");
                    cantidad.setText("");
                }
            }
        });
        anadir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(id.getText().equalsIgnoreCase("") || cantidad.getText().equalsIgnoreCase("") ){
                    JOptionPane.showMessageDialog(null, "Error: Ingrese el ID del producto y" +
                            "oprima el botón cargar, luego si ingrese la cantidad de unidades a agregar al producto");
                    id.setText("");
                    nombre.setText("");
                    cantidad.setText("");

                }else{
                    int idb = Integer.parseInt(id.getText());
                    String n = nombre.getText();
                    int q = Integer.parseInt(cantidad.getText());
                    Producto pr = new Producto();
                    try {
                        pr.anadirUnidades(idb, n, q);
                    } catch (SQLException throwables) {

                    }
                }
                id.setText("");
                nombre.setText("");
                cantidad.setText("");
                JOptionPane.showMessageDialog(null, "Se han añadido las unidades al inventario" +
                        " del producto exitosamente");
            }
        });
    }

    public JPanel getPanelAnadir() {
        return panelAnadir;
    }
}
