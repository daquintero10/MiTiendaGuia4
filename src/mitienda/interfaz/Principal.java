package mitienda.interfaz;

import javax.swing.*;
import java.io.IOException;
import java.sql.SQLException;

public class Principal extends JFrame {

    //Constructor
    public Principal() throws IOException, SQLException {
        super( "Mi Tienda");
        //setSize(660, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setContentPane(new interfazPrin().getPanelPrincipal());
        pack();
        setVisible(true);

    }

    //Programa
    public static void main(String[] args) throws IOException, SQLException {
        Principal frame = new Principal();
    }

}
