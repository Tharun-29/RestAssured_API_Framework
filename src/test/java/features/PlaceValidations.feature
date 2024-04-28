Feature: Validating Place API's

Scenario Outline: Verify if Place is being Successfully added using AddPlaceAPI

Given Add Place Payload with "<name>" "<language>" "<address>"
When user calls "AddPlaceAPI" with Post Http Request
Then the API call is success with status code 200
And "status" in response body is "OK"

Examples:
      | name   | language | address |
      | Randy  | English  | Reading |
      | Jackson| Tamil    | Slough  |