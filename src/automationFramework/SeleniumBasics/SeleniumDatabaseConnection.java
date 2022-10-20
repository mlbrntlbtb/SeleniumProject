package automationFramework.SeleniumBasics;

import java.sql.*;

import org.testng.annotations.*;

public class SeleniumDatabaseConnection 
{
	//MySQL Constants
//	private String dbURL = "jdbc:mysql://localhost:3306/toolsqa_users";
//	private String dbUsername = "root";
//	private String dbPassword = "admin";
	private String dbQuery = "select * from users;";
	
	//MSSQL Constants
	private String connectionString = "jdbc:sqlserver://localhost:1433;databaseName=toolsqa_users;encrypt=true;trustServerCertificate=true;integratedSecurity=true;";
	
	
	@Test
	public void Test() throws ClassNotFoundException, SQLException 
	{
		//MySQL Database Connection
		
		//Load MySQL JDBC Driver
		//Class.forName("com.mysql.cj.jdbc.Driver"); //MySQL JDBC Driver
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); //MSSQL JDBC Driver
		
		//Create connection to Database
		//Connection connection = DriverManager.getConnection(dbURL, dbUsername, dbPassword);
		Connection connection = DriverManager.getConnection(connectionString);
		
		//Create statement object
		Statement statement = connection.createStatement();
		
		//Execute SQL query then store results in ResultSet
		ResultSet resultSet = statement.executeQuery(dbQuery);
		
		//Get Database MetaData Info
		DatabaseMetaData dbMetaData = (DatabaseMetaData)connection.getMetaData();
		System.out.println("Driver Name: [" + dbMetaData.getDriverName() + "]");
		System.out.println("Driver Version: [" + dbMetaData.getDriverVersion() + "]");
		System.out.println("Product Name: [" + dbMetaData.getDatabaseProductName() + "]");
		System.out.println("Product Version: [" + dbMetaData.getDatabaseProductVersion() + "]");
		
		//Display ResultSet
		while(resultSet.next())
		{
			String username = resultSet.getString(2);
			String password = resultSet.getString(3);
			System.out.println("Username: [" + username + "] Password: [" + password + "]");
		}		
		
		connection.close();
	}
}
