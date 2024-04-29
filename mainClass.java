import java.util.Scanner;

public class mainClass {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Initial setup - Admin creates username and password
        System.out.println("Welcome! Let's set up your admin account.");
        System.out.print("Enter admin username: ");
        String adminUsername = scanner.nextLine();
        System.out.print("Enter admin password: ");
        String adminPassword = scanner.nextLine();
        Admin admin = new Admin(adminUsername, adminPassword);

        // Admin login
        System.out.println("\nAdmin Login");
        System.out.print("Username: ");
        String username = scanner.nextLine();
        System.out.print("Password: ");
        String password = scanner.nextLine();

        // Authentication
        if (!admin.authenticate(username, password)) {
            System.out.println("Invalid username or password. Exiting...");
            System.exit(0);
        }

        // Main menu
        while (true) {
            System.out.println("\nEmployee Management System Menu:");
            System.out.println("1. Add Employee");
            System.out.println("2. Delete Employee");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:{
                    System.out.println("Enter id:");
                    int id=scanner.nextInt();
                    System.out.println("Enter name:");
                    String name=scanner.next();
                    System.out.println("Enter salary:");
                    double salary=scanner.nextDouble();
                    Employee employee=new Employee(id,name,salary);
                    admin.addEmployee(employee);
                    employee=null;
                
                    break;
                }
                case 2:
                    System.out.println("Enter id:");
                    int id=scanner.nextInt();
                    admin.deleteEmployee(id);
                    break;
                case 3:
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
