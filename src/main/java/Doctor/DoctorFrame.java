package Doctor;
import Edit.EditDoctorFrame;
import Login.LoginFrame;
import ReporteFrame.ReporteCita;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import javax.swing.*;
public class DoctorFrame extends JFrame {

    LinkedList<Doctor>listaDoctores;
    String codio;
    private JButton citasButton;

    private JButton editarPerfil;
    private JButton regresarButton;
    public DoctorFrame(String codigo,LinkedList<Doctor>listaDoctores){
        super("Doctor");

        setSize(300, 150);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        Container pane = getContentPane();
        pane.setLayout(new BoxLayout(pane, BoxLayout.Y_AXIS));

        this.codio = codigo;
        this.listaDoctores = listaDoctores;
        citasButton = new JButton("Citas");
        regresarButton = new JButton("Salir");
        editarPerfil = new JButton("Editar Perfil");

        Box buttonBox1 = new Box(BoxLayout.X_AXIS);
        buttonBox1.add(Box.createHorizontalGlue());
        buttonBox1.add(citasButton);
        buttonBox1.add(Box.createHorizontalGlue());

        Box buttonBox2 = new Box(BoxLayout.X_AXIS);
        buttonBox1.add(Box.createHorizontalGlue());
        buttonBox1.add(editarPerfil);
        buttonBox1.add(Box.createHorizontalGlue());

        Box buttonBox4 = new Box(BoxLayout.X_AXIS);
        buttonBox4.add(Box.createHorizontalGlue());
        buttonBox4.add(regresarButton);
        buttonBox4.add(Box.createHorizontalGlue());


        pane.add(Box.createRigidArea(new Dimension(0, 10)));
        pane.add(buttonBox1);
        pane.add(Box.createRigidArea(new Dimension(0, 10)));
        pane.add(buttonBox2);
        pane.add(Box.createRigidArea(new Dimension(0, 10)));
        pane.add(buttonBox4);
        pane.add(Box.createRigidArea(new Dimension(0, 10)));

        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);

        citasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                for (int i =0; i<listaDoctores.size();i++){
                    if (codigo.equals(listaDoctores.get(i).getCodigo())){
                      if(listaDoctores.get(i).getListaPersonal().isEmpty()){
                          JOptionPane.showMessageDialog(DoctorFrame.this,"No hay citas registradas","Trate otra vez",JOptionPane.ERROR_MESSAGE);
                      }else {
                          new ReporteCita(listaDoctores.get(i).getListaPersonal()).setVisible(true);
                      }
                    }
                }

            }
        });

        editarPerfil.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (int i=0; i<listaDoctores.size();i++){
                    if(codigo.equals(listaDoctores.get(i).getCodigo())){
                        new EditDoctorFrame(listaDoctores.get(i)).setVisible(true);
                    }
                }

            }
        });


        regresarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new LoginFrame().setVisible(true);
            }
        });

    }
}
