package com.forge.bean;

import java.io.Serializable;
import java.sql.Date;

/**
*@Descrptionforge_product实体类
*/ 


public class Forge_Product  implements Serializable{
	private int id;
	private String name;
	private String description;
	private double price;
	private int stock;
	private int categoryLevel1;
	private int categoryLevel2;
	private String categoryLevel3;
	private String fileName;
	private int isDelete;
	private int score;
	public Forge_Product(){
		
	}
	public Forge_Product(int id,String name,String description,double price,int stock,int categoryLevel1,int categoryLevel2,String categoryLevel3,String fileName,int isDelete,int score){
	super();
	this. id=id;
	this. name=name;
	this. description=description;
	this. price=price;
	this. stock=stock;
	this. categoryLevel1=categoryLevel1;
	this. categoryLevel2=categoryLevel2;
	this. categoryLevel3=categoryLevel3;
	this. fileName=fileName;
	this. isDelete=isDelete;
	this. score=score;
}
	public void setId(int id){
	this.id=id;
	}
	public int getId(){
		return id;
	}
	public void setName(String name){
	this.name=name;
	}
	public String getName(){
		return name;
	}
	public void setDescription(String description){
	this.description=description;
	}
	public String getDescription(){
		return description;
	}
	public void setPrice(double price){
	this.price=price;
	}
	public double getPrice(){
		return price;
	}
	public void setStock(int stock){
	this.stock=stock;
	}
	public int getStock(){
		return stock;
	}
	public void setCategoryLevel1(int categoryLevel1){
	this.categoryLevel1=categoryLevel1;
	}
	public int getCategoryLevel1(){
		return categoryLevel1;
	}
	public void setCategoryLevel2(int categoryLevel2){
	this.categoryLevel2=categoryLevel2;
	}
	public int getCategoryLevel2(){
		return categoryLevel2;
	}
	public void setCategoryLevel3(String categoryLevel3){
	this.categoryLevel3=categoryLevel3;
	}
	public String getCategoryLevel3(){
		return categoryLevel3;
	}
	public void setFileName(String fileName){
	this.fileName=fileName;
	}
	public String getFileName(){
		return fileName;
	}
	public void setIsDelete(int isDelete){
	this.isDelete=isDelete;
	}
	public int getIsDelete(){
		return isDelete;
	}
	public void setScore(int score){
	this.score=score;
	}
	public int getScore(){
		return score;
	}
	@Override
	public String toString() {
		return "Forge_Product [id=" + id + ", name=" + name + ", description="
				+ description + ", price=" + price + ", stock=" + stock
				+ ", categoryLevel1=" + categoryLevel1 + ", categoryLevel2="
				+ categoryLevel2 + ", categoryLevel3=" + categoryLevel3
				+ ", fileName=" + fileName + ", isDelete=" + isDelete
				+ ", score=" + score + "]";
	}
	
}

