/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pes2;

import database.user_database;
import java.awt.Color;
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
public class second_screen extends JFrame implements ActionListener {

    image ii = new image();
    JLabel user, pass, depart, note;
    JTextField username, password, department;
    JButton send, cancel;
    public second_screen() {

    }

    public void show_second_screen() {
        //intilize username password department
        user = new JLabel("USER NAME");
        pass = new JLabel("PASSWORD");
        depart = new JLabel("DEPARTMENT");
        note = new JLabel("ENTER DEPARTMENT(CS,IS,IT)");
        user.setBounds(95, 250, 80, 50);
        pass.setBounds(95, 280, 80, 50);
        depart.setBounds(95, 310, 80, 50);
        note.setBounds(320, 310, 200, 50);
        note.setForeground(Color.ORANGE);
        ii.add(user);
        ii.add(pass);
        ii.add(depart);
        ii.add(note);

        //intilize textfields
        username = new JTextField();
        password = new JTextField();
        department = new JTextField();
        username.setBounds(175, 265, 130, 20);
        password.setBounds(175, 295, 130, 20);
        department.setBounds(175, 325, 130, 20);
        ii.add(username);
        ii.add(password);
        ii.add(department);

        //itilize button
        send = new JButton("SIGN");
        cancel = new JButton("CANCEL");
        send.setBounds(175, 350, 80, 20);
        cancel.setBounds(270, 350, 80, 20);
        ii.add(send);
        ii.add(cancel);
        send.addActionListener(this);
        cancel.addActionListener(this);

        // intilize main form for project
        this.setTitle("lod in");
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(960, 600);
        this.setResizable(false);
        this.setLocation(400, 150);
        add(ii);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == cancel) {
            this.dispose();
            new frist_screen().show_frist_screen();
        }
        if (e.getSource() == send) {
            try {
                String t1 = department.getText();
                if (t1.equalsIgnoreCase("CS") || t1.equalsIgnoreCase("IS") || t1.equalsIgnoreCase("IT")) {
                    user_database.insert_user(username.getText(), password.getText(), department.getText());
                    this.dispose();
                    new frist_screen().show_frist_screen();
                    JOptionPane.showMessageDialog(null, "hello  " + username.getText(), "department error", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "department does not exist", "department error", JOptionPane.WARNING_MESSAGE);
                }

            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(second_screen.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
