package springboot.org.om.product.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="TBL_USER")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class User implements Serializable
{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "user_id_Sequence")
	@SequenceGenerator(name = "user_id_Sequence", sequenceName = "USER_ID_SEQ")
	private long userId;
	private String firstName;
	private String lastName;
	private String city;

	public User(){}
	public User(String firstName, String lastName, String city)
	{
		this.firstName = firstName;
		this.lastName = lastName;
		this.city = city;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}
	
	public long getUserId() {
		return userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getCity() {
		return city;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", city=" + city + "]";
	}
}
