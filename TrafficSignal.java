package Applet_assign_3;

import javax.swing.*;
import java.awt.*;

public class TrafficSignal extends JFrame {

    public TrafficSignal(){

        Font font = new Font("Tahoma",100,100);
        GridLayout layout = new GridLayout(3,1,0,0);
        setLayout(layout);
        setTitle("Signal");
        setBounds(200,200,600,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        JPanel red = new JPanel();
        red.setBackground(Color.RED);
        JLabel stop = new JLabel("STOP");
        stop.setFont(font);
        red.add(stop);
        add(red);
        red.setVisible(false);

        JPanel orange = new JPanel();
        orange.setBackground(Color.ORANGE);
        JLabel ready = new JLabel("GET READY");
        ready.setFont(font);
        orange.add(ready);
        add(orange);
        orange.setVisible(false);

        JPanel green = new JPanel();
        green.setBackground(Color.GREEN);
        JLabel go = new JLabel("GO");
        go.setFont(font);
        green.add(go);
        add(green);
        green.setVisible(false);



        Thread t = new Thread();
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

                orange.setVisible(true);
                t.sleep(1000);
                orange.setVisible(false);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }

    public static void main(String [] args){

        new TrafficSignal();
    }
}
