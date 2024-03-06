package ReporteFrame;
import Admin.AdminPacienteFrame;
import Paciente.Paciente;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

public class ReportePaciente extends JFrame {
    private JTable doctorTable;
    private DefaultTableModel tableModel;
    private LinkedList<Paciente>listaPacientes;
    private JButton regresar;

    public ReportePaciente(LinkedList<Paciente>listaPacientes){
        this.listaPacientes = listaPacientes;
        regresar = new JButton("Regresar");
        setTitle("Lista de pacientes");
        setSize(600, 300);
        setLocationRelativeTo(null);
        String[] columnNames = {"Codigo", "Nombre", "Edad","Genero"};
        int contador=0;
        for (int i =0;i<listaPacientes.size();i++){
            contador++;
        }
        String[][] datos = new String[contador][4];
        contador =0;
        for (int i = 0; i < listaPacientes.size(); i++) {
            for (int j = 0; j < 4; j++) {

                if(contador==0){
                    datos[i][j]=listaPacientes.get(i).getCodigo(); ;
                }
                if(contador==1){datos[i][j]=listaPacientes.get(i).getNombre()+" "+listaPacientes.get(i).getApellidos();}

                if(contador==2){datos[i][j]=String.valueOf(listaPacientes.get(i).getEdad()); }

                if(contador==3){datos[i][j]=listaPacientes.get(i).getGenero();}

                contador++;
            }
            contador = 0;
        }

        tableModel = new DefaultTableModel(datos, columnNames);
        doctorTable = new JTable(tableModel);
        doctorTable.setEnabled(false);
        JScrollPane scrollPane = new JScrollPane(doctorTable);
        add(scrollPane, BorderLayout.CENTER);
        add(regresar,BorderLayout.SOUTH);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        regresar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); new AdminPacienteFrame().setVisible(true);
            }
        });


    }



}
