package com.tnt.autoplayer;

public class DelayTimer {

    private int ticks = 0;

    public void set(int delay) {
        this.ticks = delay;
    }

    public boolean ready() {
        if (ticks > 0) {
            ticks--;
            return false;
        }
        return true;
    }
}
