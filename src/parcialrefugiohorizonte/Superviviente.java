package parcialrefugiohorizonte;

import java.util.Objects;

/**
 * Modelo base de los supervivientes del refugio.
 * La igualdad depende del código y el nombre, sin importar la especialidad.
 */
public abstract class Superviviente {
    
    private final String codigo;
    private final String nombre;
    private final NivelExperiencia nivel;
    private boolean disponible;

    protected Superviviente(String codigo, String nombre, NivelExperiencia nivel, boolean disponible) {
        validarTexto(codigo, "El código no puede ser nulo, ni estar en blanco.");
        validarTexto(nombre, "El nombre no puede ser nulo, ni estar en blanco.");
        validarNivel(nivel);
        this.codigo = codigo;
        this.nombre = nombre;
        this.nivel = nivel;
        this.disponible = disponible;
    }
    
    protected static void validarTexto(String texto, String mensaje){
        if(texto == null || texto.isBlank()) {
            throw new IllegalArgumentException(mensaje);
        }
    }
    
    protected static void validarNivel(NivelExperiencia nivel){
        if(nivel == null) {
            throw new IllegalArgumentException("El nivel de experiencia no puede ser nulo.");
        }
    }
    
    protected static void validarPositivo(int valor){
        if (valor <= 0) {
            throw new IllegalArgumentException("El valor debe ser estrictamente positivo.");
        }
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public NivelExperiencia getNivel() {
        return nivel;
    }

    public boolean isDisponible() {
        return disponible;
    }

    /**
     * Permite que las subclases marquen al superviviente como ocupado.
     */
    protected final void ocupar() {
        disponible = false;
    }
    
    /**
     * Calcula la aptitud según la especialidad.
     *
     * @return valor de aptitud del superviviente
     */
    public abstract int calcularAptitud();

    protected String datosComunes() {
        return "codigo=" + codigo + ", nombre=" + nombre
                + ", nivel=" + nivel + ", disponible=" + disponible;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (!(o instanceof Superviviente)) {
            return false;
        }

        Superviviente s = (Superviviente) o;

        return this.codigo.equals(s.codigo) && this.nombre.equals(s.nombre);
    }
    
    
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.codigo);
        hash = 97 * hash + Objects.hashCode(this.nombre);
        return hash;
    }

    @Override
    public String toString() {
        return "Superviviente [" + datosComunes() + "]";
    }
    
   
}
