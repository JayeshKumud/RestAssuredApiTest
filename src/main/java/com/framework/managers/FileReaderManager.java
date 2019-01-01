package com.framework.managers;

import com.framework.dataProvider.ConfigFileReader;

public class FileReaderManager {

    private static FileReaderManager fileReaderManager = new FileReaderManager();
    private static ConfigFileReader configFileReader;

    private FileReaderManager(){

    }

    public static FileReaderManager getInstance(){
        return fileReaderManager;
    }

    public ConfigFileReader getConfigFileReader(){
        return configFileReader == null ? configFileReader = new ConfigFileReader() : configFileReader;
    }
}
