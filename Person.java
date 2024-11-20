package JDBC_19Nov_v2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Person {

	 public void Insert(int pId, String pName, String pAddress) throws Exception {
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/person", "root", "root");
	        Statement stmt = conn.createStatement();

	        String query = "INSERT INTO personDetails VALUES(" + pId + ", '" + pName + "', '" + pAddress + "')";
	        stmt.executeUpdate(query);

	        System.out.println("Data Added Successfully....");
	        conn.close();
	    }

	    public void Update(int pId, String pName, String pAddress) throws Exception {
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/person", "root", "root");
	        Statement stmt = conn.createStatement();

	        String query = "UPDATE personDetails SET pName='" + pName + "', pAddreass='" + pAddress + "' WHERE pId=" + pId;
	        stmt.executeUpdate(query);

	        System.out.println("Data Updated Successfully....");
	        conn.close();
	    }

	    public void Delete(int pId) throws Exception {
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/person", "root", "root");
	        Statement stmt = conn.createStatement();

	        String query = "DELETE FROM personDetails WHERE pId=" + pId;
	        stmt.executeUpdate(query);

	        System.out.println("Data Deleted Successfully....");
	        conn.close();
	    }

	    public void GetAllData() throws Exception {
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/person", "root", "root");
	        Statement stmt = conn.createStatement();

	        String query = "SELECT * FROM personDetails";
	        ResultSet rs = stmt.executeQuery(query);

	        while (rs.next()) {
	            System.out.println("PId = " + rs.getInt(1) + "\nPName = " + rs.getString(2) + "\nPAddress = " + rs.getString(3) + "\n=======================");
	        }
	        conn.close();
	    }
}
