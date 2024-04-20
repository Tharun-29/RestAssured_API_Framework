package stepDefinitions;

import static io.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;
import POJO.addGoogleMaps;
import POJO.locations;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;


public class stepDefinition {
	
	RequestSpecification res;
	ResponseSpecification respon;
	Response response;
	
	@Given("Add Place Payload")
	public void add_place_payload() {
	   
		RequestSpecification req = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com").addQueryParam("key","qaclick123")
				.setContentType(ContentType.JSON).build();		
				// Creating Payload request details using created POJO Class and methods - by creating object of that class
				
				addGoogleMaps gm = new addGoogleMaps();
				gm.setAccuracy(50);
				gm.setName("David house");
				gm.setPhone_number("(+91) 983 893 3937");
				gm.setAddress("29, side layout, cohen 09");
				gm.setWebsite("http://google.com");
				gm.setLangugae("French-IN");
				
				//Types object
				List<String> list = new ArrayList<String>();
				list.add("shoe park");
				list.add("shop");
				
				gm.setTypes(list);
					
				//Location object
				locations l = new locations(); 
				l.setLat(-38.383494);
				l.setLng(33.427362);
				
				gm.setLocation(l);
				
				// Provide the request spec builder created
				// Provide the addGoogleMaps object input in the body for input request payload
				res = given().spec(req).body(gm);
				
				// Creating object of Response Spec builder
				respon = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
		
	}
	@When("user calls {string} with Post Http Request")
	public void user_calls_with_post_http_request(String string) {
	  response = res.when().post("/maps/api/place/add/json").then().spec(respon).extract().response();
	}
	@Then("the API call is success with status code {int}")
	public void the_api_call_is_success_with_status_code(Integer int1) {
	    
		assertEquals(response.getStatusCode(),200);
	}
	@Then("{string} in response body is {string}")
	public void in_response_body_is_ok(String keyValue,String expectedValue) {
	    String resp = response.asString();
	    JsonPath js = new JsonPath(resp);
	    assertEquals(js.getString(keyValue), expectedValue);
	}


}
