package org.openweather.util;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Smita Sahu
 * EnvironmentConstant enum is a mapping between environment name and environment base url
 */
public enum EnvironmentConstant {
    /**
     *  Add more environment as necessary. Also don't forget to add the corresponding url in envMap.
     */
    PROD;

    private static final Map<EnvironmentConstant, String> envMap = new HashMap<>();
    static {
        envMap.put(EnvironmentConstant.PROD, "http://api.openweathermap.org/data/2.5/weather");
    }

    public static String getBaseUrl(EnvironmentConstant environmentConstant){
        return envMap.get(environmentConstant);
    }

    public static EnvironmentConstant fromString(String envName){
        return EnvironmentConstant.valueOf(envName);
    }

}
