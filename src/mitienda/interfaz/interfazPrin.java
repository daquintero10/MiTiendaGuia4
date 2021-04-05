package mitienda.interfaz;

import mitienda.Producto;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;

public class interfazPrin {
    private JPanel panelPrincipal;
    private JButton Salir;
    private JButton agregarProducto;
    private JButton editarProducto;
    private JButton eliminarProducto;
    private JButton anadirUnidades;
    private JTextField idBusqueda;
    private JButton busquedaProducto;
    private JScrollPane scrollProducts;
    private JTextArea areaProductos;
    private JButton actualizar;

    public interfazPrin() throws IOException, SQLException {
        Producto p= new Producto();
        areaProductos.setText(p.listaProductos());
        Salir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int resp = JOptionPane.showConfirmDialog(null,"Desea salir del programa?","Mi Tienda",JOptionPane.YES_NO_OPTION);
                if(resp == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }
            }
        });
        agregarProducto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame abrirAgregar = new JFrame("Agregar Producto");
                abrirAgregar.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
                abrirAgregar.setContentPane(new agregarProducto().getPanelAgregar());
                abrirAgregar.pack();
                abrirAgregar.setVisible(true);
            }
        });
        editarProducto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame abrirEditar = new JFrame("Editar Producto");
                abrirEditar.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
                abrirEditar.setContentPane(new editarProducto().getPanelEditar());
                abrirEditar.pack();
                abrirEditar.setVisible(true);
            }
        });
        anadirUnidades.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame abrirAnadir = new JFrame("Añadir Producto");
                abrirAnadir.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
                abrirAnadir.setContentPane(new anadirUnidades().getPanelAnadir());
                abrirAnadir.pack();
                abrirAnadir.setVisible(true);
            }
        });
        eliminarProducto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame abrirEliminar = new JFrame("Eliminar Producto");
                abrirEliminar.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
                abrirEliminar.setContentPane(new eliminarProducto().getPanelEliminar());
                abrirEliminar.pack();
                abrirEliminar.setVisible(true);
            }
        });
        busquedaProducto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int idABuscar = Integer.parseInt(idBusqueda.getText());
                //Aqui se busca el producto, ya hay un metodo para saber si existe
                Producto pro = new Producto();
                try {
                    if (pro.existeID(idABuscar)==1){
                        //hola
                        areaProductos.setText(idABuscar + " || " + pro.encontrarNombre(idABuscar) + " || " + pro.encontrarCantidad(idABuscar) +
                                " || $" + pro.encontrarPrecio(idABuscar));
                    }else{

                    }
                } catch (SQLException throwables) {

                }
            }
        });
        actualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Producto pro = new Producto();
                try {
                    areaProductos.setText(p.listaProductos());
                } catch (SQLException throwables) {

                } catch (IOException ioException) {

                }
            }
        });
    }




    public JPanel getPanelPrincipal(){
        return panelPrincipal;
    }
}
