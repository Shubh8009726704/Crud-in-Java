package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Students {

	public void createDatabase() throws ClassNotFoundException, SQLException {
		    String url = "jdbc:mysql://localhost:3306/";
	        String username = "root";
	        String password = "Shubh@8055";
	        
	        //driver
			Class.forName("com.mysql.cj.jdbc.Driver");
	        
	        //connection establish
	        Connection conn = DriverManager.getConnection(url,username,password);
	        System.out.println("Database Connected Successfully " + conn);
	        
	        //statement 
	        Statement stm = conn.createStatement();
	        
	        //execute query 
	        String query = "create database CodingWallah";
	        stm.execute(query);
	        System.out.println("Databse created successfully");
	        
	        //connection close
	        conn.close();
	}

	public void createTable() throws ClassNotFoundException, SQLException {
		    String url = "jdbc:mysql://localhost:3306/CodingWallah";
	        String username = "root";
	        String password = "Shubh@8055";
	        
	        //driver
			Class.forName("com.mysql.cj.jdbc.Driver");
	        
	        //connection establish
	        Connection conn = DriverManager.getConnection(url,username,password);
	        System.out.println("Database Connected Successfully " + conn);
	        
	        //statement 
	        Statement stm = conn.createStatement();
	        
	        //execute query 
	        String query = "create table Students(name varchar(50),age int(10),city varchar(50),college varchar(50))";
	        stm.execute(query);
	        System.out.println("Table created successfully");
	        
	        //connection close
	        conn.close();
	}

	public void createData() throws ClassNotFoundException, SQLException {
		    String url = "jdbc:mysql://localhost:3306/";
	        String username = "root";
	        String password = "Shubh@8055";
	        String db = "CodingWallah";
	        
	        //driver
			Class.forName("com.mysql.cj.jdbc.Driver");
	        
	        //connection establish
	        Connection conn = DriverManager.getConnection(url+db,username,password);
//	        System.out.println("Database Connected Successfully " + conn);
	        
	        //statement 
	        String query = "insert into Students(name,age,city,college) values(?,?,?,?)";
	        PreparedStatement pstm = conn.prepareStatement(query);
	        pstm.setString(1, "Vivek");
	        pstm.setInt(2, 24);
	        pstm.setString(3, "Kanpur");
	        pstm.setString(4, "NSTI Ramanthapur");

	        
	        
	        //execute query 
	        pstm.executeUpdate();
	        System.out.println("Data inserted successfully");
	        
	        //connection close
	        conn.close();		
	}

	public void readData() throws ClassNotFoundException, SQLException {
		 String url = "jdbc:mysql://localhost:3306/";
	        String username = "root";
	        String password = "Shubh@8055";
	        String db = "CodingWallah";
	        
	        //driver
			Class.forName("com.mysql.cj.jdbc.Driver");
	        
	        //connection establish
	        Connection conn = DriverManager.getConnection(url+db,username,password);
//	        System.out.println("Database Connected Successfully " + conn);
	        
	        //statement 
	        Statement stm = conn.createStatement();
	        
	        //execute query 
	        String query = "Select *from Students";
	        ResultSet rs = stm.executeQuery(query);
//	        System.out.println(rs);
	        while(rs.next()) {
//	        	System.out.println(rs.getString(1) + " "+  rs.getInt(2) +" " + rs.getString(3)+" " + rs.getString(4));
	        	System.out.println(rs.getString("name") + " "+  rs.getInt("age") +" " + rs.getString("city")+" " + rs.getString("college"));

	        }
	        
	        //connection close
	        conn.close();				
	}

	public void updateData() throws ClassNotFoundException, SQLException {
		String url = "jdbc:mysql://localhost:3306/";
        String username = "root";
        String password = "Shubh@8055";
        String db = "CodingWallah";
        
        //driver
		Class.forName("com.mysql.cj.jdbc.Driver");
        
        //connection establish
        Connection conn = DriverManager.getConnection(url+db,username,password);
//        System.out.println("Database Connected Successfully " + conn);
        
        //statement 
        String query = "Update students SET name = ? where city = ?";
        PreparedStatement pstm = conn.prepareStatement(query);
        pstm.setString(1, "Vivek Kumar");
        pstm.setString(2, "Kanpur");
       
        
        //execute query 
        pstm.executeUpdate();
        System.out.println("Update data successfully");
        
        //connection close
        conn.close();	
		
	}

	public void deleteData() throws ClassNotFoundException, SQLException {
		    String url = "jdbc:mysql://localhost:3306/";
		    String username = "root";
	        String password = "Shubh@8055";
	        String db = "CodingWallah";
	        
	        //driver
			Class.forName("com.mysql.cj.jdbc.Driver");
	        
	        //connection establish
	        Connection conn = DriverManager.getConnection(url+db,username,password);
//	        System.out.println("Database Connected Successfully " + conn);
	        
	        //statement 
	        String query = "Delete from Students where city = ?";
	        PreparedStatement pstm = conn.prepareStatement(query);
	        pstm.setString(1, "Kanpur");
	       
	        
	        //execute query 
	        pstm.executeUpdate();
	        System.out.println("Deleted data successfully");
	        
	        //connection close
	        conn.close();	
		
	}

}
