public class Employee {
    private int id;
    private String name;
    private double salary;
    private int attendance;
    private int leavesTaken;

    public Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    protected void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public int getAttendance() {
        return attendance;
    }

    protected void setAttendance(int attendance) {
        this.attendance = attendance;
    }

    public int getLeavesTaken() {
        return leavesTaken;
    }

    public void applyForLeave(int leaveDays) {
        if (leaveDays + leavesTaken <= 30) {
            leavesTaken += leaveDays;
            System.out.println("Leave application accepted.");
        } else {
            System.out.println("Leave application denied. You have already taken 30 leaves in the year.");
        }
    }
}
