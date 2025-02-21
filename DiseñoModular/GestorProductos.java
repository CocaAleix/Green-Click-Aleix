package DiseñoModular;

import java.util.*;

public class GestorProductos {
    List<Productos> productos;

    public GestorProductos(String[] nombres, String[] origenes, double[] precios) {
        productos = new ArrayList<>();
        for (int i = 0; i < nombres.length; i++) {
            productos.add(new Productos(nombres[i], origenes[i], precios[i]));
        }
    }

    public List<Productos> buscarPorNombre(String nombre) {
        List<Productos> resultados = new ArrayList<>();
        for (int i = 0; i < productos.size(); i++) {
            Productos p = productos.get(i);
            if (p.nombre.toLowerCase().contains(nombre.toLowerCase())) {
                resultados.add(p);
            }
        }
        return resultados;
    }

    public List<Productos> buscarPorOrigen(String origen) {
        List<Productos> resultados = new ArrayList<>();
        for (int i = 0; i < productos.size(); i++) {
            Productos p = productos.get(i);
            if (p.origen.equalsIgnoreCase(origen)) {
                resultados.add(p);
            }
        }
        return resultados;
    }

    public void ordenarPorPrecio(boolean ascendente) {
        if (ascendente) {
            productos.sort((p1, p2) -> Double.compare(p1.precio, p2.precio));
        } else {
            productos.sort((p1, p2) -> Double.compare(p2.precio, p1.precio));
        }
    }

    public void mostrarProductos() {
        for (int i = 0; i < productos.size(); i++) {
            Productos p = productos.get(i);
            System.out.println(p);
        }
    }
}