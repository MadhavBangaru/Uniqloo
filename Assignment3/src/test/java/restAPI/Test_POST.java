package restAPI;

import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

public class Test_POST {
	
	@DataProvider(name = "DataForTest") 
	public Object[][] dataForTest(){
		return new Object[][] {
			{"foo3","bar3"},
			{"foo4","bar4"}
			
		};
	}

	@Test(dataProvider = "DataForTest")
	public void test_1_post()
	{
		baseURI = "https://postman-echo.com/";
		JSONObject request = new JSONObject();
		
		request.put("foo3","bar3");
		request.put("foo4","bar4");
		
		given().
			body(request.toJSONString()).
		when().
			post("/post").
		then().
			statusCode(200).
			log().all();
		
		
	}
	@Test
	public void test_2_put()
	{
		baseURI = "https://postman-echo.com/";
		JSONObject request = new JSONObject();
		
		request.put("foo3","bar3");
		request.put("foo4","bar4");
		
		given().
			body(request.toJSONString()).
		when().
			put("https://postman-echo.com/put/1").
		then().
			statusCode(201).
			log().all();
		
		
	}
	@Test
	public void test_3_delete()
	{
		baseURI = "https://postman-echo.com/";		
		when().
			put("https://postman-echo.com/").
		then().
			statusCode(200).
			log().all();
		
		
	}
}
