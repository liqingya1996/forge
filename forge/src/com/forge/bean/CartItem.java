package com.forge.bean;
/**
 * ��������ﳵ�е����ݣ�
 * @author ����
 *
 */
public class CartItem {
private Forge_Product product;//��Ʒ
private int num;//����
private double price;//��Ʒ���ܼ�
@Override
public String toString() {
	return "CartItem [product=" + product + ", num=" + num + ", price=" + price
			+ "]";
}
public CartItem() {
	super();
}
public CartItem(Forge_Product product, int num, double price) {
	super();
	this.product = product;
	this.num = num;
	this.price = price;
}
public Forge_Product getProduct() {
	return product;
}
public void setProduct(Forge_Product product) {
	this.product = product;
}
public int getNum() {
	return num;
}
public void setNum(int num) {
	this.num = num;
}
//��Ʒ���ܼ۸�  ��Ʒ�ĵ���*����  ���ظ��ܼ۸�
public double getPrice() {
	return product.getPrice()*num;
}
public void setPrice(double price) {
	this.price = price;
}
}
