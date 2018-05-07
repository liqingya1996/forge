package com.forge.service_impl;

import java.io.Serializable;
import java.util.List;

import org.apache.log4j.Logger;

import com.forge.bean.Forge_News;
import com.forge.dao.Forge_News_Dao;
import com.forge.dao_impl.Forge_News_Dao_Impl;
import com.forge.service.Forge_News_Service;



public class Forge_News_Service_Impl implements Forge_News_Service {
	//����ʵ��
	Forge_News_Dao dao=new Forge_News_Dao_Impl();
		//����Logger����
		Logger logger=Logger.getLogger(Forge_News_Service_Impl.class);
		@Override
		public void add(Forge_News t) {
			int rowNum = dao.add(t);
			if(rowNum>0){
				logger.info("�����ɹ�");
			}else{
				logger.info("����ʧ��");
			}
			
		}

		@Override
		public void delete(Serializable id) {
			int rowNum = dao.delete(id);
			if(rowNum>0){
				logger.info("ɾ���ɹ�");
			}else{
				logger.info("ɾ��ʧ��");
			}
			
		}

		@Override
		public void update(Forge_News t) {
			int rowNum = dao.add(t);
			if(rowNum>0){
				logger.info("�޸ĳɹ�");
			}else{
				logger.info("�޸�ʧ��");
			}
			
		}

		@Override
		public List<Forge_News> findAll() {
			
			return dao.findAll();
		}

		@Override
		public Forge_News findById(Serializable id) {
			
			return dao.findById(id);
		}

}
