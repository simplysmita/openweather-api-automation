package org.openweather.cucumber.steps;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Shared;
import org.openweather.restassured.actions.GetWeatherAction;

import static org.hamcrest.MatcherAssert.assertThat;

public class GetWeatherSteps {
    @Shared
    private GetWeatherAction getWeatherAction;

    @Given("We have the apiKey as {string} to access OpenWeather and we want to fetch the weather of {string}")
    public void weHaveTheApiKeyAsToAccessOpenWeatherAndWeWantToFetchTheWeatherOf(String apiKey, String cityName) {
        getWeatherAction.setApiKeyAndCityNameInQueryParam(apiKey, cityName);
    }

    @When("we send a GET request to GetWeatherByCityName api")
    public void weSendAGETRequestToGetWeatherByCityNameApi() {
        getWeatherAction.invokeWeatherAPIByCityName();
    }

    @Then("API sends {string} as status code in response")
    public void apiSendsAsStatusCodeInResponse(String statusCode) {
        assertThat("Status Code is not matching", getWeatherAction.getStatusCode() == Integer.parseInt(statusCode));
    }

    @And("if status is 200 then Name in response matches {string}")
    public void cityNameInResponseMatches(String cityName) throws JsonProcessingException {
        if (200 == getWeatherAction.getStatusCode()) {
            assertThat("CityName is not matching", cityName.equals(getWeatherAction.getWeatherResponse().getName()));
        }
    }
}
