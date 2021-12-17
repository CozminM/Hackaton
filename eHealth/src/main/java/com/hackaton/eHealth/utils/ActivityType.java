package com.hackaton.eHealth.utils;

public enum ActivityType {
    SWIMMING(10),
    RUNNING(10),
    ROPE_JUMPING(10),
    ROWING(10);

    private int value;

    ActivityType(int value) {
        this.value=value;
    }
}
