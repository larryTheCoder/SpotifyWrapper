package net.syskiller.utils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class VersionControl {

    public static int VERSION_1 = 0;
    public static int VERSION_2 = 1;

    public static int checkJSONVersion(JSONArray jsonArray){
        try {
            JSONObject object = jsonArray.getJSONObject(0);
            object.getString("endTime"); // This should throw JSONException if not exists
            return VERSION_2;
        } catch (JSONException ignored) {
        }
        try {
            JSONObject object = jsonArray.getJSONObject(0);
            object.getString("time"); // This should throw JSONException if not exists
            ConsoleLogger.logInfo("Legacy method being used for one of the files");
            return VERSION_1;
        } catch (JSONException ignored) {
        }
        return -1;
    }
}
