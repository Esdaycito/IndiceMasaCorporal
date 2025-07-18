package mx.edu.itspa.tics.indicemasacorporal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class AppIMC {
    public static void main(String[] args) throws IOException {
        ServicioIMC serviceTask = new ServicioIMC();
        BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));

        int opcionSeleccionada = 0;

        do {
            System.out.println("Calculadora de tu Indice de Masa Corporal");
            System.out.println("1. Calcular tu indice de masa corporal");
            System.out.println("2. Mostrar los calculos realizados");
            System.out.println("3. Eliminar un calculo");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opcion con el numero correspondiente: ");
            opcionSeleccionada = Integer.parseInt(leer.readLine());

            switch (opcionSeleccionada) {
                case 1:
                    System.out.println("Ingresa tu nombre:");
                    String nombre = leer.readLine();
                    System.out.println("Ingresa tu peso en KG:");
                    double peso = Double.parseDouble(leer.readLine());
                    System.out.println("Ingresa tu estatura:");
                    double estatura = Double.parseDouble(leer.readLine());

                    TareaIMC calculo = new TareaIMC(nombre, peso, estatura);
                    serviceTask.agregarCalculo(calculo);

                    System.out.println("Nombre: " + calculo.getNombre());
                    System.out.println("Fecha: " + calculo.getFecha());
                    System.out.println("Su IMC es: " + calculo.getImc());
                    System.out.println("Clasificación: " + calculo.getResultado());
                    break;

                case 2:
                    List<TareaIMC> historial = serviceTask.obtenerCalculos();
                    if (historial.isEmpty()) {
                        System.out.println("No hay cálculos registrados.");
                    } else {
                        int index = 0;
                        for (TareaIMC t : historial) {
                            System.out.println(index + ". Nombre: " + t.getNombre() +
                                    ", Fecha: " + t.getFecha() +
                                    ", IMC: " + t.getImc() +
                                    ", Clasificación: " + t.getResultado());
                            index++;
                        }
                    }
                    break;

                case 3:
                    System.out.print("Ingrese el índice del cálculo a eliminar: ");
                    int indice = Integer.parseInt(leer.readLine());

                    if (serviceTask.eliminarCalculo(indice)) {
                        System.out.println("Cálculo eliminado correctamente.");
                    } else {
                        System.out.println("Índice inválido.");
                    }
                    break;

                case 4:
                    System.out.println("Saliendo...");
                    break;

                default:
                    System.out.println("Opción inválida.");
            }

            System.out.println();
        } while (opcionSeleccionada != 4);
    }
}
