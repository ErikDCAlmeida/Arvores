package Exceptions;

/**
 *
 * @author ErikDCAlmeida
 */
public class NoNaoExiste extends Exception{

    private static final long serialVersionUID = 1L;
    private final String info;
    
    public NoNaoExiste(String info) {
        this.info = info;
    }
    
    @Override
    public String getMessage() {
        return "O no com elemento '" + this.info + "' nao existe!";
    }
    
}
