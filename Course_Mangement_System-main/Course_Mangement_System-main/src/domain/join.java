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
public class join {
    private int id,m1,m2,m3,m4,m5,m6;
     private String frist_name,last_name,address1,department;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getM1() {
        return m1;
    }

    public void setM1(int m1) {
        this.m1 = m1;
    }

    public int getM2() {
        return m2;
    }

    public void setM2(int m2) {
        this.m2 = m2;
    }

    public int getM3() {
        return m3;
    }

    public void setM3(int m3) {
        this.m3 = m3;
    }

    public int getM4() {
        return m4;
    }

    public void setM4(int m4) {
        this.m4 = m4;
    }

    public int getM5() {
        return m5;
    }

    public void setM5(int m5) {
        this.m5 = m5;
    }

    public int getM6() {
        return m6;
    }

    public void setM6(int m6) {
        this.m6 = m6;
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

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public join( int id,String frist_name, String last_name, String address1, String department, int m1, int m2, int m3, int m4, int m5, int m6) {
        this.id = id;
        this.m1 = m1;
        this.m2 = m2;
        this.m3 = m3;
        this.m4 = m4;
        this.m5 = m5;
        this.m6 = m6;
        this.frist_name = frist_name;
        this.last_name = last_name;
        this.address1 = address1;
        this.department = department;
    }
}
