package database;

import java.sql.SQLException;

public class Main {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Students std = new Students();
//		std.createDatabase();
//		std.createTable();
		
//		CRUD
//		std.createData();
//		std.readData();
//		std.updateData();
		std.deleteData();
	}
}
