package restAPI;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;


public class Test_GET {

	@Test
	public void test_1()
	{
		given().
			get("https://postman-echo.com/get?foo1=bar1&foo2=bar2").
		then().
			statusCode(200).
			body("args.foo1",equalTo("bar1")).
			log().all();
			
	}
}
