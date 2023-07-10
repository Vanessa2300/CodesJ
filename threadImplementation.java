/*Write a program to print “Hello Friends” and “Welcome to Java Programming”
continuously on the screen in Java using threads. Add delay to its execution for
200ms.Also set priority to thread and display it.*/
class Hello extends Thread {
    synchronized public void run() {
        try {
            int i = 0;
            while (i < 5) {
                sleep(200);
                System.out.println("Hello!");
                i++;
            }
        } catch (Exception e) {
        }
    }
}

class Welcome extends Thread{
    synchronized public void run(){
        try{
            int i=0;
            while(i<5){
                sleep(200);
                System.out.println("Welcome to Java Programming!");
                i++;
            }
        }catch (Exception e){
        }
    }
}

public class threadImplementation {
    public static void main(String [] args){
        Hello t1 = new Hello();
        Welcome t2 = new Welcome();
        t1.setPriority(2);
        t2.setPriority(2);
        t1.start();
        t2.start();
    }
}
