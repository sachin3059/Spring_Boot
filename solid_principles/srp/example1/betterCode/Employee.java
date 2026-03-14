package srp.example1.betterCode;


// this class follows srp

public class Employee {
    private int id;
    private String name;
    private String address;

    public Employee(int id, String name, String address){
        this.id = id;
        this.name = name;
        this.address = address;
    }

    public int getEmployeeId(){
        return id;
    }

    public String getEmployeeName(){
        return name;
    }

    public String getEmployeeAddress(){
        return address;
    }

    public void setEmployeeName(String name){
        this.name = name;
    }

    public void setEmployeeAddress(String address){
        this.address = address;
    }
}
