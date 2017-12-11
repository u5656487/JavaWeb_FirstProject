package com.entity;

/**
 * 数据库中的sysuser用户表（利用该类来中间过渡数据库的每一个数据）
 * @author Alienware
 *
 */
public class SysUser {
	private int id;
	/**
	 * 登陆用户名
	 */
	private String userName;
	/**
	 * 登陆密码
	 */
	private String password;
	/**
	 * 登陆昵称
	 */
	private String nickName;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public SysUser(int id, String userName, String password, String nickName) {
		super();
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.nickName = nickName;
	}
	public SysUser() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
