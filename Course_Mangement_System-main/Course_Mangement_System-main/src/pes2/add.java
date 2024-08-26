/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pes2;

import database.student_database;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

/**
 *
 * @author hema
 */
public class add extends JPanel implements ActionListener{
    JLabel fname,lname,add,depart;
    JTextField fristname,lastname,address,department;
    JButton senddata;
    public add(){
        this.setLayout(null);
        //intilize labels ..........
        fname=new JLabel("ENTER FRIST NAME");
        lname=new JLabel("ENTER LAST NAME");
        add=new JLabel("ENTER ADDRESS");
        depart=new JLabel("ENTER DEPARTMENT");
        fname.setBounds(80, 50, 120, 25);
        lname.setBounds(80, 80, 120, 25);
        add.setBounds(80, 110, 120, 25);
        depart.setBounds(80, 140, 120, 25);
        this.add(fname);this.add(lname);this.add(add);this.add(depart);
        // intialize textfields.........
        fristname=new JTextField();
        lastname=new JTextField();
        address=new JTextField();
        department=new JTextField();
        fristname.setBounds(200, 50, 120, 20);
        lastname.setBounds(200, 80, 120, 20);
        address.setBounds(200, 110, 120, 20);
        department.setBounds(200, 140, 120, 20);
        this.add(fristname);this.add(lastname);this.add(address);this.add(department);
        //intialize buttons .......
        senddata=new JButton("SEND DATA");
        senddata.setBounds(120, 200, 100, 20);
        this.add(senddata);
        senddata.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==senddata){
            try {
                student_database.insert_user(fristname.getText(), lastname.getText(), address.getText(), department.getText());
            } catch (SQLException | ClassNotFoundException ex) {
                System.out.println(ex.getMessage());
            }
            JOptionPane.showMessageDialog(null, "inserted"+fristname.getText(),"ok",JOptionPane.INFORMATION_MESSAGE);
        }
    }

}

    





