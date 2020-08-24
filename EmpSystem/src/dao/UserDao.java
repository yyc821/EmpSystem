package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.User;
import entity.User;
import utils.DBUtils;

public class UserDao {
	
	/**
	 * 注册用户
	 * author:
	 */
	public boolean registe(User user){
		Connection c=null ;      ;
		try{
			 c=DBUtils.getConnection();
			String sql="insert into tb_user(userName,userPwd) values (?,?)";
			PreparedStatement pst=c.prepareStatement(sql);
			pst.setString(1,user.getUserName());
			pst.setString (2,user.getUserPwd());
			pst.execute();
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}finally{
			try {
				c.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	

	public List<User> listUser(int pageNo){
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<User> list=new ArrayList<User>();
		int pageSize=5;
		int page=(pageNo-1)*5;
		
		Connection c=DBUtils.getConnection();
	
		String sql="select * from tb_user order by id limit ?,?";
		try {
			pstmt=c.prepareStatement(sql);
			pstmt.setInt(1, page);
			pstmt.setInt(2, pageSize);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				 User user=new User();
				 user.setId(rs.getInt("id"));
				 user.setUserName(rs.getString("userName"));
				 user.setUserPwd(rs.getString("userPwd"));
		         list.add(user);
			}
			
		
		} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		}finally{
			DBUtils.closeConnection(c);
		}
			return list;
		}
		
	
	public int getPage(){
		int recordCount=0,t1=0,t2=0;
		PreparedStatement pstmt=null;
		ResultSet result=null;
		Connection c=null; 
		
		String sql="select count(*) from tb_user";
		try {
			c=DBUtils.getConnection();
			pstmt=c.prepareStatement(sql);
			result=pstmt.executeQuery();
			result.next();
			recordCount=result.getInt(1);
			t1=recordCount%5;
			t2=recordCount/5;
		} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		}finally{
			DBUtils.closeConnection(c);
		}
		if(t1 != 0){
			t2=t2+1;
		}
			return t2;
		}


	
	public User findUser(String userName){
		Connection c=null;
		try{
			 c=DBUtils.getConnection();
			String sql="select * from tb_user where userName=?";
			PreparedStatement pst=c.prepareStatement(sql);
			pst.setString(1, userName);
			ResultSet rs=pst.executeQuery();
			if(rs.next()==false){
				return null;
			}else{
				User user=new User();
				
				user.setUserName(rs.getString("userName"));
				user.setUserPwd(rs.getString("userPwd"));
				return user;
			}
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}finally{
			DBUtils.closeConnection(c);
		}
	}
	public static void main(String args[]){
			UserDao userdao=new UserDao();
			User user=userdao.findUser("admin");
			System.out.println(user);
			System.out.println(user.getUserPwd());
					
	}
}



