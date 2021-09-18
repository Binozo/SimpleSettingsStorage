package com.binozoworks.simplesettingsstorage;

import java.io.IOException;

public class main {
    public static void main(String[] args) {
        //for testing
        try {
            SimpleSettingsStorage simplesettingsstorage = new SimpleSettingsStorage();
            simplesettingsstorage.getStorage().put("test", "value");
            simplesettingsstorage.saveStorage(); //never forget that!
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
