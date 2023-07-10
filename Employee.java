import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Employee {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:XE";
			String username = "system";
			String password = "oracle";
			Connection connection = DriverManager.getConnection(url, username, password);
			Statement statement = connection.createStatement();
			
			String query =  "SELECT emp_id, age, doj, first_nm, last_nm FROM jdbc_emp";
			ResultSet resultSet = statement.executeQuery(query);

			while(resultSet.next()) {
				int employeeId = resultSet.getInt("emp_id");
				int age = resultSet.getInt("age");
				Date joinDate = resultSet.getDate("doj");
				String firstName = resultSet.getString("first_nm");
				String lastName = resultSet.getString("last_nm");
				
				System.out.println("Employee ID: " + employeeId);
				System.out.println("Age: " + age);
				System.out.println("Date of Joining: " + joinDate);
				System.out.println("First Name: " + firstName);
				System.out.println("Last Name: " + lastName);
				System.out.println("--------------------------------------");
			}
			
			resultSet.close();
			statement.close();
			connection.close();

		} catch (ClassNotFoundException | SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

}
