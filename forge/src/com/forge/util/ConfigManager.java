package com.forge.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigManager {
	//01.��������ľ�̬����
	private static ConfigManager manger=new ConfigManager();
	
	private static Properties properties;
	
	//02.˽�л�����
	private ConfigManager(){
		//ʵ����properties����
		properties=new Properties();
	
		InputStream stream=ConfigManager.class.getClassLoader().getResourceAsStream("jdbc.properties");
		//����properties�ļ�
		try {
			properties.load(stream);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
	
	//03.���� �ṩ������ʵĽӿ�
	public static synchronized ConfigManager getInstance(){
		return manger;
	}
	//04.���û�����һ���ļ���key ���Ƿ����ļ��е�value
	public static String getValue(String key){
		return properties.getProperty(key);
	}
}
