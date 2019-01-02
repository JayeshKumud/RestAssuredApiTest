package com.framework.managers;

import com.framework.dataProvider.ConfigFileReader;

public class FileReaderManager {

    private static FileReaderManager fileReaderManager;
    private static ConfigFileReader configFileReader;

    private FileReaderManager(){
    }

    public static FileReaderManager getInstance(){
        return fileReaderManager == null ?  fileReaderManager = new FileReaderManager() : fileReaderManager;
    }

    public ConfigFileReader getConfigFileReader(){
        return configFileReader == null ? configFileReader = new ConfigFileReader() : configFileReader;
    }
}
