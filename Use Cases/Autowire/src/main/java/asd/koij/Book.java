package asd.koij;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

public class Book {

	private String name;
	private String author;
	private Cover cover;
	private List list;

	public Book() {
		System.out.println("inside book cons");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	@Override
	public String toString() {
		return "Book [name=" + name + ", author=" + author + ", cover=" + cover
				+ "]";
	}

	public Cover getCover() {
		return cover;
	}

	@Autowired
	public void setCover(Cover cover) {
		this.cover = cover;
	}

}