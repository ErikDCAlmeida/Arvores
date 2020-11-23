package Arvores.ArvoreAVL;

/**
 *
 * @author ErikDCAlmeida
 */
public class NoAVL<T> {
    
    private T elemento;
    private NoAVL<T> filhoEsquerdo;
    private NoAVL<T> filhoDireito;
    private NoAVL<T> pai;
    private int balancoNo;
    
    public NoAVL(T elemento, NoAVL<T> pai) {
        this.elemento = elemento;
        this.pai = pai;
        this.filhoDireito = null;
        this.filhoEsquerdo = null;
        this.balancoNo = 0;
    }

    public NoAVL(T elemento) {
        this(elemento, null);
    }
    
    public int qntDeFilhosNo(){
        int cont = 0;
        if (this.filhoDireito != null) {
            cont++;
        }
        if (this.filhoEsquerdo != null) {
            cont++;
        }
        return cont;
    }
    
    public boolean possuiFilhoEsquerdo(){
        return this.filhoEsquerdo != null;
    }
    
    public boolean possuiFilhoDireito(){
        return this.filhoDireito != null;
    }
    
    public boolean possuiPai(){
        return this.pai != null;
    }
    
    public T getElemento() {
        return elemento;
    }

    public NoAVL<T> getFilhoEsquerdo() {
        return filhoEsquerdo;
    }

    public void setFilhoEsquerdo(NoAVL<T> filhoEsquerdo) {
        this.filhoEsquerdo = filhoEsquerdo;
    }

    public NoAVL<T> getFilhoDireito() {
        return filhoDireito;
    }

    public void setFilhoDireito(NoAVL<T> filhoDireito) {
        this.filhoDireito = filhoDireito;
    }

    public NoAVL<T> getPai() {
        return pai;
    }

    public void setPai(NoAVL<T> pai) {
        this.pai = pai;
    }

    public int getBalancoNo() {
        return balancoNo;
    }

    public void setBalancoNo(int balancoNo) {
        this.balancoNo = balancoNo;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        
        @SuppressWarnings ("unchecked")
        NoAVL<T> other = (NoAVL<T>) obj;
        
        return this.elemento == other.elemento;
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        string.append("Nome: ").append(this.elemento);
        if (this.filhoEsquerdo != null) {
            string.append("\nFilho esquerdo: ").append(this.filhoEsquerdo);
        }
        if (this.filhoDireito != null) {
            string.append("\nFilho direito: ").append(this.filhoDireito);
        }
        string.append("\n");
        string.append("Balanço: ").append(this.balancoNo);
        return string.toString();
    } 

}
