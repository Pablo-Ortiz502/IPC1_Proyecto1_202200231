package RegistroFrame;

import Admin.Admin;
import Cita.Cita;
import Paciente.Paciente;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.Random;

public class RegistroPacienteFrame extends JFrame {
    private JTextField nombreField;
    private JTextField apellidoField;
    private JPasswordField contraField;
    private JRadioButton hombreButton;
    private JRadioButton mujerButton;
    private JSpinner edadSpinner;
    private JTextField codigoField;
    private JButton aceptarButton;
    private JButton cancelarButton;
    public RegistroPacienteFrame(){
        JLabel nombreLabel = new JLabel("Nombre:");
        JLabel apellidoLabel = new JLabel("Apellido:");
        JLabel contraLabel = new JLabel("Contraseña:");
        JLabel generoLabel = new JLabel("Genero:");
        JLabel edadLabel = new JLabel("Edad:");
        JLabel creadorLabel = new JLabel("CREAR USUARO (PACIENTE)");
        JLabel espacioLabel = new JLabel("");
        JLabel espacioLabel2 = new JLabel("");
        JLabel espacioLabel3 = new JLabel("");

        nombreField = new JTextField();
       apellidoField = new JTextField();
       contraField = new JPasswordField();
        hombreButton = new JRadioButton("Hombre");
        mujerButton = new JRadioButton("Mujer");
        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(hombreButton);
        genderGroup.add(mujerButton);
       edadSpinner = new JSpinner(new SpinnerNumberModel(0, 0, 120, 1));

       aceptarButton = new JButton("Aceptar");
        cancelarButton = new JButton("Cancelar");

        Container contenedor = getContentPane();
        contenedor.setBackground(new Color(144,238,144));
        contenedor.setLayout(new GridLayout(8, 1));
        contenedor.add(creadorLabel);
        contenedor.add(espacioLabel);
        contenedor.add(nombreLabel);
        contenedor.add(nombreField);
        contenedor.add(apellidoLabel);
        contenedor.add(apellidoField);
        contenedor.add(contraLabel);
        contenedor.add(contraField);
        contenedor.add(generoLabel);
        JPanel genderPanel = new JPanel();
        genderPanel.add(hombreButton);
        genderPanel.add(mujerButton);
        contenedor.add(genderPanel);
        contenedor.add(edadLabel);
        contenedor.add(edadSpinner);
        contenedor.add(espacioLabel2);
        contenedor.add(espacioLabel3);
        contenedor.add(aceptarButton);
        contenedor.add(cancelarButton);

        setTitle("Creador Paciente");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        aceptarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                String nombre = nombreField.getText();
                String apellido = apellidoField.getText();
                String contra = new String(contraField.getPassword());
                String genero = hombreButton.isSelected() ? "Hombre" : "Mujer";
                int edad = (int) edadSpinner.getValue();

                if(nombre.isEmpty() || apellido.isEmpty()||contra.isEmpty()||genero.isBlank()||edad<=0){
                    JOptionPane.showMessageDialog(RegistroPacienteFrame.this,"Por favor llenar todos los campos","Error",JOptionPane.ERROR_MESSAGE);
                }else {
                    LinkedList<Cita> listaCitas = new LinkedList<>();
                    Paciente paciente = new Paciente(nombre,apellido,contra,genero,edad,codigoPaciente(),listaCitas);
                    Admin.listaPacientes.add(paciente);
                    JOptionPane.showMessageDialog(RegistroPacienteFrame.this, "Usuario creado con exito"+"su codigo es: "+Admin.listaPacientes.getLast().getCodigo(), "Bienvenido", JOptionPane.PLAIN_MESSAGE);
                    dispose();



                }


            }
        });

        cancelarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

    }

    private String codigoPaciente(){
        Random random = new Random();
        String codigo ="P";

        for (int j = 0; j < 3; j++) {

            int randomNumero =  (random.nextInt(9) + 1);
            codigo += Integer.toString(randomNumero);
        }


        for (int j = 0; j < 3; j++) {

            char randomLetra = (char) (random.nextInt(26) + 'a');
            codigo += randomLetra;
        }

        return codigo;


    }
}
