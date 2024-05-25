package stepDefinitions;

import io.cucumber.java.Before;

import java.io.IOException;


public class Hooks {

	@Before ("@DeletePlace")
	public void beforeScenario() throws IOException {
		// execute this code only when place id is null
		// write a code that will give you place id

		stepDefinition m = new stepDefinition();
		if (m.place_id == null) {
			m.add_place_payload_with("Dravid", "chinese", "china");
			m.user_calls_with_http_request("AddPlaceAPI", "POST");
			m.verify_place_id_created_maps_to_using("Dravid", "getPlaceAPI");

		}
	}

}
