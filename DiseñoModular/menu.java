package DiseñoModular;

import java.util.List;
import java.util.Scanner;

public class menu {
    public static void main(String[] args) {
        String[] hierba = { "Maria Juana", "Hierba de los bosques", "La seta feliz", "El oro verde" };
        String[] origen = { "Mexico", "Andorra", "Marruecos", "Palestina" };
        double[] precio = { 1.70, 4.20, 2.47, 1.33 };

        GestorProductos gestor = new GestorProductos(hierba, origen, precio);
        Carrito carrito = new Carrito();
        Scanner scanner = new Scanner(System.in);
        int opcion;

        // Bucle para mostrar el menú
        for (;;) { // Bucle infinito, se romperá con una opción de salida
            System.out.println("\n--- Menú ---");
            System.out.println("1. Buscar por nombre");
            System.out.println("2. Buscar por origen");
            System.out.println("3. Ordenar productos");
            System.out.println("4. Añadir al carrito");
            System.out.println("5. Mostrar carrito");
            System.out.println("6. Eliminar del carrito");
            System.out.println("7. Finalizar compra");
            System.out.println("0. Salir");
            System.out.print("Elige una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer

            if (opcion == 0) {
                System.out.println("Saliendo del programa...");
                break; // Salir del bucle
            }

            // Manejo de opciones
            if (opcion == 1) {
                System.out.print("Introduce el nombre a buscar: ");
                String nombre = scanner.nextLine();
                List<Productos> resultados = gestor.buscarPorNombre(nombre);
                resultados.forEach(System.out::println);
                
            } else if (opcion == 2) {
                System.out.print("Introduce el origen a buscar: ");
                String origenBuscado = scanner.nextLine();
                List<Productos> resultados = gestor.buscarPorOrigen(origenBuscado);
                resultados.forEach(System.out::println);
                
            } else if (opcion == 3) {
                System.out.print("¿Ordenar de forma ascendente? (true/false): ");
                boolean ascendente = scanner.nextBoolean();
                gestor.ordenarPorPrecio(ascendente);
                gestor.mostrarProductos();
                
            } else if (opcion == 4) {
                System.out.print("Introduce el nombre del producto a añadir al carrito: ");
                String productoNombre = scanner.nextLine();
                Productos producto = gestor.buscarPorNombre(productoNombre).get(0);
                System.out.print("Introduce la cantidad: ");
                double cantidad = scanner.nextDouble();
                carrito.agregarProducto(producto, cantidad);
                
            } else if (opcion == 5) {
                carrito.mostrarCarrito();
                
            } else if (opcion == 6) {
                System.out.print("Introduce el nombre del producto a eliminar del carrito: ");
                String eliminarNombre = scanner.nextLine();
                Productos eliminarProducto = gestor.buscarPorNombre(eliminarNombre).get(0);
                carrito.eliminarProducto(eliminarProducto);
                
            } else if (opcion == 7) {
                System.out.println("Total a pagar: " + carrito.calcularTotal() + "€");
                
            } else {
                System.out.println("Opción no válida. Inténtalo de nuevo.");
            }
        }

        scanner.close();
    }
}