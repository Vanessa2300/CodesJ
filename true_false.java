package tut3;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class button extends JFrame implements ActionListener{

    JFrame f = new JFrame();
    Container c;
    JButton tb = new JButton("True");
    JButton fb = new JButton("False");

    public button(){
        setTitle("Message button");
        setBounds(300, 90, 300, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        c = getContentPane();
        c.setLayout(null);


        tb.setBounds(100,100,100,20);
        tb.addActionListener(this);
        fb.setBounds(100,140,100,20);
        fb.addActionListener(this);
        c.add(tb);

        c.add(fb);
        c.setSize(400,450);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==tb){
            JOptionPane.showMessageDialog(f,"True is pressed");
        }

        if (e.getSource()==fb){
            JOptionPane.showMessageDialog(f,"False is pressed");
        }


    }
}

class true_false {
    public static void main(String[] args) {
        button b=new button();
    }

}
