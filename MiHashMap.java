
import java.util.ArrayList;
import java.util.List;

// Clase para representar la tabla hash
class MiHashMap {
    private static final int TAMANIO = 10;
    private List<Nodo> cubeta;

    public MiHashMap() {
        cubeta = new ArrayList<>(TAMANIO);
        for (int i = 0; i < TAMANIO; i++) {
            cubeta.add(null);
        }
    }

    // Método hash para obtener el índice de la tabla hash
    private int obtenerIndice(int clave) {
        return clave % TAMANIO;
    }

    // Método para insertar un par clave-valor en la tabla hash
    public void poner(int clave, int valor) {
        int indice = obtenerIndice(clave);
        Nodo cabeza = cubeta.get(indice);
        while (cabeza != null) {
            if (cabeza.clave == clave) {
                cabeza.valor = valor;
                return;
            }
            cabeza = cabeza.siguiente;
        }
        Nodo nuevoNodo = new Nodo(clave, valor);
        nuevoNodo.siguiente = cubeta.get(indice);
        cubeta.set(indice, nuevoNodo);
    }

    // Método para obtener el valor asociado a una clave
    public int obtener(int clave) {
        int indice = obtenerIndice(clave);
        Nodo cabeza = cubeta.get(indice);
        while (cabeza != null) {
            if (cabeza.clave == clave) {
                return cabeza.valor;
            }
            cabeza = cabeza.siguiente;
        }
        return -1; // Valor no encontrado
    }

    // Método para eliminar un par clave-valor de la tabla hash
    public void eliminar(int clave) {
        int indice = obtenerIndice(clave);
        Nodo cabeza = cubeta.get(indice);
        Nodo previo = null;
        while (cabeza != null) {
            if (cabeza.clave == clave) {
                if (previo != null) {
                    previo.siguiente = cabeza.siguiente;
                } else {
                    cubeta.set(indice, cabeza.siguiente);
                }
                return;
            }
            previo = cabeza;
            cabeza = cabeza.siguiente;
        }
    }

    // Método para imprimir la tabla hash
    public void imprimirHashMap() {
        for (int i = 0; i < TAMANIO; i++) {
            System.out.print("Cubeta " + i + ": ");
            Nodo cabeza = cubeta.get(i);
            while (cabeza != null) {
                System.out.print("(" + cabeza.clave + "," + cabeza.valor + ") ");
                cabeza = cabeza.siguiente;
            }
            System.out.println();
        }
    }
}