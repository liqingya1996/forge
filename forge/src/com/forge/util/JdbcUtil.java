package com.forge.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import javax.sql.DataSource;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;



public class JdbcUtil {
	//��ȡ������jdbc API
	static Connection conn=null;
	static PreparedStatement statement=null;
	protected static ResultSet rs=null;
	/**
	 * ��ȡ�����Ŀ�������
	 * @return
	 * @throws ClassNotFoundException
	 * 
	 * 
	 * public static boolean getConnection() throws ClassNotFoundException{	
		//������ (���似��)
			try {
				Class.forName(ConfigManager.getInstance().getValue("jdbc.driver"));
				conn=DriverManager.getConnection(ConfigManager.getInstance().getValue("jdbc.url"),
						ConfigManager.getInstance().getValue("jdbc.user"),
						ConfigManager.getInstance().getValue("jdbc.password"));
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}
		
		return true;
	}
	 * 
	 * 
	 */
	
	/**
	 * ʹ�����Դ������ݿ�
	 * ����taomcat���Դ
	 * Spring ������Դ  ali  c3p0   dbcp
	 */
	public static boolean getConnection(){
		
		try {//��ʼ�����Ķ���tomcat����
			Context con=new InitialContext();
			//ͨ�����Դ �е�name���Ի�ȡָ�������Դ
			DataSource ds=(DataSource) con.lookup("java:comp/env/jdbc/User");
			//�����ӳ��л�ȡ����connection pool
			try {
				conn=ds.getConnection();
				return true;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
		
		
	}
	
	
	
	
	
	
	/**
	 * ���������Ĺر���
	 */
	public static void closeConnection() {
		if(rs!=null){
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(statement!=null){
			try {
				statement.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(conn!=null){
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	/**
	 * ��ͬ��sql��� ������ɾ���ģ�
	 * @param sql
	 * @param param
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public static int getmyExecuteUpdate(String sql,Object...param) throws ClassNotFoundException, SQLException{
		int rowNumb=0;//Ӱ�������
		if(getConnection()){//���ӽ�ִͨ��
			statement=conn.prepareStatement(sql);
			for (int i = 0; i < param.length; i++) {
				statement.setObject(i+1,param[i]);
			}
			//ִ��
			rowNumb=statement.executeUpdate();
		}
	closeConnection();
		return rowNumb;
		
	}
	/**
	 * ��ͬ��sql�����
	 * @param sql
	 * @param param
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public static ResultSet getmyExecuteQuery(String sql,Object...param) throws ClassNotFoundException, SQLException{
		
		if(getConnection()){//���ӽ�ִͨ��
			statement=conn.prepareStatement(sql);
			for (int i = 0; i < param.length; i++) {
				statement.setObject(i+1,param[i]);
			}
			//ִ��
			rs=statement.executeQuery();
		}
		return rs;
		
		
	}
	
	

}