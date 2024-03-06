package Cita;

public class Cita {

    private String nombre;
    private String mes;
    private int dia;
    private int year;
    private String descripcion;

    public Cita(String nombre,String mes, int dia, int year, String descripcion) {
        this.nombre = nombre;
        this.mes = mes;
        this.dia = dia;
        this.year = year;
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
