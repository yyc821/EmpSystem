package utils;

import java.sql.Connection;
import java.sql.DriverManager;


public class DBUtils {
	final static String DRIVER="com.mysql.jdbc.Driver";
	final static String URL="jdbc:mysql://localhost:3306/emp?useUnicode=true&characterEncoding=utf-8";
	final static String USER="root";
	final static String PASSWORD="123456";
	public static Connection getConnection(){
		try{
			Class.forName(DRIVER);
			Connection connection=DriverManager.getConnection(URL,USER,PASSWORD);
			System.out.println("连接成功");
			return connection;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	
	public static void closeConnection(Connection con){
		try{
			con.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	} 
	
	public static void main(String[] args){
		DBUtils db=new DBUtils();
		DBUtils.getConnection();
		//System.out.print(c);
	}

	
	
}
