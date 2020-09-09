/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InterfaceTrees;

/**
 *
 * @author EriikD
 */
public interface BinaryTree<T> extends Iterable<T> {
    public abstract void adicionarNo(T elemento);
    public abstract boolean consultarNo(T elemento);
    public abstract int grauNo(T elemento);
    public abstract int profundidadeNo(T elemento);
    public abstract int alturaNo(T elemento);
    public abstract int nivelNo(T elemento);
    public abstract int quantidadeNoArvore();
    public abstract boolean removerNo(T elemento);
    public abstract void navegarPelaArvore();
    public abstract void inverterSubArvores();
}   
