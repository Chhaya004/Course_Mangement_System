/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;


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
public class degree_database {

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

    public static void insert_degree(int id, int m1, int m2, int m3, int m4, int m5, int m6) throws SQLException, ClassNotFoundException {
        try (
            Connection con = connect();
            PreparedStatement p = con.prepareStatement("insert into  degree  values(?,?,?,?,?,?,?,?) ");) {
            p.setInt(1, id);
            p.setInt(2, m1);
            p.setInt(3, m2);
            p.setInt(4, m3);
            p.setInt(5, m4);
            p.setInt(6, m5);
            p.setInt(7, m6);
            p.setInt(8, m1 + m2 + m3 + m4 + m5 + m6);
            p.execute();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void update_degree(int id, int m1, int m2, int m3, int m4, int m5, int m6) throws SQLException, ClassNotFoundException {
        try (
            Connection con = connect();
            PreparedStatement p = con.prepareStatement("update degree set  m1=?,m2=?,m3=?,m4=?,m5=?,m6=? where id=? ");) {
            p.setInt(1, m1);
            p.setInt(2, m2);
            p.setInt(3, m3);
            p.setInt(4, m4);
            p.setInt(5, m5);
            p.setInt(6, m6);
            p.setInt(7, id);
            p.execute();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static ArrayList<domain.degree> get_students(int id) throws SQLException, ClassNotFoundException {
        ArrayList<domain.degree> list = new ArrayList<>();
        try (
                Connection con = connect();
                PreparedStatement p = con.prepareStatement("select * from degree where id=?");) {
            ResultSet r;
            p.setInt(1, id);
            r = p.executeQuery();
            while (r.next()) {
                list.add(new domain.degree(r.getInt("id"),r.getInt("m1"),r.getInt("m2"),r.getInt("m3"),r.getInt("m4"),r.getInt("m5"),r.getInt("m6")));
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return list;
    }
    
   public static ArrayList<domain.join> get_join() throws SQLException, ClassNotFoundException {
        ArrayList<domain.join> list = new ArrayList<>();
        try (
                Connection con = connect();
                PreparedStatement p = con.prepareStatement("select frist_name,last_name,address1,department,m1,m2,m3,m4,m5,m6,sum, from student ,degree \n" +
"where student.id=degree.id ");) {
            ResultSet r;
           // p.setInt(1, id);
            r = p.executeQuery();
            while (r.next()) {
                list.add(new domain.join(r.getInt("id"),r.getString("frist_name"),r.getString("last_name"), r.getString("address1"), r.getString("department"),r.getInt("m1"),r.getInt("m2"),r.getInt("m3"),r.getInt("m4"),r.getInt("m5"),r.getInt("m6")));
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return list;
    }
}