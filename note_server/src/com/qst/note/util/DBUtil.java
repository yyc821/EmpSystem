package com.qst.note.util;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

public class DBUtil {
	static String dbName = "note_db";  //数据库名
	static String name = "root";    //数据库用户名
	static String pass = "123456";  //数据库密码
	
	//main方法测试一下是否能连接到数据库
//	public static void main(String[] args) {
//		Connection c = getConnection();
//		try {
//			Statement st = (Statement) c.createStatement();
//			st.execute("insert into user(name,pass) values('zhangsan','123')");
//			
//			close(c, st,null);
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
	
	//获取数据库连接对象
	public static Connection getConnection() {
		Connection c = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");  //加载mysql的Jdbc驱动
			c = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/" + dbName + "?ssl=false", name, pass); //获取数据库连接
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return c;
	}
	
	//释放资源
	public static void close(Connection c,Statement stat,ResultSet rs) {
		if(rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(stat != null ) {
			try {
				stat.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(c != null) {
			try {
				c.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
 
}
