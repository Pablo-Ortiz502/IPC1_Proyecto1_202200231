package Admin;

import Doctor.Doctor;
import Paciente.Paciente;
import Producto.Producto;

import java.util.LinkedList;

public class Admin {

   private static String nombreAdmin ="Pablo";
   private static String contraAdmin="123";//"proyecto1IPC1";      CAMBIAR ANTES DE ENTREGAR****************
    private static int carnetAdmin=202200231;

    public static LinkedList<Paciente> listaPacientes = new LinkedList<>();
    public static LinkedList<Doctor> listaDoctores = new LinkedList<>();
    public static LinkedList<Producto> listaProductos = new LinkedList<>();

    public static String getNombreAdmin() {return nombreAdmin;}
    public static String getContraAdmin() {return contraAdmin;}
    public static int getCarnetAdmin() {return carnetAdmin;}


    public void eliminarDoctor(){

    }

    public void mostrarReporte(){

    }


    public void eliminarPaciente(){

    }

    public void eliminarProrducto(){

    }



}
