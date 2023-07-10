import java.applet.*;
import java.awt.*;
 /*<applet code = applet_concat.class height = 400 width = 400>
 <param name = "string1" value = "This is">
 <param name = "string2" value = " String Concatenation">
 </applet>*/
 public class applet_concat extends Applet
 {
 String str1;
 public void init()
 {
 str1 = getParameter("string1").concat(getParameter("string2"));
 }
 public void paint(Graphics g)
 {
 showStatus(str1);
 }
 }