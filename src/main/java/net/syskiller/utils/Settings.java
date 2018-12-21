package net.syskiller.utils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Settings {

    /**
     * This variable defines the Spotify .zip data archive
     */
    public static List<File> DATAFOLDER;
    /**
     * This is the directory of the jvm itself.
     */
    public static String DATAPATH;

    static {
        DATAFOLDER = new ArrayList<>();
        DATAPATH = System.getProperty("user.dir") + "/";
    }
}
