package Producto;

public class Producto {

    public String nomreProducto;
    public String descripcionProducto;
    public float precio;
    public int cantidad;

    public Producto(String nomreProducto, String descripcionProducto, float precio, int cantidad) {
        this.nomreProducto = nomreProducto;
        this.descripcionProducto = descripcionProducto;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    public String getNomreProducto() {
        return nomreProducto;
    }

    public void setNomreProducto(String nomreProducto) {
        this.nomreProducto = nomreProducto;
    }

    public String getDescripcionProducto() {
        return descripcionProducto;
    }

    public void setDescripcionProducto(String descripcionProducto) {
        this.descripcionProducto = descripcionProducto;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}
