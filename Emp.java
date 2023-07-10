package employee;

import java.util.Scanner;

public class Emp {

    int emp_id;
    String name;
    float salary, hra, da, np, pf, gp, it, al;
    Emp()
    {
        emp_id=0;
        name = "";
        salary = 0.0f;
        hra = 0.0f;
        da = 0.0f;
        np = 0.0f;
        gp = 0.0f;
        it = 0.0f;
        al = 0.0f;
    }
    void get()
    {
        Scanner sc=new Scanner(System.in);
        System.out.print("\nEnter Employee ID=");
        emp_id = sc.nextInt();
        System.out.print("Enter name=");
        name = sc.next();
        System.out.print("Enter salary=");
        salary = sc.nextFloat();
    }
    void calculate()
    {
        hra = salary * 0.1f;
        da = salary * 0.555f;
        pf = salary * 0.03f;
        it = salary * 0.06f;
        al = salary * 0.02f;
        gp = salary + hra + da - pf - it ;
        np = salary + hra + da + pf;

    }
    void display()
    {
        System.out.println("Salary Slip\n");
        System.out.println("Employee ID="+emp_id);
        System.out.println("Name="+name);
        System.out.println("Basic pay="+salary);
        System.out.println("Housing Rent Allowance="+hra);
        System.out.println("Dearness Allowance="+da);
        System.out.println("Net Pay="+np);
        System.out.println("Provident Fund="+pf);
        System.out.println("Gross pay="+gp);
        System.out.println("Income Tax="+it);
        System.out.println("Allowance="+al);
    }
    public static void main(String args[])
    {
        Emp e = new Emp();
        e.get();
        e.calculate();
        e.display();
    }
}
