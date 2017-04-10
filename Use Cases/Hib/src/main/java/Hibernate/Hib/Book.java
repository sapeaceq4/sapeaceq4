package Hibernate.Hib;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long isbnNumber;

	@Column
	private String title;

	@OneToOne(cascade = { CascadeType.ALL }, mappedBy = "book", fetch = FetchType.EAGER)
	//@Fetch(value = org.hibernate.annotations.FetchMode.SELECT)
	private Cover cover;

	public Cover getCover() {
		return cover;
	}

	public void setCover(Cover cover) {
		this.cover = cover;
	}

	public long getIsbnNumber() {
		return isbnNumber;
	}

	public void setIsbnNumber(long isbnNumber) {
		this.isbnNumber = isbnNumber;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String toString() {
		return "Book [isbnNumber=" + isbnNumber + ", title=" + title
				+ ", cover=" + cover + "]";
	}

}