import java.io.*;
import java.util.*;

public class MultiFileConcat
{
    public static void main(String[] args) throws IOException
    {
        String f1,f2;
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter the Name of File1 with extension: ");
        f1 = scan.nextLine();

        System.out.print("Enter the Name of File2 with extension: ");
        f2 = scan.nextLine();


        PrintWriter pw = new PrintWriter("file3.txt");

        BufferedReader br = new BufferedReader(new FileReader(f1));

        String line = br.readLine();

        while (line != null)
        {
            pw.println(line);
            line = br.readLine();
        }

        br = new BufferedReader(new FileReader(f2));
        line = br.readLine();

        while(line != null)
        {
            pw.println(line);
            line = br.readLine();
        }

        pw.flush();

        br.close();
        pw.close();

        System.out.println("Merged file1.txt and file2.txt into file3.txt\n");

        BufferedReader bufferedReader = new BufferedReader(new FileReader("file3.txt"));

        System.out.println("File 3 Content: ");
        while((line = bufferedReader.readLine()) != null)
        {
            System.out.println(line);
        }
        bufferedReader.close();
    }
}