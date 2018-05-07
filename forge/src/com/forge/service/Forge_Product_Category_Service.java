package com.forge.service;

import java.io.Serializable;
import java.util.List;

import com.forge.bean.Cart;
import com.forge.bean.Forge_Product;
import com.forge.bean.Forge_Product_Category;

public interface Forge_Product_Category_Service extends BaseServise<Forge_Product_Category>{
		//��ѯ����һ���˵�
		List<Forge_Product_Category> findAll();
		//��ѯָ����
		Forge_Product_Category findById(Serializable id );
		
		//��ӹ��ﳵ
		void addCart(String id,Cart cart);
		
		//ɾ�����ﳵ
		void delCart(String id,Cart cart);
		//�����˵�
		List<Forge_Product_Category> findAll2(Serializable id);
		//��ѯ���������˵�
		List<Forge_Product_Category> findAll3();
		List<Forge_Product> findByT3(Serializable id);
		
}
