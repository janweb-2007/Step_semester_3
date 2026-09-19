package oop_classes.assignments_problems;

public class EmployeeCompanyInfo {
    String empName;
    double salary;

    static String companyName = "Bright Horizon Technologies";
    static int employeeCount = 0;

    public EmployeeCompanyInfo(String empName, double salary) {
        this.empName = empName;
        this.salary = salary;
        employeeCount++;
    }

    public static void printCompanyInfo() {
        System.out.println(companyName);
        System.out.println("Employees on record: " + employeeCount);
    }

    public static void main(String[] args) {
        EmployeeCompanyInfo e1 = new EmployeeCompanyInfo("A", 30000);
        EmployeeCompanyInfo e2 = new EmployeeCompanyInfo("B", 32000);
        EmployeeCompanyInfo e3 = new EmployeeCompanyInfo("C", 35000);

        EmployeeCompanyInfo.printCompanyInfo();
    }
}