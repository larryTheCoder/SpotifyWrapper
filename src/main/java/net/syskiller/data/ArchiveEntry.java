package net.syskiller.data;

import net.syskiller.utils.ConsoleLogger;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class ArchiveEntry {

    public boolean isNull = false;
    private Map<String, JSONArray> archiveArray = new HashMap<>();
    private Map<String, JSONObject> archiveEntry = new HashMap<>();

    public ArchiveEntry(File zipLocation) throws IOException {
        ZipFile zip = new ZipFile(zipLocation);

        if (zip.size() != 8) {
            isNull = true;

            ConsoleLogger.INSTANCE.logError("This is not a valid Spotify Default Data archive...");
            return;
        }

        for (ArchiveData data : ArchiveData.values()) {
            ZipEntry entry = zip.getEntry(data.getFileName());
            // Find out if the entry is exists in the zip file...
            if (entry == null) {
                isNull = true;

                ConsoleLogger.INSTANCE.logError("This is not a valid Spotify Default Data archive...");
                break;
            }

            ConsoleLogger.INSTANCE.logDebug("Processing " + entry.getName(), 2);
            if (data.isJSONArray()) {
                JSONArray JSONObject = new JSONArray(getJSONFile(zip.getInputStream(entry)));
                archiveArray.put(entry.getName(), JSONObject);
            } else {
                JSONObject JSONObject = new JSONObject(getJSONFile(zip.getInputStream(entry)));
                archiveEntry.put(entry.getName(), JSONObject);
            }
        }
    }

    private static String getJSONFile(InputStream in) {
        StringBuilder out = new StringBuilder();
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        String line;
        try {
            while ((line = reader.readLine()) != null) {
                out.append(line);
            }
        } catch (IOException e) {
            // do something, probably not a text file
            e.printStackTrace();
        }
        return out.toString();
    }

    /**
     * Read a JSON object from the entry given.
     * Use ArchiveData to choose what file you
     * want to use.
     *
     * @param data The data of the archive
     * @return The JSONObject for the file
     */
    public JSONObject readObject(ArchiveData data) {
        if (data.isJSONArray()) {
            ConsoleLogger.INSTANCE.logError(data.getFileName() + " only can be read through readArrayObject().");
            return null;
        }
        return archiveEntry.get(data.getFileName());
    }

    /**
     * Read a JSON array from the entry given.
     * Use ArchiveData to choose what file you
     * want to use.
     *
     * @param data The data of the archive
     * @return The JSONObject for the file
     */
    public JSONArray readArrayObject(ArchiveData data) {
        if (data.isJSONArray()) {
            ConsoleLogger.INSTANCE.logError(data.getFileName() + " only can be read through readArrayObject().");
            return null;
        }
        return archiveArray.get(data.getFileName());
    }
}
