package SpringBoot.Domain;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * 
 * @author asingh
 */
@Entity
public class Rating {
	@Id
	@GeneratedValue
	private Long ratingId;

	private BigDecimal rating;

	private Integer productId;

	private String userId;

	public Rating() {

	}

	public Rating(BigDecimal rating, Integer productId, String userId) {
		super();
		this.rating = rating;
		this.productId = productId;
		this.userId = userId;
	}

	public Long getRatingId() {
		return ratingId;
	}

	public void setRatingId(Long ratingId) {
		this.ratingId = ratingId;
	}

	public BigDecimal getRating() {
		return rating;
	}

	public void setRating(BigDecimal rating) {
		this.rating = rating;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

}
