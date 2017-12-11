package com.util01;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


public class ConfigUtil {
	private static Properties pro = new Properties();
	static{
		try {
			//创建读取流
			//FileReader fr = new FileReader("src/jdbc.properties");
			//加载配置文件
			InputStream is = ConfigUtil.class.getResourceAsStream("/jdbc.properties");
			pro.load(is);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 通过键获取值
	 * @return 获取到的值
	 */
	public static String getProValue(String a){
		return pro.getProperty(a);
	}
}