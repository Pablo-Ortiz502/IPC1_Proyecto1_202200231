package ReporteFrame;

import Admin.AdminDoctorFrame;
import Doctor.Doctor;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;


public class ReporteDoctor extends JFrame {
    private JTable doctorTable;
    private DefaultTableModel tableModel;
    private LinkedList<Doctor>listaDoctores;
    private JButton regresar;

    public ReporteDoctor(LinkedList<Doctor>listaDoctores){
        this.listaDoctores = listaDoctores;
        regresar = new JButton("Regresar");
        setTitle("Lista de Doctores");
        setSize(600, 300);
        setLocationRelativeTo(null);
        String[] columnNames = {"Codigo", "Nombre", "Edad","Genero","Especialidad","telefono"};
        int contador=0;
        for (int i =0;i<listaDoctores.size();i++){
            contador++;
        }
        String[][] datos = new String[contador][6];
        contador =0;
        for (int i = 0; i < listaDoctores.size(); i++) {
            for (int j = 0; j < 6; j++) {

                if(contador==0){
                    datos[i][j]=listaDoctores.get(i).getCodigo(); ;
                }
                if(contador==1){datos[i][j]=listaDoctores.get(i).getNombre()+" "+listaDoctores.get(i).getApellidos();}

                if(contador==2){datos[i][j]=String.valueOf(listaDoctores.get(i).getEdad()); }

                if(contador==3){datos[i][j]=listaDoctores.get(i).getGenero();}

                if(contador==4){datos[i][j]=listaDoctores.get(i).getEspecialidad();}

                if (contador==5) { datos[i][j]=String.valueOf(listaDoctores.get(i).getTelefono());  }

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
                new AdminDoctorFrame().setVisible(true);
                dispose();
            }
        });


    }



}
