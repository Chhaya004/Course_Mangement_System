/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pes2;


import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import database.user_database;
import java.sql.SQLException;




/**
 *
 * @author hema
 */
public class frist_screen extends JFrame implements ActionListener {

    image ii = new image();
    JLabel user, pass, text;
    JTextField username;
    JPasswordField password;
    JButton signin, signup;

    public frist_screen() {
        // show_frist_screen(); 
    }

    public void show_frist_screen() {
        //intilize user name and passsword and text
        user = new JLabel("USER NAME");
        pass = new JLabel("PASSWORD");
        text = new JLabel("WELCOME TO OUR PROJECT COURSES");
        text.setFont(new Font("atalic", Font.BOLD, 20));
        user.setBounds(100, 60, 80, 25);
        pass.setBounds(400, 60, 80, 25);
        text.setBounds(100, 250, 400, 20);
        text.setBackground(Color.white);
        text.setForeground(Color.DARK_GRAY);
        ii.add(user);
        ii.add(pass);
        ii.add(text);

        //itilize password and textfiled
        username = new JTextField();
        password = new JPasswordField();
        username.setBounds(200, 60, 130, 25);
        password.setBounds(500, 60, 130, 25);
        ii.add(username);
        ii.add(password);

        //itilize signin and signup
        signin = new JButton("SIGN IN");
        signup = new JButton("SIGN UP");
        signin.setBounds(200, 90, 80, 25);
        signup.setBounds(200, 120, 80, 25);
        ii.add(signin);
        ii.add(signup);
        signin.addActionListener(this);
        signup.addActionListener(this);

        // intilize main form for project
        this.setTitle("staff");
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(960, 600);
        this.setResizable(false);
        this.setLocation(400, 150);
        add(ii);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == signin) {
            int i = 0;
            try {
                i = user_database.check_user(username.getText(), password.getText());
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            } catch (ClassNotFoundException ex) {
                System.out.println(ex.getMessage());
            }
            switch (i) {
                case 1:
                    this.dispose();
            {
                try {
                    new doctor(user_database.get_department(username.getText())).show_doctor_screen();
                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                } catch (ClassNotFoundException ex) {
                    System.out.println(ex.getMessage());
                }
            }
                    break;
                case 2:
                    JOptionPane.showMessageDialog(null, "wrong password ", "password error", JOptionPane.WARNING_MESSAGE);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "wrong username  ", "user error", JOptionPane.WARNING_MESSAGE);
                    break;
            }
        }
        if (e.getSource() == signup) {
            this.dispose();
            new second_screen().show_second_screen();
        }
    }

}
