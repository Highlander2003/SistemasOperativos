package com.Package;

public abstract class Hilo extends Thread {
    protected Buffer buffer;

    public Hilo(Buffer buffer) {
        this.buffer = buffer;
    }
}
