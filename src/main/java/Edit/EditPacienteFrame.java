package Edit;

import Paciente.Paciente;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditPacienteFrame extends JFrame {
    private JTextField nombreField;
    private JTextField apellidoField;
    private JPasswordField contraField;
    private JSpinner edadSpinner;

    private JTextField codigoTextField;

    private JButton aceptarButton;
    private JButton cancelarButton;

    public EditPacienteFrame(Paciente paciente) {
        JLabel nombreLabel = new JLabel("Nombre:");
        JLabel apellidoLabel = new JLabel("Apellido:");
        JLabel contraLabel = new JLabel("Contraseña:");
        JLabel codigoLabel = new JLabel("Codigo:");
        JLabel edadLabel = new JLabel("Edad:");
        JLabel creadorLabel = new JLabel("Editar USUARO (PACIENTE)");
        JLabel espacioLabel = new JLabel("");
        JLabel espacioLabel2 = new JLabel("");
        JLabel espacioLabel3 = new JLabel("");

        nombreField = new JTextField();
        apellidoField = new JTextField();
        codigoTextField = new JTextField();
        contraField = new JPasswordField();
        edadSpinner = new JSpinner(new SpinnerNumberModel(1, 1, 120, 1));

        aceptarButton = new JButton("Aceptar");
        cancelarButton = new JButton("Cancelar");

        Container contenedor = getContentPane();
        contenedor.setBackground(new Color(135, 206, 235));
        contenedor.setLayout(new GridLayout(8, 1));
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
        contenedor.add(espacioLabel2);
        contenedor.add(espacioLabel3);
        contenedor.add(aceptarButton);
        contenedor.add(cancelarButton);

        nombreField.setText(paciente.getNombre());
        apellidoField.setText(paciente.getApellidos());
        codigoTextField.setEnabled(false);
        codigoTextField.setText(paciente.getCodigo());
        contraField.setText(paciente.getContra());
        edadSpinner.setValue(paciente.getEdad());




        setTitle("Editor Pacientes");
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


                if (nombre.isEmpty() || apellido.isEmpty() || contra.isEmpty() || edad <= 1 ) {
                    JOptionPane.showMessageDialog(EditPacienteFrame.this, "Por favor llenar todos los campos", "Error", JOptionPane.ERROR_MESSAGE);
                } else {


                    paciente.setEdad(edad);
                    paciente.setContra(contra);
                    paciente.setNombre(nombre);
                    paciente.setApellidos(apellido);


                    JOptionPane.showMessageDialog(EditPacienteFrame.this, "Usuario editado con exito", "Bienvenido", JOptionPane.PLAIN_MESSAGE);
                    dispose();


                }


            }
        });

        cancelarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                dispose();
            }
        });

    }
}

