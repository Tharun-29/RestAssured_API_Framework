package resources;

import POJO.*;

public class eCommerceResources {
	//Creating POJO Classes for JSON Body/Payload which we call as Serialization
        
	public LoginRequest Logins() {
		//Creating POJO Classes for JSON Body/Payload which we call as Serialization
				LoginRequest login = new LoginRequest();
				login.setUserEmail("DavidMDiaz@rhyta.com");
				login.setUserPassword("David@54321");
				return login;
	}
	
	public LoginResponse LoginResp() {
		LoginResponse loginResp = new LoginResponse();
		return loginResp;
	}
}
