# OpenWeather API Automation Suite using Cucumber and RestAssured

Purpose:
--------
This is the automation suite for OpenWeather API. I have automated the Get Weather Data By CityName.

Following Test scenarios have been covered for this api.

```gherkin
Feature: Get Weather

  Scenario Outline: Get Weather By CityName
    Given We have the apiKey as "<apiKey>" to access OpenWeather and we want to fetch the weather of "<cityName>"
    When we send a GET request to GetWeatherByCityName api
    Then API sends "<statusCode>" as status code in response
    And if status is 200 then Name in response matches "<cityName>"
    Examples:
      | scenarioName     | apiKey                           | cityName  | statusCode |
      | Success          | c4c876061b4c655c1afc20cb19f2f5d3 | Bengaluru | 200        |
      | Success          | c4c876061b4c655c1afc20cb19f2f5d3 | Chennai   | 200        |
      | Invalid API Key  | c4c876061b4c655c1afc20cb19f2f5d  | Bengaluru | 401        |
      | Invalid City     | c4c876061b4c655c1afc20cb19f2f5d3 | Bengalur  | 404        |
      | Missing CityName | c4c876061b4c655c1afc20cb19f2f5d3 |           | 400        |
      | Missing API Key  |                                  | Bengaluru | 401        |

```

Prerequisites:
---------------

* Java 8 or higher
* Apache Maven 3 or higher
* IDE(Eclipse or Intellij) With Java 8 or higher

Execution From CommandLine:
---------------------------

* Clone the repository.
* Open command prompt and navigate to root directory.
* run the command "**mvn clean verify**"
* The Serenity reports can be found in "**target/site/serenity/index.html**"

Execution From IDE:
---------------------------

* Clone the repository to your local workspace.
* Open the project as a Maven project in your IDE.
* Run the Maven command "**clean verify**"
* The Serenity reports can be found in "**target/site/serenity/index.html**"