package dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class DAO {
	public static Connection con;
	
	public DAO(){
		if(con == null){
			String dbUrl = "jdbc:mysql://localhost:3306/bookstore?useSSL=false&serverTimezone=UTC";
                        String dbClass = "com.mysql.cj.jdbc.Driver";

			try {
				Class.forName(dbClass);
				con = DriverManager.getConnection (dbUrl, "root", "Huyphan1610@");   
                                System.out.println("Kết nối thành công");
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
}