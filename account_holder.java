import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

class actions{

    String name;
    int ac_num;
    float s_balance, c_balance;
    Scanner sc = new Scanner(System.in);
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
    LocalDateTime now = LocalDateTime.now();

    public void get(){
        System.out.println("Enter account holder name: ");
        name = sc.nextLine();

        System.out.println("Enter account number: ");
        ac_num = sc.nextInt();

        System.out.println("Enter savings balance: ");
        s_balance = sc.nextFloat();

        System.out.println("Enter current balance: ");
        c_balance = sc.nextFloat();

    }

    public void display(){
        System.out.println("Account holder name: " + name);
        System.out.println("Account number: " + ac_num);
        System.out.println("Savings Balance: " + s_balance);
        System.out.println("Savings Balance: " + c_balance);
        System.out.println("Date of account creation: "+ dtf.format(now));
    }

    public void deposit(){
        float amt;
        int x;

        do{
            System.out.println("Enter 1 to deposit to in savings \nEnter 2 to deposit to in current \nEnter 3 to exit");
            x = sc.nextInt();
            switch (x){
                case 1:
                    System.out.println("Enter amount to deposit: ");
                    amt = sc.nextFloat();

                    s_balance += amt;
                    System.out.println("New balance= " + s_balance);
                    break;

                case 2:
                    System.out.println("Enter amount to deposit: ");
                    amt = sc.nextFloat();

                    c_balance += amt;
                    System.out.println("New balance= " + c_balance);
                    break;

                case 3:
                    break;

                default:
                    System.out.println("Wrong choice");
                    break;

            }
        }while (x != 3);



    }

    public void withdraw(){

        float amt;
        int x;

       do{
            System.out.println("Enter 1 to withdraw from savings \nEnter 2 to withdraw from current \nEnter 3 to exit ");
            x = sc.nextInt();
            switch (x){
                case 1:
                    System.out.println("Enter amount to withdraw: ");
                    amt = sc.nextFloat();

                    if(s_balance>=amt){
                        s_balance -= amt;
                        System.out.println("New balance= " + s_balance);
                    }else{
                        System.out.println("Balance is insufficient");
                    }
                    break;

                case 2:
                    System.out.println("Enter amount to withdraw: ");
                    amt = sc.nextFloat();

                    if(c_balance>=amt){
                        c_balance -= amt;
                        System.out.println("New balance= " + c_balance);
                    }else{
                        System.out.println("Balance is insufficient");
                    }
                    break;

                case 3:
                    break;

                default:
                    System.out.println("Wrong choice");
                    break;

            }
        } while (x != 3);

    }

    public void show(){
        System.out.println("Savings A/c balance: " + s_balance);
        System.out.println("Current A/c balance: " + c_balance);

    }

}



public class account_holder {

    public static void main(String[] args){
        int n;
        Scanner sc = new Scanner(System.in);
        actions a = new actions();
        a.get();

        do{
            System.out.println("\nEnter 1 to display details");
            System.out.println("Enter 2 to deposit");
            System.out.println("Enter 3 to withdraw");
            System.out.println("Enter 4 to see savings and current balance");
            System.out.println("Enter 5 to exit");
            n = sc.nextInt();

            switch (n){
                case 1:
                    a.display();
                    break;

                case 2:
                    a.deposit();
                    break;

                case 3:
                    a.withdraw();
                    break;

                case 4:
                    a.show();
                    break;

                case 5:
                    break;

                default:
                    System.out.println("Wrong choice");

            }

        }while(n!=5);
    }
}
