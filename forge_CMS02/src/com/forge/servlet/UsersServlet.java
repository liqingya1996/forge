package com.forge.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.forge.bean.Forge_Users;
import com.forge.service.UserService;
import com.forge.service.impl.UserServiceImpl;
import com.forge.util.Md5Encrypt;


@WebServlet(value="/UsersServlet")
public class UsersServlet extends HttpServlet {

	Logger logger = Logger.getLogger(UsersServlet.class);
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req,resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String name = req.getParameter("loginName");
		String name2 = new String(name.getBytes("gbk"),"utf-8");
		String password = req.getParameter("password");
		UserService service = new UserServiceImpl();
		System.out.println(name2);
		System.out.println(password);
		Forge_Users user = null;
		user = service.login(name2,password );
		System.out.println(user);
		if(user==null){
			resp.setContentType("text/html;charset=utf-8");
			PrintWriter out = resp.getWriter();
			out.print("<meta   http-equiv='Content-Type'   content='text/xml;   charset=utf-8'>");
			out.print("<script>");
			out.print("alert('账户或者密码错误');");
			out.print("window.location.href='index.jsp'");
			out.print("</script>");
			out.flush();
			out.close();

		}else if((user!=null)&&(user.getLoginName().equals("admin"))&&(user.getPassword().equals("123456"))){
			req.getSession().setAttribute("user", user);
			resp.setContentType("text/html;charset=GBK");
			PrintWriter out = resp.getWriter();
			out.print("<meta   http-equiv='Content-Type'   content='textml;   charset=utf-8'>");
			out.print("<script>");
			out.print("alert('欢迎您，唐栋梁大人！');");
			out.print("window.location.href='production/index.jsp'");
			out.print("</script>");
			out.flush();
			out.close();

		}else{
			logger.info("没有权限登陆后台管理");
		}
			
	}

}
