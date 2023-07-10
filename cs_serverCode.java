import java.io.*;
import java.net.*;
public class cs_serverCode
{
	public static void main(String[] args)
	{
		try
		{
			ServerSocket sos=new ServerSocket(6666);
			Socket soc= sos.accept();
			ObjectInputStream ois=new
			ObjectInputStream(soc.getInputStream());
			String str=(String)ois.readUTF();
			System.out.println("Connection Successful\nmessage received = "+str);
			sos.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}
