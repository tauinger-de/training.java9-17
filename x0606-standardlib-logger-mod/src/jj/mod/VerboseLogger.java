package jj.mod;

import java.lang.System.Logger;
import java.util.ResourceBundle;

import static java.text.MessageFormat.format;

public class VerboseLogger implements Logger {

    @Override
    public String getName() {
        return "VerboseLogger";
    }

    @Override
    public boolean isLoggable(Level level) {
        return true;
    }

    @Override
    public void log(Level level, ResourceBundle bundle, String msg, Throwable thrown) {
        System.out.printf("VerboseLogger [%s]: %s - %s%n", level, msg, thrown);
    }

    @Override
    public void log(Level level, ResourceBundle bundle, String format, Object... params) {
        System.out.printf("VerboseLogger [%s]: %s%n", level, format(format, params));
    }

}