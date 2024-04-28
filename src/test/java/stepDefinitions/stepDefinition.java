package stepDefinitions;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

import java.io.FileNotFoundException;
import java.io.IOException;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import resources.TestDataBuilds;
import resources.Utility;

public class stepDefinition extends Utility {

	RequestSpecification res;
	ResponseSpecification respon;
	Response response;
	TestDataBuilds data = new TestDataBuilds();
	
	@Given("Add Place Payload with {string} {string} {string}")
	public void add_place_payload_with(String name, String language, String address) throws IOException {
	    
		// Provide the request spec builder created
	   // Provide the addGoogleMaps object input in the body for input request payload
	   res = given().spec(requestSpecification()).body(data.addPlacePayload(name, language, address));
		
	}



	@When("user calls {string} with Post Http Request")
	public void user_calls_with_post_http_request(String string) {

		// Creating object of Response Spec builder
		respon = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();

		response = res.when().post("/maps/api/place/add/json").then().spec(respon).extract().response();
	}

	@Then("the API call is success with status code {int}")
	public void the_api_call_is_success_with_status_code(Integer int1) {

		assertEquals(response.getStatusCode(), 200);
	}

	@Then("{string} in response body is {string}")
	public void in_response_body_is_ok(String keyValue, String expectedValue) {
		String resp = response.asString();
		JsonPath js = new JsonPath(resp);
		assertEquals(js.getString(keyValue), expectedValue);
	}

}
