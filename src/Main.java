import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Crear la baraja utilizando nuestra propia Lista.
        Lista<Carta> baraja = crearBaraja();

        System.out.println("==========================================");
        System.out.println("       BARAJA DE PÓKER - 52 CARTAS");
        System.out.println("==========================================");

        System.out.println("\nBaraja inicial ordenada:");
        baraja.imprimir();

        int opcion;

        do {

            System.out.println("\n==========================================");
            System.out.println("              MENÚ PRINCIPAL");
            System.out.println("==========================================");
            System.out.println("1. Revolver la baraja");
            System.out.println("2. Ordenar por un palo");
            System.out.println("3. Salir");
            System.out.println("==========================================");
            System.out.print("Seleccione una opción: ");

            opcion = scanner.nextInt();

            switch (opcion) {

                case 1:

                    System.out.println("\n--- BARAJANDO ---");

                    baraja.shuffle();

                    System.out.println("Baraja revuelta:");
                    baraja.imprimir();

                    break;

                case 2:

                    System.out.print(
                            "\nSeleccione el palo (C, D, P, T): "
                    );

                    char palo = Character.toUpperCase(
                            scanner.next().charAt(0)
                    );

                    if (!paloValido(palo)) {

                        System.out.println(
                                "Error: el palo debe ser C, D, P o T."
                        );

                        break;
                    }

                    // Crear una nueva lista para las 13 cartas.
                    Lista<Carta> cartasPalo = extraerPalo(
                            baraja,
                            palo
                    );

                    System.out.println(
                            "\nCartas del palo " + palo + " antes de ordenar:"
                    );

                    cartasPalo.imprimir();

                    // Ordenar utilizando el método de nuestra Lista.
                    cartasPalo.sortList();

                    System.out.println(
                            "\nCartas del palo " + palo + " ordenadas:"
                    );

                    cartasPalo.imprimir();

                    break;

                case 3:

                    System.out.println("\nPrograma terminado.");

                    break;

                default:

                    System.out.println(
                            "\nOpción inválida. Seleccione 1, 2 o 3."
                    );
            }

        } while (opcion != 3);

        scanner.close();
    }

    // =========================================================
    // CREA LAS 52 CARTAS
    // =========================================================

    public static Lista<Carta> crearBaraja() {

        Lista<Carta> baraja = new Lista<>();

        char[] palos = {'C', 'D', 'P', 'T'};

        for (char palo : palos) {

            for (int valor = 1; valor <= 13; valor++) {

                baraja.agregar(
                        new Carta(palo, valor)
                );
            }
        }

        return baraja;
    }

    // =========================================================
    // EXTRAE LAS CARTAS DE UN PALO
    // =========================================================

    public static Lista<Carta> extraerPalo(
            Lista<Carta> baraja,
            char palo
    ) {

        Lista<Carta> resultado = new Lista<>();

        for (int i = 0; i < baraja.size(); i++) {

            Carta carta = baraja.obtener(i);

            if (carta.getPalo() == palo) {
                resultado.agregar(carta);
            }
        }

        return resultado;
    }

    // =========================================================
    // VALIDACIÓN DEL PALO
    // =========================================================

    public static boolean paloValido(char palo) {

        return palo == 'C'
                || palo == 'D'
                || palo == 'P'
                || palo == 'T';
    }
}