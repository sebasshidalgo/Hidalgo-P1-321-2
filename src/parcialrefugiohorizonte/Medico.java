package parcialrefugiohorizonte;

/**
 * Superviviente especializado en medicina que puede capacitarse.
 */
public class Medico extends Superviviente implements Capacitable {

    private final int conocimientos;

    public Medico(String codigo, String nombre, NivelExperiencia nivel, boolean disponible, int conocimientos) {
        super(codigo, nombre, nivel, disponible);
        validarPositivo(conocimientos);
        this.conocimientos = conocimientos;
    }

    public int getConocimientos() {
        return conocimientos;
    }

    @Override
    public int calcularAptitud() {
        return conocimientos + 10;
    }

    @Override
    public String capacitar() {
        return "Se capacitó a " + getNombre() + " (" + getCodigo() + ").";
    }

    @Override
    public String toString() {
        return "Medico [" + datosComunes() + ", conocimientos=" + conocimientos + "]";
    }
}
