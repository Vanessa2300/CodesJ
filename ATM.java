import java.util.Scanner;

public class ATM {
    public static void main(String[] args){
        float balance = 20000, withdraw, deposit;
        int ch;

        Scanner sc = new Scanner(System.in);

        do{
            System.out.println("\nEnter your choice");
            System.out.println("Press 1 to withdraw");
            System.out.println("Press 2 to deposit");
            System.out.println("Press 3 to check balance");
            System.out.println("Press 4 to exit");

            ch = sc.nextInt();


            switch (ch){

                case 1:
                    System.out.println("Enter amount to withdraw: ");
                    withdraw = sc.nextFloat();

                    if (withdraw>balance){
                        System.out.println("Insufficient balance");
                    }else{
                        balance -= withdraw;
                        System.out.println("New Balance: " + balance);
                    }

                    break;

                case 2:
                    System.out.println("Enter amount to deposit: ");
                    deposit = sc.nextFloat();
                    balance += deposit;
                    System.out.println("New Balance: " + balance);
                    break;

                case 3:
                    System.out.println("Available balance= " + balance );
                    break;

                case 4:
                    break;

                default:
                    System.out.println("Wrong Choice!!");
            }
        }while (ch!=4);
    }
}
