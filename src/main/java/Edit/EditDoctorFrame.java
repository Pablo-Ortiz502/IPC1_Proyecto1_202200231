package Edit;


import Admin.AdminDoctorFrame;
import Doctor.Doctor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditDoctorFrame extends JFrame {
    private JTextField nombreField;
    private JTextField apellidoField;
    private JPasswordField contraField;
    private JSpinner edadSpinner;

    private JTextField telefonoField;

    private JTextField codigoTextField;

    private JButton aceptarButton;
    private JButton cancelarButton;
    private JComboBox<String> especialidadComboBox;

    public EditDoctorFrame(Doctor doctor) {
        JLabel nombreLabel = new JLabel("Nombre:");
        JLabel apellidoLabel = new JLabel("Apellido:");
        JLabel contraLabel = new JLabel("Contraseña:");
        JLabel codigoLabel = new JLabel("Codigo:");
        JLabel edadLabel = new JLabel("Edad:");
        JLabel creadorLabel = new JLabel("Editar USUARO (DOCTOR)");
        JLabel espacioLabel = new JLabel("");
        JLabel espacioLabel2 = new JLabel("");
        JLabel espacioLabel3 = new JLabel("");
        JLabel teleffonoLabel = new JLabel("Telefofno");
        JLabel especialidadLabel = new JLabel("Especialidad");

        String[] especialidades = {"Cardiología", "Neurología", "Urología", "Nutricionista", "Ginecología",
                "Dermatología", "Cirugia", "Hematología", "Obstetricia", "Pediatria", "Geriatria", "Gastrientetrología",
                "Ortopedia", "Psiquiatria", "Urologia", "Neurocirugia", "Cardiocirugia"};
        nombreField = new JTextField();
        especialidadComboBox = new JComboBox<>(especialidades);
        telefonoField = new JTextField();
        apellidoField = new JTextField();
        codigoTextField = new JTextField();
        contraField = new JPasswordField();
        edadSpinner = new JSpinner(new SpinnerNumberModel(0, 0, 120, 1));

        aceptarButton = new JButton("Aceptar");
        cancelarButton = new JButton("Cancelar");

        Container contenedor = getContentPane();
        contenedor.setBackground(new Color(135, 206, 235));
        contenedor.setLayout(new GridLayout(10, 1));
        contenedor.add(creadorLabel);
        contenedor.add(espacioLabel);
        contenedor.add(nombreLabel);
        contenedor.add(nombreField);
        contenedor.add(apellidoLabel);
        contenedor.add(apellidoField);
        contenedor.add(contraLabel);
        contenedor.add(contraField);
        contenedor.add(codigoLabel);
        contenedor.add(codigoTextField);
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

        nombreField.setText(doctor.getNombre());
        apellidoField.setText(doctor.getApellidos());
        telefonoField.setText(String.valueOf(doctor.getTelefono()));
        codigoTextField.setEnabled(false);
        codigoTextField.setText(doctor.getCodigo());
        contraField.setText(doctor.getContra());
        edadSpinner.setValue(doctor.getEdad());


        for (int j = 0; j < especialidades.length;j++){
            if(doctor.getEspecialidad().equals(especialidades[j])){
                especialidadComboBox.setSelectedIndex(j);
            }
        }




        setTitle("Editor Doctores");
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
                int edad = (int) edadSpinner.getValue();
                int telefono = Integer.parseInt(telefonoField.getText());
                String especialidad = (String) especialidadComboBox.getSelectedItem();


                if (nombre.isEmpty() || apellido.isEmpty() || contra.isEmpty() || edad <= 25 || telefono >= 100000000 || telefono <= 0) {
                    JOptionPane.showMessageDialog(EditDoctorFrame.this, "Por favor llenar todos los campos", "Error", JOptionPane.ERROR_MESSAGE);
                } else {

                    doctor.setEspecialidad(especialidad);
                    doctor.setEdad(edad);
                    doctor.setTelefono(telefono);
                    doctor.setContra(contra);
                    doctor.setNombre(nombre);
                    doctor.setApellidos(apellido);

                    new AdminDoctorFrame().setVisible(true);
                    JOptionPane.showMessageDialog(EditDoctorFrame.this, "Usuario editado con exito", "Bienvenido", JOptionPane.PLAIN_MESSAGE);
                    dispose();


                }


            }
        });

        cancelarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AdminDoctorFrame().setVisible(true);
                dispose();
            }
        });

    }
}

