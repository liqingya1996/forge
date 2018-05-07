package com.forge.util;
import java.io.IOException;
import java.net.InetSocketAddress;
import net.spy.memcached.MemcachedClient;



	/**
	 * 1.�ڵ����а�װָ���汾��memcached
	 * 2.����Ŀ��������Ҫ��jar
	 * 3.�ڹ��߰��д���memcached�Ĺ����� ����service��ʹ��
	 * 4.��service��д���߼� ����
	 * @author ����
	 *
	 */
public class MemcachedUtil {
	//01.˽�л��������
	private static MemcachedUtil util;
	private static MemcachedClient client=null;
	static{
		util=new MemcachedUtil();
		try {
			client=new MemcachedClient(new InetSocketAddress("127.0.0.1", 11211));
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
	//02.˽�л�����
	private MemcachedUtil(){
		
	}
	//03.����������ʵĽӿ�
	public static MemcachedClient getInstance(){
		return client;
	}
}

