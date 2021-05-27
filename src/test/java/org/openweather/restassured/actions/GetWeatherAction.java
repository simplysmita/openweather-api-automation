package org.openweather.restassured.actions;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.apache.commons.lang3.StringUtils;
import org.openweather.model.WeatherResponse;
import org.openweather.util.EnvironmentSelector;

import java.util.HashMap;
import java.util.Map;

public class GetWeatherAction {

    private Map<String, String> queryParams;
    private Response response;
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper()
            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

    @Step
    public void setApiKeyAndCityNameInQueryParam(String apiKey, String cityName) {
        queryParams = new HashMap<>();
        if(StringUtils.isNotEmpty(apiKey)){
            queryParams.put("appid", apiKey);
        }
        if(StringUtils.isNotEmpty(cityName)){
            queryParams.put("q", cityName);
        }
    }

    @Step
    public void invokeWeatherAPIByCityName() {
        response = SerenityRest.given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .baseUri(EnvironmentSelector.getWeatherMapEnvUrl())
                .log()
                .everything()
                .when()
                .queryParams(queryParams)
                .get();

        response.prettyPrint();
    }

    @Step
    public int getStatusCode() {
        return response.getStatusCode();
    }

    @Step
    public WeatherResponse getWeatherResponse() throws JsonProcessingException {
        return OBJECT_MAPPER.readValue(response.print(), WeatherResponse.class);
    }

}
