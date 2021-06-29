package me.tsb.backdoor;

import lombok.Getter;

public class Logger {

    private final String name;
    @Getter
    private String logs = ""; // todo: if this gets spammed by some exceptions it could fill up memory and if inspected with some tool it could reveal the backdoor

    public Logger(String name) {
        this.name = name;
    }

    public void log(String input) {
        logs += "\n" + name + input;
    }

    public void warn(String input) {
        log("[WARN] " + input);
    }

    public void exception(String input) {
        log("[EXCEPTION] " + input);
    }
}
