Feature: Get Weather

  Scenario Outline: Get Weather By CityName
    Given We have the apiKey as "<apiKey>" to access OpenWeather and we want to fetch the weather of "<cityName>"
    When we send a GET request to GetWeatherByCityName api
    Then API sends "<statusCode>" as status code in response
    And if status is 200 then Name in response matches "<cityName>"
    Examples:
      | apiKey                           | cityName  | statusCode |
      | c4c876061b4c655c1afc20cb19f2f5d3 | Bengaluru | 200        |
      | c4c876061b4c655c1afc20cb19f2f5d3 | Chennai   | 200        |
      | c4c876061b4c655c1afc20cb19f2f5d  | Bengaluru | 401        |
      | c4c876061b4c655c1afc20cb19f2f5d3 | Bengalur  | 404        |
      | c4c876061b4c655c1afc20cb19f2f5d3 |           | 400        |
      |                                  | Bengaluru | 401        |