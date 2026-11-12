package parcialrefugiohorizonte;

import java.util.ArrayList;

/**
 * Administra los supervivientes registrados y permite consultarlos por nivel y aptitud.
 */
public class Refugio {

    private final String nombre;
    private final ArrayList<Superviviente> supervivientes;

    public Refugio(String nombre) {
        Superviviente.validarTexto(nombre, "El nombre del refugio no puede ser nulo ni estar en blanco.");
        this.nombre = nombre;
        this.supervivientes = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    /**
     * Registra un superviviente sin permitir duplicados por código y nombre.
     *
     * @param superviviente superviviente que se desea registrar
     * @throws SupervivienteDuplicadoException si ya existe otro igual
     * @throws IllegalArgumentException si el superviviente es nulo
     */
    public void agregarSuperviviente(Superviviente superviviente) throws SupervivienteDuplicadoException {
        if (superviviente == null) {
            throw new IllegalArgumentException("El superviviente no puede ser nulo.");
        }
        if (supervivientes.contains(superviviente)) {
            throw new SupervivienteDuplicadoException("Ya existe un superviviente con código "
                    + superviviente.getCodigo() + " y nombre " + superviviente.getNombre() + ".");
        }
        supervivientes.add(superviviente);
    }

    /**
     * Devuelve una copia de la lista para proteger la colección interna.
     *
     * @return lista con todos los supervivientes registrados
     */
    public ArrayList<Superviviente> obtenerSupervivientes() {
        return new ArrayList<>(supervivientes);
    }

    /**
     * Busca los supervivientes que tienen el nivel de experiencia solicitado.
     *
     * @param nivel nivel de experiencia que se desea buscar
     * @return lista de supervivientes del nivel solicitado
     * @throws IllegalArgumentException si el nivel es nulo
     */
    public ArrayList<Superviviente> filtrarPorNivel(NivelExperiencia nivel) {
        Superviviente.validarNivel(nivel);
        ArrayList<Superviviente> resultado = new ArrayList<>();
        for (Superviviente superviviente : supervivientes) {
            if (superviviente.getNivel() == nivel) {
                resultado.add(superviviente);
            }
        }
        return resultado;
    }

    /**
     * Busca supervivientes disponibles cuya aptitud alcanza el mínimo indicado.
     *
     * @param minimo aptitud mínima, mayor o igual que cero
     * @return lista de supervivientes que cumplen ambas condiciones
     * @throws IllegalArgumentException si el mínimo es negativo
     */
    public ArrayList<Superviviente> obtenerDisponiblesConAptitudMinima(int minimo) {
        if (minimo < 0) {
            throw new IllegalArgumentException("La aptitud mínima no puede ser negativa.");
        }
        ArrayList<Superviviente> resultado = new ArrayList<>();
        for (Superviviente superviviente : supervivientes) {
            if (superviviente.isDisponible() && superviviente.calcularAptitud() >= minimo) {
                resultado.add(superviviente);
            }
        }
        return resultado;
    }
}
