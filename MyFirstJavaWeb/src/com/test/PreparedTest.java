package com.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.entity.SysUser;
import com.util01.ConfigUtil;

public class PreparedTest {
	public static void main(String[] args) {
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
				//创建sql语句，预编译语句Sql中参数用？代替
				String sql ="select * from sysuser where userName = ? and password = ?";
				PreparedStatement pst = con.prepareStatement(sql);
				//设置第一个问号位置的数据
				pst.setString(1, "aaa");
				pst.setString(2, "000");
				
				//用预编译语句查询时，该处不用参数
				rSet = pst.executeQuery();
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
		}
}
