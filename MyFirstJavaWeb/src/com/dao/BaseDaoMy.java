package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.util01.ConfigUtil;

public class BaseDaoMy {
	//定义mySQL驱动、连接数据库、用户名、密码
	private Connection con = null;//连接
	private PreparedStatement pst = null;
	protected ResultSet rs = null;//查询返回的结果集
	/**
	 * 获取连接方法
	 * @return
	 * @throws ClassNotFoundException 
	 * @throws SQLException 
	 */
	private Connection getConn() throws ClassNotFoundException, SQLException{
		String driver = ConfigUtil.getProValue("driver");
		String url = ConfigUtil.getProValue("url");
		String jduserName = ConfigUtil.getProValue("userName");
		String jdpwd = ConfigUtil.getProValue("pwd");
		//1.加载驱动
		Class.forName(driver);
		//2.获取连接
		con = DriverManager.getConnection(url,jduserName,jdpwd);

		return con;
	}

	protected void closeRsource(){
		if(rs != null){
			try {
				rs.close();
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

	/**
	 * 公用查询方法
	 * 返回值：ResultSet
	 * 		sql语句		参数列表
	 * 参数：String sql,Object[] params
	 * @return
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	protected ResultSet exceQuery(String readSql,Object[] params) throws ClassNotFoundException, SQLException{
		//获取连接
		getConn();
		pst = con.prepareStatement(readSql);

		//设置参数
		if(params != null){
			for(int i = 0;i<params.length;i++){
				pst.setObject(i+1, params[i]);
			}
		}
		pst.executeQuery();
		return rs;
	}


	/**
	 * 公用增删改方法
	 * 返回值：boolean
	 * 参数：String sql,Object[] params
	 * @throws Exception 
	 * @throws ClassNotFoundException 
	 */
	public boolean exceUpdate(String writeSql,Object[] params) throws ClassNotFoundException, Exception{
		boolean bool = false;
		getConn();

		pst = con.prepareStatement(writeSql);

		if(params != null){
			for(int i = 0;i<params.length;i++){
				pst.setObject(i+1, params[i]);
			}
		}
		int num = pst.executeUpdate();
		if(num>0){
			bool = true;
		}
		return bool;
	}
}
