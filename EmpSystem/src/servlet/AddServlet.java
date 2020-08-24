package servlet;

import java.io.IOException;


import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EmpDao;
import entity.Emp;



/**
 * Servlet implementation class AddServlet
 */
@WebServlet("/AddServlet")
public class AddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		//response.setContentType("text/html;charset=utf-8");
		int empNo=Integer.parseInt(request.getParameter("empno"));
		String eName=request.getParameter("ename");
		String job=request.getParameter("job");
		
		
		Double sal=Double.parseDouble(request.getParameter("sal"));
		Double comm=Double.parseDouble(request.getParameter("comm"));
		int mgr=Integer.parseInt(request.getParameter("mgr"));
		int deptno=Integer.parseInt(request.getParameter("deptno"));
		String hireDate=request.getParameter("hiredate");
		Emp emp=new Emp();
		emp.setEmpno(empNo);
		emp.setEname(eName);
		emp.setSal(sal);
		emp.setComm(comm);
		emp.setJob(job);
		emp.setMgr(mgr);
		emp.setDeptno(deptno);
		
		
		try {
			Date nowtime=Date.valueOf(hireDate);
			emp.setHiredate(nowtime);
		}catch(Exception e) {
			e.printStackTrace();
			
		};
		
		EmpDao empDao=new EmpDao();
		boolean b=empDao.insert(emp);
		System.out.println(b);
		if(b==true){
			request.getRequestDispatcher("MainServlet").forward(request, response);
		}else{
			response.sendRedirect("addEmp.jsp");
		}
	
		doGet(request, response);
	}
	

}
