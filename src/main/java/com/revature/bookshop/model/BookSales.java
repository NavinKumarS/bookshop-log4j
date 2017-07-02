package com.revature.bookshop.model;

import java.time.LocalDate;

import org.apache.log4j.Logger;

public class BookSales {
	private static final Logger LOGGER = Logger.getLogger(BookSales.class);
	private int salesID;
	private int userID;
	private long isbn;
	private int quantity;
	private double price;
	private double totalAmount;
	private LocalDate orderDate;
	private String status;
	
	public int getSalesID() {
		return salesID;
	}
	public void setSalesID(int salesID) {
		this.salesID = salesID;
	}
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public long getIsbn() {
		return isbn;
	}
	public void setIsbn(long isbn) {
		this.isbn = isbn;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}
	public LocalDate getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "BookSales [salesID=" + salesID + ", userID=" + userID + ", isbn=" + isbn + ", quantity=" + quantity
				+ ", price=" + price + ", totalAmount=" + totalAmount + ", orderDate=" + orderDate + ", status="
				+ status + "]";
	}
}
