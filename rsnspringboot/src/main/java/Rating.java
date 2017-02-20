import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Ravdeep Singh on 2/20/2017.
 */
@Entity
@Table(name = "TBL_RATING")
public class Rating implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "rating_id_seq")
    @SequenceGenerator(name = "rating_id_seq", sequenceName = "RATING_ID_SEQ", allocationSize = 100)
    private Integer id;
    private float rating;
    private User userId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }
}
