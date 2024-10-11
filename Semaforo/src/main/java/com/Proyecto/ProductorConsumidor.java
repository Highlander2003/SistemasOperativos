package com.Proyecto;

public class ProductorConsumidor {
    public static void main(String[] args) {
        int bufferSize = 10;
        Buffer buffer = new Buffer(bufferSize);

        // Crear productores
        for (int i = 0; i < 2; i++) {
            new Productor(buffer).start();
        }

        // Crear consumidores
        for (int i = 0; i < 3; i++) {
            new Consumidor(buffer).start();
        }
    }
}
