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
public class student {
    
    private int id;
    private String frist_name,last_name,address1,department;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFrist_name() {
        return frist_name;
    }

    public void setFrist_name(String frist_name) {
        this.frist_name = frist_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getAddress() {
        return address1;
    }

    public void setAddress(String address) {
        this.address1 = address;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public student(int id, String frist_name, String last_name, String address1, String department) {
        this.id = id;
        this.frist_name = frist_name;
        this.last_name = last_name;
        this.address1 = address1;
        this.department = department;
    }
}
