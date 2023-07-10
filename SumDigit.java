package Applet_assign_3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class sum extends JFrame implements ActionListener {

    JLabel l = new JLabel("Enter number: ");
    JTextField text = new JTextField();
    JTextArea msg = new JTextArea();
    JButton sub = new JButton("SUBMIT");
    Container c = new Container();

    public sum(){
        setTitle("Sum of digits");
        setBounds(300, 90, 500, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        c = getContentPane();
        //f.setLayout(null);

        l.setBounds(100,100,100,20);
        text.setBounds(200,100,150,20);
        msg.setBounds(100, 150, 300, 20);
        sub.setBounds(170,200,100,30);

        c.add(l);
        c.add(text);
        c.add(msg);
        c.add(sub);
        sub.addActionListener(this);

        c.setSize(300,300);//400 width and 500 height
        c.setLayout(null);//using no layout managers
        setVisible(true);//making the frame visible
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==sub){

            int n = Integer.parseInt(text.getText());

            int r,s =0;

            while(n>0){
                r = n % 10;
                s += r;
                n = n / 10;
            }

            msg.setText("Sum Of Digits= "+ String.valueOf(s));
        }
    }
}

class SumDigit {
    public static void main(String[] args) {

        sum  f=new sum();
    }

}