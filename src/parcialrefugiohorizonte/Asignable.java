package parcialrefugiohorizonte;


/**
 * Capacidad de recibir tareas del refugio.
 */
public interface Asignable {
    
    /**
     * Asigna una tarea y deja ocupado al superviviente.
     *
     * @param tarea descripción de la tarea
     * @return confirmación de la asignación
     * @throws IllegalArgumentException si la tarea es nula o está en blanco
     * @throws IllegalStateException si el superviviente está ocupado
     */
    public abstract String asignarTarea(String tarea);
    
}
