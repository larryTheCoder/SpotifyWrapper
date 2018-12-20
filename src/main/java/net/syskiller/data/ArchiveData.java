package net.syskiller.data;

/**
 * All of the valid filename and its extension
 * will be recorded in here.
 */
public enum ArchiveData {
    /**
     * The followers data of Spotify
     */
    DATA_FOLLOWERS("Follow.json", false),
    /**
     * This is the identity of the user
     */
    DATA_IDENTITY("Identity.json", false),
    /**
     * Payments history that been made by the user.
     */
    DATA_PAYMENTS("Payments.json", false),
    /**
     * The playlist of the user that been created.
     */
    DATA_PLAYLIST("Playlist.json", false),
    /**
     * The search queries that user interact with.
     */
    DATA_SEARCH_QUERIES("SearchQueries.json", true),
    /**
     * This part stores the player steaming history,
     * Valuable and this data will going to be used for
     * this application.
     */
    DATA_STREAM_HISTORY("StreamingHistory.json", true),
    /**
     * This part stores the 'User Spotify Data',
     * Take a note that this is not the same with Identity.json
     */
    DATA_USERDATA("Userdata.json", false),
    /**
     * This stores the music that been saved into a user
     * library.
     */
    DATA_LIBRARY("YourLibrary.json", false);

    private final boolean isArray;
    private final String fileName;

    ArchiveData(String fileName, boolean jsonArray) {
        this.fileName = fileName;
        this.isArray = jsonArray;
    }

    /**
     * @return The file name of an enum.
     */
    public String getFileName() {
        return fileName;
    }

    /**
     * @return If the file is readable through JSONArray class
     */
    public boolean isJSONArray() {
        return isArray;
    }
}
