/* WAP using applet to roll a ball from one corner to another of applet window */

// Create a rolling ball on Applet

import java.awt.Color;

import java.awt.Graphics;

import javax.swing.JApplet;

/*

<applet code="Applet_ball" width=500 height=500></applet>

*/

public class Applet_ball extends JApplet implements Runnable

{

    // Declaring required variables

    int x=0, increment =1;

    Thread t=null;

    /* start() method of applet is used to create and start a thread that will     continuously change value of x and will call the repaint method */

    public void start()

    {

        t = new Thread(this);

        t.start();

    }



    /* In the run method we simply change the x position for drawing the         ball and then call the repaint() */

    public void run()

    {

        while(true)

        {

            if(x==0)

            {

                increment=1;

            }

            else if(x > getWidth() -50)

            {

                increment=-1;

            }

            x+=increment;

            repaint();

           try{

            Thread.sleep(10);

           }catch(Exception e)

           {

               System.out.println(e);

           }

        }

    }



// paint() is used to draw the contents on the GUI of applet

    public void paint(Graphics g)

    {

        g.setColor(Color.white);

        g.fillRect(0, 0, 500, 500);

        //g.setColor(Color.black);

        //g.drawLine(0, 250, 500, 250);

        g.setColor(Color.red);

        g.fillOval(x, 200, 50, 50);

        g.setColor(Color.blue);

	g.fillOval(x+5, 205, 40, 40);

    }
    

}

