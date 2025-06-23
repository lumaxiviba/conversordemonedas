import java.util.Scanner;

public class Conversor {
    public void mostrarMenu() {
        System.out.println("\n=== Bienvenido al Conversor de Monedas ===");
        System.out.println("1. Dólar (USD) → Euro (EUR)");
        System.out.println("2. Euro (EUR) → Dólar (USD)");
        System.out.println("3. Dólar (USD) → Libra Esterlina (GBP)");
        System.out.println("4. Salir");
        System.out.print("Elija una opción: ");
    }

    public void iniciar(Moneda moneda) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            mostrarMenu();
            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    convertir("USD", "EUR", moneda);
                    break;
                case 2:
                    convertir("EUR", "USD", moneda);
                    break;
                case 3:
                    convertir("USD", "GBP", moneda);
                    break;
                case 4:
                    System.out.println("Saliendo del programa. ¡Gracias!");
                    return; // Sale del método y termina el programa
                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
            }
        }
    }

    public void convertir(String desde, String hacia, Moneda moneda) {
        if (!moneda.getRates().containsKey(desde) || !moneda.getRates().containsKey(hacia)) {
            System.out.println("Error: Una de las monedas no está disponible.");
            return;
        }

        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el monto a convertir: ");
        double monto = scanner.nextDouble();

        double tasaOrigen = moneda.getRates().get(desde);
        double tasaDestino = moneda.getRates().get(hacia);

        double resultado = (monto / tasaOrigen) * tasaDestino;

        System.out.printf("%.2f %s = %.2f %s%n", monto, desde, resultado, hacia);
    }
}