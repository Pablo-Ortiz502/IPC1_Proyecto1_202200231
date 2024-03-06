package Admin;

import Edit.EditPacienteFrame;

import RegistroFrame.RegistroPacienteFrame;
import ReporteFrame.ReportePaciente;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class AdminPacienteFrame extends JFrame {
    private JButton crearButton;
    private JButton editarButton;
    private JButton eliminar;

    private JButton reporteButton;

    private JButton regresarButton;

    public AdminPacienteFrame() {

        super("Opciones de Pacientes");
        setSize(300, 200);


        setDefaultCloseOperation(EXIT_ON_CLOSE);

        Container pane = getContentPane();
        pane.setLayout(new BoxLayout(pane, BoxLayout.Y_AXIS));


        crearButton = new JButton("Crear Paciente");
        editarButton = new JButton("Editar Paciente");
        eliminar = new JButton("Eliminar Paciente");
        reporteButton = new JButton("Lista de Pacientes");


        regresarButton = new JButton("Regresar");

        Box buttonBox1 = new Box(BoxLayout.X_AXIS);
        buttonBox1.add(Box.createHorizontalGlue());
        buttonBox1.add(crearButton);
        buttonBox1.add(Box.createHorizontalGlue());

        Box buttonBox2 = new Box(BoxLayout.X_AXIS);
        buttonBox2.add(Box.createHorizontalGlue());
        buttonBox2.add(editarButton);
        buttonBox2.add(Box.createHorizontalGlue());

        Box buttonBox3 = new Box(BoxLayout.X_AXIS);
        buttonBox3.add(Box.createHorizontalGlue());
        buttonBox3.add(eliminar);
        buttonBox3.add(Box.createHorizontalGlue());

        Box buttonBox4 = new Box(BoxLayout.X_AXIS);
        buttonBox4.add(Box.createHorizontalGlue());
        buttonBox4.add(reporteButton);
        buttonBox4.add(Box.createHorizontalGlue());

        Box buttonBox5 = new Box(BoxLayout.X_AXIS);
        buttonBox4.add(Box.createHorizontalGlue());
        buttonBox4.add(regresarButton);
        buttonBox4.add(Box.createHorizontalGlue());


        pane.add(buttonBox1);
        pane.add(Box.createRigidArea(new Dimension(0, 20)));
        pane.add(buttonBox2);
        pane.add(Box.createRigidArea(new Dimension(0, 20)));
        pane.add(buttonBox3);
        pane.add(Box.createRigidArea(new Dimension(0, 10)));
        pane.add(buttonBox4);
        pane.add(Box.createRigidArea(new Dimension(0, 10)));
        pane.add(buttonBox5);


        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);

        eliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String codigo = JOptionPane.showInputDialog("Introduzca el codigo del Paciente");
                boolean estado = false;
                if(codigo != null){
                    for(int i = 0; i<Admin.listaPacientes.size();i++){
                        if (codigo.equals(Admin.listaPacientes.get(i).getCodigo())){
                            Admin.listaPacientes.remove(i);
                            estado = true;
                        }
                    }
                    if(estado){
                        JOptionPane.showMessageDialog(AdminPacienteFrame.this, "Paciente Eliminado", "Eliminar", JOptionPane.PLAIN_MESSAGE);
                    }else {
                        JOptionPane.showMessageDialog(AdminPacienteFrame.this,"No se encontro el Paciente","Trate otra vez",JOptionPane.ERROR_MESSAGE);
                    }

                }
            }
        });

        crearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new RegistroPacienteFrame().setVisible(true);
                dispose();
            }
        });

        editarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String codigo = JOptionPane.showInputDialog("Introduzca el codigo del Paciente");
                boolean estado = false;
                if(codigo != null){
                    for(int i = 0; i<Admin.listaPacientes.size();i++){
                        if (codigo.equals(Admin.listaPacientes.get(i).getCodigo())){
                            estado = true;
                            new EditPacienteFrame(Admin.listaPacientes.get(i)).setVisible(true);
                        }
                    }
                    if(!estado){
                        JOptionPane.showMessageDialog(AdminPacienteFrame.this,"No se encontro el Paciente","Trate otra vez",JOptionPane.ERROR_MESSAGE);
                    }

                }
            }

        });

        reporteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (Admin.listaPacientes.isEmpty()){
                    JOptionPane.showMessageDialog(AdminPacienteFrame.this,"No hay pacientes registrados","Trate otra vez",JOptionPane.ERROR_MESSAGE);
                }else {
                  dispose();  new ReportePaciente(Admin.listaPacientes).setVisible(true);
                }
            }
        });

        regresarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new AdminFrame().setVisible(true);

            }
        });
    }
}