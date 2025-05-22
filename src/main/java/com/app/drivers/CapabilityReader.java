package com.app.drivers;

import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.remote.DesiredCapabilities;
import com.fasterxml.jackson.databind.ObjectMapper;

public class CapabilityReader {
    private static JSONArray parseJSON(String jsonLocation) throws Exception {
        JSONParser jsonParser = new JSONParser();
        return (JSONArray) jsonParser.parse(new FileReader(jsonLocation));
    }

    private static JSONObject getCapability(String capabilityName, String jsonLocation) throws Exception {
        JSONArray capabilitiesArray = parseJSON(jsonLocation);
        for (Object jsonObj : capabilitiesArray) {
            JSONObject capability = (JSONObject) jsonObj;
            if (capability.get("name").toString().equalsIgnoreCase(capabilityName)) {
                return (JSONObject) capability.get("caps");
            }
        }
        return null;
    }

    @SuppressWarnings("unchecked")
    private static HashMap<String, Object> convertCapsToHashMap(String capabilityName, String jsonLocation) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        HashMap<String, Object> caps = objectMapper.readValue(getCapability(capabilityName, jsonLocation).toString(), HashMap.class);
        for (Map.Entry<String, Object> entry : caps.entrySet()) {
            if (entry.getKey().equals("appium:app")) {
                entry.setValue(System.getProperty("user.dir") + entry.getValue());
            }
        }
        return caps;
    }

    public static DesiredCapabilities getDesiredCapabilities(String capabilityName, String capsContentRootLocation) throws Exception {
        String jsonLocation = System.getProperty("user.dir") + "/" + capsContentRootLocation;
        HashMap<String, Object> caps = convertCapsToHashMap(capabilityName, jsonLocation);
        return new DesiredCapabilities(caps);
    }
}
