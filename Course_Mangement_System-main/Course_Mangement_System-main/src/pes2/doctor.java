/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pes2;

import java.sql.SQLException;
import javax.swing.*;

/**
 *
 * @author hema
 */
public class doctor extends JFrame{
    JTabbedPane tap;
    add a1;
    degree d1;
    print_degree d2;
    update_student u1;
    update_degree u2;
    static String depart;
    image i1=new image();
    public doctor(String s){
     depart=s;
    }
    public doctor(){
        
    }
    public  void show_doctor_screen() throws SQLException, ClassNotFoundException{
        
        a1=new add();
        d1=new degree();
        d2=new print_degree();
        u1=new update_student();
        u2=new update_degree();
        tap=new JTabbedPane();
        tap.addTab("student", a1);
        tap.addTab("degree", d1);
        tap.addTab("print", d2);
        tap.addTab("update_student", u1);
        tap.addTab("update_degree", u2);
        
       
      //  i1.add(tap);
        this.setTitle("doctor");
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500, 600);
        this.setResizable(false);
        this.setLocation(400, 150);
        this.add(tap);
    }
}
