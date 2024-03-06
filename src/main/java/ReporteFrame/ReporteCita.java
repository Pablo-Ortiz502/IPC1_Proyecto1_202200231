package ReporteFrame;


import Cita.Cita;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;


public class ReporteCita extends JFrame {

    private JTable doctorTable;
    private DefaultTableModel tableModel;
    private LinkedList<Cita> listaCitas;
    private JButton regresar;

    public ReporteCita(LinkedList<Cita> listaCitas){
        this.listaCitas = listaCitas;
        regresar = new JButton("Regresar");
        setTitle("Lista de Citas");
        setSize(600, 300);
        setLocationRelativeTo(null);
        String[] columnNames = {"Nombre","Descripcion","Fecha"};
        int contador=0;
        for (int i = 0; i< listaCitas.size(); i++){
            contador++;
        }
        String[][] datos = new String[contador][3];
        contador =0;
        for (int i = 0; i < listaCitas.size(); i++) {
            for (int j = 0; j < 3; j++) {

                if(contador==0){datos[i][j]= listaCitas.get(i).getNombre(); }

                if(contador==1){datos[i][j]=listaCitas.get(i).getDescripcion(); }

                if(contador==2){datos[i][j]=String.valueOf(listaCitas.get(i).getDia())+"/"+listaCitas.get(i).getMes()+
                                            "/"+String.valueOf(listaCitas.get(i).getYear());}

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
                dispose();
            }
        });



    }
}
