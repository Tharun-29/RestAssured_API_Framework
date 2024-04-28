Feature: Create Customer Product in eComm Application

Scenario: Verify Customer is able to Create Product in eComm Application


Given CreateProduct Payload is Triggered
When customer creates order via CreateOrder Payload with Post Https Request
Then the API Status is Success with response 200
And "Product Added Successfully" product added success response is displayed