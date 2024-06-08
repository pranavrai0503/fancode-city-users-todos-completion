
---

# FanCode City Users Todos Completion Test

This project contains a test suite to verify that users from the city "FanCode" have completed more than 50% of their todos tasks.

## Table of Contents

- [Dependencies](#dependencies)
- [Setup](#setup)
- [Running the Tests](#running-the-tests)
- [Test Details](#test-details)
## Dependencies

This project requires the following dependencies:

- Java 8 or higher
- TestNG
- RestAssured
- Jackson Databind

Make sure these dependencies are installed and configured in your development environment before running the tests.

## Setup

1. Clone this repository to your local machine:

   ```bash
   git clone https://github.com/pranavrai0503/fancode-city-users-todos-completion.git
   ```

2. Ensure you have Java and Maven installed on your machine.

3. Add the necessary dependencies (TestNG, RestAssured, Jackson Databind) to your Maven `pom.xml` file.

4. Update the `ApiRequestBuilder` class to set up your base API URL and request specifications as per your project requirements.

## Running the Tests

To run the tests, execute the following command in your terminal from the project root directory:

```bash
mvn test
```

This will run the test suite and display the results in the terminal.

## Test Details

The `FanCodeCityTest` class contains a TestNG test method `testFancodeCityUsersTodosCompletion()` that:

1. Fetches users and todos from the respective API endpoints using RestAssured.
2. Filters users belonging to the "FanCode" city based on the given latitude and longitude criteria.
3. For each user from "FanCode" city, calculates the completion percentage of their todos tasks.
4. Asserts that each user has completed more than 50% of their todos tasks.

---