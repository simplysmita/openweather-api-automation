package org.openweather.util;

import org.apache.commons.lang3.StringUtils;

/**
 * @author Smita Sahu
 * Utility Class to select an environment and set the environment specific properties for test execution
 */
public class EnvironmentSelector {
    private static final EnvironmentConstant weatherMapEnv;

    static {
        String envName = System.getProperty("env");
        if (StringUtils.isNotEmpty(envName)) {
            weatherMapEnv = EnvironmentConstant.fromString(envName);
        } else {
            /**
             * Set Prod as default environment if no argument has been set.
             */
            weatherMapEnv = EnvironmentConstant.PROD;
        }
    }

    private EnvironmentSelector() {

    }

    public static EnvironmentConstant getWeatherMapEnv() {
        return weatherMapEnv;
    }

    public static String getWeatherMapEnvUrl() {
        return EnvironmentConstant.getBaseUrl(weatherMapEnv);
    }
}
