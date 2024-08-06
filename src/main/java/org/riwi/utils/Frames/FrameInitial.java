package org.riwi.utils.Frames;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrameInitial extends JFrame implements ActionListener {
    private JLabel label1;
    private JButton button1, button2, button3, button4;
    public FrameInitial(){
        setLayout(null);
        label1 = new JLabel("Choose one of the next options: ");
        label1.setBounds(50,20,400,25);
        add(label1);
        button1 = new JButton("Students Interface");
        button1.setBounds(80,60,170,30);
        button1.addActionListener(this);
        add(button1);
        button2 = new JButton("Courses Interface");
        button2.setBounds(80,100,170,30);
        button2.addActionListener(this);
        add(button2);
        button3 = new JButton("Inscriptions Interface");
        button3.setBounds(80,140,190,30);
        button3.addActionListener(this);
        add(button3);
        button4 = new JButton("Grades Interface");
        button4.setBounds(80,180,170,30);
        button4.addActionListener(this);
        add(button4);
    }
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == button1){
            this.setVisible(false);
            FrameStudents formulario = new FrameStudents();
            formulario.setBounds(250,250,400,250);
            formulario.setVisible(true);
            formulario.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        } else if(e.getSource() == button2){
            this.setVisible(false);
            FrameCreateCourse formulario = new FrameCreateCourse();
            formulario.setBounds(250,250,400,250);
            formulario.setVisible(true);
            formulario.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        } else if(e.getSource() == button3){
            this.setVisible(false);
        }
    }
}
