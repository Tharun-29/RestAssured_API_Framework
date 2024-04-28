package resources;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class Utility{
	RequestSpecification req;
	RequestSpecification reqBuild;

	public RequestSpecification requestSpecification() throws IOException {
		PrintStream log = new PrintStream(new FileOutputStream("Logging.txt"));

		//.addFilter(RequestLoggingFilter.logRequestTo(null)) - The stream to log the request to (Collect all logs)
		
		
		req = new RequestSpecBuilder().setBaseUri(getGlobalValue("baseUrl")).addQueryParam("key", "qaclick123")
		.addFilter(RequestLoggingFilter.logRequestTo(log)).addFilter(ResponseLoggingFilter.logResponseTo(log)) // Implementation of Logs
	    .setContentType(ContentType.JSON).build();

		return req;
	}
	
	public String getGlobalValue(String key) throws IOException {
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream("C:\\Users\\91807\\eclipse-workspace\\APIFramework\\src\\test\\java\\resources\\global.properties");
	    prop.load(fis);
	    String Target = prop.getProperty(key);
	    return Target;   
	 
	
	}
	
	
	public RequestSpecification eCommerceRequestSpecification() throws FileNotFoundException {
		PrintStream log = new PrintStream(new FileOutputStream("Logging2.txt"));
		
		
		//.addFilter(RequestLoggingFilter.logRequestTo(null)) - The stream to log the request to (Collect all logs)
		reqBuild = new RequestSpecBuilder()
				.setBaseUri("https://rahulshettyacademy.com")
				.addFilter(RequestLoggingFilter.logRequestTo(log)).addFilter(ResponseLoggingFilter.logResponseTo(log))
				.setContentType(ContentType.JSON)
				.build();
		
		return reqBuild;
	}
	
	
	public PrintStream JustLog() throws FileNotFoundException {
		PrintStream log = new PrintStream(new FileOutputStream("Logging3.txt"));
	    return log;
	}
	
	
	

}
