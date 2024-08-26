/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pes2;

import database.student_database;
import domain.student;
import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.sql.SQLException;
import java.text.MessageFormat;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import sun.swing.table.DefaultTableCellHeaderRenderer;

/**
 *
 * @author hema
 */
public class print_degree extends JLabel implements ActionListener{
        JTable table;
    static String depart;
    JScrollPane sc;
    String data[][];
    String header[] = {"ID", "FRIST NAME", "LAST NAME","degree"};
    ArrayList<student> arr;
    JButton  print;
    
    public print_degree() throws SQLException, ClassNotFoundException{
        this.setLayout(null);
        this.setBackground(Color.yellow);
        show_table();
        
    }
        public void show_table() throws SQLException, ClassNotFoundException {
        arr= student_database.get_students_and_degree();
        data = new String[arr.size()][4];
        for (int i = 0; i < arr.size(); i++) {
            data[i][0] = " " + arr.get(i).getId();
            data[i][1] = arr.get(i).getFrist_name();
            data[i][2] = arr.get(i).getLast_name();
            data[i][3] = arr.get(i).getAddress();
        }
        table = new JTable(data, header);
        sc = new JScrollPane(table);
        sc.setBounds(20, 20, 300, 500);
        add(sc);
        // intialize button
        print=new JButton("PRINT DEGREE");
        print.setBounds(120, 0, 120, 20);
        print.setBackground(Color.BLACK);
        print.setForeground(Color.red);
        this.add(print);
        print.addActionListener(this);
        
        //كود لتعديل الجدول
        ((DefaultTableCellRenderer) table.getTableHeader().getDefaultRenderer())
                .setHorizontalAlignment((int) JLabel.CENTER_ALIGNMENT);
        DefaultTableCellRenderer v = new DefaultTableCellHeaderRenderer();
        v.setHorizontalAlignment(JLabel.CENTER);
        table.getColumnModel().getColumn(0).setCellRenderer(v);
        for (int i = 0; i < table.getColumnCount(); i++) {
            table.getColumnModel().getColumn(i).setCellRenderer(v);

        }
        table.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        }
    @Override
    public void actionPerformed(ActionEvent ae) {
        MessageFormat h=new MessageFormat("student degree");
        MessageFormat f=new MessageFormat("page{1}");
        try{
            table.print(JTable.PrintMode.NORMAL,h,f);
        }   catch (PrinterException ex) {
                System.out.println(ex.getMessage());
            }
    }
}