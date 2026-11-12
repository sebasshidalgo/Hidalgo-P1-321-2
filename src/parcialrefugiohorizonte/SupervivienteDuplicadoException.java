package parcialrefugiohorizonte;

/**
 * Excepción comprobada que indica que un superviviente ya está registrado.
 */
public class SupervivienteDuplicadoException extends Exception {

    public SupervivienteDuplicadoException(String mensaje) {
        super(mensaje);
    }
}
