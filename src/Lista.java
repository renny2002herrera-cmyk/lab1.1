import java.util.Random;

public class Lista<T extends Comparable<T>> {

    private Nodo<T> cabeza;
    private int tamaño;

    public Lista() {
        cabeza = null;
        tamaño = 0;
    }

    // Agrega un elemento al final de la lista.
    public void agregar(T dato) {

        Nodo<T> nuevo = new Nodo<>(dato);

        if (cabeza == null) {
            cabeza = nuevo;
        } else {

            Nodo<T> actual = cabeza;

            while (actual.siguiente != null) {
                actual = actual.siguiente;
            }

            actual.siguiente = nuevo;
        }

        tamaño++;
    }

    // Devuelve el tamaño de la lista.
    public int size() {
        return tamaño;
    }

    // Obtiene el nodo que se encuentra en una posición determinada.
    private Nodo<T> obtenerNodo(int posicion) {

        if (posicion < 0 || posicion >= tamaño) {
            return null;
        }

        Nodo<T> actual = cabeza;

        for (int i = 0; i < posicion; i++) {
            actual = actual.siguiente;
        }

        return actual;
    }

    // Obtiene el dato de una posición.
    public T obtener(int posicion) {

        Nodo<T> nodo = obtenerNodo(posicion);

        if (nodo == null) {
            return null;
        }

        return nodo.dato;
    }

    // Imprime todos los elementos.
    public void imprimir() {

        Nodo<T> actual = cabeza;

        if (actual == null) {
            System.out.println("La lista está vacía.");
            return;
        }

        while (actual != null) {
            System.out.print(actual.dato + "  ");
            actual = actual.siguiente;
        }

        System.out.println();
    }

    // Mezcla la lista.
    //
    // Se utiliza una versión de Fisher-Yates.
    // Como la estructura es enlazada, se busca cada posición
    // recorriendo los nodos, sin utilizar arrays ni ArrayList.
    public void shuffle() {

        if (tamaño <= 1) {
            return;
        }

        Random random = new Random();

        for (int i = tamaño - 1; i > 0; i--) {

            int j = random.nextInt(i + 1);

            Nodo<T> nodoI = obtenerNodo(i);
            Nodo<T> nodoJ = obtenerNodo(j);

            T temporal = nodoI.dato;
            nodoI.dato = nodoJ.dato;
            nodoJ.dato = temporal;
        }
    }

    // Ordena la lista utilizando Bubble Sort.
    //
    // No se utilizan colecciones nativas de Java.
    public void sortList() {

        if (tamaño <= 1) {
            return;
        }

        boolean intercambio;

        do {

            intercambio = false;

            Nodo<T> actual = cabeza;

            while (actual != null && actual.siguiente != null) {

                if (actual.dato.compareTo(actual.siguiente.dato) > 0) {

                    T temporal = actual.dato;
                    actual.dato = actual.siguiente.dato;
                    actual.siguiente.dato = temporal;

                    intercambio = true;
                }

                actual = actual.siguiente;
            }

        } while (intercambio);
    }
}