package DiseñoModular;

public class Productos {
    String nombre;
    String origen;
    double precio;

    public Productos(String nombreProducto, String origenProducto, double precioProducto) {
        nombre = nombreProducto;
        origen = origenProducto;
        precio = precioProducto;
    }

    public String toString() {
        return nombre + " - Origen: " + origen + " - Precio: " + precio + "€";
    }
}