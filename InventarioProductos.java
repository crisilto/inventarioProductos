import java.util.Scanner;

public class InventarioProductos {
    Scanner sc = new Scanner(System.in);
    //Declaramos tres arrays para cada propiedad de nuestros productos y le damos una longitud máxima de 20
    String[] nombresProductos = new String[20];
    double[] preciosProductos = new double[20];
    int[] cantidadesProductos = new int[20];
    int indice = 0; //Variable para rastrear la posición en los arrays

    public void agregarProducto() {
        System.out.println("Nombre del nuevo producto: ");
        String nombre = sc.nextLine();
        System.out.println("Precio del nuevo producto: ");
        double precio = Double.parseDouble(sc.nextLine());
        System.out.println("Cantidad: ");
        int cantidad = Integer.parseInt(sc.nextLine());

        nombresProductos[indice] = nombre;
        preciosProductos[indice] = precio;
        cantidadesProductos[indice] = cantidad;

        indice++;

        System.out.println("Producto agregado con éxito!");
    }

    public void buscarProducto() {
        System.out.println("Introduce el nombre del producto a buscar: ");
        String nombreBuscado = sc.nextLine();

        for (int i = 0; i < indice; i++) {
            if (nombresProductos[i] != null && nombresProductos[i].equalsIgnoreCase(nombreBuscado)) {
                System.out.println("Producto encontrado: \nNombre: " + nombresProductos[i] + "\nPrecio: " + preciosProductos[i] + "" +
                        "\nCantidad en stock: " + cantidadesProductos[i]);
                return;
            }
        }
        System.out.println("Producto no encontrado en el inventario.");
    }

    public void actualizarProducto() {
        System.out.println("Introduce el nombre del producto a actualizar: ");
        String nombreBuscado = sc.nextLine();

        for (int i = 0; i < indice; i++) {
            if (nombresProductos[i] != null && nombresProductos[i].equalsIgnoreCase(nombreBuscado)) {
                System.out.println("Nombre actual: " + nombresProductos[i] + "\nIntroduce su nuevo nombre: ");
                String nombreActualizado = sc.nextLine();
                System.out.println("Precio actual: " + preciosProductos[i] + "\nIntroduce su nuevo precio: ");
                double precioActualizado = Double.parseDouble(sc.nextLine());
                System.out.println("Cantidad actual: " + cantidadesProductos[i] + "\nIntroduce su nueva cantidad: ");
                int cantidadActualizada = Integer.parseInt(sc.nextLine());

                nombresProductos[i] = nombreActualizado;
                preciosProductos[i] = precioActualizado;
                cantidadesProductos[i] = cantidadActualizada;

                System.out.println("Producto actualizado con éxito!");
                return;
            }
        }
        System.out.println("Producto no encontrado en el inventario.");
    }

    public void eliminarProducto() {
        System.out.println("Introduce el nombre del producto a eliminar: ");
        String nombreBuscado = sc.nextLine();

        for (int i = 0; i < indice; i++) {
            if (nombresProductos[i] != null && nombresProductos[i].equalsIgnoreCase(nombreBuscado)) {
                System.out.println("Producto encontrado. \nEliminando...");

                nombresProductos[i] = null;
                preciosProductos[i] = 0.0;
                cantidadesProductos[i] = 0;

                System.out.println("Producto eliminado con éxito!");
                return;
            }
        }
        System.out.println("Producto no encontrado en el inventario.");
    }

    public void mostrarInventario() {
        System.out.println("Aquí está tu inventario: ");

        for (int i = 0; i < indice; i++) {
            if (nombresProductos != null) {
                System.out.println("Nombre: " + nombresProductos[i] + ".\nPrecio: " + preciosProductos[i] + ".\nCantidad en stock: "
                        + cantidadesProductos[i] + "\n-------------------------------");
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        InventarioProductos inventario = new InventarioProductos();

        //Añadimos un booleano para controlar que el menú continúe permitiendo realizar acciones mientras el usuario no presione el 6.
        boolean salir = false;

        while (!salir) {
            //Menú interactivo
            System.out.println("¿Qué acción deseas realizar con el inventario?\n1. Agregar un producto nuevo.\n2. Buscar un producto" +
                    "por su nombre.\n3. Actualizar la información de un producto.\n4. Eliminar un producto.\n5.Visualizar inventario.\n6. Salir.");
            int accion = Integer.parseInt(sc.nextLine());

            switch (accion) {
                case 1:
                    inventario.agregarProducto();
                    break;
                case 2:
                    inventario.buscarProducto();
                    break;
                case 3:
                    inventario.actualizarProducto();
                    break;
                case 4:
                    inventario.eliminarProducto();
                    break;
                case 5:
                    inventario.mostrarInventario();
                    break;
                case 6:
                    System.out.println("Hasta luego.");
                    salir = true;
                    break;
                default:
                    System.out.println("Introduce un número válido entre el 1 y el 6.");
                    break;
            }
        }
    }
}
