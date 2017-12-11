package com.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dao.BaseDao;
import com.dao.UserDao;
import com.entity.SysUser;

public class UserDaoImpl2 extends BaseDao implements UserDao {

	@Override
	public SysUser login(String userName, String password) {
		SysUser user =null;
		String readSql = "select * from sysuser " //注意拼接之间的空格是否缺失!!!!!!!!!!!!
				+ "WHERE userName=? "
				+ "and password = ?";
		Object[] paras = {userName,password};

		try {
			super.rs = super.execQuery(readSql, paras);
			while(rs.next()){
				//如果查询到数据用户表示能够登录，将数据设置到用户对象中返回对象
				user = new SysUser();
				user.setId(rs.getInt("id"));
				user.setNickName(rs.getString("NickName"));
				user.setPassword(rs.getString("Password"));
				user.setUserName(rs.getString("UserName"));
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				super.closeResource();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return user;
	}

	@Override
	public List<SysUser> queryUsers() {
		List<SysUser> uls = new ArrayList<>();

		String readSql = "select * from sysuser";

		try {
			rs = super.execQuery(readSql, null);
			while(rs.next()){
				SysUser user = new SysUser();//每次循环new不同的对象放入集合中
				user.setId(rs.getInt("id"));
				user.setNickName(rs.getString("nickName"));
				user.setPassword(rs.getString("password"));
				user.setUserName(rs.getString("userName"));
				uls.add(user);
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return uls;
	}

	@Override
	public SysUser querySysUserById(int id) {
		SysUser user = null;
		List<SysUser> uls = new ArrayList<>();

		String readSql = "select * from sysuser where id=?";
		Object[] paras = {id};
		try {
			rs = super.execQuery(readSql, paras);
			while(rs.next()){
				user = new SysUser();//每次循环new不同的对象放入集合中
				user.setId(rs.getInt("id"));
				user.setNickName(rs.getString("nickName"));
				user.setPassword(rs.getString("password"));
				user.setUserName(rs.getString("userName"));
				uls.add(user);
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return user;
	}

	@Override
	public boolean updateUser(SysUser user) {
		boolean bool = false;
		
		String writeSql = "update sysuser set userName = ?,password=?,nickName=? where id=? ";
		
		Object[] paras = {user.getUserName(),user.getPassword(),user.getNickName(),user.getId()};

		try {
			bool = super.execUpdate(writeSql, paras);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bool;
	}

	@Override
	public boolean addUser(SysUser user) {
		boolean bool = false;
		
		String writeSql = "insert into sysuser values(?,?,?,?)"; 
		Object[] paras = {user.getId(),user.getUserName(),user.getPassword(),user.getNickName()};
		
		try {
			bool = super.execAdd(writeSql, paras);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bool;
	}

	@Override
	public boolean deleteUser(int id) {
		boolean bool = false;
		String writeSql = " delete from sysuser where id = ?"; 
		Object[] paras = {id};
		
		try {
			bool = super.execDelete(writeSql, paras);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return bool;
	}
}
