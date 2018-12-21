package net.syskiller.data;

/**
 * All of the valid filename and its extension
 * will be recorded in here.
 */
public enum ArchiveData {
    /**
     * The followers data of Spotify
     */
    DATA_FOLLOWERS("Follow.json", false, true),
    /**
     * This is the identity of the user
     */
    DATA_IDENTITY("Identity.json", false, true),
    /**
     * Payments history that been made by the user.
     */
    DATA_PAYMENTS("Payments.json", false, true),
    /**
     * The playlist of the user that been created.
     */
    DATA_PLAYLIST("Playlist.json", false, true),
    /**
     * The search queries that user interact with.
     */
    DATA_SEARCH_QUERIES("SearchQueries.json", true, true),
    /**
     * This part stores the player steaming history,
     * Valuable and this data will going to be used for
     * this application.
     */
    DATA_STREAM_HISTORY("StreamingHistory.json", true, true),
    /**
     * This part stores the 'User Spotify Data',
     * Take a note that this is not the same with Identity.json
     */
    DATA_USERDATA("Userdata.json", false, true),
    /**
     * This stores the music that been saved into a user
     * library.
     */
    DATA_LIBRARY("YourLibrary.json", false, true),
    /**
     * This stores the family plan address.
     */
    DATA_FAMILY_PLAN("FamilyPlan.json", false, false);

    private final boolean isArray;
    private final boolean isPrimary;
    private final String fileName;

    ArchiveData(String fileName, boolean jsonArray, boolean isPrimary) {
        this.fileName = fileName;
        this.isArray = jsonArray;
        this.isPrimary = isPrimary;
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

    /**
     * @return If the included file should exists to make sure this code could run properly
     */
    public boolean shouldBeIncluded() {
        return isPrimary;
    }
}
