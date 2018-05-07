package com.forge.service;

import java.io.Serializable;
import java.util.List;



public interface BaseServise<T> {
	/**
	 * ����
	 * @param t
	 * @return
	 */
		void add(T t);
		/**
		 * ɾ��
		 * @param id
		 * @return
		 */
		void delete(Serializable id);
		/**
		 * �޸�
		 * @param t
		 * @return
		 */
		void update(T t);
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
