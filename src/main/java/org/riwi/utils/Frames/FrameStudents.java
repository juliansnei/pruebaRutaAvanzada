package org.riwi.utils.Frames;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import org.riwi.controllers.studentController;
import org.riwi.entities.student;

public class FrameStudents extends JFrame implements ActionListener {
    private JLabel label1;
    private JButton button1,button2,button3;
    public FrameStudents(){
        setLayout(null);
        label1 = new JLabel("Choose one the following options: ");
        label1.setBounds(25,25,250,25);
        add(label1);
        button1 = new JButton("Insert a New Student");
        button1.setBounds(25,55,200,25);
        button1.addActionListener(this);
        add(button1);
        button2 = new JButton("Update information of one student");
        button2.setBounds(25,105,300,25);
        button2.addActionListener(this);
        add(button2);
        button3 = new JButton("List all students");
        button3.setBounds(25,155,300,25);
        button3.addActionListener(this);
        add(button3);
    }
    @Override
    public void actionPerformed(ActionEvent event){
        if(event.getSource() == button1){
            this.setVisible(false);
            FrameCreateStudent frameModifyStudent = new FrameCreateStudent();
            frameModifyStudent.setBounds(0,0,700,400);
            frameModifyStudent.setVisible(true);
            frameModifyStudent.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        } else if(event.getSource() == button2){
            this.setVisible(false);
            FrameModifyStudent frameModifyStudent = new FrameModifyStudent();
            frameModifyStudent.setBounds(0,0,700,400);
            frameModifyStudent.setVisible(true);
            frameModifyStudent.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        } else if(event.getSource() == button3){
            studentController controlStudent = new studentController();
            Integer size = Integer.parseInt(JOptionPane.showInputDialog("Put what you wanna see"));
            Integer page = Integer.parseInt(JOptionPane.showInputDialog("Put how much"));
            List<student> studentEntities = controlStudent.readAll(size,page);
            String total = "";
            for(student eachOne: studentEntities){
                total += eachOne.toString() + "\n";
            }
            JOptionPane.showMessageDialog(null,total);
        }
    }
}
