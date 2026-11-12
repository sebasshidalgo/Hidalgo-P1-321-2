package parcialrefugiohorizonte;

/**
 * Superviviente especializado en construcción que puede recibir tareas y capacitarse.
 */
public class Constructor extends Superviviente implements Asignable, Capacitable {
                    
    private final int habilidadTecnica;

    public Constructor(String codigo, String nombre, NivelExperiencia nivel, boolean disponible, int habilidadTecnica) {
        super(codigo, nombre, nivel, disponible);
        
        validarPositivo(habilidadTecnica);
        this.habilidadTecnica = habilidadTecnica;
    }

    public int getHabilidadTecnica() {
        return habilidadTecnica;
    }

    @Override
    public int calcularAptitud() {
        return habilidadTecnica * 3;
    }

    @Override
    public String asignarTarea(String tarea) {
        validarTexto(tarea, "Indicar tarea es obligatorio.");
        if (!isDisponible()) {
            throw new IllegalStateException("El constructor está ocupado con otra tarea.");
        }
        ocupar();
        return "Se asignó a " + getNombre() + " la tarea: " + tarea + ".";
    }

    @Override
    public String capacitar() {
        return "Se capacitó a " + getNombre() + " (" + getCodigo() + ").";
    }

    @Override
    public String toString() {
        return "Constructor [" + datosComunes() + ", habilidadTecnica=" + habilidadTecnica + "]";
    }

}
