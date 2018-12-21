package net.syskiller.query;

import net.syskiller.data.StreamData;
import net.syskiller.utils.ConsoleLogger;
import net.syskiller.utils.VersionControl;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.*;

public class StreamQuery {

    private final JSONArray jsonArray;
    private Map<String, StreamData> streamData;

    /**
     * Starts to queries all artists of the file
     * This tasks run in another thread to make sure
     * that this query wont block the main thread.
     *
     * @param data     The json array object of fileName
     */
    public StreamQuery(JSONArray data) {
        this.jsonArray = data;
        this.streamData = new HashMap<>();

        this.startQuery();
    }

    private void startQuery() {
        // This could be moRe than 1000
        int version = VersionControl.checkJSONVersion(jsonArray);
        for (Object o : jsonArray) {
            JSONObject object = (JSONObject) o;
            if (version == VersionControl.VERSION_1) {

            } else if (version == VersionControl.VERSION_2) {

            } else {
                ConsoleLogger.logError("Unknown version provided for the Spotify package...");
            }
        }
    }

    /**
     * @return The results of the query.
     */
    public List<StreamData> getResults() {
        return new ArrayList<>(streamData.values());
    }
}
