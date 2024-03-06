package ReporteFrame;

import Producto.Producto;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
public class ReporteProducto extends JFrame {
    private JTable doctorTable;
    private DefaultTableModel tableModel;
    private LinkedList<Producto> listaProductos;
    private JButton regresar;

    public ReporteProducto(LinkedList<Producto> listaProductos){
        this.listaProductos = listaProductos;
        regresar = new JButton("Regresar");
        setTitle("Lista de Productos");
        setSize(600, 300);
        setLocationRelativeTo(null);
        String[] columnNames = {"Nombre", "Precio", "Descripcion","Cantidad"};
        int contador=0;
        for (int i = 0; i< listaProductos.size(); i++){
            contador++;
        }
        String[][] datos = new String[contador][4];
        contador =0;
        for (int i = 0; i < listaProductos.size(); i++) {
            for (int j = 0; j < 4; j++) {

                if(contador==0){
                    datos[i][j]= listaProductos.get(i).getNomreProducto(); ;
                }
                if(contador==1){datos[i][j]="Q."+String.valueOf(listaProductos.get(i).getPrecio()); }

                if(contador==2){datos[i][j]=listaProductos.get(i).getDescripcionProducto(); }

                if(contador==3){datos[i][j]= String.valueOf(listaProductos.get(i).getCantidad());}

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
