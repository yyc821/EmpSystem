package com.qst.note.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.qst.note.bean.Userbean;
import com.qst.note.dao.UserDao;
import com.qst.note.result.Result;

@WebServlet("/regist")
public class RegistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public RegistServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		Userbean use = new Userbean();
		use.setName(request.getParameter("name"));
		use.setPass(request.getParameter("pass"));
		use.setTel(request.getParameter("tel"));
		
		UserDao userDao = new UserDao();
		Boolean b  = userDao.regist(use);
		
		Result r = new Result();
		r.isSuccess = b;	
		if(b) {
			r.msg = "恭喜您注册成功";
		}else {
			r.msg = "注册失败，该手机号已被注册";
		}
		
		Gson gson = new Gson();
		String result = gson.toJson(r);
		
		response.getWriter().append(result);
	}

}
