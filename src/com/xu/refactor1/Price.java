package com.xu.refactor1;

public abstract class Price {
	public abstract int getPriceCode();
	public abstract double getCharge(int daysRented);
	
	public int getFrequentRentalPoints(int daysRented) {
		return 1;
	}
}

class RegularPrice extends Price{


	@Override
	public int getPriceCode() {
		return Movie.REGULAR;
	}
	
	@Override
	public double getCharge(int daysRented) {
		return 2+(daysRented>2?(daysRented-2)*1.5:0);
	}
	
}

class NewReleasePrice extends Price{

	@Override
	public int getPriceCode() {
		return Movie.NEW_RELEASE;
	}

	
	@Override
	public double getCharge(int daysRented) {
		return daysRented*3;
	}


	
	@Override
	public int getFrequentRentalPoints(int daysRented) {
		return daysRented>1?2:1;
	}
	
	
}

class ChildrenPrice extends Price{

	@Override
	public int getPriceCode() {
		return Movie.CHILDRENS;
	}

	
	@Override
	public double getCharge(int daysRented) {
		return 1.5+(daysRented>3?(daysRented-3)*1.5:0);
	}
	
}
