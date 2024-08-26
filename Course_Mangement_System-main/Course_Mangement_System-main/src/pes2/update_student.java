
package pes2;

import database.student_database;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class update_student   extends JPanel implements ActionListener{
        JLabel student_id,fname,lname,add,depart;
        JTextField id,fristname,lastname,address,department;
        JButton updatedata;
    public update_student(){
              this.setLayout(null);
        //intilize labels ..........
        student_id=new JLabel("ENTER STUDENT ID");
        fname=new JLabel("ENTER FRIST NAME");
        lname=new JLabel("ENTER LAST NAME");
        add=new JLabel("ENTER ADDRESS");
        depart=new JLabel("ENTER DEPARTMENT");
        student_id.setBounds(80, 20, 120, 25);
        fname.setBounds(80, 50, 120, 25);
        lname.setBounds(80, 80, 120, 25);
        add.setBounds(80, 110, 120, 25);
        depart.setBounds(80, 140, 120, 25);
        this.add(student_id); this.add(fname);this.add(lname);this.add(add);this.add(depart);
        // intialize textfields.........
        id =new JTextField();
        fristname=new JTextField();
        lastname=new JTextField();
        address=new JTextField();
        department=new JTextField();
        id.setBounds(200, 20, 120, 20);
        fristname.setBounds(200, 50, 120, 20);
        lastname.setBounds(200, 80, 120, 20);
        address.setBounds(200, 110, 120, 20);
        department.setBounds(200, 140, 120, 20);
        this.add(fristname);this.add(lastname);this.add(address);this.add(department);this.add(id);
        //intialize buttons .......
        updatedata=new JButton("UPDATE DATA");
        updatedata.setBounds(120, 200, 100, 20);
        this.add(updatedata);
        updatedata.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        try{
         if(ae.getSource()==updatedata){
            student_database.update_student(Integer.parseInt(id.getText()),fristname.getText(), lastname.getText(), address.getText(), department.getText());
            JOptionPane.showMessageDialog(null, "updateded"+fristname.getText(),"ok",JOptionPane.INFORMATION_MESSAGE);
        }}catch(Exception e){
            System.out.println(e.getMessage());
        }

    }
    
    }

 
