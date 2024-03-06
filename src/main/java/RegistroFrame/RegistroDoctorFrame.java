package RegistroFrame;
import Admin.AdminDoctorFrame;
import Admin.Admin;
import Doctor.Doctor;
import Cita.Cita;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.Random;

public class RegistroDoctorFrame extends JFrame {
    private JTextField nombreField;
    private JTextField apellidoField;
    private JPasswordField contraField;
    private JRadioButton hombreButton;
    private JRadioButton mujerButton;
    private JSpinner edadSpinner;

    private JTextField telefonoField;


    private JButton aceptarButton;
    private JButton cancelarButton;
    private JComboBox<String> especialidadComboBox;

    public RegistroDoctorFrame(){
        JLabel nombreLabel = new JLabel("Nombre:");
        JLabel apellidoLabel = new JLabel("Apellido:");
        JLabel contraLabel = new JLabel("Contraseña:");
        JLabel generoLabel = new JLabel("Genero:");
        JLabel edadLabel = new JLabel("Edad:");
        JLabel creadorLabel = new JLabel("CREAR USUARO (DOCTOR)");
        JLabel espacioLabel = new JLabel("");
        JLabel espacioLabel2 = new JLabel("");
        JLabel espacioLabel3 = new JLabel("");
        JLabel teleffonoLabel = new JLabel("Telefofno");
        JLabel especialidadLabel = new JLabel("Especialidad");

        String[] especialidades = {"Cardiología", "Neurología", "Urología", "Nutricionista","Ginecología",
                "Dermatología","Cirugia","Hematología","Obstetricia","Pediatria","Geriatria","Gastrientetrología",
                "Ortopedia","Psiquiatria","Urologia","Neurocirugia","Cardiocirugia"};
        nombreField = new JTextField();
        especialidadComboBox = new JComboBox<>(especialidades);
        telefonoField = new JTextField();
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
        contenedor.setBackground(new Color(135,206,235));
        contenedor.setLayout(new GridLayout(10, 1));
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
        contenedor.add(teleffonoLabel);
        contenedor.add(telefonoField);
        contenedor.add(especialidadLabel);
        contenedor.add(especialidadComboBox);
        contenedor.add(espacioLabel2);
        contenedor.add(espacioLabel3);
        contenedor.add(aceptarButton);
        contenedor.add(cancelarButton);


        telefonoField.setText("0");
        setTitle("Creador Doctores");
        setSize(600, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        aceptarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String nombre = nombreField.getText();
                String apellido = apellidoField.getText();
                String contra = new String(contraField.getPassword());
                String genero = hombreButton.isSelected() ? "Hombre" : "Mujer";
                int edad = (int) edadSpinner.getValue();
                int telefono = Integer.parseInt(telefonoField.getText());
                String especialidad = (String) especialidadComboBox.getSelectedItem();


                if(nombre.isEmpty() || apellido.isEmpty()||contra.isEmpty()||genero.isBlank()||edad<=0||telefono>=100000000){
                    JOptionPane.showMessageDialog(RegistroDoctorFrame.this,"Por favor llenar todos los campos","Error",JOptionPane.ERROR_MESSAGE);
                }else {
                    LinkedList<Cita> listaPersonal = new LinkedList<>();
                    String codigo = codigoDoctor();
                    Doctor doctor = new Doctor(nombre,apellido,especialidad,contra,genero,telefono,edad,listaPersonal,codigo);
                    Admin.listaDoctores.add(doctor);
                    JOptionPane.showMessageDialog(RegistroDoctorFrame.this, "Usuario creado con exito"+"su codigo es: "+codigo, "Bienvenido", JOptionPane.PLAIN_MESSAGE);
                    dispose();
                    new AdminDoctorFrame().setVisible(true);


                }


            }
        });

        cancelarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new AdminDoctorFrame().setVisible(true);
            }
        });

    }

    private String codigoDoctor(){
        Random random = new Random();
        String codigo ="D";

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