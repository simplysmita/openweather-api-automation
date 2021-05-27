package org.openweather.restassured.actions;

import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import net.serenitybdd.rest.SerenityRest;
import org.openweather.util.EnvironmentSelector;

/**
 * @author Smita Sahu
 * Parent class for all rest-assured classes
 */
public class BaseAction {
    /**
     * Builds a simple requestSpecification object
     * @return RequestSpecification
     */
    RequestSpecification buildRestAssuredRequest() {
        return SerenityRest.given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .baseUri(EnvironmentSelector.getWeatherMapEnvUrl())
                .log()
                .everything()
                .when();
    }
}
