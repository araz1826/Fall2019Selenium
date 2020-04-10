package utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigurationReader {

    private static Properties configFile;
    static {
        try {
            //location of properties file path
            String path = System.getProperty("user.dir")+"/configuration.properties";

            FileInputStream input = new FileInputStream(path); //this is to get the file
            //create object of properties class
            configFile = new Properties();
            //load it
            configFile.load(input);
            input.close();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to load properties file!");
        }
    }
    //this method return the property valuse from con.pro file
    public static String getProperty(String keyName) {
        return configFile.getProperty(keyName);    //keyname is browser (remember configuration.properties file)
    }
}
