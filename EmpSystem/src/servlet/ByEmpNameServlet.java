package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EmpDao;
import entity.Emp;



/**
 * Servlet implementation class ByEmpNameServlet
 */
@WebServlet("/ByEmpNameServlet")
public class ByEmpNameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ByEmpNameServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		response.setHeader("content-type", "text/html,charset=UTF-8");
		EmpDao empdao=new EmpDao();
		
		String ename=request.getParameter("ename");
		List<Emp> list=empdao.findByName(ename);
		System.out.println(ename);
		if(null == list || list.size() ==0 ){
			request.setAttribute("msg" ,"无此员工");
			request.getRequestDispatcher("MainServlet").forward(request, response);
		}else if(ename==""){
			request.getRequestDispatcher("MainServlet").forward(request, response);
		}else {
			request.removeAttribute("msg");
			request.setAttribute("list" ,list);
			request.getRequestDispatcher("other.jsp").forward(request, response);
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		doGet(request, response);
		
	}

}
