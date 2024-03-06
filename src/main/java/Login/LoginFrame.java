package Login;
import Admin.AdminFrame;
import Admin.Admin;
import Doctor.DoctorFrame;
import Paciente.PacienteFrame;
import RegistroFrame.RegistroPacienteFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginFrame extends JFrame {

    public LoginFrame (){
        JLabel codigoU = new JLabel("Codigo:");
        JLabel contraU = new JLabel("Contraseña:");
        JTextField codigoField = new JTextField();
        JPasswordField contraField = new JPasswordField();
        JButton loginButton = new JButton("Login");
        JButton registrarButton = new JButton("Registar");

        Container container = getContentPane();
        container.setLayout(new GridLayout(3, 2));
        container.add(codigoU);
        container.add(codigoField);
        container.add(contraU);
        container.add(contraField);
        container.add(loginButton);
        container.add(registrarButton);

        setTitle("Login");
        setSize(300, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);


        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String codigo = codigoField.getText();
                String contra = new String(contraField.getPassword());


                boolean estado  = false;

                if (codigo.isEmpty() || contra.isEmpty()){
                    JOptionPane.showMessageDialog(LoginFrame.this,"Por favor llenar todas las casillas","Trate otra vez",JOptionPane.ERROR_MESSAGE);
                }else {
                    for (int i = 0; i < Admin.listaDoctores.size() && Admin.listaDoctores.get(i) != null; i++){//Doctores
                        if(contra.equals(Admin.listaDoctores.get(i).getContra()) && codigo.equals(Admin.listaDoctores.get(i).getCodigo())){
                            JOptionPane.showMessageDialog(LoginFrame.this, "Bienvenido", "Ingresado", JOptionPane.PLAIN_MESSAGE);
                            estado = true;
                            dispose();
                            new DoctorFrame(Admin.listaDoctores.get(i).getCodigo(),Admin.listaDoctores);
                        }

                    }
                    for (int j = 0; j < Admin.listaPacientes.size() && Admin.listaPacientes.get(j) != null; j++){//pacientes
                        if(contra.equals(Admin.listaPacientes.get(j).getContra()) && codigo.equals(Admin.listaPacientes.get(j).getCodigo())){
                            JOptionPane.showMessageDialog(LoginFrame.this, "Bienvenido", "Ingresado", JOptionPane.PLAIN_MESSAGE);
                            estado = true;
                            dispose();
                            new PacienteFrame(Admin.listaPacientes.get(j).getCodigo(),Admin.listaPacientes,Admin.listaProductos,Admin.listaDoctores);
                        }

                    }
                    if (contra.equals(Admin.getContraAdmin()) && codigo.equals(Admin.getNombreAdmin())){// Administrador
                        JOptionPane.showMessageDialog(LoginFrame.this, "Bienvenido", "Ingresado", JOptionPane.PLAIN_MESSAGE);
                        estado = true;
                        dispose();
                        new AdminFrame().setVisible(true);

                    }
                    if(!estado){
                        JOptionPane.showMessageDialog(LoginFrame.this,"datos incorectos","Trate otra vez",JOptionPane.ERROR_MESSAGE);
                    }

                }

            }
        });

        registrarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new RegistroPacienteFrame().setVisible(true);
            }

        });



    }

}
