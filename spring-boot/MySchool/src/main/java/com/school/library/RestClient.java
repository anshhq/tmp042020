package com.school.library;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.school.library.model.Book;
import com.school.library.model.Library;

public class RestClient {

	private static final String GET_LIBRARIES_ENDPOINT_URL = "http://localhost:8080/api/v1/libraries";
	private static final String GET_LIBRARY_ENDPOINT_URL = "http://localhost:8080/api/v1/libraries/{id}";
	private static final String CREATE_LIBRARY_ENDPOINT_URL = "http://localhost:8080/api/v1/libraries";
	private static final String UPDATE_LIBRARY_ENDPOINT_URL = "http://localhost:8080/api/v1/libraries/{id}";
	private static final String DELETE_LIBRARY_ENDPOINT_URL = "http://localhost:8080/api/v1/libraries/{id}";

	private static final String GET_BOOKS_ENDPOINT_URL = "http://localhost:8080/api/v1/books";
	private static final String GET_BOOK_ENDPOINT_URL = "http://localhost:8080/api/v1/books/{id}";
	private static final String CREATE_BOOKS_ENDPOINT_URL = "http://localhost:8080/api/v1/books";
	private static final String UPDATE_BOOK_ENDPOINT_URL = "http://localhost:8080/api/v1/books/{id}";
	private static final String DELETE_BOOK_ENDPOINT_URL = "http://localhost:8080/api/v1/books/{id}";

	private static RestTemplate restTemplate = new RestTemplate();

	public static void main(String[] args) {
		RestClient springRestClient = new RestClient();

		springRestClient.createLibrary();
		springRestClient.getLibraries();
		springRestClient.getLibraryById();
		springRestClient.updateLibrary();
		springRestClient.deleteLibrary();

		springRestClient.createBook();
		springRestClient.getBooks();
		springRestClient.getBookById();
		springRestClient.updateBook();
		springRestClient.deleteBook();
	}

	private void createLibrary() {
		Library newLibrary = new Library("admin");

		RestTemplate restTemplate = new RestTemplate();
		Library result = restTemplate.postForObject(CREATE_LIBRARY_ENDPOINT_URL, newLibrary, Library.class);

		System.out.println(result);
	}

	private void getLibraries() {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);

		ResponseEntity<String> result = restTemplate.exchange(GET_LIBRARIES_ENDPOINT_URL, HttpMethod.GET, entity, String.class);
		System.out.println(result);
	}

	private void getLibraryById() {
		Map<String, String> params = new HashMap<String, String>();
		params.put("id", "1");

		RestTemplate restTemplate = new RestTemplate();
		Library result = restTemplate.getForObject(GET_LIBRARY_ENDPOINT_URL, Library.class, params);
		System.out.println(result);
	}

	private void updateLibrary() {
		Map<String, String> params = new HashMap<String, String>();
		params.put("id", "1");
		Library updatedLibrary = new Library("dummy");
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.put(UPDATE_LIBRARY_ENDPOINT_URL, updatedLibrary, params);
	}

	private void deleteLibrary() {
		Map<String, String> params = new HashMap<String, String>();
		params.put("id", "1");
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.delete(DELETE_LIBRARY_ENDPOINT_URL, params);
	}

	private void createBook() {
		Book newBook = new Book("dummy", 1);
		RestTemplate restTemplate = new RestTemplate();
		Book result = restTemplate.postForObject(CREATE_BOOKS_ENDPOINT_URL, newBook, Book.class);
		System.out.println(result);
	}

	private void getBooks() {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
		ResponseEntity<String> result = restTemplate.exchange(GET_BOOKS_ENDPOINT_URL, HttpMethod.GET, entity, String.class);
		System.out.println(result);
	}

	private void getBookById() {
		Map<String, String> params = new HashMap<String, String>();
		params.put("id", "1");

		RestTemplate restTemplate = new RestTemplate();
		Book result = restTemplate.getForObject(GET_BOOK_ENDPOINT_URL, Book.class, params);

		System.out.println(result);
	}

	private void updateBook() {
		Map<String, String> params = new HashMap<String, String>();
		params.put("id", "1");
		Book updatedBook = new Book("dummy", 1);
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.put(UPDATE_BOOK_ENDPOINT_URL, updatedBook, params);
	}

	private void deleteBook() {
		Map<String, String> params = new HashMap<String, String>();
		params.put("id", "1");
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.delete(DELETE_BOOK_ENDPOINT_URL, params);
	}

}