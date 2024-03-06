package Doctor;

import Cita.Cita;

import java.util.LinkedList;

public class Doctor {

    private String nombre;
   private String apellidos;
    private String especialidad;
    private String contra;
   private String genero;
    private int telefono;
    private int edad;
    private String codigo;
    private LinkedList<Cita> listaPersonal;




    public Doctor(String nombre, String apellidos, String especialidad, String contra, String genero, int telefono, int edad,LinkedList<Cita> listaPersonal, String codigo ) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.especialidad = especialidad;
        this.contra = contra;
        this.genero = genero;
        this.telefono = telefono;
        this.edad = edad;
        this.listaPersonal = listaPersonal;
        this.codigo=codigo;
    }

    public String getNombre() {return nombre;}
    public String getApellidos() {return apellidos;}
    public String getEspecialidad() {return especialidad;}
    public String getContra() {return contra;}

    public String getGenero() {return genero;}
    public int getTelefono() {return telefono;}
    public int getEdad() {return edad;}

    public String getCodigo(){return codigo;}

    public void setNombre(String nombre) {this.nombre = nombre;}
    public void setApellidos(String apellidos) {this.apellidos = apellidos;}
    public void setEspecialidad(String especialidad) {this.especialidad = especialidad;}
    public void setContra(String contra) {this.contra = contra;}
    public void setGenero(String genero) {this.genero = genero;}
    public void setTelefono(int telefono) {this.telefono = telefono;}
    public void setEdad(int edad) {this.edad = edad;}
    public void setCodigo(){this.codigo = codigo;}

    public void addCitas(Cita cita){
        listaPersonal.add(cita);
    }

    public LinkedList<Cita> getListaPersonal() {
        return listaPersonal;
    }

    public void setListaPersonal(LinkedList<Cita> listaPersonal) {
        this.listaPersonal = listaPersonal;
    }


}
