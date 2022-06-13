package com.pi.person;

public class Person {
    private String name;
    private String lastName;
    private String email;

    public String getEmail() {
        return email;
    }

    public String getAlterEmail() {
        return alterEmail;
    }

    public int getMailboxCapacity() {
        return mailboxCapacity;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAlterEmail(String alterEmail) {
        this.alterEmail = alterEmail;
    }

    public void setMailboxCapacity(int mailboxCapacity) {
        this.mailboxCapacity = mailboxCapacity;
    }

    private String alterEmail;
    private int mailboxCapacity = 500;

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Person(String name, String lastName) {
        this.name = name;
        this.lastName = lastName;
    }
}
