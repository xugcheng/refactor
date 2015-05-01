package com.xu.source;

/**
 * 租赁对象,代表一名顾客租赁了一部影片
 * @author xugc
 *
 */
public class Rental {
	private Movie movie;
	private int daysRented;
	
	public Rental(Movie movie,int daysRented){
		this.movie = movie;
		this.daysRented = daysRented;
	}
	
	public void setMovie(Movie movie) {
		this.movie = movie;
	}
	public Movie getMovie() {
		return movie;
	}
	public void setDaysRented(int daysRented) {
		this.daysRented = daysRented;
	}
	public int getDaysRented() {
		return daysRented;
	}
	
	
}
