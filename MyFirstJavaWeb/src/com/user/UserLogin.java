package com.user;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.entity.SysUser;
import com.util01.ConfigUtil;

public class UserLogin {
	//数据库种所有的表都要在java中有对应的实体类
	/**
	 * 登陆
	 * select * from sysuser 
	 * where userName='aaa' 
	 * and 'password'='000'
	 * 
	 * 返回值：SysUser
	 * 参数：String userName，String pwd
	 * @return
	 */
	public SysUser Login(String userName,String pwd){
		//1.返回值是什么就声明什么对象
		SysUser user = null;
		//定义mySQL驱动、连接数据库、用户名、密码
		Connection con = null;//连接
//		Statement stm = null;//SQL语句
		PreparedStatement pst = null;
		ResultSet rSet = null;//查询返回的结果集
		String driver = ConfigUtil.getProValue("driver");
		String url = ConfigUtil.getProValue("url");
		String jduserName = ConfigUtil.getProValue("userName");
		String jdpwd = ConfigUtil.getProValue("pwd");
		try {
			//1.加载驱动
			Class.forName(driver);
			//2.获取连接
			con = DriverManager.getConnection(url,jduserName,jdpwd);
			//3.创建执行SQL语句
			
			String sql ="select * from sysuser " //注意拼接之间的空格是否缺失!!!!!!!!!!!!
					+ "WHERE userName=? and password = ?";
			pst= con.prepareStatement(sql);
			pst.setString(1, userName);
			pst.setString(2, pwd);
			
			//4.执行方法将查询结果返回给结果集对象,返回受影响函数
			rSet = pst.executeQuery();
			//5.循环输出数据库内容
			while(rSet.next()){
				user = new SysUser();
				user.setId(rSet.getInt("id"));
				user.setNickName(rSet.getString("NickName"));
				user.setPassword(rSet.getString("Password"));
				user.setUserName(rSet.getString("UserName"));
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			//6.释放资源，后创先释放
			if(rSet != null){
				try {
					rSet.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(pst != null){
				try {
					pst.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(con != null){
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}	


		return user;
	}

	public ArrayList queryUsers(){
		ArrayList<SysUser> userInfors = new ArrayList<SysUser>();
		//1.返回值是什么就声明什么对象
		SysUser user = null;
		//定义mySQL驱动、连接数据库、用户名、密码
		Connection con = null;//连接
		Statement stm = null;//SQL语句
		ResultSet rSet = null;//查询返回的结果集
		String driver = ConfigUtil.getProValue("driver");
		String url = ConfigUtil.getProValue("url");
		String jduserName = ConfigUtil.getProValue("userName");
		String jdpwd = ConfigUtil.getProValue("pwd");

		try {
			//加载驱动
			Class.forName(driver);
			//获取连接
			con = DriverManager.getConnection(url, jduserName, jdpwd);
			//创建sql语句
			stm = con.createStatement();
			String sql ="select * from sysuser";
			//将sql语句放入结果集
			rSet = stm.executeQuery(sql);
			while(rSet.next()){
				user = new SysUser();//每次循环new不同的对象放入集合中
				user.setId(rSet.getInt("id"));
				user.setNickName(rSet.getString("nickName"));
				user.setPassword(rSet.getString("password"));
				user.setUserName(rSet.getString("userName"));
				userInfors.add(user);
			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			//6.释放资源，后创先释放
			if(rSet != null){
				try {
					rSet.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(stm != null){
				try {
					stm.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(con != null){
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		//返回集合
		return userInfors;
	}
	@Test
	public void testLogin(){
		String userName = "aaa";
		String pwd = "000";

		SysUser user = Login(userName, pwd);
		if(user != null){
			System.out.println("登陆成功");
		}else{
			System.out.println("登陆失败");
		}

	}

}
