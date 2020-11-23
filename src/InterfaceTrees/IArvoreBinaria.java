package InterfaceTrees;

import Arvores.BinariaBusca.ArvoreBinariaBusca;
import Arvores.No;
import Arvores.Binaria.ArvoreBinaria;
import Exceptions.NoNaoExiste;
import Exceptions.PossuiFilhoNaDireita;
import Exceptions.PossuiFilhoNaEsquerda;

/**
 *
 * @author ErikDCAlmeida
 */
public interface IArvoreBinaria<T extends Comparable<T>> {
    public abstract void adicionarNo(T elemento, T elementoNoPai, char posFilho) throws PossuiFilhoNaDireita, PossuiFilhoNaEsquerda;
    public abstract boolean consultarExistenciaNo(T elemento);
    public abstract int grauNo(T elemento) throws NoNaoExiste;
    public abstract int profundidadeNo(T elemento)throws NoNaoExiste;
    public abstract int alturaNo(T elemento) throws NoNaoExiste;
    public abstract int nivelNo(T elemento) throws NoNaoExiste;
    public abstract int quantidadeNoArvore(No<T> raizAtual);
    public abstract void removerNo(T elemento);
    public abstract StringBuilder navegarPelaArvore();
    public abstract ArvoreBinaria<T> inverterSubArvores();
    public abstract ArvoreBinariaBusca<T> transformarEmBinariaBusca();
}   
