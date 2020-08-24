package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;
import entity.User;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @return 
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		UserDao dao=new UserDao();
		System.out.print("已经到达");
		String name=request.getParameter("userName");
		String pwd=request.getParameter("userPwd");
		User user=dao.findUser(name);
	
		//System.out.print(user.getUserName()+user.getUserPwd());
		System.out.println(user);
		if(user==null) {
			   System.out.println("*????????***********************");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}else if(!user.getUserPwd().equals(pwd)){
			   System.out.println("********************************");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}else {
			System.out.println("ok");
			//response
			request.getRequestDispatcher("main.jsp").forward(request, response);
		}
		
	}

}
