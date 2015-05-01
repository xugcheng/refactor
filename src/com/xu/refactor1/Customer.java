package com.xu.refactor1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


/**
 * 顾客对象
 * @author xugc
 *
 */
public class Customer {
	
	public static void main(String args[]){
		Customer customer = new Customer("Jimi");
		customer.addRental(new Rental(new Movie("儿童片", Movie.CHILDRENS), 4));
		customer.addRental(new Rental(new Movie("新片", Movie.NEW_RELEASE), 3));
		customer.addRental(new Rental(new Movie("常规片", Movie.REGULAR), 5));
		System.out.println(customer.statement());
		System.out.println(customer.htmlStatement());
	}
	
	private String name;
	
	private List<Rental> rentals = new ArrayList<Rental>();
	
	public Customer(String name){
		this.name = name;
	}
	
	public void addRental(Rental rental){
		rentals.add(rental);
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * 生成详单
	 */
	public String statement(){
		Iterator<Rental> rentalIterator = rentals.iterator();
		String result = String.format("Rental record for %s \n",getName());
		while(rentalIterator.hasNext()){
			Rental rental = rentalIterator.next();
			result+="\t"+rental.getMovie().getTitle()+"\t"+rental.getDaysRented()+"\t"+rental.getCharge()+"\n";
		}
		result+="\t金额:"+getTotalCharge()+"\n";
		result+="\t积分:"+getTotalFrequentRentalPoints();
		return result;
	}
	
	/**
	 * 计算总租赁费用
	 * @return
	 */
	public double getTotalCharge(){
		double result = 0;
		Iterator<Rental> iterator = rentals.iterator();
		while(iterator.hasNext()){
			Rental rental = iterator.next();
			result += rental.getCharge();
		}
		return result;
	}
	
	/**
	 * 计算总积分
	 * @return
	 */
	public int getTotalFrequentRentalPoints(){
		int result = 0;
		Iterator<Rental> iterator = rentals.iterator();
		while(iterator.hasNext()){
			Rental rental = iterator.next();
			result += rental.getFrequentRentalPoints();
		}
		return result;
	}
	
	public String htmlStatement(){
		Iterator<Rental> iterator = rentals.iterator();
		String result = String.format("<h1>Rental Record for %s</h1>\n",getName());
		while(iterator.hasNext()){
			Rental rental = iterator.next();
			result+=String.format("<div>\t%s\t%s\t%s</div>\n", rental.getMovie().getTitle(),rental.getDaysRented(),rental.getCharge());
		}
		result+=String.format("<p>\t金额:%s</>\n", getTotalCharge());
		result+=String.format("<p>\t积分:%s</p>", getTotalFrequentRentalPoints());
		return result;
	}
	
}
