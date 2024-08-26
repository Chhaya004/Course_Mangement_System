/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pes2;

import database.degree_database;
import database.student_database;
import domain.student;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.*;
import javax.swing.JTextField;
import domain.degree;
import domain.join;
import java.sql.SQLException;

/**
 *
 * @author hema
 */
public class update_degree extends JPanel implements  ActionListener {
        JLabel m1,m2,m3,m4,m5,m6,i;
    JTextField t1,t2,t3,t4,t5,t6,id;
    JButton  updatedegree,search;
   ArrayList<degree> arr;
   ArrayList<join> arrr;
   String data1[][];
   String header[] = {"ID", "m1", "m2","m3","m4","m5","m6", "FRIST NAME", "LAST NAME","address","department"};
   JTable table;
    JScrollPane sc;
    public update_degree() throws SQLException, ClassNotFoundException{
              arrr = degree_database.get_join();
        data1 = new String[arrr.size()][11];
        for (int i = 0; i < arrr.size(); i++) {
            data1[i][0] = " " + arrr.get(i).getId();
            data1[i][1] = arrr.get(i).getFrist_name();
            data1[i][2] = arrr.get(i).getLast_name();
        }
        table = new JTable(data1, header);
        sc = new JScrollPane(table);
        sc.setBounds(30, 230, 400, 200);
        add(sc);
        this.setLayout(null);
        this.setBackground(Color.yellow);
        i=new JLabel("enter id");
        m1=new JLabel("IS");
        m2=new JLabel("NC");
        m3=new JLabel("IT");
        m4=new JLabel("SC");
        m5=new JLabel("SA");
        m6=new JLabel("AI");
        i.setBounds(200, 15, 120, 25);
        m1.setBounds(60, 20, 80, 25);
        m2.setBounds(60, 50, 80, 25);
        m3.setBounds(60, 80, 80, 25);
        m4.setBounds(60, 110, 80, 25);
        m5.setBounds(60, 140, 80, 25);
        m6.setBounds(60, 170, 80, 25);
        this.add(i) ;this.add(m1);this.add(m2);this.add(m3);this.add(m4);this.add(m5);this.add(m6);
        id=new JTextField();
        t1=new JTextField();
        t2=new JTextField();
        t3=new JTextField();
        t4=new JTextField();
        t5=new JTextField();
        t6=new JTextField();
        id.setBounds(270, 15, 50, 25);
        t1.setBounds(90, 20, 50, 25);
        t1.setBounds(90, 20, 50, 25);
        t2.setBounds(90, 50, 50, 25);
        t3.setBounds(90, 80, 50, 25);
        t4.setBounds(90, 110, 50, 25);
        t5.setBounds(90, 140, 50, 25);
        t6.setBounds(90, 170, 50, 25);
        this.add(id); this.add(t1);this.add(t2);this.add(t3);this.add(t4);this.add(t5);this.add(t6);
        updatedegree=new JButton("UPDATE DEGREE");
        updatedegree.setBounds(200, 150, 150, 20);
        updatedegree.setBackground(Color.BLACK);
        updatedegree.setForeground(Color.red);
        this.add(updatedegree);
        search=new JButton("SEARCH DEGREE");
        search.setBounds(200, 180, 150, 20);
        search.setBackground(Color.BLACK);
        search.setForeground(Color.red);
        this.add(search);
        updatedegree.addActionListener(this);
        search.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        try{
        if(ae.getSource()==search){
            //الحاجة الى جاية فى الادى هو استرينج فلازم عشان اعرضها محتاج اررى ليست وبعد كدا خدت القيم من الاررى ليت حططها فى التيكست فيلد
        arr=database.degree_database.get_students(Integer.parseInt(id.getText()));
        t1.setText(""+arr.get(0).getM1());
        t2.setText(""+arr.get(0).getM2());
        t3.setText(""+arr.get(0).getM3());
        t4.setText(""+arr.get(0).getM4());
        t5.setText(""+arr.get(0).getM5());
        t6.setText(""+arr.get(0).getM6());
        }
        else if(ae.getSource()==updatedegree){
            degree_database.update_degree(Integer.parseInt(id.getText()), Integer.parseInt(t1.getText()),Integer.parseInt( t2.getText()), Integer.parseInt(t3.getText()), Integer.parseInt(t4.getText()), Integer.parseInt(t5.getText()), Integer.parseInt(t6.getText()));
            JOptionPane.showMessageDialog(null, " degree updated ", " complete", JOptionPane.INFORMATION_MESSAGE);
            t1.setText("");
            t2.setText("");
            t3.setText("");
            t4.setText("");
            t5.setText("");
            t6.setText("");
        }}catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
}
