package com.forge.service;

import java.io.Serializable;
import java.util.List;

import com.forge.bean.Cart;
import com.forge.bean.Forge_Product;

public interface Forge_Product_Service extends BaseServise<Forge_Product> {
	//��ѯ����
	List<Forge_Product> findAll();
	//��ѯָ����
	Forge_Product findById(Serializable id );
	
	//��ӹ��ﳵ
	void addCart(String id,Cart cart);
	
	//ɾ�����ﳵ
	void delCart(String id,Cart cart);
}
