import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class vendorInsert {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:XE";
			String username = "system";
			String password = "oracle";
			Connection connection = DriverManager.getConnection(url, username, password);
			
			String insertQuery = "insert into vendor(vendor_no, name, balance_amount) VALUES (?, ?, ?)";
			PreparedStatement statement = connection.prepareStatement(insertQuery);
			Scanner scanner = new Scanner(System.in);
			String userInput;
			
			do{
				System.out.print("Enter vendor number: ");
				int vendorNo = scanner.nextInt();
				scanner.nextLine();
				System.out.print("Enter vendor name: ");
				String name = scanner.nextLine();
				System.out.print("Enter balance amount: ");
				double balanceAmount = scanner.nextDouble();
				
				statement.setInt(1, vendorNo);
				statement.setString(2, name);
				statement.setDouble(3, balanceAmount);
				
				int rowsInserted = statement.executeUpdate();
				System.out.println(rowsInserted + " row(s) inserted successfully.");
				
				System.out.print("Do you want to insert another record? (Y/N): ");
				userInput = scanner.next().toUpperCase();
			} while (!userInput.equals("N"));
			
			statement.close();
			connection.close();
		}
		catch (ClassNotFoundException | SQLException e)
		{
			e.printStackTrace();
		}
		
	}

}

/*
 Enter vendor number: 24
Enter vendor name: Karan
Enter balance amount: 3000
1 row(s) inserted successfully.
Do you want to insert another record? (Y/N): Y
Enter vendor number: 123
Enter vendor name:  Aman
Enter balance amount: 1500
1 row(s) inserted successfully.
Do you want to insert another record? (Y/N): N
*/
