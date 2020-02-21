/**
 * The DBHandler program implements an application that has a method used for
 *  connection establishment with the database.
 * @author Prashant Pandey
 * @version 1.0
 * @since 2020-02-19
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


@SuppressWarnings("unused")
public class DBHandler {
	
	//private static Properties props = new Properties();

	/**
	 * The method establishConnection use to establish connection using
	 * db.properties file connection establishment with the database.
	 */
	public Connection establishConnection() throws ClassNotFoundException, SQLException {
		Connection con = null;
//		try {
//
//			FileInputStream fis = null;
//			fis = new FileInputStream("db.properties");
//			props.load(fis);
//			Class.forName(props.getProperty("db.classname"));
//			con = DriverManager.getConnection(props.getProperty("db.url"), props.getProperty("db.username"),
//					props.getProperty("db.password"));
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		return con;
		//Connection con = null;
		try
		{
		Class.forName("com.mysql.cj.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/HolidayPackage?" + "autoReconnect=true&useSSL=false","root","root");
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	 return con;

	}
}
