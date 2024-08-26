/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

/**
 *
 * @author hema
 */
public class user {
    private String user_name1,password1,department;

    public user(String user_name1, String password1, String department) {
        this.user_name1 = user_name1;
        this.password1 = password1;
        this.department = department;
    }

    public String getUser_name() {
        return user_name1;
    }

    public void setUser_name(String user_name) {
        this.user_name1 = user_name;
    }

    public String getPassword() {
        return password1;
    }

    public void setPassword(String password) {
        this.password1 = password;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
    


}
