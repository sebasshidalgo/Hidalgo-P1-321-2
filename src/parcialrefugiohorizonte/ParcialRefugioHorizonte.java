package parcialrefugiohorizonte;

import java.util.ArrayList;

/**
 * Programa de prueba. 
 */
public class ParcialRefugioHorizonte {

    /**
     * Registra supervivientes y muestra aptitudes, tareas, capacitaciones y filtros.
     * @param args
     */
    public static void main(String[] args) {
        Refugio refugio = new Refugio("Horizonte");

        try {
            refugio.agregarSuperviviente(new Explorador(
                    "EXP-101", "Ada", NivelExperiencia.EXPERTO, true, 30));
            refugio.agregarSuperviviente(new Medico(
                    "MED-220", "Bruno", NivelExperiencia.INTERMEDIO, true, 45));
            refugio.agregarSuperviviente(new Constructor(
                    "CON-330", "Carla", NivelExperiencia.EXPERTO, true, 25));
            refugio.agregarSuperviviente(new Explorador(
                    "EXP-404", "Diego", NivelExperiencia.NOVATO, true, 18));
            refugio.agregarSuperviviente(new Medico(
                    "EXP-101", "Ada", NivelExperiencia.NOVATO, true, 12));
        } catch (SupervivienteDuplicadoException e) {
            System.out.println("No se pudo registrar: " + e.getMessage());
        }

        System.out.println("Supervivientes registrados:");
        mostrarSupervivientes(refugio.obtenerSupervivientes());
        System.out.println("\nAptitudes:");
        mostrarAptitudes(refugio.obtenerSupervivientes());
        System.out.println("\nAsignación de tareas:");
        asignarTareas(refugio.obtenerSupervivientes());
        System.out.println("\nCapacitaciones:");
        capacitarSupervivientes(refugio.obtenerSupervivientes());
        System.out.println("\nDisponibles con aptitud >= 50:");
        mostrarSupervivientes(refugio.obtenerDisponiblesConAptitudMinima(50));
        System.out.println("\nSupervivientes EXPERTO:");
        mostrarSupervivientes(refugio.filtrarPorNivel(NivelExperiencia.EXPERTO));
    }

    /**
     * Muestra los datos de cada superviviente.
     *
     * @param lista supervivientes que se desean mostrar
     */
    private static void mostrarSupervivientes(ArrayList<Superviviente> lista) {
        for (Superviviente superviviente : lista) {
            System.out.println(superviviente);
        }
    }

    /**
     * Muestra la aptitud calculada según la especialidad de cada superviviente.
     *
     * @param lista supervivientes cuyas aptitudes se desean mostrar
     */
    private static void mostrarAptitudes(ArrayList<Superviviente> lista) {
        for (Superviviente superviviente : lista) {
            System.out.println(superviviente.getNombre() + ": " + superviviente.calcularAptitud());
        }
    }

    /**
     * Asigna una misión a quienes pueden recibir tareas.
     *
     * @param lista supervivientes del refugio
     */
    private static void asignarTareas(ArrayList<Superviviente> lista) {
        for (Superviviente superviviente : lista) {
            if (superviviente instanceof Asignable) {
                Asignable asignable = (Asignable) superviviente;
                System.out.println(asignable.asignarTarea("Misión de apoyo"));
            } else {
                System.out.println(superviviente.getNombre() + " no puede recibir tareas.");
            }
        }
    }

    /**
     * Capacita a quienes tienen esa capacidad.
     *
     * @param lista supervivientes del refugio
     */
    private static void capacitarSupervivientes(ArrayList<Superviviente> lista) {
        for (Superviviente superviviente : lista) {
            if (superviviente instanceof Capacitable) {
                Capacitable capacitable = (Capacitable) superviviente;
                System.out.println(capacitable.capacitar());
            } else {
                System.out.println(superviviente.getNombre() + " no puede capacitarse.");
            }
        }
    }
    
}
