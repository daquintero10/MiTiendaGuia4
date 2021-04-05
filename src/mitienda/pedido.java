package mitienda;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import java.util.*;

@DatabaseTable
public class pedido {



    @DatabaseField(id = true)
    private int id;

    @DatabaseField(canBeNull = false)
    private String listadoProductos;

    @DatabaseField(canBeNull = false)
    private String cantidadProductos;

    @DatabaseField(canBeNull = false)
    private double precioTotal;

    @DatabaseField(canBeNull = false)
    private Date fechaHora;

    public pedido() {}

    public pedido(int id, String listadoProductos, String cantidadProductos, double precioTotal, Date fechaHora) {
        this.id = id;
        this.listadoProductos = listadoProductos;
        this.cantidadProductos = cantidadProductos;
        this.precioTotal = precioTotal;
        this.fechaHora = fechaHora;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getListadoProductos() {
        return listadoProductos;
    }

    public void setListadoProductos(String listadoProductos) {
        this.listadoProductos = listadoProductos;
    }

    public String getCantidadProductos() {
        return cantidadProductos;
    }

    public void setCantidadProductos(String cantidadProductos) {
        this.cantidadProductos = cantidadProductos;
    }

    public double getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(double preicioTotal) {
        this.precioTotal = preicioTotal;
    }

    public Date getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(Date fechaHora) {
        this.fechaHora = fechaHora;
    }

}
