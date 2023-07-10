package Applet_assign_3;

import javax.swing.*;
import java.awt.*;

public class signal extends JFrame implements Runnable {

    JPanel red = new JPanel();
    JPanel orange = new JPanel();
    JPanel green = new JPanel();
    public enum Signal
    {
        GREEN,ORANGE,RED;
    }

    //private static volatile Signal previous=Signal.ORANGE;
    private static Object lock=new Object();
    private Signal s;

    public signal(Signal s){
        this.s = s;

        Font font = new Font("Tahoma",100,100);
        GridLayout layout = new GridLayout(3,1,0,0);
        setLayout(layout);
        setTitle("Signal");
        setBounds(200,200,500,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);


        red.setBackground(Color.RED);
        JLabel stop = new JLabel("STOP");
        stop.setFont(font);
        red.add(stop);
        add(red);
        red.setVisible(false);


        orange.setBackground(Color.ORANGE);
        JLabel ready = new JLabel("GET READY");
        ready.setFont(font);
        orange.add(ready);
        add(orange);
        orange.setVisible(false);


        green.setBackground(Color.GREEN);
        JLabel go = new JLabel("GO");
        go.setFont(font);
        green.add(go);
        add(green);
        green.setVisible(false);



        /*Thread t = new Thread();
        t.start();

        for(;;){
            try {
                red.setVisible(true);
                t.sleep(1000);
                red.setVisible(false);

                orange.setVisible(true);
                t.sleep(1000);
                orange.setVisible(false);

                green.setVisible(true);
                t.sleep(1000);
                green.setVisible(false);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }*/

    }

    private void display() throws InterruptedException{
        synchronized (lock) {
            for(;;){
                switch (s) {
                    case RED:

                        red.setVisible(true);
                        Thread.sleep(1000);
                        red.setVisible(false);
                        break;
                    case GREEN:

                        green.setVisible(true);
                        Thread.sleep(1000);
                        green.setVisible(false);
                        break;
                    case ORANGE:

                        orange.setVisible(true);
                        Thread.sleep(1000);
                        orange.setVisible(false);

                        break;
                }
            }


            //lock.notify();
        }

    }

    public static void main(String [] args){

       // new signal();
        new Thread(new signal(Signal.GREEN)).start();
        new Thread(new signal(Signal.RED)).start();
        new Thread(new signal(Signal.ORANGE)).start();
    }

    @Override
    public void run() {
        try {
            while (true)
                display();
        } catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
        }
    }


}
