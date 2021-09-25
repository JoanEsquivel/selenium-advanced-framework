package utils;

import org.apache.commons.lang3.StringUtils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesManager {
    static Properties prop = new Properties();


    public static String getPropertyValueByKey(String key) {
        String propFilePath = System.getProperty("user.dir")+"/src/test/resources/config.properties";
        FileInputStream fis;
        try {
            fis = new FileInputStream(propFilePath);
            prop.load(fis);
        } catch (Exception e) {
            e.printStackTrace();
        }

        String systemPropertyValue = System.getProperty(key);
        //If you send any custom value from mvn test -Dbrowser it will validate first the custom value.
        //Else, it is going to take the default one
        if (systemPropertyValue == null) {
            String value = prop.get(key).toString();
            if(StringUtils.isEmpty(value)) {
                try {
                    throw new Exception("Value is not specified for key: "+key + " in properties file.");
                }catch(Exception e) {}
            }
            return value;
        }else {
            return systemPropertyValue;
        }
        //

//        String value = prop.get(key).toString();
//        if(StringUtils.isEmpty(value)) {
//            try {
//                throw new Exception("Value is not specified for key: "+key + " in properties file.");
//            }catch(Exception e) {}
//        }
//        return value;
    }

}
