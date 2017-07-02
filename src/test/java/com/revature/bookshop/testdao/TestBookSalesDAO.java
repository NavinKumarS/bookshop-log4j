package com.revature.bookshop.testdao;

import java.time.LocalDate;

import com.revature.bookshop.dao.BookSalesDAO;

public class TestBookSalesDAO {
	public static void main(String[] args) {
		
		LocalDate searchDate = LocalDate.parse("2017-06-06");
		
		BookSalesDAO bookSalesDAO = new BookSalesDAO();
		
		/* Author can able to view- how many books sold */
		/* Weekly */
		try {
			bookSalesDAO.bookSalesWeekly(searchDate);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		/* Author can able to view- how many books sold */
		/* Monthly */
		try {
			bookSalesDAO.bookSalesMonthly(searchDate);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		/* Author can able to view- how many books sold */
		/* Yearly */
		try {
			bookSalesDAO.bookSalesYearly(searchDate);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
