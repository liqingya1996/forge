package com.forge.util;

import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 1.���Ǵ����ݿ��л�ȡ�Ľ��������resultSet
 * 2.������е��������ǲ�ȷ��
 * 3.sql���ִ�о;���T��������
 * 4.ͨ�����������ʵ�����е����Ը�ֵ
 * @author ����
 *
 */
public class ResultSerUtil {
	
	/***
	 * 01.�����Ҫһ�������ResultSet,���ܻ�ȡT����
	 * 02.���������ҪClass<T>
	 * 
	 */
	public static <T> T findById(ResultSet rs,Class<T> c){
		T object=null;
		try {
			if(rs.next()){
				try {
					object=c.newInstance();//ʵ��������
				Field[] fields = c.getDeclaredFields();//��ȡʵ�����������ԣ�������
				for (Field field : fields) {
					field.setAccessible(true);//��Ȩ��
					field.set(object,rs.getObject(field.getName()));
				}
				} catch (InstantiationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return object;
	}
	
	
	public static <T> List<T>findAll(ResultSet rs,Class<T>c){
		T object=null;
		List<T> list=new ArrayList();//��������   ����ÿһ������
		try {
			
			try {
				while(rs.next()){
					object=c.newInstance();//ͨ������ʵ��������
					Field[]fields  = c.getDeclaredFields();//��ȡ��������
					for (Field field2 : fields) {
						field2.setAccessible(true);//��Ȩ��
						field2.set(object,rs.getObject(field2.getName()));
					}
					//��������뵽����
					list.add(object);
				}
			} catch (SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
				} catch (InstantiationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
		
		
		return list;
	}
	
}
