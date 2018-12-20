package net.syskiller;

import net.syskiller.data.ArchiveEntry;
import net.syskiller.data.SpotifyData;
import net.syskiller.utils.ConsoleLogger;
import net.syskiller.utils.Settings;

import java.io.File;
import java.io.IOException;

public class Loader extends ConsoleLogger {

    private boolean noGUI = false;

    private Loader(String[] args) {
        super();
        logInfo("Starting SpotifyWrapper to read the archive.");
        logInfo("SpotifyWrapper is a free software and not affiliated under Spotify Ltd.");
        logDebug(System.getProperty("user.dir"), 2);

        // Here we skip the parameter X for some stuff
        int index = -1;
        boolean skip = false;
        for (String arguments : args) {
            index++;
            if (skip) {
                skip = false;
                continue;
            }
            switch (arguments) {
                case "--nogui":
                    noGUI = true;
                    break;
                case "--debug":
                    skip = true;
                    int debugLevel = 0;
                    try {
                        debugLevel = Integer.parseInt(args[index + 1]);
                    } catch (Exception ignored) {
                    }
                    setDebugLevel(debugLevel);
                    logDebug("Started to debug at level " + debugLevel, 1);
                    break;
                case "--file":
                    skip = true;
                    String fileName = args[index + 1];
                    try {
                        File readFile = new File(Settings.DATAPATH + fileName);
                        if (readFile.isFile()) {
                            Settings.DATAFOLDER = readFile;
                            logInfo("Found the correct archive for Spotify Data.");
                        } else {
                            logError("No valid archive were found for Spotify Data.");
                            logError("Please make sure that you are using the right command.");
                            logError("Example: SpotifyLoader.jar --file Decoded-Data.zip");
                        }
                    } catch (RuntimeException ex) {
                        logError("A runtime exception has been thrown...");
                        ex.printStackTrace();
                    }
                    break;
                case "--logfile":
                    break;
                case "readable":
                    break;
                case "fast":
                    break;
            }
        }

        ArchiveEntry data = null;
        try {
            data = new ArchiveEntry(Settings.DATAFOLDER);
        } catch (IOException ex) {
            logError("An IOException has been thrown...");
            ex.printStackTrace();
        }

        if (data == null || data.isNull) {
            logError("Failed to run SpotifyWrapper due to invalid archive.");
            return;
        } else {
            logInfo("Archive has been confirmed and validated.");
            logInfo("Starting to organize playlist and streaming history...");
        }

        // TODO: Process GUI Response...
        //       Main Thread: wait.. (wait for thread 1 and 2 to finish)
        //       Thread 1: GUI Thread
        //       Thread 2: Calculation Thread...

        if (!noGUI) {
            processData(data);
        } else {
            initGUIProcessor();
        }
    }

    public static void main(String[] args) {
        new Loader(args);
    }

    private void initGUIProcessor() {

    }

    private void processData(ArchiveEntry data) {
        new SpotifyData(data);
    }
}
