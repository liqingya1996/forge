package com.forge.dao;

import java.io.Serializable;
import java.util.List;

import com.forge.bean.Forge_Product_Category;



/**
 * ���нӿڵĹ����ӿ�
 * @author ����
 *
 */
public interface BaseDao<T> {
/**
 * ����
 * @param t
 * @return
 */
	int add(T t);
	/**
	 * ɾ��
	 * @param id
	 * @return
	 */
	int delete(Serializable id);
	/**
	 * �޸�
	 * @param t
	 * @return
	 */
	int update(T t);
	/**
	 * ��ѯ����
	 * @return
	 */
	List<T>findAll();
	
	/**
	 * ����id��ѯָ������Ϣ
	 * @param id
	 * @return
	 */
	T findById(Serializable id);

}
