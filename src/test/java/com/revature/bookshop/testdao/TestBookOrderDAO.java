package com.revature.bookshop.testdao;

import java.time.LocalDate;

import com.revature.bookshop.dao.BookOrderDAO;
import com.revature.bookshop.model.BookSales;

public class TestBookOrderDAO {
	public static void main(String[] args) {
		
		BookSales bookSales = new BookSales();
		
		bookSales.setSalesID(1001);
		bookSales.setUserID(101);
		bookSales.setIsbn(9788700631625l);
		bookSales.setQuantity(3);
		bookSales.setPrice(250.00);
		bookSales.setTotalAmount(bookSales.getPrice() * bookSales.getQuantity());
		bookSales.setOrderDate(LocalDate.parse("2017-06-06"));
		bookSales.setStatus("Shipped");
		
		BookOrderDAO bookOrderDAO = new BookOrderDAO();
		
		/* User can able to view the available books and place an order */
		try {
			bookOrderDAO.orderBook(bookSales);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		/* User can select the quantity of books */ 
		try {
			bookOrderDAO.selectQuantity(bookSales);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		/* User can cancel the book order */
		try {
			bookOrderDAO.cancelOrder(bookSales);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
