package com.xu.refactor1;

/**
 * 电影对象
 * @author xugc
 *
 */
public class Movie {
	
	public static final int REGULAR = 0;		//常规电影
	public static final int NEW_RELEASE = 1;	//新片
	public static final int CHILDRENS = 2;	//儿童片
	
	private String title;	//标题
	private Price price;
	
	public Movie(String title,int priceCode){
		this.title = title;
		setPriceCode(priceCode);
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	public String getTitle() {
		return title;
	}
	
	public void setPriceCode(int priceCode) {
		switch (priceCode) {
			case REGULAR:
				price = new RegularPrice();
				break;
			case NEW_RELEASE:
				price = new NewReleasePrice();
				break;
			case CHILDRENS:
				price = new ChildrenPrice();
			default:
				break;
		}
	}
	
	public int getPriceCode() {
		return price.getPriceCode();
	}

	
	/**
	 * 计算租赁费用
	 * @param rental TODO
	 * @return
	 */
	public double getCharge(int daysRented) {
		return price.getCharge(daysRented);
	}

	/**
	 * 计算积分
	 * @param daysRented
	 * @return
	 */
	int getFrequentRentalPoints(int daysRented) {
		return price.getFrequentRentalPoints(daysRented);
	}
	
}
