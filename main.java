import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Admin Username: ");
        String adminUsername = scanner.nextLine();
        System.out.print("Enter Admin Password: ");
        String adminPassword = scanner.nextLine();
        Admin admin = new Admin(adminUsername, adminPassword);

        while (true) {
            System.out.println("\nEmployee Management System Menu:");
            System.out.println("1. Add Employee");
            System.out.println("2. Delete Employee");
            System.out.println("3. Search Employee by ID");
            System.out.println("4. Search Employee by Name");
            System.out.println("5. View All Employees");
            System.out.println("6. Update Employee Details");
            System.out.println("7. Mark Attendance");
            System.out.println("8. Handle Leave Application");
            System.out.println("9. Generate Payroll Report");
            System.out.println("10. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    admin.addEmployee(scanner);
                    break;
                case 2:
                    System.out.print("Enter Employee ID to delete: ");
                    int deleteId = scanner.nextInt();
                    admin.deleteEmployee(deleteId);
                    break;
                case 3:
                    admin.searchEmployeeByID(scanner);
                    break;
                case 4:
                    admin.searchEmployeeByName(scanner);
                    break;
                case 5:
                    System.out.println("view all Employee");
                    admin.viewAllEmps();

                    break;
                case 6:
                    admin.updateEmployeeDetails(scanner);
                    break;
                case 7:
                    System.out.print("Enter Employee ID to mark attendance: ");
                    int empId = scanner.nextInt();
                    System.out.print("Enter Days Present: ");
                    int daysPresent = scanner.nextInt();
                    admin.markAttendance(empId, daysPresent);
                    break;
                case 8:
                    admin.handleLeaveApplication(scanner);
                    break;
                case 9:
                    admin.generatePayrollReport();
                    break;
                case 10:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
