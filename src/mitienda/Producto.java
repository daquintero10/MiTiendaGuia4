package mitienda;


import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.jdbc.JdbcPooledConnectionSource;
import com.j256.ormlite.table.DatabaseTable;

import java.io.IOException;
import java.sql.SQLException;

@DatabaseTable
public class Producto {

    @DatabaseField(id = true)
    private int id;

    @DatabaseField(canBeNull = false)
    private String nombre;

    @DatabaseField(canBeNull = false)
    private int cantidad;

    @DatabaseField(canBeNull = false)
    private double precio;

    public Producto() {}

    public Producto(int id, String nombre, int cantidad, double precio) {
        this.id = id;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void agregarProducto(String name, int q, double price) throws SQLException, IOException {
        //Conectarse con el driver de SQLite
        JdbcPooledConnectionSource con = new JdbcPooledConnectionSource( "jdbc:sqlite:mitienda.db");

        //Creamos un DAO, un representante de la tabla en el programa
        Dao<Producto, Integer> tablaProductos =
                DaoManager.createDao(con, Producto.class);

        int number=0;
        try {
            for (Producto prod : tablaProductos){
                if (prod.getId() > number){
                    number = prod.getId();
                }
            }
        } catch (Exception ext) {
            number=0;
        }

        number= number+1;

        Producto nuevo = new Producto(number, name, q, price);
        tablaProductos.create(nuevo);

        //Cerrar la conexiòn con la base de datos
        con.close();
    }

    public void listarProductos() throws SQLException, IOException {
        //Conectarse con el driver de SQLite
        JdbcPooledConnectionSource con = new JdbcPooledConnectionSource( "jdbc:sqlite:mitienda.db");

        //Creamos un DAO, un representante de la tabla en el programa
        Dao<Producto, Integer> tablaProductos =
                DaoManager.createDao(con, Producto.class);

        for (Producto prod : tablaProductos){
            System.out.println(prod.getId() + " - " + prod.getNombre() + " - " + prod.getCantidad() + " - "
                    + prod.getPrecio());
        }

        //Cerrar la conexiòn con la base de datos
        con.close();
    }

    public String listaProductos() throws SQLException, IOException {
        //Conectarse con el driver de SQLite
        JdbcPooledConnectionSource con = new JdbcPooledConnectionSource( "jdbc:sqlite:mitienda.db");

        //Creamos un DAO, un representante de la tabla en el programa
        Dao<Producto, Integer> tablaProductos =
                DaoManager.createDao(con, Producto.class);
        String result="";
        for (Producto prod : tablaProductos){
            result=result + "\n" +prod.getId() + " || " + prod.getNombre() + " || " + prod.getCantidad() + " || "
                    + prod.getPrecio();
        }

        //Cerrar la conexiòn con la base de datos
        con.close();
        return result;
    }

    public int existeID(int idB) throws SQLException {
        int resp;
        //Conectarse con el driver de SQLite
        JdbcPooledConnectionSource con = new JdbcPooledConnectionSource( "jdbc:sqlite:mitienda.db");

        //Creamos un DAO, un representante de la tabla en el programa
        Dao<Producto, Integer> tablaProductos =
                DaoManager.createDao(con, Producto.class);
        Producto pr = tablaProductos.queryForId(idB);
        if (pr != null){
            resp=1;
        }else{
            resp=0;
        }
        return resp;
    }

    //Dado un ID de producto encuentra el nombre del producto
    public String encontrarNombre(int idB) throws SQLException {
        String resp="";
        //Conectarse con el driver de SQLite
        JdbcPooledConnectionSource con = new JdbcPooledConnectionSource( "jdbc:sqlite:mitienda.db");

        //Creamos un DAO, un representante de la tabla en el programa
        Dao<Producto, Integer> tablaProductos =
                DaoManager.createDao(con, Producto.class);
        for (Producto p: tablaProductos){
            if (p.getId()== idB){
                resp = p.getNombre();
            }
        }
        return resp;
    }

    //Dado un ID de producto encuentra la cantidad del producto
    public int encontrarCantidad(int idB) throws SQLException {
        int resp=0;
        //Conectarse con el driver de SQLite
        JdbcPooledConnectionSource con = new JdbcPooledConnectionSource( "jdbc:sqlite:mitienda.db");

        //Creamos un DAO, un representante de la tabla en el programa
        Dao<Producto, Integer> tablaProductos =
                DaoManager.createDao(con, Producto.class);
        for (Producto p: tablaProductos){
            if (p.getId()== idB){
                resp = p.getCantidad();
            }
        }
        return resp;
    }


    //Dado un ID de producto encuentra el precio del producto
    public double encontrarPrecio(int idB) throws SQLException {
        double resp=0;
        //Conectarse con el driver de SQLite
        JdbcPooledConnectionSource con = new JdbcPooledConnectionSource( "jdbc:sqlite:mitienda.db");

        //Creamos un DAO, un representante de la tabla en el programa
        Dao<Producto, Integer> tablaProductos =
                DaoManager.createDao(con, Producto.class);
        for (Producto p: tablaProductos){
            if (p.getId()== idB){
                resp = p.getPrecio();
            }
        }
        return resp;
    }

    public void editarProducto(int idB, String nomb, int q, double p) throws SQLException {
        //Conectarse con el driver de SQLite
        JdbcPooledConnectionSource con = new JdbcPooledConnectionSource( "jdbc:sqlite:mitienda.db");

        //Creamos un DAO, un representante de la tabla en el programa
        Dao<Producto, Integer> tablaProductos =
                DaoManager.createDao(con, Producto.class);

        Producto pr = tablaProductos.queryForId(idB);
        pr.setNombre(nomb);
        pr.setCantidad(q);
        pr.setPrecio(p);
        tablaProductos.update(pr);

    }

    public void anadirUnidades(int idB, String nomb, int q) throws SQLException {
        //Conectarse con el driver de SQLite
        JdbcPooledConnectionSource con = new JdbcPooledConnectionSource( "jdbc:sqlite:mitienda.db");

        //Creamos un DAO, un representante de la tabla en el programa
        Dao<Producto, Integer> tablaProductos =
                DaoManager.createDao(con, Producto.class);

        Producto pr = tablaProductos.queryForId(idB);
        pr.setCantidad(pr.getCantidad()+q);
        tablaProductos.update(pr);

    }

    public void eliminarProducto(int idB) throws SQLException {
        //Conectarse con el driver de SQLite
        JdbcPooledConnectionSource con = new JdbcPooledConnectionSource( "jdbc:sqlite:mitienda.db");

        //Creamos un DAO, un representante de la tabla en el programa
        Dao<Producto, Integer> tablaProductos =
                DaoManager.createDao(con, Producto.class);
        tablaProductos.deleteById(idB);
    }

}
