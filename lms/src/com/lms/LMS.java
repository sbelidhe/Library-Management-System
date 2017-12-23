package com.lms;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class LMS {

	static List<BookDetails> books = new ArrayList<BookDetails>();
	static List<UserDetails> users = new ArrayList<UserDetails>();
	static List<BookIssueDetails> bookIssueDetails = new ArrayList<BookIssueDetails>();
	
	static Map<Integer, List<BookIssueDetails>> hm = new HashMap<Integer, List<BookIssueDetails>>();

	public static void main(String[] args) {
		//addIssueDetails();
		System.out.println("Library Management System");
		System.out.println("Press 1 to add Book");
		System.out.println("Press 2 to add User");
		System.out.println("Press 3 to issue a book");
		System.out.println("Press 4 to return a book");
		System.out.println("Press 5 to print the book details");
		System.out.println("Press 6 to print complete issue detais");
		System.out.println("Press 7 to exit");
		Scanner c = new Scanner(System.in);
		int choice = c.nextInt();
		do {
			switch (choice) {
			case 1:
				addBook();
				break;
			case 2:
				addUser();
				break;
			case 3:
				issueBook();
				break;
			case 4:
				returnBook();
				break;
			case 5:
				printBookDetails();
				break;
			case 6:
				printCompleteIssueDetails();
				break;
			case 7:
				System.exit(0);
			default:
				System.out.println("Invalid input");
				break;
			}
			c = new Scanner(System.in);
			choice = c.nextInt();
		} while (choice > 0 && choice < 7);
	}

	private static void printCompleteIssueDetails() {
		for (Map.Entry<Integer, List<BookIssueDetails>> entry : hm
				.entrySet()) {
			for (BookIssueDetails b : entry.getValue()) {
				System.out.println(entry.getKey() + "  " + b.getBookNumber()
						+ "  " + b.getName() + "  " + b.getNoOfBookIssued()
						+ "  " + b.getIssueDate() + "  " + b.getReturnDate() +
						" " + b.getUserId()+ " " + b.getFine());
			}
		}
	}

	private static void printBookDetails() {
		for (BookDetails b : books) {
			System.out.print(b.getBookNumber() + "  " + b.getBookName() + "  "
					+ b.getCount() + "  " + b.getPrice());
		}
	}

	private static void returnBook() {
		System.out.println("Enter userId & bookId");
		Scanner c = new Scanner(System.in);
		int id = c.nextInt();
		if (!validateUserId(id)) {
			System.out.println("Invalid User Id ! Please enter valid User Id");
		} else {
			int bookId = c.nextInt();
			List<BookIssueDetails> bd = hm.get(id);
			for (BookIssueDetails b : bd) {
				if (b.getBookNumber() == bookId) {
					Date issueDate = b.getIssueDate();
					Date todayDate = new Date();
	
					long diff = todayDate.getTime() - issueDate.getTime();
	
					long diffDays = diff / (24 * 60 * 60 * 1000);
					b.setReturnDate(new Date());
					if (diffDays > 10) {
						int fine = (int) (diffDays - 10);
						fine = fine * 10;
						System.out.println("Total Fine " + fine + " Rs.");
						b.setFine(fine);
					}
				}
			}
			//hm.remove(id);
		}
			//c.close();
	}


	private static void issueBook() {
		System.out.println("Enter userId,Booknumber, name");
		Scanner c = new Scanner(System.in);
		int userId = c.nextInt();
		
		if (!validateUserId(userId)) {
			System.out.println("Invalid User Id ! Please enter valid User Id");
		} else {
	
			int bookNumber = c.nextInt();
			String name = c.next();
			BookIssueDetails newIssuedBook = new BookIssueDetails();
			newIssuedBook.setName(name);
			newIssuedBook.setBookNumer(bookNumber);
			newIssuedBook.setUserId(userId);
			
			
			ArrayList<BookIssueDetails> l=new ArrayList<BookIssueDetails>();
			
	
			//SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
	
				newIssuedBook.setIssueDate(new Date());
	
			
			List<BookIssueDetails> list = hm.get(userId);
			if (list == null) {
				newIssuedBook.setNoOfBookIssued(1);
				bookIssueDetails.add(newIssuedBook);
				hm.put(userId, bookIssueDetails);
			} else {
			for (BookIssueDetails b : list) {
				int value = b.getNoOfBookIssued();
				newIssuedBook.setNoOfBookIssued(++value);
				l.add(newIssuedBook);
				if (value > 2)
					System.out.println("You already issued max(2) books");
				else
					hm.put(userId, l);
			 }
			}
		}
		System.out.println(hm);
		//c.close();
	}
	
	private static boolean validateUserId(int userId) {
		boolean flag=false;
		for (UserDetails u : users) {
			if (u.getUserId() == userId) {
				 flag=true;
			}
		}
		
		return flag;
	}

	private static void addBook() {
		Scanner c = new Scanner(System.in);
		System.out.println("Enter Booknumber ");
		int bookNumber = c.nextInt();
		System.out.println("Enter name Without Spaces");
		String name = c.next();
		System.out.println("Enter price ");
		Double price = c.nextDouble();

		
		BookDetails book = new BookDetails(bookNumber, name, price);
		books.add(book);
		//c.close();

	}
	
	private static void addUser() {
		Scanner c = new Scanner(System.in);
		System.out.println("Enter User Id ");
		int userId = c.nextInt();
		System.out.println("Enter User Name ");
		String userName = c.next();

		
		UserDetails user = new UserDetails(userId, userName);
		users.add(user);
		//c.close();
	}

}