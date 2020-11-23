package Exceptions;

/**
 *
 * @author ErikDCAlmeida
 */
public class PossuiFilhoNaDireita extends Exception{
    
    private static final long serialVersionUID = 1L;

    @Override
    public String getMessage() {
        return "O n pai ja possui filho na sua direita!";
    }
    
}
