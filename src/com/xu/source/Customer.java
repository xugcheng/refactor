package com.xu.source;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


/**
 * 顾客对象
 * @author xugc
 *
 */
public class Customer {
	
	private String name;
	private List<Rental> rentals = new ArrayList<Rental>();
	
	public Customer(String name){
		this.name = name;
	}
	
	/**
	 * 生成详单
	 */
	public String statement(){
		double totalAmount = 0;
		int frequentRentalPoints = 0;
		Iterator<Rental> rentalIterator = rentals.iterator();
		String result = String.format("Rental record for %s \n",getName());
		while(rentalIterator.hasNext()){
			//租赁费用计算
			double thisAmount = 0;
			Rental rental = rentalIterator.next();
			switch (rental.getMovie().getPriceCode()) {
			case Movie.REGULAR:	//常规片2元,超过2天,超出部分1.5元/天
				thisAmount+=2;
				if(rental.getDaysRented()>2){
					thisAmount+=(rental.getDaysRented()-2)*1.5;
				}
				break;
			case Movie.NEW_RELEASE://新片3元/天
				thisAmount+=rental.getDaysRented()*3;
				break;
			case Movie.CHILDREN_MOVIE://儿童片1.5元,超出3天,超出部分1.5元/天
				thisAmount+=1.5;
				if(rental.getDaysRented()>3){
					thisAmount+=(rental.getDaysRented()-3)*1.5;
				}
				break;
			}
			//积分加1
			frequentRentalPoints++;
			//租新片超过1天,积分加1.
			if(rental.getMovie().getPriceCode()==Movie.NEW_RELEASE && rental.getDaysRented()>1){
				frequentRentalPoints++;
			}
			result+="\t"+rental.getMovie().getTitle()+"\t"+rental.getDaysRented()+"\t"+thisAmount+"\n";
			totalAmount+=thisAmount;
		}
		result+="\t金额:"+totalAmount+"\n";
		result+="\t积分:"+frequentRentalPoints;
		return result;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
	
	public void addRental(Rental rental){
		rentals.add(rental);
	}
	
	public static void main(String args[]){
		Customer customer = new Customer("Jimi");
		customer.addRental(new Rental(new Movie("儿童片", Movie.CHILDREN_MOVIE), 4));
		customer.addRental(new Rental(new Movie("新片", Movie.NEW_RELEASE), 3));
		customer.addRental(new Rental(new Movie("常规片", Movie.REGULAR), 5));
		System.out.println(customer.statement());
	}
	
}
