import java.util.Random; // Asegúrate de que esta línea esté al inicio del archivo

public class Car extends Thread {
    private final Parking parking;
    private final String carName;

    // Constructor que acepta los parámetros Parking y String
    public Car(Parking parking, String carName) {
        this.parking = parking;
        this.carName = carName;
    }

    @Override
    public void run() {
        try {
            System.out.println(carName + " listo para aparcar");
            parking.parkCar(carName); // Intenta aparcar

            // Simula el tiempo que el coche permanece aparcado
            Thread.sleep(new Random().nextInt(3000) + 1000);

            // Deja el estacionamiento
            parking.leaveCar(carName);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}