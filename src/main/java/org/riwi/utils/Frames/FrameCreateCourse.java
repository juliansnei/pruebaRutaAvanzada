package org.riwi.utils.Frames;

import org.riwi.controllers.courseController;
import org.riwi.entities.course;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrameCreateCourse extends JFrame implements ActionListener {
    private JLabel label1;
    private JTextField text1;
    private JButton button1;
    public FrameCreateCourse(){
        setLayout(null);
        label1 = new JLabel("Put the course name: ");
        label1.setBounds(25,34,200,35);
        add(label1);
        text1 = new JTextField();
        text1.setBounds(205,34,100,30);
        add(text1);
        button1 = new JButton("Create new Course");
        button1.setBounds(25,64,200,25);
        button1.addActionListener(this);
        add(button1);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == button1){
            String cad1 = text1.getText();

            if(!cad1.equals("")){
                course aCourse= new course(cad1);
                courseController courseControl = new courseController();
                courseControl.create(aCourse);
                JOptionPane.showMessageDialog(null,"It was created succesfully");
            } else {
                JOptionPane.showMessageDialog(null,"You cannot leave a datafield without information");
            }
        }
    }

}
