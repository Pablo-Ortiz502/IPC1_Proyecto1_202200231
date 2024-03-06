package Paciente;

import Cita.CrearCitaFrame;
import Doctor.Doctor;
import Edit.EditPacienteFrame;
import Login.LoginFrame;
import Producto.Producto;
import ReporteFrame.ReporteCita;
import ReporteFrame.ReporteProducto;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import javax.swing.*;

public class PacienteFrame extends JFrame {
    LinkedList<Paciente> listaPaciente;
    String codio;
    LinkedList<Producto> listaProducto;
    LinkedList<Doctor> listaDoctor;
    private JButton citasButton;
    private JButton farmaciaButton;
    private JButton editarPerfil;
    private JButton regresarButton;
    private JButton crearCita;

    public PacienteFrame(String codigo, LinkedList<Paciente> listaPaciente,LinkedList<Producto> listaProductos,LinkedList<Doctor> listaDoctor){
        super("Pciente");

        setSize(300, 210);
        this.listaPaciente = listaPaciente;
        this.codio = codigo;
        this.listaProducto = listaProductos;
        this.listaDoctor = listaDoctor;
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        Container pane = getContentPane();
        pane.setLayout(new BoxLayout(pane, BoxLayout.Y_AXIS));


        citasButton = new JButton("Citas");
        farmaciaButton = new JButton("Farmacia");
        editarPerfil = new JButton("Editar perffil");
        regresarButton = new JButton("Salir");
        crearCita = new JButton("Crear Cita");

        Box buttonBox1 = new Box(BoxLayout.X_AXIS);
        buttonBox1.add(Box.createHorizontalGlue());
        buttonBox1.add(editarPerfil);
        buttonBox1.add(Box.createHorizontalGlue());

        Box buttonBox2 = new Box(BoxLayout.X_AXIS);
        buttonBox2.add(Box.createHorizontalGlue());
        buttonBox2.add(farmaciaButton);
        buttonBox2.add(Box.createHorizontalGlue());

        Box buttonBox3 = new Box(BoxLayout.X_AXIS);
        buttonBox3.add(Box.createHorizontalGlue());
        buttonBox3.add(citasButton);
        buttonBox3.add(Box.createHorizontalGlue());

        Box buttonBox4 = new Box(BoxLayout.X_AXIS);
        buttonBox3.add(Box.createHorizontalGlue());
        buttonBox3.add(crearCita);
        buttonBox3.add(Box.createHorizontalGlue());

        Box buttonBox5 = new Box(BoxLayout.X_AXIS);
        buttonBox4.add(Box.createHorizontalGlue());
        buttonBox4.add(regresarButton);
        buttonBox4.add(Box.createHorizontalGlue());


        pane.add(buttonBox1);
        pane.add(Box.createRigidArea(new Dimension(0, 20)));
        pane.add(buttonBox2);
        pane.add(Box.createRigidArea(new Dimension(0, 20)));
        pane.add(buttonBox3);
        pane.add(Box.createRigidArea(new Dimension(0, 20)));
        pane.add(buttonBox4);
        pane.add(Box.createRigidArea(new Dimension(0, 5)));
        pane.add(buttonBox5);

        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);


        citasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (int i =0; i<listaPaciente.size();i++){
                    if (codigo.equals(listaPaciente.get(i).getCodigo())){
                        if(listaPaciente.get(i).getListaCitas().isEmpty()){
                            JOptionPane.showMessageDialog(PacienteFrame.this,"No hay citas registradas","Trate otra vez",JOptionPane.ERROR_MESSAGE);
                        }else {
                            new ReporteCita(listaPaciente.get(i).getListaCitas()).setVisible(true);
                        }
                    }
                }

            }
        });

        editarPerfil.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (int i=0; i<listaPaciente.size();i++){
                    if(codigo.equals(listaPaciente.get(i).getCodigo())){
                        new EditPacienteFrame(listaPaciente.get(i)).setVisible(true);
                    }
                }

            }
        });

        farmaciaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                new ReporteProducto(listaProductos).setVisible(true);
            }
        });


        regresarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new LoginFrame().setVisible(true);
            }
        });

        crearCita.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (int i=0; i<listaPaciente.size();i++){
                    if(codigo.equals(listaPaciente.get(i).getCodigo())){
                        new CrearCitaFrame(listaDoctor,listaPaciente.get(i)).setVisible(true);
                    }
                }
            }
        });


    }
}
