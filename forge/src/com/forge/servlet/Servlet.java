package com.forge.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.annotation.ServletSecurity;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.forge.bean.Forge_Users;
import com.forge.dao.Forge_Users_Dao;
import com.forge.dao_impl.Forge_Users_Dao_Impl;
import com.forge.service.Forge_Users_Service;
import com.forge.service_impl.Forge_Users_Service_Impl;
import com.sun.mail.iap.Response;

@WebServlet("/forgeServlet")
public class Servlet extends HttpServlet {
	Forge_Users_Dao userDao = new Forge_Users_Dao_Impl();
	Forge_Users_Service service = new Forge_Users_Service_Impl();


	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		String method = req.getParameter("method");
		System.out.println("����������" + method);
		switch (method) {
		case "login":
			login(req, resp);
			break;
		case "validate":
			validateLoginName(req, resp);
			break;
		case "add":
			try {
				add(req, resp);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		}

	}

	/**
	 * ע�� ��������
	 * 
	 * @param req
	 * @param resp
	 * @throws IOException
	 */
	private void add(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {

		
		System.out.println("������add����");
		String id = req.getParameter("id");
		req.setCharacterEncoding("UTF-8");
		String password = req.getParameter("password");
		String repassword = req.getParameter("repassword");

		Forge_Users user = new Forge_Users();

		user.setUserId(id);
		user.setAddress(req.getParameter("address"));
		user.setEmail(req.getParameter("email"));
		user.setPhone(req.getParameter("phone"));
		user.setLoginName(req.getParameter("loginName"));
		user.setPassword(password);
		service.add(user);
		System.out.println("ִ�����");
		resp.sendRedirect("login.jsp");

	}
	
	public void validateLoginName(HttpServletRequest req, HttpServletResponse resp) throws IOException{
		//����userʵ������
		Forge_Users user=null;
		//�ж����ݿ����Ƿ�����û�������û�
		String loginName = req.getParameter("loginName");
		System.out.println("=====================++++"+loginName);
		user = service.findByName(loginName);

				boolean flag=false;
				System.out.println(loginName);
				if(user!=null){
					flag=true;//֤�����ݿ����
					System.out.println("______________________________________");
				}
				PrintWriter writer = resp.getWriter();
				writer.print(flag);
				writer.close();

	}

	// //����factory���� �������û�������С �Լ����λ��
	// DiskFileItemFactory factory = new DiskFileItemFactory();
	// ServletFileUpload upload=new ServletFileUpload(factory);
	// Forge_Users user=new Forge_Users();
	// boolean flag = upload.isMultipartContent(req);
	// System.out.println(flag);
	// if(flag){//form�����ļ��ϴ�����
	//
	//
	// List<FileItem> items=upload.parseRequest(req);
	// //ʹ�õ��������� Ч�ʸ�
	// Iterator<FileItem> its = items.iterator();
	// while(its.hasNext()){
	// FileItem item = its.next();
	// //�жϱ�Ԫ����ʲô����
	// if(item.isFormField()){//֤������ͨ��Ԫ��
	// String fieldName = item.getFieldName();// title context
	// //createTime
	// switch(fieldName){
	// case "loginName":
	// user.setLoginName(item.getString("UTF-8"));
	// break;
	// case "phone":
	// user.setPhone(item.getString("UTF-8"));
	// break;
	// case "address":
	// user.setAddress(item.getString("UTF-8"));
	// case "email":
	// user.setEmail(item.getString("UTF-8"));
	// case "password":
	// if()
	// break;
	// }
	//
	// }
	// }}
	//

	// }

	/**
	 * ��¼
	 * 
	 * @param req
	 * @param resp
	 * @throws IOException
	 */
	private void login(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		resp.setContentType("text/html;charset=UTF-8");
		// 解决请求编码
		req.setCharacterEncoding("utf-8");
		// ��ȡout���
		PrintWriter out = resp.getWriter();
		// ��ȡ �û�����
		String loginName = req.getParameter("loginName");
		String password = req.getParameter("password");

		// ��ȡ�����ֵ ���չ�����0��
		String reslut = req.getParameter("slider_block");
		// ���ռ�ס����
		String remember = req.getParameter("remember");
		// �����û�����
		Forge_Users user = new Forge_Users();
		// ���õ�¼����
		user = userDao.login(loginName, password);
		// �߼��ж�
		if (user == null) {
			JOptionPane.showMessageDialog(null, "�û������벻��ȷ");
			resp.sendRedirect("login.jsp");
		} else {
			if (reslut.equals("0")) {
				JOptionPane.showMessageDialog(null, "�뻬��������¼");
				resp.sendRedirect("login.jsp");
			} else {
				if (remember == null) {
					resp.sendRedirect("index.jsp");
				} else {
					// ��¼�����浽cookie�Ự
					resp.addCookie(new Cookie("loginName", "loginName"));
					resp.sendRedirect("index.jsp");
				}

			}
		}
	}
}
