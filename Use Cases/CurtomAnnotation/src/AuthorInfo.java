import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.CLASS)
@Target({ ElementType.TYPE })
@interface AuthorInfo {
	public String authorName();
	public String emailId();
	public String empType() default "permament";
}