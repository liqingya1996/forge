package com.forge.dao;

import java.io.Serializable;
import java.util.List;

import com.forge.bean.Forge_Product;
import com.forge.bean.Forge_Product_Category;

public interface Forge_Product_Category_Dao extends BaseDao<Forge_Product_Category> {
	//��ѯ����
	List<Forge_Product_Category>findAll();
	//��ѯ���еĶ����˵�
	List<Forge_Product_Category>findAll2(Serializable id);
	//�����˵�
	List<Forge_Product_Category>findAll3();
	List<Forge_Product> findByT3(Serializable id);
	
}
