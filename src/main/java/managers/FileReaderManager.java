package managers;

import dataProvider.ConfigFileReader;

public enum FileReaderManager {

    INSTANCE;
    private static ConfigFileReader configFileReader;

    public ConfigFileReader getConfigFileReader(){
        return (configFileReader == null) ? (configFileReader = new ConfigFileReader()) : configFileReader;
    }
}
