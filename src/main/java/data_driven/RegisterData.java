package data_driven;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import settings.Settings;
import utils.Helper;

import java.util.HashMap;
import java.util.Map;

public class RegisterData {
    private final JSONObject jsonData;

    //Prevent instance
    private RegisterData() {
        final String filePath = Settings.registerDataJsonFile;
        final Map<String, Object> newEmailObject = new HashMap<>();
        final String currentDate = Helper.getCurrentDate();
        final String newEmail = "harrypotter+".concat(currentDate).concat("@gmail.com");
        newEmailObject.put("email", newEmail);
        Helper.updateJsonFile(filePath, newEmailObject, "email");
        jsonData = Helper.readJsonFile(filePath);
    }

    public static RegisterData getRegisterData() {
        return new RegisterData();
    }

    public String getFirstName() {
        return (String) jsonData.get("firstName");
    }

    public String getLastName() {
        return (String) jsonData.get("lastName");
    }

    public String getEmail() {
        return (String) jsonData.get("email");
    }

    public String getPhoneNumber() {
        return (String) jsonData.get("phoneNumber");
    }

    public String getCourse() {
        JSONArray courses = (JSONArray) jsonData.get("courses");
        int randomCompanyNumber = Helper.getRandomNumber(courses.size());
        return (String) courses.get(randomCompanyNumber);
    }
    public String getMonth() {
        JSONArray months = (JSONArray) jsonData.get("months");
        int randomCompanyNumber = Helper.getRandomNumber(months.size());
        return (String) months.get(randomCompanyNumber);
    }
}
