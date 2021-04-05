package mitienda;

import com.j256.ormlite.jdbc.JdbcPooledConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.io.IOException;
import java.sql.SQLException;

public class CrearBaseDeDatos {

    public static void main(String[] args) throws SQLException, IOException {
        //Conectarse con el driver de SQLite
        JdbcPooledConnectionSource con = new JdbcPooledConnectionSource( "jdbc:sqlite:mitienda.db");

        //Creamos la tabla en la base de datos
        TableUtils.createTableIfNotExists(con, Producto.class);
        //TableUtils.createTableIfNotExists(con, pedido.class);
        System.out.println("Tabla Producto creada con éxito");

        //Cerramos la conexión con la base de datos
        con.close();
    }
}
