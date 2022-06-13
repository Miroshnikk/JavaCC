package com.pi.person;

import com.pi.utils.Department;

public class Employee extends Person{
    private Department department;
    private String password;


    public Employee(String name, String lastName, Department department) {
        super(name, lastName);
        this.department = department;
        createEmail();
        createPassword();
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void createPassword() {
        int max = 122;
        int min = 1;
        int range = max - min + 1;

        char[] chars = new char[8];
        for (int i = 0; i < 8; i++) {
            int rand = (int)(Math.random() * range) + min;
            if(rand > 47 && rand < 58 || rand > 64 && rand < 91 || rand > 96 && rand < 123){
                chars[i] =(char) rand;
            } else{
                i--;
            }
        }
        setPassword(String.valueOf(chars));
    }

    private void createEmail() {
        this.setEmail(getName().toLowerCase() + "." + getLastName().toLowerCase()
            + "@" + String.valueOf(getDepartment()).toLowerCase() + ".company.com");
    }

    public void showInfo(){
        System.out.println("NAME: " + getName() + " " + getLastName());
        System.out.println("DEPARTMENT: " + getDepartment());
        System.out.println("EMAIL: " + getEmail());
        System.out.println("PASSWORD: " + getPassword());
        System.out.println("MAILBOX CAPACITY: " + getMailboxCapacity() + "mb");
        System.out.println("ALTER EMAIL: " + getAlterEmail());
    }
}
