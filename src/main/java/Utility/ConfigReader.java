package Utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class ConfigReader {

   public static Properties properties;

    public static Properties getProperties(){
        try{
        FileInputStream fileInputStream = new FileInputStream(System.getProperty("user.dir")+"/config.properties");
        properties = new Properties();
        properties.load(fileInputStream);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return properties;
    }
}
