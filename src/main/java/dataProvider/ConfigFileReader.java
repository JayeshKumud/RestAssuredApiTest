package dataProvider;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader {

    private Properties properties;
    private final String propertyFilePath = "configs//Configuration.properties";

    public ConfigFileReader(){
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(propertyFilePath));
            properties = new Properties();
            try {
                properties.load(reader);
                reader.close();
            } catch (IOException e) {
                throw new RuntimeException("Runtime Exception : " + e.getMessage());
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Configuration.properties not found at " + propertyFilePath + e.getMessage());
        }
    }

    public String getBaseURI(){
        String baseURI = properties.getProperty("baseURI");
        if(baseURI!= null) return baseURI;
        else throw new RuntimeException("BaseURI not specified in the Configuration.properties file.");
    }

    public String getBasePath(){
        String  basePath = properties.getProperty("basePath");
        if(basePath!= null) return basePath;
        else throw new RuntimeException("BasePath not specified in the Configuration.properties file.");
    }

    public String getReportConfigPath(){
        String  reportConfigPath = properties.getProperty("reportConfigPath");
        if(reportConfigPath!= null) return reportConfigPath;
        else throw new RuntimeException("BasePath not specified in the Configuration.properties file.");
    }
}
