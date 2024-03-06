package Cita;

import Doctor.Doctor;
import Paciente.Paciente;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

public class CrearCitaFrame extends JFrame {


        private  LinkedList<Doctor> listaDoctores;
        private Paciente pacienteAcual;
        private JComboBox<String> doctorComboBox;
        private JComboBox<String> especialidadComboBox;
        private JTextField descriptionTextField;
        private JButton scheduleButton;
        private JLabel doctorLabel;
        private JLabel especialidadLabel;
        private JLabel descriptionLabel;

        private JLabel diaLabel;
        private JLabel mesLabel;
        private JLabel yearLabel;
        private JSpinner diaSpinner;
        private JComboBox mesComboBox;
        private JSpinner yearSpinner;

        public CrearCitaFrame(LinkedList<Doctor> listaDoctores,Paciente pacienteAcual) {

           this.listaDoctores = listaDoctores;
            this.pacienteAcual = pacienteAcual;

            setTitle("Crear Cita");
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setSize(300, 400);

            Box mainBox = Box.createVerticalBox();
            getContentPane().add(mainBox, BorderLayout.CENTER);

            descriptionLabel = new JLabel("Razon de la cita:");
            mainBox.add(descriptionLabel);

            descriptionTextField = new JTextField(20);
            mainBox.add(descriptionTextField);

            especialidadLabel = new JLabel("Especialidad");
            mainBox.add(especialidadLabel);
            String[] especialidades = {"Cardiología", "Neurología", "Urología", "Nutrición","Ginecología",
                    "Dermatología","Cirugia","Hematología","Obstetricia","Pediatria","Geriatria","Gastrientetrología",
                    "Ortopedia","Psiquiatria","Urologia","Neurocirugia","Cardiocirugia"};
            especialidadComboBox = new JComboBox<>(especialidades);
            mainBox.add(especialidadComboBox);

            doctorLabel = new JLabel("Doctor:");
            mainBox.add(doctorLabel);
            doctorComboBox = new JComboBox<>(opcionDoctores());
            mainBox.add(doctorComboBox);


            yearLabel = new JLabel("Año:");
            yearSpinner = new JSpinner(new SpinnerNumberModel(2024, 2024, 2025, 1));
            mainBox.add(yearLabel);
            mainBox.add(yearSpinner);

            mesLabel = new JLabel("Mes:");
            String[] meses = {"Enero","Febrero","Marzo","Abril","Mayo","Junio","Julio","Agosto","Septiembre","Octubre","Noviembre","Diciembre"};
            mesComboBox = new JComboBox<>(meses);
            mainBox.add(mesLabel);
            mainBox.add(mesComboBox);

            diaLabel = new JLabel("Día:");
            diaSpinner = new JSpinner(new SpinnerNumberModel(1, 1, 31, 1));
            mainBox.add(diaLabel);
            mainBox.add(diaSpinner);

            scheduleButton = new JButton("Gernerar cita");
            mainBox.add(scheduleButton);

            setLocationRelativeTo(null);
            setResizable(false);

            mesComboBox.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    String mesSeleccion=(String)mesComboBox.getSelectedItem();
                    if(mesSeleccion.equals("Febrero")){
                        diaSpinner.setModel(new SpinnerNumberModel(1, 1, 28, 1));
                    }else if(mesSeleccion.equals("Abril") || mesSeleccion.equals("Junio") ||mesSeleccion.equals("Septiembre") || mesSeleccion.equals("Noviembre")){
                        diaSpinner.setModel(new SpinnerNumberModel(1, 1, 30, 1));
                    }else {
                        diaSpinner.setModel(new SpinnerNumberModel(1, 1, 31, 1));
                    }
                }
            });


            scheduleButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String doctor = (String) doctorComboBox.getSelectedItem();
                    String description = descriptionTextField.getText();
                    int dia = (int)diaSpinner.getValue();
                    String mes =(String)mesComboBox.getSelectedItem();
                    int year = (int)yearSpinner.getValue();

                    if (doctor == null || doctor.isEmpty() || description == null || description.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Por favor llenar todos los campos", "Error", JOptionPane.ERROR_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, "Cita creada con " + doctor , "Exito", JOptionPane.INFORMATION_MESSAGE);
                        Cita cita = new Cita(pacienteAcual.getNombre(),mes,dia,year,description);
                        pacienteAcual.addLisataCita(cita);
                        doctorSeleccionado(doctor,cita);
                    }
                }
            });

           especialidadComboBox.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    DefaultComboBoxModel model = new DefaultComboBoxModel(opcionDoctores());
                    doctorComboBox.setModel(model);

                }
            });


        }


        private String[] opcionDoctores(){
            String especialidad = (String) especialidadComboBox.getSelectedItem();
            int contador =0;
            for (int o =0;o<listaDoctores.size();o++){
                if(listaDoctores.get(o).getEspecialidad().equals(especialidad)){
                    contador++;
                }
            }
           String[] doctoresDisponibles = new String[contador];
            contador =0;
            for (int i=0;i<listaDoctores.size();i++){
                if(listaDoctores.get(i).getEspecialidad().equals(especialidad)){
                    doctoresDisponibles[contador] = (listaDoctores.get(i).getNombre()+" "+listaDoctores.get(i).getApellidos());
                    contador++;
                }

            }
            return doctoresDisponibles;
        }

        private void doctorSeleccionado(String doctor,Cita cita){
            for (int i=0;i<listaDoctores.size();i++){
                if(doctor.equals(listaDoctores.get(i).getNombre()+" "+listaDoctores.get(i).getApellidos())){
                    listaDoctores.get(i).addCitas(cita);
                }
            }

        }

}
