package com.Package;

import java.util.concurrent.Semaphore;

public class Buffer {
    private final int[] buffer;
    private int in, out;
    private final Semaphore mutex, lleno, vacio;

    public Buffer(int size) {
        buffer = new int[size];
        in = 0;
        out = 0;
        mutex = new Semaphore(1);
        lleno = new Semaphore(0);
        vacio = new Semaphore(size);
    }

    public void insertar(int item) throws InterruptedException {
        vacio.acquire();
        mutex.acquire();
        buffer[in] = item;
        in = (in + 1) % buffer.length;
        mutex.release();
        lleno.release();
    }

    public int extraer() throws InterruptedException {
        lleno.acquire();
        mutex.acquire();
        int item = buffer[out];
        out = (out + 1) % buffer.length;
        mutex.release();
        vacio.release();
        return item;
    }
}
