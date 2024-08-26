/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import domain.student;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author hema
 */
public class student_database {

        public static Connection connect() throws ClassNotFoundException  {
       Connection con=null;
       Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String url="jdbc:sqlserver://localhost:1433;databaseName=sample;user=admin;password=hema0100";
        try{
            con=DriverManager.getConnection(url);
            System.out.println("sucssful connection");
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return con;
    }
    public static void insert_user(String fname, String lname, String address, String depart) throws SQLException, ClassNotFoundException {
        try (
            Connection con = connect();
            PreparedStatement p = con.prepareStatement("insert into  student (frist_name,last_name,address1,department) values(?,?,?,?) ");) {
            p.setString(1, fname);
            p.setString(2, lname);
            p.setString(3, address);
            p.setString(4, depart);
            p.execute();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

     public static ArrayList<student> get_students() throws SQLException, ClassNotFoundException {
        ArrayList<student> list = new ArrayList<>();
        try (
            Connection con = connect();
            PreparedStatement p = con.prepareStatement("select * from student ");) {
            ResultSet r;
           // p.setString(1, de);
            r = p.executeQuery();
            while (r.next()) {
                list.add(new student(r.getInt("id"), r.getString("frist_name"), r.getString("last_name"), r.getString("address1"), r.getString("department")));
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return list;
    }
    // دى كدا فكرة متطورة بدل ما اعمل كلاس تانى اضيف فية الاصم الاول والاخير والادى هستخدم الكلاس بتاع الاسديودينت واخلى الادريس مكانة الدرجة

    public static ArrayList<student> get_students_and_degree() throws SQLException, ClassNotFoundException {
        ArrayList<student> list = new ArrayList<>();
        try (
            Connection con = connect();
            PreparedStatement p = con.prepareStatement("select * from student,degree where student.id=degree.id");) {
            ResultSet r;
            r = p.executeQuery();
            while (r.next()) {
                // لاحظ التعديل هنا والتحويل من ايترينج الى انتيجر..............
                list.add(new student(r.getInt("id"), r.getString("frist_name"), r.getString("last_name"), r.getString("sum1") + "", r.getString("department")));
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return list;
    }

    public static void update_student(int id, String fname, String lname, String address, String depart) throws SQLException, ClassNotFoundException {
        try (
            Connection con = connect();
            PreparedStatement p = con.prepareStatement("update student set frist_name=? ,last_name=? ,address1=? ,department=? where id=? ");) {
            p.setString(1, fname);
            p.setString(2, lname);
            p.setString(3, address);
            p.setString(4, depart);
            p.setInt(5, id);
            p.execute();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
  

    
    }
}

