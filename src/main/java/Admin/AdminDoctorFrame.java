package Admin;

import Edit.EditDoctorFrame;
import RegistroFrame.RegistroDoctorFrame;
import ReporteFrame.ReporteDoctor;
import ReporteFrame.ReportePaciente;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class AdminDoctorFrame extends JFrame {
    private JButton crearButton;
    private JButton editarButton;
    private JButton eliminar;

    private JButton reporteButton;

    private JButton regresarButton;

    public AdminDoctorFrame() {

        super("Opciones de Doctores");
        setSize(300, 200);


        setDefaultCloseOperation(EXIT_ON_CLOSE);

        Container pane = getContentPane();
        pane.setLayout(new BoxLayout(pane, BoxLayout.Y_AXIS));


        crearButton = new JButton("Crear Doctor");
        editarButton = new JButton("Editar Doctor");
        eliminar = new JButton("Eliminar doctor");
        reporteButton = new JButton("Lista de doctores");


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
                String codigo = JOptionPane.showInputDialog("Introduzca el codigo del Doctor");
                boolean estado = false;
                if(codigo !=null){
                    for(int i = 0; i<Admin.listaDoctores.size();i++){
                        if (codigo.equals(Admin.listaDoctores.get(i).getCodigo())){
                            Admin.listaDoctores.remove(i);
                            estado = true;
                        }
                    }
                    if(estado){
                        JOptionPane.showMessageDialog(AdminDoctorFrame.this, "Doctor Eliminado", "Eliminar", JOptionPane.PLAIN_MESSAGE);
                    }else {
                        JOptionPane.showMessageDialog(AdminDoctorFrame.this,"No se encontro el Doctor","Trate otra vez",JOptionPane.ERROR_MESSAGE);
                    }

                }
            }
        });
        reporteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(Admin.listaDoctores.isEmpty()){
                    JOptionPane.showMessageDialog(AdminDoctorFrame.this,"No hay Doctores registrados","Trate otra vez",JOptionPane.ERROR_MESSAGE);
                }else {
                    dispose(); new ReporteDoctor(Admin.listaDoctores).setVisible(true);
                }

            }
        });


        crearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new RegistroDoctorFrame().setVisible(true);
                dispose();
            }
        });

        editarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String codigo = JOptionPane.showInputDialog("Introduzca el codigo del Doctor");
                boolean estado = false;
                if(codigo != null){
                    for(int i = 0; i<Admin.listaDoctores.size();i++){
                        if (codigo.equals(Admin.listaDoctores.get(i).getCodigo())){
                            estado = true;
                            new EditDoctorFrame(Admin.listaDoctores.get(i)).setVisible(true);
                            dispose();
                        }
                    }
                    if(!estado){
                        JOptionPane.showMessageDialog(AdminDoctorFrame.this,"No se encontro el Doctor","Trate otra vez",JOptionPane.ERROR_MESSAGE);
                    }
                }


            }
        });

        reporteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ReporteDoctor(Admin.listaDoctores).setVisible(true);
            }
        });

        regresarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AdminFrame().setVisible(true);
            }
        });
    }
}