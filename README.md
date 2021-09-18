# SimpleSettingsStorage
A simple utility to save settings or small amount of data

[Click here if you want to download the latest jar](https://github.com/Binozo/SimpleSettingsStorage/raw/master/out/artifacts/SimpleSettingsStorage_jar/SimpleSettingsStorage.jar)

### Sample Usage
```java
try {
    SimpleSettingsStorage simplesettingsstorage = new SimpleSettingsStorage();
    simplesettingsstorage.getStorage().put("key", "value");
    simplesettingsstorage.saveStorage(); //never forget that!
} catch (IOException e) {
    e.printStackTrace();
}
```

#### Dependency
[org.json](https://github.com/stleary/JSON-java)
