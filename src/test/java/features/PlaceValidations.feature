Feature: Validating Place API's

@AddPlace
Scenario Outline: Verify if Place is being Successfully added using AddPlaceAPI

Given Add Place Payload with "<name>" "<language>" "<address>"
When user calls "AddPlaceAPI" with "Post" Http Request
Then the API call is success with status code 200
And "status" in response body is "OK"
And verify place_Id created maps to "<name>" using "getPlaceAPI"

Examples:
      | name   | language | address |
      | Randy  | English  | Reading |
      #| Jackson| Tamil    | Slough  |

@DeletePlace
Scenario Outline: Verify if Delete Place functionality is working

Given DeletePlace Payload
When user calls "deletePlaceAPI" with "Post" Http Request
Then the API call is success with status code 200
And "status" in response body is "OK"