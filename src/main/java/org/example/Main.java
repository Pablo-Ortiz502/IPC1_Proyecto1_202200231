package org.example;
import Admin.Admin;
import Cita.Cita;
import Doctor.Doctor;
import Paciente.Paciente;
import Producto.Producto;
import Admin.AdminDoctorFrame;
import ReporteFrame.ReporteCita;
import ReporteFrame.ReporteDoctor;
import ReporteFrame.ReportePaciente;
import ReporteFrame.ReporteProducto;
import Doctor.DoctorFrame;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {



        LinkedList<Cita> listaCita = new LinkedList<>();
        LinkedList<Cita> listaCita1 = new LinkedList<>();
        LinkedList<Cita> listaCita2 = new LinkedList<>();
        LinkedList<Cita> listaCitaP1 = new LinkedList<>();
        LinkedList<Cita> listaCitaP2 = new LinkedList<>();
        Doctor doctor = new Doctor("Pablo","Ortiz","Cardiología","1234","Hombre",41877278,45,listaCita,"D124abc");
        Doctor doctor2 = new Doctor("Juan","Linares","Urología","1234","Hombre",41877278,30,listaCita1,"D125abc");
        Doctor doctor3 = new Doctor("Roberto","Roman","Pediatria","1234","Hombre",41877278,28,listaCita2,"D193abc");
        Paciente paciente = new Paciente("Carlos","JOse","1234","Hombre",55,"P123abc",listaCitaP1);
        Paciente paciente1 = new Paciente("Juan","Carlos","12","Hombre",58,"P321bca",listaCitaP2);
        Producto producto = new Producto("alpha","cura la tos",15.5f,100);
        Cita cita =new Cita("Juan Hernandez","Enero",12,2025,"Me duele el estomago");
        Cita cita1 = new Cita("Juan Carlos","Febrero",28,2024,"Dolor de pierna");

        doctor.addCitas(cita);

        Admin.listaPacientes.add(paciente);
        Admin.listaDoctores.add(doctor);
        Admin.listaDoctores.add(doctor2);
        Admin.listaDoctores.add(doctor3);
        Admin.listaProductos.add(producto);

//new EditDoctroFrame().setVisible(true);
    //  new CrearCitaFrame(Admin.listaDoctores,paciente).setVisible(true);
      //new AdminFrame().setVisible(true);
        //new LoginFrame().setVisible(true);
      //new EditProductoFrame().setVisible(true);
     // new EditProductoFrame(doctor3).setVisible(true);
      //  new RegistroPacienteFrame().setVisible(true);
        //new EditProductoFrame(paciente).setVisible(true);
      //  new AdminPacienteFrame().setVisible(true);
       // new AdminProductoFrame().setVisible(true);
        new AdminDoctorFrame().setVisible(true);
        //new ReporteDoctor(Admin.listaDoctores).setVisible(true);
        //new ReportePaciente(Admin.listaPacientes).setVisible(true);
       // new ReporteProducto(Admin.listaProductos).setVisible(true);
       // new ReporteCita(doctor.getListaPersonal()).setVisible(true);
        //new DoctorFrame(doctor2.getCodigo(),Admin.listaDoctores).setVisible(true);


        //hacer los editores de los usuarios

    }
}