package com.forge.dao;

import java.io.Serializable;
import java.util.List;

import com.forge.bean.Forge_Product;

public interface Forge_Product_Dao extends BaseDao<Forge_Product> {
	//��ѯ����
	List<Forge_Product>findAll();
	//ָ����ѯ 
	Forge_Product findById(Serializable id);
}
