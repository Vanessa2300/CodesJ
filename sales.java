import java.util.ArrayList;
import java.util.List;

class emp {
    protected String name;
    protected double salary;

    public emp(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }
}

class Mng extends emp {
    private String department;

    public Mng(String name, double salary, String department) {
        super(name, salary);
        this.department = department;
    }

    public String getDepartment() {
        return department;
    }
}

class SalesManager extends Mng {
    private double bonus;

    public SalesManager(String name, double salary, String department, double bonus) {
        super(name, salary, department);
        this.bonus = bonus;
    }

    public double getBonus() {
        return bonus;
    }

    @Override
    public double getSalary() {
        return super.getSalary() + bonus;
    }
}

public class sales {
    public static void main(String[] args) {
        List<emp> employeeList = new ArrayList<>();
        employeeList.add(new emp("Bhushan", 25000));
        employeeList.add(new Mng("Raj", 30000, "IT"));
        employeeList.add(new SalesManager("Riya", 20000, "Sales", 2000));

        System.out.println("\n");
        for (emp employee : employeeList) {
            if (employee instanceof SalesManager) {
                System.out.println("Sales Manager Salary: " + employee.getSalary());
            } else if (employee instanceof Mng) {
                System.out.println("Manager Salary: " + employee.getSalary());
            } else {
                System.out.println("Employee Salary: " + employee.getSalary());
            }
        }
    }
}