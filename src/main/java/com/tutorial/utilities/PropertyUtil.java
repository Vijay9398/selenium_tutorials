package com.tutorial.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class PropertyUtil {

    private String configuration_file = "src/main/resources/config.properties";
    private Properties properties;
    private FileInputStream stream;

    public PropertyUtil() {
        load(configuration_file);
    }

    public PropertyUtil(String filePath){
        load(filePath);
    }

    private void load(String filePath){
        try{
            stream = new FileInputStream(new File(filePath));
            properties = new Properties();
            properties.load(stream);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public String getProperty(String key){
        return properties.getProperty(key);
    }

}
