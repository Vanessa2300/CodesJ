import java.util.Scanner;

class OddThread extends Thread{
    int num;
    show display;

    public OddThread(int num, show display){
        this.num = num;
        this.display = display;
    }

    @Override
    public void run(){
        int oddNumber = 1;

        while (oddNumber <= num){
            display.printOdd(oddNumber);
            oddNumber = oddNumber + 2;
        }
    }
}


class EvenThread extends Thread{
    int limit;
    show printer;

    public EvenThread(int limit, show printer){
        this.limit = limit;
        this.printer = printer;
    }

    @Override
    public void run(){
        int evenNumber = 2;
        while (evenNumber <= limit){
            printer.printEven(evenNumber);
            evenNumber = evenNumber + 2;
        }
    }
}

class show {

    boolean isOddPrinted = false;
    synchronized void printOdd(int number){
        while (isOddPrinted){
            try{
                wait();
            }
            catch (InterruptedException e){
                e.printStackTrace();
            }
        }

        System.out.println(Thread.currentThread().getName()+" : "+number);
        isOddPrinted = true;

        try{
            Thread.sleep(1000);
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }

        notify();
    }

     synchronized void printEven(int number)
    {
        while (! isOddPrinted)
        {
            try
            {
                wait();
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }

        System.out.println(Thread.currentThread().getName()+" : "+number);

        isOddPrinted = false;

        try
        {
            Thread.sleep(1000);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }

        notify();
    }
}



public class oddEvenThread
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number: ");
        int n = sc.nextInt();
        show printer = new show();

        OddThread oddThread = new OddThread(n, printer);

        oddThread.setName("Odd: ");

        EvenThread evenThread = new EvenThread(n, printer);

        evenThread.setName("Even: ");

        oddThread.start();

        evenThread.start();
    }
}