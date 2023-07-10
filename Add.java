package tut3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Add extends JFrame {
    Container c;
    JLabel[] l =new JLabel[5];
    JTextField[] t = new JTextField[5];
    /*JLabel l1 = new JLabel("Enter Num 1: ");
    JTextField t1 = new JTextField();
    JLabel l2 = new JLabel("Enter Num 2:");
    JTextField t2 = new JTextField();
    JLabel l3 = new JLabel("Enter Num 3: ");
    JTextField t3 = new JTextField();
    JLabel l4 = new JLabel("Enter Num 4:");
    JTextField t4 = new JTextField();
    JLabel l5 = new JLabel("Enter Num 5: ");
    JTextField t5= new JTextField();*/
    JButton b = new JButton("Add");
    JTextField ans = new JTextField();
    JFrame f= new JFrame();


    public Add() {
        setTitle("Addition");
        setBounds(300, 90, 500, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        c = getContentPane();
        c.setLayout(null);

        int y = 100;
        for(int i=0; i<5; i++){
            l[i] = new JLabel("Enter Num " + (i+1)+ ":" );
            t[i] = new JTextField();
            l[i].setBounds(100, y, 100, 20);
            t[i].setBounds(200,y,150,20);
            y+=40;
            c.add(l[i]);
            c.add(t[i]);
        }

      /* y = 100;
        for(int i=0; i<5; i++){
            t[i].setBounds(200, y, 150, 20);
            y+=40;
            c.add(t[i]);
        }*/
        /*l1.setBounds(100,100,100,20);
        t1.setBounds(200,100,150,20);

        l2.setBounds(100,140,100,20);
        t2.setBounds(200,140,150,20);

        l3.setBounds(100,180,100,20);
        t3.setBounds(200,180,150,20);

        l4.setBounds(100,220,100,20);
        t4.setBounds(200,220,150,20);

        l5.setBounds(100,260,100,20);
        t5.setBounds(200,260,150,20);

        ans.setBounds(100, 300, 300, 20);
        b.setBounds(150, 340, 200, 20);



        c.add(l1);
        c.add(t1);
        c.add(l2);
        c.add(t2);
        c.add(l3);
        c.add(t3);
        c.add(l4);
        c.add(t4);
        c.add(l5);
        c.add(t5);
        c.add(ans);
        c.add(b);*/

        ans.setBounds(100, 300, 300, 20);
        b.setBounds(150, 340, 200, 20);
        c.add(ans);
        c.add(b);
        c.setSize(400,450);
        setVisible(true);



        b.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {

                float[] n = new float[5];
                float sum = 0;
                for (int i=0; i<5; i++){
                    if (t[i].getText().isEmpty()){
                        JOptionPane.showMessageDialog(f,"Please fill all fields or enter 0 for no number" );
                    }else{
                            n[i]=Float.parseFloat(t[i].getText());
                            sum += n[i];

                    }
                }
                ans.setText("Addition = " + sum);

              /* if (t[0].getText().isEmpty() || t[1].getText().isEmpty()||t[2].getText().isEmpty()||t[3].getText().isEmpty()||t[4].getText().isEmpty()){
                    JOptionPane.showMessageDialog(f,"Please fill all fields or enter 0 for no number" );
                }
                else{
                    float n1 = Float.parseFloat(t[0].getText());
                    float n2 = Float.parseFloat(t[1].getText());
                    float n3 = Float.parseFloat(t[2].getText());
                    float n4 = Float.parseFloat(t[3].getText());
                    float n5 = Float.parseFloat(t[4].getText());

                    float sum = n1 + n2 + n3 + n4 + n5;
                    ans.setText("Addition = " + String.valueOf(sum));
                }*/

            }
        });
    }
    public static void main(String []args) {
        new Add();
    }
}