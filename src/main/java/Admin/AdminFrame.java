package Admin;

import Login.LoginFrame;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class AdminFrame extends JFrame {
    private JButton doctorButton;
    private JButton pacienteButton;
    private JButton productoButton;

    private JButton regresarButton;

    public AdminFrame() {

               super("Admin");
        setSize(300, 200);


        setDefaultCloseOperation(EXIT_ON_CLOSE);

        Container pane = getContentPane();
        pane.setLayout(new BoxLayout(pane, BoxLayout.Y_AXIS));


        doctorButton = new JButton("Doctores");
        pacienteButton = new JButton("Pacientes");
        productoButton = new JButton("Productos");
        regresarButton = new JButton("Regresar");

        Box buttonBox1 = new Box(BoxLayout.X_AXIS);
        buttonBox1.add(Box.createHorizontalGlue());
        buttonBox1.add(doctorButton);
        buttonBox1.add(Box.createHorizontalGlue());

        Box buttonBox2 = new Box(BoxLayout.X_AXIS);
        buttonBox2.add(Box.createHorizontalGlue());
        buttonBox2.add(pacienteButton);
        buttonBox2.add(Box.createHorizontalGlue());

        Box buttonBox3 = new Box(BoxLayout.X_AXIS);
        buttonBox3.add(Box.createHorizontalGlue());
        buttonBox3.add(productoButton);
        buttonBox3.add(Box.createHorizontalGlue());

        Box buttonBox4 = new Box(BoxLayout.X_AXIS);
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

        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);


        productoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AdminProductoFrame().setVisible(true);
                dispose();
            }
        });

        doctorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AdminDoctorFrame().setVisible(true);
                dispose();
            }
        });

        pacienteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AdminPacienteFrame().setVisible(true);
                dispose();
            }
        });

       regresarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new LoginFrame().setVisible(true);
                dispose();
            }
        });
    }
}