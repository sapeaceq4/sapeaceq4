package Hibernate.Hib;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@GenericGenerator(name = "generator", strategy = "foreign", parameters = @Parameter(name = "property", value = "book"))
public class Cover {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long imageId;

	@Column
	@GeneratedValue(generator = "generator")
	private long bookIsbnNumber;

	@Column
	private String imageName;

	@OneToOne
	// (mappedBy = "cover")
	private Book book;

	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public long getBookIsbnNumber() {
		return bookIsbnNumber;
	}

	public void setBookIsbnNumber(long bookIsbnNumber) {
		this.bookIsbnNumber = bookIsbnNumber;
	}

	public long getImageId() {
		return imageId;
	}

	public void setImageId(long imageId) {
		this.imageId = imageId;
	}

	@Override
	public String toString() {
		return "Cover [bookIsbnNumber=" + bookIsbnNumber + ", imageName="
				+ imageName + "]";
	}

}
