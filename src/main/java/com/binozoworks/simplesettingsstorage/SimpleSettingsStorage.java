package com.binozoworks.simplesettingsstorage;

import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class SimpleSettingsStorage {

    private final String fileName;
    private final JSONObject jsonObject;

    public SimpleSettingsStorage() throws IOException {
        fileName = "settings.json";
        checkIfFileExistsAndCreateIt();
        jsonObject = new JSONObject(readSettingsJsonFromFile());
    }

    /**
    * @param fileName name of settingsfile (Example: settings.json)
    * */
    public SimpleSettingsStorage(String fileName) throws IOException {
        this.fileName = fileName;
        checkIfFileExistsAndCreateIt();
        jsonObject = new JSONObject(readSettingsJsonFromFile());

    }

    private void log(String msg){
        System.out.println("SimpleSettingsStorage: " + msg);
    }

    /**
     * Checks if the Settings file exists. If not, it creates one. It also checks if the File is corrupt and replace it with a new one.
     * @throws IOException if there was an error while reading from File
     * */
    private void checkIfFileExistsAndCreateIt() throws IOException {
        File file = new File(fileName);
        if(file.exists()){
            //check if it is corrupt
            String fileContent = readSettingsJsonFromFile();
            if(fileContent.startsWith("{") & fileContent.endsWith("}")){
                //everything fine!
            }else{
                //file probably corrupt. Create new one
                log("JSON File " + fileName + " is probably corrupt. A new File will be created.");
                Files.write(Paths.get(fileName), "{}".getBytes(StandardCharsets.UTF_8));
            }
        }else{
            log("JSON File " + fileName + " doesn't exists. The File will be created.");
            Files.write(Paths.get(fileName), "{}".getBytes(StandardCharsets.UTF_8));
        }
    }

    private String readSettingsJsonFromFile() throws IOException {
        return Files.readString(Paths.get(fileName));
    }

    public JSONObject getStorage(){
        return jsonObject;
    }

    public void saveStorage() throws IOException {
        Files.write(Paths.get(fileName), jsonObject.toString().getBytes(StandardCharsets.UTF_8));
    }




}
