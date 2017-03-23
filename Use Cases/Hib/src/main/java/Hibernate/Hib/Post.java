package Hibernate.Hib;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Post {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String name;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "post", orphanRemoval = true)
	private List<UserComment> UserComments = new ArrayList<UserComment>();

	public void setName(String name) {
		this.name = name;
	}

	public List<UserComment> getUserComments() {
		return UserComments;
	}

	public void addUserComment(UserComment UserComment) {
		UserComments.add(UserComment);
		UserComment.setPost(this);
	}

	public void removeUserComment(UserComment UserComment) {
		UserComment.setPost(null);
		this.UserComments.remove(UserComment);
	}
}
