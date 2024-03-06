package Edit;

import Admin.AdminProductoFrame;
import Producto.Producto;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditProductoFrame extends JFrame {
    private JTextField nombreField;
    private JTextField descripcionTextField;

    private JTextField precioTextField;
    private JSpinner cantidadSpiner;
    private JButton aceptarButton;
    private JButton cancelarButton;
    public EditProductoFrame(Producto producto){
        JLabel nombreLabel = new JLabel("Nombre:");
        JLabel descripcionLabel = new JLabel("Descripcion:");
        JLabel precioLabel = new JLabel("Precio:");
        JLabel cantidadLabel = new JLabel("Cantidad");
        JLabel creadorLabel = new JLabel("CREAR PRODUCTO");
        JLabel espacioLabel = new JLabel("");
        JLabel espacioLabel2 = new JLabel("");
        JLabel espacioLabel3 = new JLabel("");

        nombreField = new JTextField();
        descripcionTextField = new JTextField();
        cantidadSpiner = new JSpinner(new SpinnerNumberModel(0, 0, 1000, 1));
        precioTextField = new JTextField();
        aceptarButton = new JButton("Aceptar");
        cancelarButton = new JButton("Cancelar");

        precioTextField.setText("0");

        Container contenedor = getContentPane();
        contenedor.setBackground(new Color(205,205,205));
        contenedor.setLayout(new GridLayout(7, 1));
        contenedor.add(creadorLabel);
        contenedor.add(espacioLabel);
        contenedor.add(nombreLabel);
        contenedor.add(nombreField);
        contenedor.add(descripcionLabel);
        contenedor.add(descripcionTextField);
        contenedor.add(precioLabel);
        contenedor.add(precioTextField);
        contenedor.add(cantidadLabel);
        contenedor.add(cantidadSpiner);
        contenedor.add(espacioLabel2);
        contenedor.add(espacioLabel3);
        contenedor.add(aceptarButton);
        contenedor.add(cancelarButton);

        nombreField.setText(producto.getNomreProducto());
        descripcionTextField.setText(producto.getDescripcionProducto());
        precioTextField.setText(String.valueOf(producto.getPrecio()));
        cantidadSpiner.setValue(producto.cantidad);

        setTitle("Creador Producto");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        aceptarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                String nombre = nombreField.getText();
                String descripcion = descripcionTextField.getText();
                float precio = Float.parseFloat(precioTextField.getText());
                int cantidad = (int) cantidadSpiner.getValue();

                if(nombre.isEmpty() || descripcion.isEmpty()||precio <=0 ||cantidad<=0){
                    JOptionPane.showMessageDialog(EditProductoFrame.this,"Por favor llenar todos los campos","Error",JOptionPane.ERROR_MESSAGE);
                }else {

                    producto.setDescripcionProducto(descripcion);
                    producto.setNomreProducto(nombre);
                    producto.setPrecio(precio);
                    producto.setCantidad(cantidad);
                    JOptionPane.showMessageDialog(EditProductoFrame.this, "Producto creado con exito", " ", JOptionPane.PLAIN_MESSAGE);
                    new AdminProductoFrame().setVisible(true);
                    dispose();



                }


            }
        });

        cancelarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new AdminProductoFrame().setVisible(true);
                dispose();
            }
        });

    }

}
