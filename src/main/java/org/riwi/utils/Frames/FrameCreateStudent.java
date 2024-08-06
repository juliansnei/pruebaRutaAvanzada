package org.riwi.utils.Frames;

import org.riwi.controllers.studentController;
import org.riwi.entities.student;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrameCreateStudent extends JFrame implements ActionListener {
    private JLabel label1,label2,label3,label4;
    private JTextField text1,text2,text3;
    private ButtonGroup buttonGroup;
    private JRadioButton radio1, radio2;
    private JButton button1;
    public FrameCreateStudent(){
        setLayout(null);
        label1 = new JLabel("Put the student's age: ");
        label1.setBounds(25,34,200,35);
        add(label1);
        label2 = new JLabel("Put the student's name: ");
        label2.setBounds(25,74,200,35);
        add(label2);
        label3 = new JLabel("Put the student's email: ");
        label3.setBounds(25,114,200,35);
        add(label3);
        label4 = new JLabel("Choose the student's status: ");
        label4.setBounds(25,154,250,35);
        add(label4);
        text1 = new JTextField();
        text1.setBounds(205,34,100,30);
        add(text1);
        text2 = new JTextField();
        text2.setBounds(205,74,100,30);
        add(text2);
        text3 = new JTextField();
        text3.setBounds(205,114,100,30);
        add(text3);
        buttonGroup = new ButtonGroup();
        radio1 = new JRadioButton("Is Active");
        radio1.setBounds(250,160,200,25);
        buttonGroup.add(radio1);
        add(radio1);
        radio2 = new JRadioButton("Is Not Active");
        radio2.setBounds(250,200,200,25);
        buttonGroup.add(radio2);
        add(radio2);
        button1 = new JButton("Create new Student");
        button1.setBounds(250,250,200,25);
        button1.addActionListener(this);
        add(button1);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == button1){
            String cad1 = text1.getText();
            String cad2 = text2.getText();
            String cad3 = text3.getText();
            boolean status = false;
            if(radio1.isSelected()){
                status = true;
            } else if(radio2.isSelected()){
                status = false;
            }

            if(!cad1.equals("") && !cad2.equals("") && !cad3.equals("")){
                Double ageParse = Double.parseDouble(cad1);
                student anStudent = new student(ageParse,cad2,cad3,status);
                studentController studentControl = new studentController();
                studentControl.create(anStudent);
                JOptionPane.showMessageDialog(null,"It was created succesfully");
            } else {
                JOptionPane.showMessageDialog(null,"You cannot leave a datafield without information");
            }
        }
    }
}
