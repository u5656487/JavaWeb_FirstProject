package com.dao;

import java.util.List;

import com.entity.SysUser;

public interface UserDao {
	
	/**
	 * 登录
	 * 		select * from sysuser where userName = ? and password = ?
	 * 返回值   Sysuser
	 * 参数   String userName,String password
	 */
	
	public SysUser login(String userName,String pwd);
	
	/**
	 * 查询所有用户
	 * 			select * from sysuser
	 * 返回值  List<SysUser>
	 * 参数 无
	 */
	public List<SysUser> queryUsers();
	
	/**
	 * 根据id查询用户数据
	 * 		select * from sysuser where id = ?
	 * 返回值：SysUser
	 * 参数： int id
	 */
	public SysUser querySysUserById(int id);
	
	/**
	 * 修改用户数据
	 * 		update sysuser set userName = ?,password=?,nickName=? where id=?
	 * 返回值：boolean
	 * 参数：SysUser user
	 */
	public boolean updateUser(SysUser user);
	
	/**
	 * 添加用户数据
	 * 		insert into sysuser values(?,?,?,?);
	 * 返回值：boolean
	 * 参数：SysUser user
	 */
	public boolean addUser(SysUser user);
	
	/**
	 * 删除用户数据
	 * 		delete from sysuser where id = ?
	 * 返回值：boolean
	 * 参数：int id
	 */
	public boolean deleteUser(int id);
}
