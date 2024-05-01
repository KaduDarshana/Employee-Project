import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

public class Admin {
    private String username;
    private String password;
    private List<Employee> employees;

    public Admin(String username, String password) {
        this.username = username;
        this.password = password;
        this.employees = new ArrayList<>();
    }

    public void addEmployee(Scanner scanner) {
        System.out.print("Enter Employee ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter Employee Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Employee Salary: ");
        double salary = scanner.nextDouble();
        Employee emp = new Employee(id, name, salary);
        employees.add(emp);
        System.out.println("Employee added successfully.");
    }

    public void deleteEmployee(int employeeId) {
        for (Employee employee : employees) {
            if (employee.getId() == employeeId) {
                employees.remove(employee);
                System.out.println("Employee deleted successfully.");
                return;
            }
        }
        System.out.println("Employee with ID " + employeeId + " not found.");
    }

    public void updateEmployeeDetails(Scanner scanner) {
        System.out.print("Enter employee ID to update: ");
        int updateId = scanner.nextInt();
        boolean found = false;
        for (Employee employee : employees) {
            if (employee.getId() == updateId) {
                scanner.nextLine(); // Consume newline
                System.out.print("Enter new name: ");
                String newName = scanner.nextLine();
                System.out.print("Enter new salary: ");
                double newSalary = scanner.nextDouble();
                employee.setName(newName);
                employee.setSalary(newSalary);
                System.out.println("Employee details updated successfully.");
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Employee with ID " + updateId + " not found.");
        }
    }

    public void searchEmployeeByID(Scanner scanner) {
        System.out.print("Enter employee ID to search: ");
        int searchId = scanner.nextInt();
        boolean found = false;
        for (Employee employee : employees) {
            if (employee.getId() == searchId) {
                System.out.println("Employee found: ID: " + employee.getId() + ", Name: " + employee.getName()
                        + ", Salary: " + employee.getSalary());
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Employee with ID " + searchId + " not found.");
        }
    }

    public void searchEmployeeByName(Scanner scanner) {
        System.out.print("Enter employee name to search: ");
        String searchName = scanner.nextLine();
        boolean found = false;
        for (Employee employee : employees) {
            if (employee.getName().equalsIgnoreCase(searchName)) {
                System.out.println("Employee found: ID: " + employee.getId() + ", Name: " + employee.getName()
                        + ", Salary: " + employee.getSalary());
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Employee with name '" + searchName + "' not found.");
        }
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return super.toString();

    }

    public void viewAllEmps() {
        for (Employee emp : employees) {
            System.out.println(emp.getEmp());
        }

    }

    public void markAttendance(int employeeId, int daysPresent) {
        for (Employee employee : employees) {
            if (employee.getId() == employeeId) {
                employee.setAttendance(employee.getAttendance() + daysPresent);
                System.out.println("Attendance marked for employee with ID " + employeeId + ".");
                return;
            }
        }
        System.out.println("Employee with ID " + employeeId + " not found.");
    }

    public void handleLeaveApplication(Scanner scanner) {
        System.out.print("Enter employee ID for leave application: ");
        int empId = scanner.nextInt();
        boolean found = false;
        for (Employee employee : employees) {
            if (employee.getId() == empId) {
                System.out.print("Enter leave days: ");
                int leaveDays = scanner.nextInt();
                if (employee.applyForLeave(leaveDays)) {
                    System.out.println("Leave application accepted for employee with ID " + empId + ".");
                } else {
                    System.out.println(
                            "Leave application denied. Employee has exceeded allowed leaves or entered invalid leave days.");
                }
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Employee with ID " + empId + " not found.");
        }
    }

    public void generatePayrollReport() {
        System.out.println("Payroll Report:");
        for (Employee employee : employees) {
            double pfDeduction = calculatePFDeduction(employee.getSalary());
            double netSalary = employee.getSalary() - pfDeduction;
            System.out.println("ID: " + employee.getId() + ", Name: " + employee.getName() + ", Salary: "
                    + employee.getSalary() + ", PF Deduction: " + pfDeduction + ", Net Salary: " + netSalary);
        }
    }

    private double calculatePFDeduction(double salary) {
        // Assuming PF deduction is 10% of the salary
        return salary * 0.1;
    }

    public Employee[] getEmployees() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method'getEmployees'");
        
    }
}
