package Paciente;

import Cita.Cita;

import java.util.LinkedList;

public class Paciente {
    private String nombre;
    private String apellidos;
    private String contra;
    private String genero;
    private int edad;
    private String codigo;

    private LinkedList<Cita> listaCitas;



    public Paciente(String nombre, String apellidos, String contra, String genero, int edad, String codigo,LinkedList<Cita> listaCitas) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.contra = contra;
        this.genero = genero;
        this.edad = edad;
        this.codigo = codigo;
        this.listaCitas = listaCitas;
    }

    public String getNombre() {return nombre;}

    public LinkedList<Cita> getListaCitas() {return listaCitas;}

    public void setNombre(String nombre) {this.nombre = nombre;}
    public String getApellidos() {return apellidos;}
    public void setApellidos(String apellidos) {this.apellidos = apellidos;}
    public String getContra() {return contra;}
    public void setContra(String contra) {this.contra = contra;}
    public String getGenero() {return genero;}
    public void setGenero(String genero) {this.genero = genero;}
    public int getEdad() {return edad;}
    public void setEdad(int edad) {this.edad = edad;}
    public String getCodigo() {return codigo;}
    public void setCodigo(String codigo) {this.codigo = codigo;}

    public void addLisataCita(Cita cita){
        listaCitas.add(cita);
    }

}
