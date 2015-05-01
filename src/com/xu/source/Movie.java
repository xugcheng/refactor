package com.xu.source;

/**
 * 电影对象
 * @author xugc
 *
 */
public class Movie {
	
	public static final int REGULAR = 0;		//常规电影
	public static final int NEW_RELEASE = 1;	//新片
	public static final int CHILDREN_MOVIE = 2;	//儿童片
	
	private String title;	//标题
	private int priceCode;	//价格
	
	public Movie(String title,int priceCode){
		this.title = title;
		this.priceCode = priceCode;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	public String getTitle() {
		return title;
	}
	public void setPriceCode(int priceCdoe) {
		this.priceCode = priceCdoe;
	}
	public int getPriceCode() {
		return priceCode;
	}
	
}
