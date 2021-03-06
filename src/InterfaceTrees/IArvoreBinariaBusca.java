package InterfaceTrees;

import Arvores.No;
import Exceptions.NoNaoExiste;

/**
 *
 * @author ErikDCAlmeida
 */
public interface IArvoreBinariaBusca<T> {
    public abstract void adicionarNo(T elemento);
    public abstract boolean consultarExistenciaNo(T elemento);
    public abstract int grauNo(T elemento) throws NoNaoExiste;
    public abstract int profundidadeNo(T elemento)throws NoNaoExiste;
    public abstract int alturaNo(T elemento) throws NoNaoExiste;
    public abstract int nivelNo(T elemento) throws NoNaoExiste;
    public abstract int quantidadeNoArvore(No<T> raizAtual);
    public abstract void removerNo(T elemento);
    public abstract StringBuilder navegarPelaArvore();
}
