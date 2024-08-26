/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import domain.user;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author hema
 */
public class user_database {
        public static Connection connect()   {
       Connection con=null;
            try {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            } catch (ClassNotFoundException ex) {
                System.out.println(ex.getMessage());
            }
        String url="jdbc:sqlserver://localhost:1433;databaseName=sample;user=admin;password=hema0100";
        try{
            con=DriverManager.getConnection(url);
            System.out.println("sucssful connection");
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
         
        return con;
    }
    public static void insert_user(String user,String pass,String depart) throws SQLException, ClassNotFoundException{
        try(
        Connection con=connect();
        PreparedStatement p=con.prepareStatement("insert into db_user values(?,?,?)");){
        p.setString(1, user);
        p.setString(2, pass);
        p.setString(3, depart);
        p.execute();
        }catch(SQLException e){
            System.out.println(e.getMessage());
        } 
    }
    
    public static ArrayList<user> get_users() throws SQLException, ClassNotFoundException{
        ArrayList<user> list=new ArrayList<>();
        try(
            Connection con=connect();
            PreparedStatement p=con.prepareStatement("select * from db_user");){
            ResultSet r;
            r=p.executeQuery();
            while(r.next()){
                list.add(new user(r.getString("user_name1"),r.getString("password1"),r.getString("department")));
            }
            
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return list;
    }
    
    public static int check_user(String user,String pass) throws SQLException, ClassNotFoundException{
        ArrayList<user> arr=get_users();
        int x = 0;
        for(int i=0;i<arr.size();i++){
            if(arr.get(i).getUser_name().equalsIgnoreCase(user)){
                if(arr.get(i).getPassword().equalsIgnoreCase(pass)){
                    x=1;
                    break;
                }else{
                    x=2;
                    break;
                }
            }else{
                x=0;
            }
        }
        return x;
    }
    public static String get_department(String user) throws SQLException, ClassNotFoundException {
         
        try (
        Connection con = connect();
        PreparedStatement ps=con.prepareStatement("select department from db_user where user_name1=?");){
        ps.setString(1, user);
        ResultSet r=ps.executeQuery();
        return  r.getString("department");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
       
    }
    
}
