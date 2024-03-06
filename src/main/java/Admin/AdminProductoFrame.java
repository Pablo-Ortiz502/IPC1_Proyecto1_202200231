package Admin;

import Edit.EditProductoFrame;
import RegistroFrame.RegistroProducto;
import ReporteFrame.ReporteProducto;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class AdminProductoFrame extends JFrame {
    private JButton crearButton;
    private JButton editarButton;
    private JButton eliminar;

    private JButton reporteButton;

    private JButton regresarButton;

    public AdminProductoFrame() {

        super("Opciones de Productos");
        setSize(300, 200);


        setDefaultCloseOperation(EXIT_ON_CLOSE);

        Container pane = getContentPane();
        pane.setLayout(new BoxLayout(pane, BoxLayout.Y_AXIS));


        crearButton = new JButton("Crear Producto");
        editarButton = new JButton("Editar Producto");
        eliminar = new JButton("Eliminar Productor");
        reporteButton = new JButton("Lista de Productos");


        regresarButton = new JButton("Regresar");

        Box buttonBox1 = new Box(BoxLayout.X_AXIS);
        buttonBox1.add(Box.createHorizontalGlue());
        buttonBox1.add(crearButton);
        buttonBox1.add(Box.createHorizontalGlue());

        Box buttonBox2 = new Box(BoxLayout.X_AXIS);
        buttonBox2.add(Box.createHorizontalGlue());
        buttonBox2.add(editarButton);
        buttonBox2.add(Box.createHorizontalGlue());

        Box buttonBox3 = new Box(BoxLayout.X_AXIS);
        buttonBox3.add(Box.createHorizontalGlue());
        buttonBox3.add(eliminar);
        buttonBox3.add(Box.createHorizontalGlue());

        Box buttonBox4 = new Box(BoxLayout.X_AXIS);
        buttonBox4.add(Box.createHorizontalGlue());
        buttonBox4.add(reporteButton);
        buttonBox4.add(Box.createHorizontalGlue());

        Box buttonBox5 = new Box(BoxLayout.X_AXIS);
        buttonBox4.add(Box.createHorizontalGlue());
        buttonBox4.add(regresarButton);
        buttonBox4.add(Box.createHorizontalGlue());


        pane.add(buttonBox1);
        pane.add(Box.createRigidArea(new Dimension(0, 20)));
        pane.add(buttonBox2);
        pane.add(Box.createRigidArea(new Dimension(0, 20)));
        pane.add(buttonBox3);
        pane.add(Box.createRigidArea(new Dimension(0, 10)));
        pane.add(buttonBox4);
        pane.add(Box.createRigidArea(new Dimension(0, 10)));
        pane.add(buttonBox5);


        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);

        eliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = JOptionPane.showInputDialog("Introduzca el nombre del producto");
                boolean estado = false;
                if(nombre !=null){
                    for(int i = 0; i<Admin.listaProductos.size();i++){
                        if (nombre.equals(Admin.listaProductos.get(i).getNomreProducto())){
                            Admin.listaProductos.remove(i);
                            estado = true;
                        }
                    }
                    if(estado){
                        JOptionPane.showMessageDialog(AdminProductoFrame.this, "Producto Eliminado", "Eliminar", JOptionPane.PLAIN_MESSAGE);
                    }else {
                        JOptionPane.showMessageDialog(AdminProductoFrame.this,"No se encontro el producto","Trate otra vez",JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });

        crearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new RegistroProducto().setVisible(true);
                dispose();
            }
        });

        editarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                String nombre = JOptionPane.showInputDialog("Introduzca el codigo del Paciente");
                boolean estado = false;
                if(nombre !=null){
                    for(int i = 0; i<Admin.listaProductos.size();i++){
                        if (nombre.equals(Admin.listaProductos.get(i).getNomreProducto())){
                            estado = true;
                            new EditProductoFrame(Admin.listaProductos.get(i)).setVisible(true);
                            dispose();
                        }
                    }
                    if (!estado){
                        JOptionPane.showMessageDialog(AdminProductoFrame.this,"No se encontro el producto","Trate otra vez",JOptionPane.ERROR_MESSAGE);
                    }
                }


            }
        });

        regresarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new AdminFrame().setVisible(true);

            }
        });

        reporteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (Admin.listaProductos.isEmpty()){
                    JOptionPane.showMessageDialog(AdminProductoFrame.this,"No hay Productos en el inventario","Trate otra vez",JOptionPane.ERROR_MESSAGE);
                }else {
                    new ReporteProducto(Admin.listaProductos).setVisible(true);
                }
            }
        });
    }
}
