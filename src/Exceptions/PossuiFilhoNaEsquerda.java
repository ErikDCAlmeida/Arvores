package Exceptions;

/**
 *
 * @author ErikDCAlmeida
 */
public class PossuiFilhoNaEsquerda extends Exception {

    private static final long serialVersionUID = 1L;

    @Override
    public String getMessage() {
        return "O no pai ja possui filho na sua esquerda!";
    }
    
}
