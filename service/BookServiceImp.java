package com.bookapp.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.bookapp.exception.BookNotFoundException;
import com.bookapp.model.Book;

public class BookServiceImp implements BookService {

	@Override
	public Book getBookById(int bookId) throws BookNotFoundException {
		List<Book> bookList = showBooks();
		for (Book book : bookList) {

			if (book.getBookId() == bookId) {
				return book;
			}
		}

		throw new BookNotFoundException("Invalid Id");

	}

	@Override
	public List<Book> getBooksByAuthor(String author) throws BookNotFoundException {
		// TODO Auto-generated method stub
		List<Book> bookList = showBooks();
		List<Book> bookAuthor = new ArrayList<>();

		boolean flag = false;

		for (Book book : bookList) {
			if (author.equals(book.getAuthor())) {
				bookAuthor.add(book);
				flag = true;
			}

		}

		if (!flag)
			throw new BookNotFoundException("Invalid Author name");

		return bookAuthor;
	}

	@Override
	public List<Book> getBooksByCategory(String category) throws BookNotFoundException {
		List<Book> bookList = showBooks();
		List<Book> bookCategory = new ArrayList<>();

		boolean flag = false;

		for (Book book : bookList) {
			if (category.equals(book.getCategory())) {
				bookCategory.add(book);
				flag = true;
			}

		}

		if (!flag)
			throw new BookNotFoundException("Invalid Book Category");

		return bookCategory;
	}

	@Override
	public List<Book> getBooksByLessPrice(double price) throws BookNotFoundException {
		List<Book> bookList = showBooks();
		List<Book> bookPrice = new ArrayList<>();

		boolean flag = false;
		for (Book book : bookList) {
			if (price > book.getPrice()) {
				bookPrice.add(book);
				flag = true;

			}
		}
		if (!flag)
			throw new BookNotFoundException("No results");

		return bookPrice;
	}

	@Override
	public List<Book> getAllBooks() throws BookNotFoundException {
		// TODO Auto-generated method stub
		return showBooks();
	}

	private List<Book> showBooks() {
		return Arrays.asList(new Book("Java in Action", "Kathy", "Tech", 1900, 1),
				new Book("5AM club", "Robin", "Self", 400, 2),
				new Book("Captain Robin Hook", "Hal", "Children", 800, 3),
				new Book("Pooh tales", "Kathy", "Children", 700, 4), new Book("Jee", "Kathy", "Tech", 1200, 5),
				new Book("Leadership", "Robin", "self", 1900, 6));

	}

}
