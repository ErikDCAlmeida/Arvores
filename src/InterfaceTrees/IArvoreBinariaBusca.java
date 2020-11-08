/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InterfaceTrees;

import Arvores.ArvoreBinariaBusca;
import Arvores.No;
import Exceptions.NoNaoExiste;

/**
 *
 * @author EriikD
 */
public interface IArvoreBinariaBusca<T> {
    public abstract void adicionarNo(T elemento);
    public abstract boolean consultarExistenciaNo(T elemento);
    public abstract int grauNo(T elemento) throws NoNaoExiste;
    public abstract int profundidadeNo(T elemento)throws NoNaoExiste;
    public abstract int alturaNo(T elemento) throws NoNaoExiste;
    public abstract int nivelNo(T elemento) throws NoNaoExiste;
    public abstract int quantidadeNoArvore(No<T> raizAtual);
    public abstract boolean removerNo(T elemento);
    public abstract StringBuilder navegarPelaArvore();
}
