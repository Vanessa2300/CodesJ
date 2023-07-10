import java.sql.*;
import java.util.Scanner;

public class test
{
    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);
        try 
        {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            String url = "jdbc:oracle:thin:@localhost:1521:XE";
            String username = "system";
            String password = "oracle";
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();
            String createTableQuery = "create table tut_stud("+"id int primary key,"+"name char(20),"+"age int"+")";
            statement.executeUpdate(createTableQuery);
            int ch = 0;
            do 
            {
                System.out.println("-----MENU-----");
                System.out.println("1)Insert");
                System.out.println("2)Delete");
                System.out.println("3)Update");
                System.out.println("4)Exit");
                System.out.print("Enter your choice:");
                ch = scanner.nextInt();
                scanner.nextLine();
                switch (ch) 
                {
                    case 1:insertStudent(statement, scanner);
                           break;
                    case 2:deleteStudent(statement, scanner);
                           break;
                    case 3:updateStudent(statement, scanner);
                           break;
                    case 4://System.out.println("Exiting the program...");
                           break;
                    default:System.out.println("Invalid choice!");
                            break;
                }
            } while (ch!= 4);
            statement.close();
            connection.close();
        } 
        catch (ClassNotFoundException e) 
        {
            e.printStackTrace();
        } 
        catch (SQLException e)
        {
            e.printStackTrace();
        } 
        finally
        {
            // Close the scanner
            scanner.close();
        }
    }

    private static void insertStudent(Statement statement, Scanner scanner) throws SQLException
    {
        System.out.print("Enter the student roll no.: ");
        int id = scanner.nextInt();
        System.out.print("Enter the student name: ");
        String name = scanner.nextLine();
        System.out.print("Enter the student age: ");
        int age = scanner.nextInt();
        scanner.nextLine(); 
        //System.out.print("Enter the student grade: ");
        //String grade = scanner.nextLine();
        String insertDataQuery = "insert into tut_stud(id, name, age)"+"values(" + id +",'"+name+"',"+age+"')";
        statement.executeUpdate(insertDataQuery);
        System.out.println("Inserted successfully!");
        System.out.println();
    }

    private static void deleteStudent(Statement statement, Scanner scanner) throws SQLException 
    {
        System.out.print("Enter the student roll no. to delete: ");
        int id = scanner.nextInt();
        scanner.nextLine(); 
        String deleteDataQuery = "delete from tut_stud where id = " + id;
        int rowsAffected = statement.executeUpdate(deleteDataQuery);
        if (rowsAffected > 0)
        {
            System.out.println("Deleted successfully!");
        } 
        else
        {
            System.out.println("Record not found");
        }
        System.out.println();
    }

    private static void updateStudent(Statement statement, Scanner scanner) throws SQLException 
    {
        System.out.print("Enter the student roll no. to update: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        String selectQuery = "select * from tut_stud where id = " + id;
        ResultSet resultSet = statement.executeQuery(selectQuery);
        if (resultSet.next()) 
        {
            System.out.print("Enter the updated student name: ");
            String name = scanner.nextLine();
            System.out.print("Enter the updated student age: ");
            int age = scanner.nextInt();
            scanner.nextLine(); 
            //System.out.print("Enter the updated student grade: ");
            //String grade = scanner.nextLine();
            String updateDataQuery = "update tut_stud set name = '" + name + "', age = " + age +"' " +"WHERE id = " + id;
            statement.executeUpdate(updateDataQuery);
            System.out.println("Updated successfully!");
        }
        else 
        {
            System.out.println("Record not found");
        }
        resultSet.close();
        System.out.println();
    }
}