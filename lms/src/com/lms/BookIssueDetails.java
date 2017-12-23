package com.lms;

import java.util.Date;


public class BookIssueDetails {
	
	private int bookNumber;
	private String name;
	private int totalBookAllowed = 2;
	private int noOfBookIssued=0;
	private Date issueDate;
	private Date returnDate;
	private int userId;
	private int fine;
	
	public int getFine() {
		return fine;
	}

	public void setFine(int fine) {
		this.fine = fine;
	}

	public BookIssueDetails(int bookNumber,String name,int n,Date issueDate,int userId)
	{
		this.bookNumber=bookNumber;
		this.name=name;
		this.noOfBookIssued=n;
		this.issueDate=issueDate;
		this.userId = userId;
	}

	public BookIssueDetails() {
	}

	public int getBookNumber() {
		return bookNumber;
	}

	public void setBookNumer(int bookNumber) {
		this.bookNumber = bookNumber;
	}

	public int getNoOfBookIssued() {
		return noOfBookIssued;
	}

	public void setNoOfBookIssued(int noOfBookIssued) {
		this.noOfBookIssued = noOfBookIssued;
	}

	public Date getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(Date issueDate) {
		this.issueDate = issueDate;
	}

	public Date getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getTotalBookAllowed() {
		return totalBookAllowed;
	}

	public void setTotalBookAllowed(int totalBookAllowed) {
		this.totalBookAllowed = totalBookAllowed;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	


}
