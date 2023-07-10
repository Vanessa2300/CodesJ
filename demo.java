
import java.sql.Connection;

import java.sql.DriverManager;

import java.sql.SQLException;

import java.sql.Statement;

public class demo

{

public static void main(String[] args)

{

try

{

Class.forName("oracle.jdbc.driver.OracleDriver");

String url = "jdbc:oracle:thin:@localhost:1521:XE";

String username = "system";

String password = "oracle";

Connection connection = DriverManager.getConnection(url, username, password);

Statement statement = connection.createStatement();

String createTableQuery = "create table vendor(vendor_no int primary key,name varchar(20),balance_amount float)";

statement.executeUpdate(createTableQuery);

System.out.println("Vendor table created successfully.");

statement.close();

connection.close();

}

catch (ClassNotFoundException | SQLException e)

{

e.printStackTrace();

}

}

}
