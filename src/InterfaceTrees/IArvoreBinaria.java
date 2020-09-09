/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InterfaceTrees;

import Arvores.No;
import Exceptions.PossuiFilhoNaDireita;
import Exceptions.PossuiFilhoNaEsquerda;

/**
 *
 * @author EriikD
 */
public interface IArvoreBinaria<T> extends Iterable<T> {
    public abstract void adicionarNo(T nome, No noPai, char posFilho) throws PossuiFilhoNaDireita, PossuiFilhoNaEsquerda;
    public abstract boolean consultarNo(String nome);
    public abstract int grauNo(T elemento);
    public abstract int profundidadeNo(T elemento);
    public abstract int alturaNo(T elemento);
    public abstract int nivelNo(T elemento);
    public abstract int quantidadeNoArvore();
    public abstract boolean removerNo(T elemento);
    public abstract void navegarPelaArvore();
    public abstract void inverterSubArvores();
}   
