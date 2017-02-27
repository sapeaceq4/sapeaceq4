package springboot.org.om.product;

import java.net.URL;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

@Ignore
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ProductControllerTest
{
	@LocalServerPort
	private int port;

	private URL base;

	@Autowired
	private TestRestTemplate template;
	
	@Before
    public void setUp() throws Exception {
        this.base = new URL("http://localhost:" + port + "/");
    }
	
	@Test
    public void getHello() throws Exception 
	{
		System.out.println("base.toString()="+ base);
        ResponseEntity<String> response = template.getForEntity(base.toString()+"products",
                String.class);
        
        assertThat(response.getBody(), is("Hello World!"));
    }
}
