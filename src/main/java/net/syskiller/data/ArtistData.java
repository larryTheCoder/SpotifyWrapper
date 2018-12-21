package net.syskiller.data;

import java.util.HashMap;
import java.util.Map;

public class ArtistData {

    private String artistName;
    private int fullTimeRepeated = 0;
    private Map<Integer, Integer> timeRepeated; // Month (check Calender class), time repeated

    public ArtistData(String artistName) {
        this.artistName = artistName;
        this.timeRepeated = new HashMap<>();
    }

    /**
     * Add one point to the list if it repeated
     * every month.
     *
     * @param date The Calender months.
     * @return This class itself.
     */
    public ArtistData addTimeRepeated(int date) {
        int timeRepeat = 0;
        if (timeRepeated.containsKey(date)) {
            timeRepeat = timeRepeated.get(date);
        }
        timeRepeat++;
        fullTimeRepeated++;
        timeRepeated.put(date, timeRepeat);
        return this;
    }

    /**
     * @return The artist name of the music
     */
    public String getArtistName() {
        return artistName;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        return artistName.hashCode();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return artistName + "(" + timeRepeated.toString() + ") [" + fullTimeRepeated + "]";
    }
}
