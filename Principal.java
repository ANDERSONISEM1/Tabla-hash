
import java.util.Scanner;


// Clase principal que interactúa con el usuario
public class Principal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MiHashMap hashMap = new MiHashMap();

        while (true) {
                 // Mostrar el menú de opciones
           
            System.out.println("\nOpciones:");
            System.out.println("1. Insertar un elemento");
            System.out.println("2. Buscar un elemento");
            System.out.println("3. Eliminar un elemento");
            System.out.println("4. Imprimir la tabla hash");
            System.out.println("5. Salir");
            System.out.print("Ingrese su opción: ");
            int opcion = scanner.nextInt();
          // Realizar la acción correspondiente a la opción seleccionada
            switch (opcion) {
                case 1:
                    System.out.print("Ingrese la clave: ");
                    int clave = scanner.nextInt();
                    System.out.print("Ingrese el valor: ");
                    int valor = scanner.nextInt();
                    hashMap.poner(clave, valor);
                    break;
                case 2:
                    System.out.print("Ingrese la clave a buscar: ");
                    clave = scanner.nextInt();
                    valor = hashMap.obtener(clave);
                    if (valor != -1) {
                        System.out.println("Valor encontrado: " + valor);
                    } else {
                        System.out.println("Valor no encontrado");
                    }
                    break;
                case 3:
                    System.out.print("Ingrese la clave a eliminar: ");
                    clave = scanner.nextInt();
                    hashMap.eliminar(clave);
                    break;
                case 4:
                    hashMap.imprimirHashMap();
                    break;
                case 5:
                    System.out.println("Saliendo...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        }
    }
}