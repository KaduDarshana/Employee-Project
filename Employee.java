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

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getAttendance() {
        return attendance;
    }

    public void setAttendance(int attendance) {
        this.attendance = attendance;
    }

    public int getLeavesTaken() {
        return leavesTaken;
    }

    public boolean applyForLeave(int leaveDays) {
        if (leaveDays <= 30 && leavesTaken + leaveDays <= 30) {
            leavesTaken += leaveDays;
            return true;
        }
        return false;
    }

    public String getEmp(){
        return "Id:"+this.id +"| name:"+this.name+"| salary:"+this.salary+"| attendance"+this.attendance+"| leaves taken:"+this.leavesTaken;
    }
}
