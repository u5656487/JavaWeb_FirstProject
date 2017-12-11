package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.util01.ConfigUtil;


/**
 * 针对底层数据库访问对象的封装
 * @author Phillip
 */
public class BaseDao {

	private Connection con = null;
	private PreparedStatement psmt = null;
	protected ResultSet rs = null;

	/**
	 * 获得连接
	 */
	private void getConnection() throws ClassNotFoundException, SQLException{
		String driver = ConfigUtil.getProValue("driver");
		String url = ConfigUtil.getProValue("url");
		String jduserName = ConfigUtil.getProValue("userName");
		String jdpwd = ConfigUtil.getProValue("pwd");
		//1.加载驱动
		Class.forName(driver);
		//2.获取连接
		con = DriverManager.getConnection(url,jduserName,jdpwd);
	}

	/**
	 * 关闭资源
	 */
	protected void closeResource() throws SQLException{
		//6.释放资源，后创先释放
		if(rs != null){
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(psmt != null){
			try {
				psmt.close();
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
	 * 查询数据返回结果集
	 * @param readSql 查询sql语句
	 * @param paras 参数列表
	 * @return 结果集
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	protected ResultSet execQuery(String readSql, Object[] paras) 
			throws ClassNotFoundException, SQLException{
		getConnection();
		psmt = con.prepareStatement(readSql);
		//设置参数
		if(paras != null){
			for(int i = 0;i<paras.length;i++){
				psmt.setObject(i+1, paras[i]);
			}
		}
		rs = psmt.executeQuery();
		return rs;
	}

	/**
	 * 更新数据返回布尔类型(增删改)
	 * @param writeSql sql语句
	 * @param paras 参数列表
	 * @return 是否成功
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	protected boolean execUpdate(String writeSql, Object[] paras) 
			throws ClassNotFoundException, SQLException{
		boolean bool = false;
		getConnection();

		psmt = con.prepareStatement(writeSql);

		if(paras != null){
			for(int i = 0;i<paras.length;i++){
				psmt.setObject(i+1, paras[i]);
			}
		}
		int num = psmt.executeUpdate();
		if(num>0){
			bool = true;
		}
		return bool;
	}
	
	/**
	 * 添加数据返回布尔类型(增删改)
	 * @param writeSql sql语句
	 * @param paras 参数列表
	 * @return 是否成功
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	protected boolean execAdd(String writeSql, Object[] paras) 
			throws ClassNotFoundException, SQLException{
		boolean bool = false;
		getConnection();

		psmt = con.prepareStatement(writeSql);

		if(paras != null){
			for(int i = 0;i<paras.length;i++){
				psmt.setObject(i+1, paras[i]);
			}
		}
		int num = psmt.executeUpdate();
		if(num>0){
			bool = true;
		}
		return bool;
	}
	
	/**
	 * 删除数据返回布尔类型(增删改)
	 * @param writeSql sql语句
	 * @param paras 参数列表
	 * @return 是否成功
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	protected boolean execDelete(String writeSql, Object[] paras) 
			throws ClassNotFoundException, SQLException{
		boolean bool = false;
		getConnection();

		psmt = con.prepareStatement(writeSql);

		if(paras != null){
			for(int i = 0;i<paras.length;i++){
				psmt.setObject(i+1, paras[i]);
			}
		}
		int num = psmt.executeUpdate();
		if(num>0){
			bool = true;
		}
		return bool;
	}
}
