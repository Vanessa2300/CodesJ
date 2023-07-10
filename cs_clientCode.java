import java.io.*;
import java.net.*;
public class cs_clientCode
{
	public static void main(String[] args)
	{
		try
		{
			Socket soc = new Socket("localhost",6666);
			ObjectOutputStream out= new
			ObjectOutputStream(soc.getOutputStream());
			out.writeUTF("Server is now connected");
			out.flush();
			soc.close();
		}
		catch(Exception e){
			System.out.println(e);
		}
	}
}