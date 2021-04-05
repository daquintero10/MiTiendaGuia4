package mitienda;

import java.io.IOException;
import java.sql.SQLException;

public class validarInfo {

    public static void main(String[] args) throws IOException, SQLException {
        Producto p = new Producto();

        p.listarProductos();

    }
}
