class Member {
    private String name;
    private int age;
    private String phoneNumber;
    private String address;
    private double salary;

    public Member(String name, int age, String phoneNumber, String address, double salary) {
        this.name = name;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.salary = salary;
    }

    public void printSalary() {
        System.out.println("Salary " + salary);
    }
}

class Employee extends Member {

    public Employee(String name, int age, String phoneNumber,
                    String address, double salary, String specialization) {
        super(name, age, phoneNumber, address, salary);

        System.out.println("Employee name: " + name );
        System.out.println("Employee age: " + age);
        System.out.println("Employee phone number: " + phoneNumber);
        System.out.println("Employee address: " + address);
        System.out.println("Employee specialization: " + specialization);
    }

}

class Manager extends Member{

    public Manager(String name, int age, String phoneNumber,
                   String address, double salary, String department) {
        super(name, age, phoneNumber, address, salary);
        System.out.println("Manager name: " + name );
        System.out.println("Manager age: " + age);
        System.out.println("Manager phone number: " + phoneNumber);
        System.out.println("Manager address: " + address);
        System.out.println("Manager department: " + department);
    }
}

public class company {
    public static void main(String[] args) {
        System.out.println("\nEmployee Details: ");
            Employee employee = new Employee("Anil", 25, "9876543210", "Pune", 30000.00, "Data Analytics");
        employee.printSalary();

        System.out.println("\nManager Details: ");
        Manager manager = new Manager("Kiran", 35, "8967452301", "Mumbai", 70000.00, "IT");
        manager.printSalary();
    }
}