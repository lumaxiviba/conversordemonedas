import java.util.Scanner;

public class Conversor {
    public void mostrarMenu() {
        System.out.println("=== Bienvenido al Conversor de Monedas ===");
        System.out.println("1. Dólar → Euro");
        System.out.println("2. Euro → Dólar");
        System.out.println("3. Dólar → Libra Esterlina");
        System.out.println("4. Salir");
        System.out.print("Elija una opción: ");

    }

    Scanner scanner = new Scanner(System.in);
    int opcion = scanner.nextInt();

switch (opcion) {
        case 1:
            convertir("USD", "EUR", moneda);
            break;
        // ... otras opciones
        default:
            System.out.println("Opción no válida.");
    }

    public void convertir(String de, String a, Moneda moneda) {
        double tasaOrigen = moneda.getRates().get(de);
        double tasaDestino = moneda.getRates().get(a);

        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el monto a convertir: ");
        double monto = scanner.nextDouble();

        double resultado = (monto / tasaOrigen) * tasaDestino;
        System.out.printf("%.2f %s = %.2f %s%n", monto, de, resultado, a);
    }
}
