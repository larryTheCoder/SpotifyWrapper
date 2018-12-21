package net.syskiller.query;

import net.syskiller.data.ArtistData;
import net.syskiller.utils.ConsoleLogger;
import net.syskiller.utils.VersionControl;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.*;

public class ArtistQuery {

    private final JSONArray jsonArray;
    private Map<String, ArtistData> artistsData;

    /**
     * Starts to queries all artists of the file
     * This tasks run in another thread to make sure
     * that this query wont block the main thread.
     *
     * @param data     The json array object of fileName
     */
    public ArtistQuery(JSONArray data) {
        this.jsonArray = data;
        this.artistsData = new HashMap<>();

        this.startQuery();
    }

    private void startQuery() {
        // This could be moRe than 1000
        int version = VersionControl.checkJSONVersion(jsonArray);
        for (Object o : jsonArray) {
            JSONObject object = (JSONObject) o;
            if (version == VersionControl.VERSION_1) {
                // Okay this is what we call out the flaw where msPlayed cannot be accessed so
                // we can't give out how long he/she been streaming...
                // Although, artists seems like to be mixed out?!?!
                String[] artists = object.getString("artistName").split(", ");    //   DATE          TIME
                String[] timeDate = object.getString("time").split("-", 3); // 2018-03-17    13:58:59
                int month = Integer.parseInt(timeDate[1]);

                Arrays.asList(artists).forEach((artist) -> {
                    if (artistsData.containsKey(artist)) {
                        artistsData.put(artist, artistsData.get(artist).addTimeRepeated(month));
                    } else {
                        artistsData.put(artist, new ArtistData(artist).addTimeRepeated(month));
                    }
                });
            } else if (version == VersionControl.VERSION_2) {
                // Yes, the nonLegacy method, but unfortunately, its doesn't provide how long
                // the music supposed to be. So we can't really count how much music that the user
                // repeated for one object...
                String[] artists = object.getString("artistName").split(", ");       //   DATE     TIME PLAYED
                String[] endTime = object.getString("endTime").split("-", 3); // 2018-03-17     15:19
                int month = Integer.parseInt(endTime[1]);

                Arrays.asList(artists).forEach((artist) -> {
                    if (artistsData.containsKey(artist)) {
                        artistsData.put(artist, artistsData.get(artist).addTimeRepeated(month));
                    } else {
                        artistsData.put(artist, new ArtistData(artist).addTimeRepeated(month));
                    }
                });
            } else {
                // TODO: Open an issue about this uncompleted part of data to spotify help center
                //       They should think about this at the first place!

                ConsoleLogger.logError("Unknown version provided for the Spotify package...");
            }
        }
    }

    /**
     * @return The results of the query.
     */
    public List<ArtistData> getResults() {
        return new ArrayList<>(artistsData.values());
    }
}
