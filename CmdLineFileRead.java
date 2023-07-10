import java.util.Scanner;
import java.io.*;

public class CmdLineFileRead
{
    public static void main(String[] args)
    {
        String fname;
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter the Name of File with extension: ");
        fname = scan.nextLine();

        String line = null;
        try
        {
            FileReader fileReader = new FileReader(fname);

            BufferedReader bufferedReader = new BufferedReader(fileReader);

            while((line = bufferedReader.readLine()) != null)
            {
                System.out.println(line);
            }
            bufferedReader.close();
        }
        catch(IOException ex)
        {
            System.out.println("\nError occurred");
            System.out.println("Exception Name: " +ex);
        }
    }
}
