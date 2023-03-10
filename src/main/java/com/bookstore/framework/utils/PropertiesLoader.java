package com.bookstore.framework.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Objects;
import java.util.Properties;

/**
 * class for loading variables from properties file
 */
public class PropertiesLoader {

    private static Properties prop = setPropertiesPath();
    public static final String BASE_URL = prop.getProperty("host");
    public static final String BROWSER = prop.getProperty("browser");
    public static final Long TIMEOUT = Long.parseLong(prop.getProperty("timeOutForWait"));

    /**
     * @return properties object
     */
    private static Properties setPropertiesPath() {
        final String path = "common.properties";
        Properties prop = new Properties();
        File propFile;
        URL url = PropertiesLoader.class.getClassLoader().getResource(path);

        try {
            propFile = new File(Objects.requireNonNull(url).toURI());
        } catch (URISyntaxException e) {
            throw new NullPointerException("Can't get URI to file");
        }

        try (FileInputStream flPropStream = new FileInputStream(propFile)) {
            prop.load(flPropStream);
            return prop;
        } catch (IOException | NullPointerException e) {
            throw new NullPointerException("Exception while reading file path in stream");
        }
    }
}