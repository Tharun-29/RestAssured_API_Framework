Feature: Validating Place API's

Scenario: Verify if Place is being Successfully added using AddPlaceAPI

Given Add Place Payload
When user calls "AddPlaceAPI" with Post Http Request
Then the API call is success with status code 200
And "status" in response body is "OK"