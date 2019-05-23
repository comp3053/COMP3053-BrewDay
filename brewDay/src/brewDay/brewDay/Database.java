package brewDay;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Database {
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	static final String DB_URL = "jdbc:mysql://localhost:3306/database";
	static final String USER = "root";
	static final String PASS = ""; 

	//*************************Select function***********************
	public static ResultSet Select(String sql) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			//System.out.println("Database connecting...");
			conn = DriverManager.getConnection(DB_URL,USER,PASS);
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
		}catch(SQLException se){
			se.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}
		//System.out.println("The End, Goodbye!");
		return rs;

	}
	//**********************End of Select function********************   

	//***********************Delete function*************************
	public static void Delete(String sql) {
		Connection conn = null;
		Statement stmt = null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			//System.out.println("Database connecting...");
			conn = DriverManager.getConnection(DB_URL,USER,PASS);
			stmt = conn.createStatement();
			stmt.execute(sql);
			stmt.close();
			conn.close();
		}catch(SQLException se){
			se.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				if(stmt!=null) stmt.close();
			}catch(SQLException se2){
				try{
					if(conn!=null) conn.close();
				}catch(SQLException se){
					se.printStackTrace();
				}
			}
		}
	}
	//*************************End of Delete function********************* 

	//****************************Insert function************************* 
	public static void Insert(String sql) {
		Connection conn = null;
		Statement stmt = null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			//System.out.println("Database connecting...");
			conn = DriverManager.getConnection(DB_URL,USER,PASS);
			stmt = conn.createStatement();
			stmt.execute(sql);
			stmt.close();
			conn.close();
		}catch(SQLException se){
			se.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				if(stmt!=null) stmt.close();
			}catch(SQLException se2){
				try{
					if(conn!=null) conn.close();
				}catch(SQLException se){
					se.printStackTrace();
				}
			}
		}
	}
	//****************************End of Insert function************************* 

	//*****************************Update function******************************
	public static void Update(String sql) {
		Connection conn = null;
		Statement stmt = null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			//System.out.println("Database connecting...");
			conn = DriverManager.getConnection(DB_URL,USER,PASS);
			stmt = conn.createStatement();
			stmt.execute(sql);

			stmt.close();
			conn.close();
		}catch(SQLException se){
			se.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				if(stmt!=null) stmt.close();
			}catch(SQLException se2){
				try{
					if(conn!=null) conn.close();
				}catch(SQLException se){
					se.printStackTrace();
				}
			}
		}
	}
	//**************************8**End of Update function********************** 

	//*******************************Set Zero function************************* 
	public static void SetZero(String sql) {
		Connection conn = null;
		Statement stmt = null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			//System.out.println("Database connecting...");
			conn = DriverManager.getConnection(DB_URL,USER,PASS);
			stmt = conn.createStatement();
			stmt.execute(sql);
			stmt.close();
			conn.close();
		}catch(SQLException se){
			se.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				if(stmt!=null) stmt.close();
			}catch(SQLException se2){
				try{
					if(conn!=null) conn.close();
				}catch(SQLException se){
					se.printStackTrace();
				}
			}
		}
		//******************************End of SetZero function********************** 
	}
}
