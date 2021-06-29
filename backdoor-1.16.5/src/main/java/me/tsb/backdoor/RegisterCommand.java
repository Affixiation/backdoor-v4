package me.tsb.backdoor;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface RegisterCommand {

    String displayName();

    String[] aliases();
}
