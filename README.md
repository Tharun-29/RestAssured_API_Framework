# Rest Assured API Framework

Behavioral driven development API Automation Framework using Rest Assured, Cucumber-Java, JUnit, and Maven.

## Tools and Technologies Used

- **Language**: Java
- **Testing Framework**: JUnit
- **BDD Framework**: Cucumber JVM
- **API Testing Tool**: Rest Assured
- **Build Tool**: Maven
- **JSON Parsing**: Jackson Databind
- **Reporting**: Cucumber Reporting
- **CI/CD**: Jenkins

## Features of the Framework

- **BDD Framework**: Using Cucumber-JVM. Feature files can be easily written using Given, When, Then syntax.
- **Dynamic Environment Configuration**: API endpoints and other configurations can be set at runtime from the command line (or Continuous Integration tool, if configured).
- **Automated Tests**: Execute API tests with ease, including setup and teardown processes.
- **Place Validations**: Comprehensive validation of Place API functionalities, including:
  - **Add Place**: Verifies if a place is successfully added using the AddPlaceAPI.
  - **Delete Place**: Verifies if a place is successfully deleted using the DeletePlaceAPI.
  - **Get Place**: Ensures that the added place can be retrieved correctly.
- **HTML Reports**: Generate detailed HTML reports after each test run, accessible in the `target/cucumber-reports` directory.
- **CI/CD Setup**: Integrated with CI/CD pipelines for automated testing and deployment using tools like Jenkins/GitHub Actions.

## Project Structure

### `src/main/java`

- **POJO**: Contains POJO serialization Java class for API request body payload encapsulates the data structure and fields needed for the request, enabling easy conversion to JSON format for transmission.

  ![image](https://github.com/Tharun-29/RestAssured_API_Framework/assets/60356829/23a381e8-a58a-4ae0-9fa6-32c0f36c3e40)


### `src/test/java`

- **features**: Contains all feature files for tests.

  ![image](https://github.com/Tharun-29/RestAssured_API_Framework/assets/60356829/38e391c9-6780-4bb6-ad17-5ad61edc381e)



- **stepDefinitions**: Includes the step definitions that match steps in the feature files.

  ![image](https://github.com/Tharun-29/RestAssured_API_Framework/assets/60356829/a7930e38-9725-471d-a765-05c53a6988a6)


- **Resources**: Contains common Utility classes and methods required by each test to perform actions.
  - **APIResource.java**: is a Enum Class with constants to centralize all resources details.
  - **Utility.java**: is a Utility Class to define all reusable request and response specifications used across the framework.
  - **Global.properties**: is Global property file defined to drive all global variables from properties file.

  ![image](https://github.com/Tharun-29/RestAssured_API_Framework/assets/60356829/1ec8acba-8ed7-4830-9265-9d33d18c4e95)


- **Cucumber.Options**: Contains Test Runner java file/class.
    - **TestRunner.java**: Defines features/tests to be executed and other test configurations.
 
      ![image](https://github.com/Tharun-29/RestAssured_API_Framework/assets/60356829/6090cf3a-f916-4a96-b7b6-8a5ff4a8d566)


## CI/CD Setup

This framework is integrated with Continuous Integration and Continuous Deployment (CI/CD) pipelines using Jenkins.

- **Jenkins**:
  - Configured to run tests automatically / Manually Clicking Build.
  - Generates test reports and notifies the team about the build status.
  - Steps to configure Jenkins:
    1. Install Jenkins on your server.
    2. Install necessary plugins (e.g., Maven, Git).
    3. Create a new Jenkins job and configure the path of Framework Source Code.
   
       ![image](https://github.com/Tharun-29/RestAssured_API_Framework/assets/60356829/9f9c2201-fe44-4af3-8d6c-571022254f99)

    5. Set up the build triggers.
    6. Define the build steps (e.g., `mvn clean test`).
   
       ![image](https://github.com/Tharun-29/RestAssured_API_Framework/assets/60356829/bad713e6-567c-405a-b8a4-65776d066387)
       
    7. Configure Choice Parameters in Jenkins for dynamic test execution.
   
       ![image](https://github.com/Tharun-29/RestAssured_API_Framework/assets/60356829/b04e7235-e511-418a-9242-8c903409cad9)
       

## Demo - 
![API_Automation](https://github.com/Tharun-29/RestAssured_API_Framework/assets/60356829/5d7e46c3-60c9-464d-a1e1-f8d738824155)


## Test Report

After test execution, navigate to the `target/cucumber-reports` folder and open the `feature-overview.html` file to view detailed test results.

![image](https://github.com/Tharun-29/RestAssured_API_Framework/assets/60356829/22a0b08b-3c24-42fd-b5bc-14abff6a896d)
![image](https://github.com/Tharun-29/RestAssured_API_Framework/assets/60356829/1494bb0e-1072-4637-a7ab-23336c460d51)



## Setting Up the Project

1. Install Maven.
2. Clone the repository.

```sh
$ cd RestAssured_API_Framework
$ mvn clean install
$ mvn test

## Run Tests with Specific Tags

### To run multiple scenarios:
$ mvn test -Dcucumber.filter.tags="@AddPlace or @DeletePlace"

