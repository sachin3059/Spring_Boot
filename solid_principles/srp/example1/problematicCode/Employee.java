package srp.example1.problematicCode;

public class Employee {
    private int id;
    private String name;
    private String address;

    public Employee(int id, String name, String address){
        this.id = id;
        this.name = name;
        this.address = address;
    }

    public void printPerformanceReport(){
        System.out.println("Performance report of employee: " + name);
    }

    public double computeSalary(){
        return 100.00;
    }

    public void updateEmployeeData(){
        System.out.println("Employee data updated successfully");
    }

    public void fetchEmployeeDetails(){
        System.out.println("Employee data fetched successfully");
    }
}
