package mitienda.interfaz;

import mitienda.Producto;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class agregarProducto {


    private JButton agregaProduct;
    private JTextField nombre;
    private JTextField cantidad;
    private JTextField precio;
    private JPanel PanelAgregar;

    public agregarProducto() {
        agregaProduct.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    //Trae el texto ingresado en nombre
                    String name = nombre.getText();
                }catch (Exception ex){
                    JOptionPane.showMessageDialog(null, "Error: Le falto ingresar la información" +
                            "del nombre del producto");
                    nombre.setText("");
                    cantidad.setText("");
                    precio.setText("");
                }
                try {
                    //Trae el texto de cantidad en entero
                    int q = Integer.parseInt(cantidad.getText());
                }catch (Exception ex){
                    JOptionPane.showMessageDialog(null, "Error: Valide ingresar" +
                            "en cantidad solamente numeros enteros");
                    nombre.setText("");
                    cantidad.setText("");
                    precio.setText("");
                }
                try {
                    //Trae el texto de precio en decimal
                    double p = Double.parseDouble(precio.getText());
                }catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Error: Valide ingresar" +
                            "en cantidad solamente numeros");
                    nombre.setText("");
                    cantidad.setText("");
                    precio.setText("");
                }

                try{
                    //Trae el texto ingresado en nombre
                    String name = nombre.getText();
                    //Trae el texto de cantidad en entero
                    int q = Integer.parseInt(cantidad.getText());
                    //Trae el texto de precio en decimal
                    double p = Double.parseDouble(precio.getText());
                    Producto pro = new Producto();
                    pro.agregarProducto(name, q, p);
                }catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Error: Valide que los" +
                            "datos ingresados correspondan al tipo de dato");
                    nombre.setText("");
                    cantidad.setText("");
                    precio.setText("");
                }

                nombre.setText("");
                cantidad.setText("");
                precio.setText("");
                JOptionPane.showMessageDialog(null, "El producto se ha agregado" +
                        " de manera exitosa");

            }
        });

    }

    public JPanel getPanelAgregar() {
        return PanelAgregar;
    }
}
