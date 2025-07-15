package App;

import entity.EmployeeEntity;
import service.EmployeeService;
import java.sql.Date;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        EmployeeService service = new EmployeeService();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\nEmployee Management System");
            System.out.println("1. Add New Employee");
            System.out.println("2. Update Employee");
            System.out.println("3. Delete Employee");
            System.out.println("4. View Employee by ID");
            System.out.println("5. View All Employees");
            System.out.println("6. Exit");
            System.out.print("Enter your choice (1-6): ");

            int choice;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number between 1 and 6.");
                continue;
            }

            switch (choice) {
                case 1:
                    System.out.print("Enter First Name: ");
                    String firstName = scanner.nextLine();
                    System.out.print("Enter Last Name: ");
                    String lastName = scanner.nextLine();
                    System.out.print("Enter Email: ");
                    String email = scanner.nextLine();
                    System.out.print("Enter Hire Date (YYYY-MM-DD): ");
                    String hireDateStr = scanner.nextLine();
                    try {
                        Date hireDate = Date.valueOf(hireDateStr);
                        service.createEmployee(firstName, lastName, email, hireDate);
                    } catch (IllegalArgumentException e) {
                        System.out.println("Invalid date format.");
                    }
                    break;

                case 2:
                    System.out.print("Enter Employee ID to update: ");
                    int updateId = Integer.parseInt(scanner.nextLine());
                    System.out.print("Enter New First Name: ");
                    String newFirst = scanner.nextLine();
                    System.out.print("Enter New Last Name: ");
                    String newLast = scanner.nextLine();
                    System.out.print("Enter New Email: ");
                    String newEmail = scanner.nextLine();
                    System.out.print("Enter New Hire Date (YYYY-MM-DD): ");
                    try {
                        Date newHire = Date.valueOf(scanner.nextLine());
                        service.updateEmployee(updateId, newFirst, newLast, newEmail, newHire);
                    } catch (IllegalArgumentException e) {
                        System.out.println("Invalid date format.");
                    }
                    break;

                case 3:
                    System.out.print("Enter Employee ID to delete: ");
                    int deleteId = Integer.parseInt(scanner.nextLine());
                    service.deleteEmployee(deleteId);
                    break;

                case 4:
                    System.out.print("Enter Employee ID to view: ");
                    int viewId = Integer.parseInt(scanner.nextLine());
                    EmployeeEntity emp = service.findEmployee(viewId);
                    if (emp != null) {
                        System.out.println(emp);
                    } else {
                        System.out.println("Employee not found.");
                    }
                    break;

                case 5:
                    List<EmployeeEntity> list = service.findAllEmployees();
                    for (EmployeeEntity e : list) {
                        System.out.println(e);
                    }
                    break;

                case 6:
                    running = false;
                    service.shutdown();
                    break;

                default:
                    System.out.println("Invalid choice.");
            }
        }
        scanner.close();
    }
}

