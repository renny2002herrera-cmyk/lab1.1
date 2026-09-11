public class Carta implements Comparable<Carta> {

    private char palo;
    private int valor;

    public Carta(char palo, int valor) {
        this.palo = palo;
        this.valor = valor;
    }

    public char getPalo() {
        return palo;
    }

    public int getValor() {
        return valor;
    }

    // Define el orden de las cartas:
    // primero por palo y después por valor.
    @Override
    public int compareTo(Carta otra) {

        if (this.palo != otra.palo) {
            return Integer.compare(
                    ordenPalo(this.palo),
                    ordenPalo(otra.palo)
            );
        }

        return Integer.compare(this.valor, otra.valor);
    }

    // Orden solicitado: C, D, P, T
    private int ordenPalo(char palo) {
        switch (palo) {
            case 'C':
                return 1;
            case 'D':
                return 2;
            case 'P':
                return 3;
            case 'T':
                return 4;
            default:
                return 5;
        }
    }

    // Convierte 1, 11, 12 y 13 a las figuras del póker.
    private String nombreValor() {

        switch (valor) {
            case 1:
                return "A";
            case 11:
                return "J";
            case 12:
                return "Q";
            case 13:
                return "K";
            default:
                return String.valueOf(valor);
        }
    }

    @Override
    public String toString() {
        return nombreValor() + "-" + palo;
    }
}