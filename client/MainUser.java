package com.bookapp.client;

import java.util.Scanner;
import com.bookapp.exception.BookNotFoundException;
import com.bookapp.service.BookService;
import com.bookapp.service.BookServiceImp;

public class MainUser {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		BookService bookService = new BookServiceImp();
		System.out.println("Enter Your Choice to Search!");
		System.out.println("1.Book ID \n2.Author Name\n3.Category\n4.Price");
		int n = sc.nextInt();
		switch (n) {
		case 1:
			System.out.println("Enter Book ID");
			int id = sc.nextInt();
			try {
				System.out.println(bookService.getBookById(id));
			} catch (BookNotFoundException e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());

			}
			break;
		case 2:
			System.out.println("Enter Author Name");
			String name = sc.next();

			try {
				bookService.getBooksByAuthor(name);
				System.out.println(bookService.getAllBooks());
			} catch (BookNotFoundException e1) {
				// TODO Auto-generated catch block
				System.out.println(e1.getMessage());

			}
			break;
		case 3:
			System.out.println("Enter Category");
			String category = sc.next();
			try {
				bookService.getBooksByCategory(category);
				System.out.println(bookService.getAllBooks());
			} catch (BookNotFoundException e1) {
				// TODO Auto-generated catch block
				System.out.println(e1.getMessage());

			}
			break;
		case 4:
			System.out.println("Enter Price");
			double price = sc.nextDouble();
			try {
				System.out.println(bookService.getBooksByLessPrice(price));

			} catch (BookNotFoundException e1) {
				// TODO Auto-generated catch block
				System.out.println(e1.getMessage());

			}
			break;
		}
		sc.close();
	}

}
