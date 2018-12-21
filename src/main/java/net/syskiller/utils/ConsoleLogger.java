package net.syskiller.utils;

import com.diogonunes.jcdp.color.ColoredPrinter;
import com.diogonunes.jcdp.color.api.Ansi;

public class ConsoleLogger {

    public static ConsoleLogger INSTANCE;
    private ColoredPrinter console;

    public ConsoleLogger() {
        INSTANCE = this;
        console = new ColoredPrinter.Builder(1, false)
                .foreground(Ansi.FColor.WHITE)
                .build();
    }

    public void logInfo(Object message) {
        console.print(console.getDateFormatted(), Ansi.Attribute.NONE, Ansi.FColor.CYAN, Ansi.BColor.BLACK);
        console.print(" [INFO] ", Ansi.Attribute.NONE, Ansi.FColor.YELLOW, Ansi.BColor.BLACK);
        console.println(message);
        console.clear();
    }

    public void logError(Object message) {
        console.print(console.getDateFormatted(), Ansi.Attribute.NONE, Ansi.FColor.CYAN, Ansi.BColor.BLACK);
        console.print(" [ERROR] ", Ansi.Attribute.NONE, Ansi.FColor.RED, Ansi.BColor.BLACK);
        console.println(message);
        console.clear();
    }

    public void logDebug(Object message, int minLevel) {
        console.debugPrint(console.getDateFormatted(), minLevel, Ansi.Attribute.NONE, Ansi.FColor.CYAN, Ansi.BColor.BLACK);
        console.debugPrint(" [DEBUG] ", minLevel, Ansi.Attribute.NONE, Ansi.FColor.MAGENTA, Ansi.BColor.BLACK);
        console.debugPrintln(message, minLevel);
        console.clear();
    }

    protected void setDebugLevel(int level){
        console.setLevel(level);
    }
}
