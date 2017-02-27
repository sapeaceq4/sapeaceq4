package springboot.org.om.product.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Formula;
import org.springframework.data.annotation.Transient;

@Entity
@Table(name="TBL_PRODUCT")
public class Product implements Serializable
{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "product_id_Sequence")
	@SequenceGenerator(name = "product_id_Sequence", sequenceName = "PRODUCT_ID_SEQ")
	private long id;
	private String pname;
	private int psize;
	private String pcolor;
	@Transient
	@Formula("(SELECT AVG(r.rating) FROM TBL_RATING r WHERE r.product_id = id)")
	private double paverageRating;

	public Product(){}
	public Product(String name, int size, String color, float averageRating)
	{
		this.pname = name;
		this.psize = size;
		this.pcolor = color;
		this.paverageRating = averageRating;
	}
	public long getId() {
		return id;
	}
	public String getPname() {
		return pname;
	}
	public int getPsize() {
		return psize;
	}
	public String getPcolor() {
		return pcolor;
	}
	public double getPaverageRating() {
		return paverageRating;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	@Override
	public String toString() {
		return "Product [id=" + id + ", pname=" + pname + ", psize=" + psize
				+ ", pcolor=" + pcolor + ", paverageRating=" + paverageRating
				+ "]";
	}
}
