package stepDefinitions;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.FileNotFoundException;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;
import resources.Utility;
import resources.eCommerceResources;

public class eCommerceImplementation extends Utility {
	
	RequestSpecification reqBuild;
	POJO.LoginRequest login;
	RequestSpecification loginsrequest;
	POJO.LoginResponse loginresponse;
	RequestSpecification createProductReq;
	RequestSpecification createProductRequest;
	POJO.productResponse createProductResponse;
    
	@Given("CreateProduct Payload is Triggered")
	public void create_product_payload_is_triggered() throws FileNotFoundException {
	    
		reqBuild = eCommerceRequestSpecification();
		
		eCommerceResources eComm = new eCommerceResources();
		login = eComm.Logins();
		
		RequestSpecification loginsrequest = given().spec(reqBuild).body(login);
		
		loginresponse = loginsrequest.when().post("/api/ecom/auth/login").then().extract().as(POJO.LoginResponse.class);
		
		
		//token
        System.out.println(loginresponse.getToken());
        //UserID
        System.out.println(loginresponse.getUserId());
        //message
        System.out.println(loginresponse.getMessage());
		
	}
	@When("customer creates order via CreateOrder Payload with Post Https Request")
	public void customer_creates_order_via_create_order_payload_with_post_https_request() throws FileNotFoundException {
		
		
		createProductReq = new RequestSpecBuilder()
	        		.setBaseUri("https://rahulshettyacademy.com")
	        		.addHeader("Authorization", loginresponse.getToken())
	        		.addFilter(RequestLoggingFilter.logRequestTo(JustLog())).addFilter(ResponseLoggingFilter.logResponseTo(JustLog()))
	        		.build();
		
		createProductRequest = given()
		        .spec(createProductReq)
		        .param("productName", "qwerty")
		        .param("productAddedBy", loginresponse.getUserId())
		        .param("productCategory", "fashion")
		        .param("productSubCategory", "shirts")
		        .param("productPrice", "11500")
		        .param("productDescription", "Addidas Originals")
		        .param("productFor", "men")
		        .multiPart("productImage",new File("C:\\Users\\91807\\Downloads\\addidas.png"));
		
		
		
	}
	@Then("the API Status is Success with response {int}")
	public void the_api_status_is_success_with_response(Integer int1) {
		
		//Create POJO class to capture the response
		createProductResponse = createProductRequest.when().post("/api/ecom/product/add-product").then().assertThat().statusCode(201).extract().as(POJO.productResponse.class);
	}
	@Then("{string} product added success response is displayed")
	public void product_added_success_response_is_displayed(String expectedMessage) {
		String actualMessage = createProductResponse.getMessage();
		assertEquals(expectedMessage, actualMessage);
	}

	
	
}
