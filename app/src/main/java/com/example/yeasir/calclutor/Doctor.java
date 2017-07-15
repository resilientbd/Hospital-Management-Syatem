package com.example.yeasir.calclutor;

/**
 * Created by TC on 7/15/2017.
 */

public class Doctor {
    private String name;
    private String contact;
    private String email;
    private String department;

    public Doctor(String name, String contact, String email, String department) {
        this.name = name;
        this.contact = contact;
        this.email = email;
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return
                "name='" + name + '\'' +
                ", contact='" + contact + '\'' +
                ", email='" + email + '\'' +
                ", department='" + department + '\'' +
                "\n=================\n";
    }
}
