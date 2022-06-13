package com.pi;

import com.pi.person.Employee;
import com.pi.utils.Department;

import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("NEW EMPLOYEE : ");
        String nameAndLastName = scanner.nextLine();
        String[] array = nameAndLastName.split(" ");


        System.out.println("DEPARTMENT CODES");
        System.out.println("1 for Development");
        System.out.println("2 for Sales");
        System.out.println("3 for HR");
        System.out.println("0 for None");
        System.out.println("Enter Department Code: ");

        int departmentCode = scanner.nextInt();

        Department department;
        if (departmentCode == 1) {
            department = Department.development;
        } else if (departmentCode == 2) {
            department = Department.sales;
        } else if (departmentCode == 3) {
            department = Department.HR;
        } else if (departmentCode == 0) {
            department = Department.None;
        } else {
            throw new RuntimeException("Invalid department code");
        }
        Employee employee = new Employee(array[0], array[1], department);

        boolean isWorking = true;
        while (isWorking) {
            System.out.println("\n**********************");
            System.out.println("ENTER YOUR CHOICE");
            System.out.println("(1) Show info");
            System.out.println("(2) Change Password");
            System.out.println("(3) Change Mailbox Capacity");
            System.out.println("(4) Set Alternate Email");
            System.out.println("(5) Exit");

            int command = scanner.nextInt();

            if (command == 1) {
                employee.showInfo();
            } else if (command == 2) {
                employee.createPassword();
            } else if (command == 3) {
                System.out.println("Change Mailbox capacity to: ");
                int capacity = scanner.nextInt();
                employee.setMailboxCapacity(capacity);
            } else if (command == 4) {
                System.out.println("Enter alternate email: ");
                Scanner scanner = new Scanner(System.in);
                String alterEmail = scanner.nextLine();
                employee.setAlterEmail(alterEmail);
            } else if (command == 5) {
                System.out.println("Goodbye!");
                isWorking = false;
            }
        }
    }
}
