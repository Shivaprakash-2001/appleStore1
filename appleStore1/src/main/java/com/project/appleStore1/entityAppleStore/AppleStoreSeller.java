package com.project.appleStore1.entityAppleStore;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Apple_Store")
public class AppleStoreSeller {

	// @GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private int ModelNumber;

	private String Product_Name;
	private String Product_Colour;
	private String Prize;
	private int Total_Stocks;
	private int Stocks_Sold;
	private int Available_Stocks;

	public AppleStoreSeller() {

	}

	public AppleStoreSeller(Integer modelNumber, String product_Name, String product_Colour, String prize,
			int total_Stocks, int stocks_Sold, int available_Stocks) {

		ModelNumber = modelNumber;
		Product_Name = product_Name;
		Product_Colour = product_Colour;
		Prize = prize;
		Total_Stocks = total_Stocks;
		Stocks_Sold = stocks_Sold;
		Available_Stocks = available_Stocks;
	}

	@Override
	public String toString() {
		return "AppleStoreSeller [ModelNumber=" + ModelNumber + ", Product_Name=" + Product_Name + ", Product_Colour="
				+ Product_Colour + ", Prize=" + Prize + ", Total_Stocks=" + Total_Stocks + ", Stocks_Sold="
				+ Stocks_Sold + ", Available_Stocks=" + Available_Stocks + "]";
	}

	public Integer getModelNumber() {
		return ModelNumber;
	}

	public void setModelNumber(Integer modelNumber) {
		ModelNumber = modelNumber;
	}

	public String getProduct_Name() {
		return Product_Name;
	}

	public void setProduct_Name(String product_Name) {
		Product_Name = product_Name;
	}

	public String getProduct_Colour() {
		return Product_Colour;
	}

	public void setProduct_Colour(String product_Colour) {
		Product_Colour = product_Colour;
	}

	public String getPrize() {
		return Prize;
	}

	public void setPrize(String prize) {
		Prize = prize;
	}

	public int getTotal_Stocks() {
		return Total_Stocks;
	}

	public void setTotal_Stocks(int total_Stocks) {
		Total_Stocks = total_Stocks;
	}

	public int getStocks_Sold() {
		return Stocks_Sold;
	}

	public void setStocks_Sold(int stocks_Sold) {
		Stocks_Sold = stocks_Sold;
	}

	public int getAvailable_Stocks() {
		return Available_Stocks;
	}

	public void setAvailable_Stocks(int available_Stocks) {
		Available_Stocks = available_Stocks;
	}

}