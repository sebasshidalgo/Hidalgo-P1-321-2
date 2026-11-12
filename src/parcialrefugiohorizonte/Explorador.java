package parcialrefugiohorizonte;


/**
 * Superviviente especializado en exploración que puede recibir tareas.
 */
public class Explorador extends Superviviente implements Asignable {
    
    private final int resistencia;
    
    public Explorador(String codigo, String nombre, NivelExperiencia nivel, boolean disponible, int resistencia) {
        super(codigo, nombre, nivel, disponible);
        
        validarPositivo(resistencia);
        this.resistencia = resistencia;
    }

    public int getResistencia() {
        return resistencia;
    }
    
    
    @Override
    public int calcularAptitud() {
        return resistencia * 2;
    }

    @Override
    public String asignarTarea(String tarea) {
        validarTexto(tarea, "Indicar tarea es obligatorio.");
        if (!isDisponible()) {
            throw new IllegalStateException("El Explorador está ocupado con otra tarea.");
        }
        ocupar();
        return "Se asignó a " + getNombre() + " la tarea: " + tarea + ".";
    }

    @Override
    public String toString() {
        return "Explorador [" + datosComunes() + ", resistencia=" + resistencia + "]";
    }   

}
