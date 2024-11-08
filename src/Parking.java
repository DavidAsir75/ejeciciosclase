public class Parking {
    private final int totalSpaces;
    private int availableSpaces;

    // Constructor de Parking
    public Parking(int totalSpaces) {
        this.totalSpaces = totalSpaces;
        this.availableSpaces = totalSpaces;
    }

    // Método sincronizado para que un coche intente aparcar
    public synchronized void parkCar(String carName) throws InterruptedException {
        // Si no hay espacio disponible, el coche espera
        while (availableSpaces == 0) {
            System.out.println("Estacionamiento lleno, el " + carName + " tiene que esperar");
            wait();  // Espera hasta que un espacio esté disponible
        }
        availableSpaces--;
        System.out.println(carName + " ha aparcado. Espacios disponibles: " + availableSpaces);
    }

    // Método sincronizado para liberar un espacio
    public synchronized void leaveCar(String carName) {
        availableSpaces++;
        System.out.println(carName + " ha dejado un espacio libre. Espacios disponibles: " + availableSpaces);
        notify();  // Notifica a un coche en espera que hay espacio disponible
    }
}

