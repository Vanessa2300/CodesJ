import java.util.Scanner;

public class armstrong {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int num, sum=0, r;
        System.out.println("\nEnter a number= ");
        num = sc.nextInt();
        int n=num;
        while(num>0){
            r=num%10;
            sum=sum+(r*r*r);
            num=num/10;
        }

        if (n==sum){
            System.out.println("Number is armstrong");
        }else{
            System.out.println("Number is not armstrong");
        }
    }
}
