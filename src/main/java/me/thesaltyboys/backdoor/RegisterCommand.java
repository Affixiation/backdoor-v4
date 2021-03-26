package me.thesaltyboys.backdoor;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface RegisterCommand {

    String displayName();

    String[] aliases();
}
