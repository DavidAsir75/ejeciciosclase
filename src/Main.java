public class Main {
    public static void main(String[] args) {
        // Define el número de espacios en el estacionamiento y la cantidad de coches
        int totalSpaces = 3;
        int numberOfCars = 6;

        Parking parking = new Parking(totalSpaces);

        // Crea e inicia los coches (hilos)
        for (int i = 1; i <= numberOfCars; i++) {
            new Car(parking, "Coche " + i).start();
        }
    }
}