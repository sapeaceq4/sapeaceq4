package SpringBoot.SpringBoot;

import javax.websocket.server.PathParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController1 {

	@RequestMapping("/hello1")
	public String SayHello() {
		return "akash";
	}

	@RequestMapping("/hello3")
	public String getMessage(@PathParam(value = "id") String id) {
		System.out.println("\n\n " + id);
		return id;
	}
}
