import java.util.Random;

public class Productor extends Hilo {
    private final Random random = new Random();

    public Productor(Buffer buffer) {
        super(buffer);
    }

    @Override
    public void run() {
        try {
            while (true) {
                int item = random.nextInt(100);
                buffer.insertar(item);
                System.out.println("Producido: " + item);
                Thread.sleep(random.nextInt(1000));
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}