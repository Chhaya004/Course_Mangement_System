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
import java.awt.ComponentOrientation;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import sun.swing.table.DefaultTableCellHeaderRenderer;

/**
 *
 * @author hema
 */
public class degree extends JPanel implements ActionListener {

    JTable table;
    static String depart;
    JScrollPane sc;
    String data[][];
    String header[] = {"ID", "FRIST NAME", "LAST NAME"};
    ArrayList<student> arr;
    JLabel m1, m2, m3, m4, m5, m6;
    JTextField t1, t2, t3, t4, t5, t6;
    JButton adddegree, re;
    int x;

    public degree( ) throws SQLException, ClassNotFoundException {
       // depart = s;
        this.setLayout(null);
        this.setBackground(Color.yellow);
        re = new JButton("refresh");
        re.setBounds(350, 300, 80, 25);
        this.add(re);
        show_table();

    }

    public void show_table() throws SQLException, ClassNotFoundException {
        arr = student_database.get_students();
        data = new String[arr.size()][3];
        for (int i = 0; i < arr.size(); i++) {
            data[i][0] = " " + arr.get(i).getId();
            data[i][1] = arr.get(i).getFrist_name();
            data[i][2] = arr.get(i).getLast_name();
        }
        table = new JTable(data, header);
        sc = new JScrollPane(table);
        sc.setBounds(20, 20, 300, 500);
        add(sc);
        // intialize jlabel jtextfield
        m1 = new JLabel("IS");
        m2 = new JLabel("NC");
        m3 = new JLabel("IT");
        m4 = new JLabel("SC");
        m5 = new JLabel("SA");
        m6 = new JLabel("AI");
        m1.setBounds(350, 20, 80, 25);
        m2.setBounds(350, 50, 80, 25);
        m3.setBounds(350, 80, 80, 25);
        m4.setBounds(350, 110, 80, 25);
        m5.setBounds(350, 140, 80, 25);
        m6.setBounds(350, 170, 80, 25);
        this.add(m1);
        this.add(m2);
        this.add(m3);
        this.add(m4);
        this.add(m5);
        this.add(m6);
        t1 = new JTextField();
        t2 = new JTextField();
        t3 = new JTextField();
        t4 = new JTextField();
        t5 = new JTextField();
        t6 = new JTextField();
        t1.setBounds(400, 20, 50, 25);
        t2.setBounds(400, 50, 50, 25);
        t3.setBounds(400, 80, 50, 25);
        t4.setBounds(400, 110, 50, 25);
        t5.setBounds(400, 140, 50, 25);
        t6.setBounds(400, 170, 50, 25);
        this.add(t1);
        this.add(t2);
        this.add(t3);
        this.add(t4);
        this.add(t5);
        this.add(t6);
        adddegree = new JButton("ADD DEGREE");
        adddegree.setBounds(350, 220, 120, 20);
        adddegree.setBackground(Color.BLACK);
        adddegree.setForeground(Color.red);
        this.add(adddegree);
        adddegree.addActionListener(this);

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

        // intilize table event
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ttmouseClicked(evt);
            }
        });
    }

    private void ttmouseClicked(java.awt.event.MouseEvent evt) {
        x = table.getSelectedRow();
        System.out.println("ok" + table.getSelectedRow());
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == re) {
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            model.setRowCount(0);
            try {
                show_table();
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            } catch (ClassNotFoundException ex) {
                System.out.println(ex.getMessage());
            }
        }
        int id = arr.get(x).getId();;
        try {
            degree_database.insert_degree(id, Integer.parseInt(t1.getText()), Integer.parseInt(t2.getText()), Integer.parseInt(t3.getText()), Integer.parseInt(t4.getText()), Integer.parseInt(t5.getText()), Integer.parseInt(t6.getText()));
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } catch (ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
        JOptionPane.showMessageDialog(null, "degree inserted ", "insert values", JOptionPane.INFORMATION_MESSAGE);
    }
}
