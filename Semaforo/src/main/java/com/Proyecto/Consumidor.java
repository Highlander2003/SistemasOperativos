package com.Package;

import java.util.Random;

public class Consumidor extends Hilo {

    public Consumidor(Buffer buffer) {
        super(buffer);
    }

    @Override
    public void run() {
        try {
            while (true) {
                int item = buffer.extraer();
                System.out.println("Consumido: " + item);
                Thread.sleep(new Random().nextInt(1000));
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
