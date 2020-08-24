package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EmpDao;
import entity.Emp;

/**
 * Servlet implementation class MainServlet
 */
@WebServlet("/MainServlet")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MainServlet() {
        super();
    // TODO Auto-generated constructor stub
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
		//response.getWriter().append("Served at:").append(request.getContextPath());
		request.setCharacterEncoding("utf-8");
		EmpDao empdao=new EmpDao();
		/*List<Emp> list=empdao.findAll();
		request.setAttribute("list",list);*/
		
		int pageNo = 1;
		
		List<Emp> lists=new ArrayList<Emp>();
		String pageno=request.getParameter("pageNos");
		if(pageno != null){
		pageNo=Integer.parseInt(pageno);
		}
		lists=empdao.listEmp(pageNo);
		int recordCount=empdao.getPage();
		request.setAttribute("recordCount", recordCount);
		request.setAttribute("list", lists);
		request.setAttribute("pageNos", pageNo);
		request.getRequestDispatcher("success.jsp").forward(request, response);
		
		
		//request.getRequestDispatcher("success.jsp").forward(request, response);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		doGet(request, response);
	}
}
