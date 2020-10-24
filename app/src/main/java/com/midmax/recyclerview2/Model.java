package com.midmax.recyclerview2;

import java.io.Serializable;

public class Model implements Serializable {
    String Student_Name,
    Roll_no,
    Age,Phone_no;

    public Model(String student_Name, String roll_no, String age, String phone_no) {
        Student_Name = student_Name;
        Roll_no = roll_no;
        Age = age;
        Phone_no = phone_no;
    }

    public String getStudent_Name() {
        return Student_Name;
    }

    public void setStudent_Name(String student_Name) {
        Student_Name = student_Name;
    }

    public String getRoll_no() {
        return Roll_no;
    }

    public void setRoll_no(String roll_no) {
        Roll_no = roll_no;
    }

    public String getAge() {
        return Age;
    }

    public void setAge(String age) {
        Age = age;
    }

    public String getPhone_no() {
        return Phone_no;
    }

    public void setPhone_no(String phone_no) {
        Phone_no = phone_no;
    }
}
