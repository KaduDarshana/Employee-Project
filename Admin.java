import java.util.ArrayList;
import java.util.List;

public class Admin {
    private List<Employee> employees;
    private String username;
    private String password;

    public Admin(String username, String password) {
        this.username = username;
        this.password = password;
        employees = new ArrayList<>();
    }

    public boolean authenticate(String username, String password) {
        return this.username.equals(username) && this.password.equals(password);
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
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

    // Other methods for admin functionalities...
}
