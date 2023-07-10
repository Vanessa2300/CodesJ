import java.util.Scanner;

class MarksOutOfBounds extends Exception{
    public void error()
    {
        System.out.println("Invalid Marks");
    }
}

class User_def_exception{

    public static void main(String[] args) throws Exception{

        Scanner sc = new Scanner(System.in);

        int m=0, roll_no;
        try{

            System.out.println("\nEnter Roll no.:");
            roll_no = sc.nextInt();

            System.out.println("Enter Marks:");
            m = sc.nextInt();


            if(m>100 || m<0)
                throw new MarksOutOfBounds();

            System.out.println("Roll no:"+roll_no);
            System.out.println("Marks:"+m);

        }

        catch(MarksOutOfBounds e){
            e.error();
        }
    }
}