package resources;

import java.util.ArrayList;
import java.util.List;

import POJO.addGoogleMaps;
import POJO.locations;

public class TestDataBuilds{
       
	/*
	 * Created a Package for Common Test data methods
	 * addGoogleMaps method is will provide details to place(i.e payload) as input for API to trigger
	 */
	// Creating Payload request details using created POJO Class and methods - by creating object of that class
	public addGoogleMaps addPlacePayload(String name, String language, String address) {
		addGoogleMaps gm = new addGoogleMaps();
		gm.setAccuracy(50);
		gm.setName(name);
		gm.setPhone_number("(+91) 983 893 3937");
		gm.setAddress(address);
		gm.setWebsite("http://google.com");
		gm.setLangugae(language);
		
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
		return gm;
	}
	
	public String deletePlacePayload(String placeId) {
		return "{\r\n"
				+ "    \"place_id\":\""+placeId+"\"\r\n"
				+ "}\r\n"
				+ "";
	}
	
}
