package com.forge.bean;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;



/**
 * ���ﳵ
 * @author ����
 *
 */
public class Cart {
	//������һ�����ϱ������е���Ʒ//String ���� ��Ʒ��id
	private Map<String,CartItem>map=new LinkedHashMap();
	//������Ʒ���ܼ�
	private double price;
	
	/**
	 * ������Ʒ�ķ���
	 */
	public void addProduct(Forge_Product product){
		//��һ�ι���     ������϶�Ϊnull
		CartItem cartItem=map.get(product.getId());
		if(cartItem==null){//֤�����ﳵ��û���κ���Ʒ
			cartItem=new CartItem();//ʵ����������
			//���û�����������Ʒ�Ž�������
			cartItem.setProduct(product);
			//��Ϊ�Ž����û��������Ʒ������0��Ϊ1
			cartItem.setNum(1);
			//�ѹ�����Ž����ﳵ
			map.put(product.getId(), cartItem);
		}else{
			//������ڸ���Ʒ   ����Ʒ������1
			cartItem.setNum(cartItem.getNum()+1);
		}
		
	}

	public Cart(Map<String, CartItem> map, double price) {
		super();
		this.map = map;
		this.price = price;
	}

	public Cart() {
		super();
	}

	public Map<String, CartItem> getMap() {
		return map;
	}

	public void setMap(Map<String, CartItem> map) {
		this.map = map;
	}
//������Ʒ�ܼ�
	public double getPrice() {
		//��Ʒ���ܼ�
		double totalPrice=0;
		for (Entry<String,CartItem> product : map.entrySet()) {
			CartItem cartItem=product.getValue();
			totalPrice += cartItem.getPrice();
		}
		return totalPrice;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	
	
}
