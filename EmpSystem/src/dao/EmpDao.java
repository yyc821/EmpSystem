package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;


import entity.Emp;
import utils.DBUtils;
public class EmpDao {
	Connection c=null;
	//根据员工编号查询
	public Emp queryByEmpno(int empno){
		c=DBUtils.getConnection();
		try{
			String sql="select * from tb_emp  where empno=?";
			PreparedStatement pst=c.prepareStatement(sql);
			pst.setInt(1, empno);
			ResultSet rs=pst.executeQuery();
			if(rs.next()){
				Emp emp =new Emp();
				emp.setEmpno(rs.getInt("empNo"));
				emp.setEname(rs.getString("eName"));
				emp.setJob(rs.getString("job"));
				emp.setHiredate(rs.getDate("hiredate"));
				emp.setSal(rs.getDouble("sal"));
				emp.setComm(rs.getDouble("comm"));
				emp.setMgr(rs.getInt("mgr"));
				emp.setDeptno(rs.getInt("deptno"));
				return emp;
			}else{
				return null;
			}
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}finally{
			DBUtils.closeConnection(c);
		}
		
	}
	
	//全局查询
	public List<Emp> findAll(){
		List<Emp> list =new ArrayList<Emp>();
		try{
			c=DBUtils.getConnection();
			String sql="select * from tb_emp order by hiredate asc";
			PreparedStatement pst=c.prepareStatement(sql);
			ResultSet rs=pst.executeQuery();
			while(rs.next()) {
				Emp emp =new Emp();
				emp.setEmpno(rs.getInt("empno"));
				emp.setEname(rs.getString("ename"));
				emp.setJob(rs.getString("job"));
				emp.setHiredate(rs.getDate("hiredate"));
				emp.setSal(rs.getDouble("sal"));
				emp.setComm(rs.getDouble("comm"));
				emp.setMgr(rs.getInt("mgr"));
				emp.setDeptno(rs.getInt("deptno"));
				list.add(emp);
			}
			return list;
		}catch(Exception e){
			e.printStackTrace();
			return null;
			
		}finally{
			DBUtils.closeConnection(c);
		}
		
	}
	
	//添加雇员
	public boolean insert(Emp emp){
		Connection c=null;
		try{
			c=DBUtils.getConnection();
			String sql="insert into tb_emp(empno,ename,job,hiredate,sal,comm,mgr,deptno) values (?,?,?,?,?,?,?,?)";
			PreparedStatement pst=c.prepareStatement(sql);
			pst.setInt(1,emp.getEmpno());
			pst.setString(2, emp.getEname());
			pst.setString(3, emp.getJob());
			pst.setString(4, String.valueOf(emp.getHiredate()));
			pst.setDouble(5, emp.getSal());
			pst.setDouble(6, emp.getComm());
			pst.setInt(7, emp.getMgr());
			pst.setInt(8, emp.getDeptno());
			pst.execute();
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}finally{
			DBUtils.closeConnection(c);
		}
		
	}
	
	//根据雇员编号删除
	public boolean deleteEmp( int empno) {
		Connection c=null;
		try{
			c=DBUtils.getConnection();
			String sql="delete from tb_emp where empno=?";
			PreparedStatement pst=c.prepareStatement(sql);
			pst.setInt(1,empno);
			pst.execute();
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}finally{
			DBUtils.closeConnection(c);
		}
		
	}

	
	//模糊查询，根据雇员姓名查询
	public List<Emp> findByName(String ename){	
		Connection c=null; 
		List<Emp> list =new ArrayList<Emp>();
		try{
			c=DBUtils.getConnection();
			String sql="select * from tb_emp where  ename like ?";
			PreparedStatement pst=c.prepareStatement(sql);
			pst.setString(1, "%"+ename+"%");
			ResultSet rs=pst.executeQuery();
			while(rs.next()) {
				Emp emp =new Emp();
				emp.setEmpno(rs.getInt("empno"));
				emp.setEname(rs.getString("ename"));
				emp.setJob(rs.getString("job"));
				emp.setHiredate(rs.getDate("hiredate"));
				emp.setSal(rs.getDouble("sal"));
				emp.setComm(rs.getDouble("comm"));
				emp.setMgr(rs.getInt("mgr"));
				emp.setDeptno(rs.getInt("deptno"));
				list.add(emp);
			}
			return list;
			}catch(Exception e){
			e.printStackTrace();
				return null;
		}finally{
			DBUtils.closeConnection(c);
		}
	}
	

	public List<Emp> listEmp(int pageNo){
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<Emp> list=new ArrayList<Emp>();
		int pageSize=5;
		int page=(pageNo-1)*5;
		
		Connection c=DBUtils.getConnection();
	
		String sql="select * from tb_emp order by id limit ?,?";
		try {
			pstmt=c.prepareStatement(sql);
			pstmt.setInt(1, page);
			pstmt.setInt(2, pageSize);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				 Emp emp=new Emp();
		            emp.setEmpno(rs.getInt("empno"));
					emp.setEname(rs.getString("ename"));
					emp.setJob(rs.getString("job"));
					emp.setHiredate(rs.getDate("hiredate"));
					emp.setSal(rs.getDouble("sal"));
					emp.setComm(rs.getDouble("comm"));
					emp.setMgr(rs.getInt("mgr"));
					emp.setDeptno(rs.getInt("deptno"));
		            list.add(emp);
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
		
		String sql="select count(*) from tb_emp";
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


	
	public boolean update(Emp emp) {
	 	Connection c=null;
	 	try{
	 		c=DBUtils.getConnection();
			String sql="update tb_emp set empno=?,ename=?,job=?,hiredate=?,sal=?,comm=?,mgr=?,deptno=? where empno=?";
			PreparedStatement pst=c.prepareStatement(sql);
			
			pst.setInt(1,emp.getEmpno());
			pst.setString(2, emp.getEname());
			pst.setString(3, emp.getJob());
			pst.setDate(4,emp.getHiredate());
			pst.setDouble(5, emp.getSal());
			pst.setDouble(6, emp.getComm());
			pst.setInt(7, emp.getMgr());
			pst.setInt(8, emp.getDeptno());
			pst.setInt(9, emp.getEmpno());
			pst.execute();
			return true;
	 	
	 	}catch(Exception e){
	 		e.printStackTrace();
	 		return false;
	 	}finally{
	 		DBUtils.closeConnection(c);
	 	}
}
	
	public static void main(String[] args) {
		EmpDao dao=new EmpDao();
		List<Emp> list=dao.findByName("红");
		for(Emp emp:list) {
			System.out.println( "ename:" +emp.getEname() + ":comm" +emp.getComm());  
		}	
		//boolean b=dao.deleteEmp(1211);
		//System.out.print(b);
		/*Emp emp=new Emp();
		emp.setEmpno(111);
		emp.setEname("liqz");
		emp.setJob("liqz");
		emp.setSal(11.0);
		emp.setComm(11.0);*/
		
	/*	try {
			SimpleDateFormat sim=new SimpleDateFormat("yyyy-MM-dd");
			Date hiredate=sim.parse("2018-06-15");
			emp.setHiredate(hiredate);
			}catch(Exception e) {}*/
		/*emp.setHiredate( new Date(2017-1-6));
		emp.setMgr(1);
		emp.setDeptno(1);
		EmpDao empDao=new EmpDao();
		boolean b=empDao.update(emp,1211);*/
		//System.out.println(b);
	}
}
