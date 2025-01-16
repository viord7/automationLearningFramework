package config;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigLoader {


    private static Properties properties;

   /*
   A static field is a class-level variable. It is shared across all instances of the class (or even if there are no instances).
   There is only one copy of the static variable in memory, regardless of how many objects are created from the class.
   Without static, the file is loaded every time a new instance is created and every instance will load the config.properties file
   and have its own Properties object, even though all instances are essentially using the same configuration data.
    */
   static {
        try {
            FileInputStream fis = new FileInputStream("src/test/resources/config.properties");
            properties=new Properties();
            properties.load(fis);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load config.properties file");
        }
   }


    /*
    Method is static, allowing it to be called without creating an instance of ConfigLoader. This is convenient because retrieving
    configuration values shouldn't require instantiating an object—it should be accessible globally.
     */

    public static String getProperty(String key){
      return properties.getProperty(key);
    }
}
