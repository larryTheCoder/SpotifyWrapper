package net.syskiller.data;

import org.json.JSONObject;

public class SpotifyData {

    private ArchiveEntry data;

    public SpotifyData(ArchiveEntry entry) {
        this.data = entry;

        startReadData();
    }

    private void startReadData(){
        // Start to load the user ID
        JSONObject identity = data.readObject(ArchiveData.DATA_IDENTITY);

    }

}
