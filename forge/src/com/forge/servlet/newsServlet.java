package com.forge.servlet;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.forge.bean.Forge_News;
import com.forge.service.Forge_News_Service;
import com.forge.service_impl.Forge_News_Service_Impl;

@WebServlet()
public class newsServlet extends HttpServlet {
//����Forge_News_Service_Impl����
	private Forge_News_Service service=new Forge_News_Service_Impl();
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		super.doGet(req, resp);
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		//����post����
		req.setCharacterEncoding("utf-8");
		String method=req.getParameter("method");
		System.out.println("method");
		switch(method){
		case "add":
			add(req,resp);//��������
			break;
		case "delete":
			delete(req,resp);//ɾ��
			break;
		case "update":
			update(req,resp);//�޸ķ���
			break;
		
		}
	}
	/**
	 * �����ķ���  ���ļ��ϴ�
	 * 01.������Ҫ��jar��
	 * 02.��form���и��enctype
	 * 03.ServletFileUpload.isMultipartContent(request)  ���ж����ǵ������ǲ����ļ��ϴ�����
	 * 04.��ȡ���������еı?Ԫ��
	 * 		List<FileItem>  list=ServletFileUpload.parseRequest(request)
	 * 	 ÿһ���?Ԫ�ؾͶ�Ӧһ��FileTtem
	 * 05.FileItem.isFormField()
	 * true===>��ͨ�ı?Ԫ��
	 *             getFiledName()===>��ȡname����ֵ
	 *             getString(String s)===����ȡvalue��ֵ  s===>�����ʽ
	 *     flase==>�ļ��ϴ�Ԫ��   
	 *            getName===>��ȡ�ϴ��ļ������
	 *            getContentType()===����ȡ�ϴ��ļ�������      mime-type
	 * @param req
	 * @param resp
	 * @throws FileUploadException 
	 */
	private void update(HttpServletRequest req, HttpServletResponse resp) {
		//����News����
		Forge_News news=new Forge_News();
		System.out.println("��ʱ�ļ���ŵ�λ��====��"+System.getProperty("java.io.tmpdir"));
		//����factory����  �������û������С  �Լ����λ��
		DiskFileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload upload=new ServletFileUpload(factory);
		//�ж��Ƿ����ļ��ϴ�����
		boolean flag=upload.isMultipartContent(req);
		if(flag){//form�?���ļ��ϴ�����
			try {
				List<FileItem> items=upload.parseRequest(req);
				//ʹ�õ��������  Ч�ʸ�
				Iterator<FileItem> its = items.iterator();
				while(its.hasNext()){
					FileItem item = its.next();
					//�жϱ?Ԫ����ʲô����
					if(item.isFormField()){//֤������ͨ�?Ԫ��
						String fieldName = item.getFieldName();// title context
																//createTime
						switch(fieldName){
						case "title":
							news.setTitle(item.getString("UTF-8"));
							break;
//						case "createTime":
//							news.setCreateTime(new SimpleDateFormat("dd/MM/yy")
//							.parse(item.getString("UTF-8")));
//							break;
						case "content":
							news.setContent(item.getString("UTF-8"));
							break;
						}
					}else{//֤�����ļ���Ԫ��
						String uploadPath=req.getSession().getServletContext().getRealPath("upload/");
						//����upload�ļ���
						File file=new File(uploadPath);
						if(file.exists()){
							file.mkdirs();
						}
						String fileName = item.getName();//��ȡ�ϴ��ļ������
						fileName=new String(fileName.getBytes(),"utf-8");//�����������
						if(!"".equals(fileName)&&null!=fileName){
							File saveFile = new File(uploadPath, fileName);
							try {
								item.write(saveFile);
							} catch (Exception e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							news.setImg(uploadPath + "\\" + fileName);// System.currentTimeMillis()
						}
					}
				}
			} catch (FileUploadException e) {
				
				e.printStackTrace();
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	private void delete(HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		
	}

	private void add(HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		
	}

}
