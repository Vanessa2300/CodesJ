package Applet_assign_3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class MyFrame extends JFrame implements ActionListener{

    Container f = new Container();
    JLabel lname = new JLabel("Enter Name: ");
    JTextField tname = new JTextField();
    JLabel lage = new JLabel("Enter Age:");
    JTextField tage = new JTextField();
    JLabel lgender = new JLabel("Select Gender: ");
    JRadioButton r1=new JRadioButton("A) Male");
    JRadioButton r2=new JRadioButton("B) Female");
    ButtonGroup bg=new ButtonGroup();
    JLabel lcourse = new JLabel("Select Course: ");
    JCheckBox checkBox1 = new JCheckBox("C++");
    JCheckBox checkBox2 = new JCheckBox("Java");
    JCheckBox checkBox3 = new JCheckBox("Python");
    JLabel lemail = new JLabel("Enter Email:");
    JTextField temail = new JTextField();
    JTextArea info = new JTextArea();
    JButton b=new JButton("Submit");
    JButton r=new JButton("Reset");
    public MyFrame()
    {
        setTitle("Registration Form");
        setBounds(300, 90, 900, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f = getContentPane();
        f.setLayout(null);

        lname.setBounds(100,100,100,20);

        tname.setBounds(200,100,150,20);


        lage.setBounds(100,140,100,20);

        tage.setBounds(200,140,150,20);


        lgender.setBounds(100,180,100,20);

        r1.setBounds(200,180, 100,20);

        r2.setBounds(200,200, 100,20);

        bg.add(r1);
        bg.add(r2);


        lcourse.setBounds(100, 230,100,20);

        checkBox1.setBounds(200,230, 100,20);

        checkBox2.setBounds(200,250, 100,20);

        checkBox3.setBounds(200,270, 100,20);


        lemail.setBounds(100,300,100,20);

        temail.setBounds(200,300,150,20);


        info.setBounds(100, 350,300,100);


        b.setBounds(150,460,100, 40);//x axis, y axis, width, height
        b.addActionListener(this);

        r.setBounds(300,460,100, 40);//x axis, y axis, width, height
        r.addActionListener(this);

        f.add(b);//adding button in JFrame
        f.add(r);
        f.add(lname);
        f.add(tname);
        f.add(lage);
        f.add(tage);
        f.add(lgender);
        f.add(r1);
        f.add(r2);
        f.add(lcourse);
        f.add(checkBox1);
        f.add(checkBox2);
        f.add(checkBox3);
        f.add(lemail);
        f.add(temail);
        f.add(info);
        f.setSize(600,700);//400 width and 500 height
       f.setLayout(null);//using no layout managers
        setVisible(true);//making the frame visible


    }


    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource()==b){
            String name, age, gender, course, email;

            name = tname.getText();
            age = tage.getText();

            if (r1.isSelected()){
                gender = "Male";
            }else{
                gender = "Female";
            }

            course = "";
            if (checkBox1.isSelected()){
                course +=" " + checkBox1.getText();
            }

            if(checkBox2.isSelected()){
                course += " " + checkBox2.getText();
            }

            if(checkBox3.isSelected()){
                course += " " + checkBox3.getText();
            }

            email = temail.getText();

            info.setText("Name: " + name + "\nAge: "+ age + "\nGender: "+ gender+ "\nCourse: "+course + "\nEmail: "+ email);

        }

        if (e.getSource()==r){
            String def = "";
            tname.setText(def);
            tage.setText(def);
            temail.setText(def);
            r1.setSelected(false);
            r2.setSelected(false);
            checkBox1.setSelected(false);
            checkBox2.setSelected(false);
            checkBox3.setSelected(false);
            info.setText(def);
        }

    }
}

class formSwing {
    public static void main(String[] args) {
        MyFrame f=new MyFrame();//creating instance of JFrame
    }

}