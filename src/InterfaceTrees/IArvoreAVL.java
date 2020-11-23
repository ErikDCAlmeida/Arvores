package InterfaceTrees;

import Arvores.ArvoreAVL.NoAVL;
import Exceptions.NoNaoExiste;

/**
 *
 * @author ErikDCAlmeida
 */
public interface IArvoreAVL<T> {
    public abstract void adicionarNo(T elemento);
    public abstract boolean consultarExistenciaNo(T elemento);
    public abstract int balancoNo(T elemento);
    public abstract int grauNo(T elemento);
    public abstract int profundidadeNo(T elemento)throws NoNaoExiste;
    public abstract int alturaNo(T elemento);
    public abstract int nivelNo(T elemento) throws NoNaoExiste;
    public abstract int quantidadeNoArvore(NoAVL<T> raizAtual);
    public abstract void removerNo(T elemento);
    public abstract StringBuilder navegarPelaArvore();
    public abstract StringBuilder especificaLRN();
    public abstract StringBuilder especificaLNR();
    public abstract StringBuilder especificaNLR();
}
