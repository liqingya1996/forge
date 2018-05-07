	package com.forge.dao.impl;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

import com.forge.bean.Forge_Users;
import com.forge.dao.UserDao;
import com.forge.util.ResultSetUtil;
import com.forge.util.jdbcUtil;



public class UserDaoImpl extends jdbcUtil implements UserDao {

	/**
	 * 注册新用户
	 * 需要输入登录名和密码
	 */
	@Override
	public int add(Forge_Users t) {
		String sql = "INSERT INTO forge_users(loginName,`password`,`email`,`phone`,`address`) VALUES (?,?,?,?,?);";
		Object []param = {t.getLoginName(),t.getPassword(),t.getEmail(),t.getPhone(),t.getAddress()};
		int rowNum = 0;
		try {
			rowNum = myExcuteUpdate(sql, param);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rowNum;
	}

	@Override
	public int delete(Serializable id) {
		String sql="DELETE FROM `forge_users` WHERE userid=?;";
		int rowNum=0;
		try {
			rowNum = myExcuteUpdate(sql,id);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rowNum;
		
	
	}

	@Override
	public int update(Serializable id, Forge_Users t) {
		int rowNum=0;
		String sql="UPDATE `forge_users` SET  loginName=?,phone=?,email=?,address=?where userid=?;";
		Object []param={t.getLoginName(),t.getPhone(),t.getEmail(),t.getAddress(),id};
		try {
			rowNum = myExcuteUpdate(sql, param);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rowNum;
	}

	@Override
	public List<Forge_Users> findAll() {
		List<Forge_Users> list=null;
		String sql="SELECT * FROM `forge_users`;";
		try {
			rs = myExcuteQuery(sql);
			list = ResultSetUtil.findAll(rs, Forge_Users.class);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public Forge_Users findById(Serializable id) {
		Forge_Users user=null;
		String sql="SELECT * FROM `forge_users` WHERE `userId`=?;";
		try {
			rs = myExcuteQuery(sql,id);
			user=ResultSetUtil.findById(rs, Forge_Users.class);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public Forge_Users login(String userName, String Password) {
		String sql = "select * from forge_users  where loginName=? and password=?;";
		Object []param = {userName,Password};
		Forge_Users user = null;
		try {
			rs = myExcuteQuery(sql, param);
			user = ResultSetUtil.findById(rs, Forge_Users.class);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

	

}
