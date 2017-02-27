package springboot.org.om.product.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="TBL_RATING")
public class Rating implements Serializable
{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "rating_id_Sequence")
	@SequenceGenerator(name = "rating_id_Sequence", sequenceName = "RATING_ID_SEQ")
	private long id;
	private float rating;
	private long productId;
	private long userId;

	public Rating(){}
	
	public Rating(long productId, float rating, long userId)
	{
		this.productId = productId;
		this.rating = rating;
		this.userId = userId;
	}

	public void setId(long id)
	{
		this.id = id;
	}
	
	public long getId() 
	{
		return id;
	}

	public float getRating() 
	{
		return rating;
	}

	public long getUserId() 
	{
		return userId;
	}

	public long getProductId() {
		return productId;
	}

	@Override
	public String toString() {
		return "Rating [id=" + id + ", rating=" + rating + ", productId="
				+ productId + ", userId=" + userId + "]";
	}
}
