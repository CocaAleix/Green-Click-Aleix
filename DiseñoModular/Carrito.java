package DiseñoModular;

import java.util.*;

public class Carrito {
    public Map<Productos, Double> items = new HashMap<>();

    public void agregarProducto(Productos producto, double cantidad) {
        items.put(producto, items.getOrDefault(producto, 0.0) + cantidad);
    }

    public void eliminarProducto(Productos producto) {
        items.remove(producto);
    }

    public double calcularTotal() {
        double total = 0;
        List<Map.Entry<Productos, Double>> entryList = new ArrayList<>(items.entrySet());
        for (int i = 0; i < entryList.size(); i++) {
            Map.Entry<Productos, Double> entry = entryList.get(i);
            total += entry.getKey().precio * entry.getValue();
        }
        return total;
    }

    public void mostrarCarrito() {
        List<Map.Entry<Productos, Double>> entryList = new ArrayList<>(items.entrySet());
        for (int i = 0; i < entryList.size(); i++) {
            Map.Entry<Productos, Double> entry = entryList.get(i);
            System.out.println(entry.getKey().nombre + " x " + entry.getValue() + "kg - Subtotal: " 
            + (entry.getKey().precio * entry.getValue()) + "€");
        }
    }
}