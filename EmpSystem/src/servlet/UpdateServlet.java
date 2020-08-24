package servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EmpDao;
import entity.Emp;

/**
 * Servlet implementation class UpdateServlet
 */
@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
	this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
	/*	response.setContentType("text/html;charset=utf-8");
		response.setHeader("content-type", "text/html,charset=UTF-8");*/
		int empno=Integer.parseInt(request.getParameter("empno"));
		String eName=request.getParameter("ename");
		String job=request.getParameter("job");
		String hireDate=request.getParameter("hiredate");
		String Sal=request.getParameter("sal");
		Double sal=Double.parseDouble(Sal);
		Double comm=Double.parseDouble(request.getParameter("comm"));
		int mgr=Integer.parseInt(request.getParameter("mgr"));
		int deptno=Integer.parseInt(request.getParameter("deptno"));
		Emp emp=new Emp();
		emp.setEmpno(empno);
		emp.setEname(eName);
		emp.setJob(job);
		emp.setSal(sal);
		emp.setComm(comm);
		
		try {
		
			Date hiredate=Date.valueOf(hireDate);
			emp.setHiredate(hiredate);
			}catch(Exception e) {}
		emp.setMgr(mgr);
		emp.setDeptno(deptno);
		
		EmpDao empDao=new EmpDao();
		boolean b=empDao.update(emp);
		System.out.println(b);
		if(b==true){
			request.getRequestDispatcher("MainServlet").forward(request, response);
		}else{
			response.sendRedirect("addEmp.jsp");
		}
	}
}
