package com.forge.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.forge.bean.Forge_Users;

public class UserLoginFilter implements Filter {

	@Override
	public void destroy() {
		
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req=(HttpServletRequest) request;//����ķ���  ����ת��
		HttpServletResponse resp=(HttpServletResponse) response;//����ķ���  ����ת��
		String path = req.getRequestURI();//��ȡ����ʱ��·��
		//Object���ͽ�����ǿת
		Forge_Users user = (Forge_Users) req.getSession().getAttribute("user");
		if(user!=null||path.contains("login")){
			//����
			chain.doFilter(req, resp);
		}else{
			//�ص�loginҳ��
			resp.sendRedirect("login.jsp");
		}
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		
		
	}

}
