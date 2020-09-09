/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Arvores;
import InterfaceTrees.BinaryTree;
import java.util.Iterator;
/**
 *
 * @author EriikD
 */
public class ArvoreBinaria<T> implements BinaryTree<T>{

    @Override
    public void adicionarNo(T elemento) {
        /*Método responsável para adicionar um nó na árvore.*/
        
        
    }

    @Override
    public boolean consultarNo(T elemento) {
        /*Método responsável para consultar um elemento dentro da árvore. Verificar se ele existe.*/
        
        
        return false;
    }

    @Override
    public int grauNo(T elemento) {
        /*Método responsável para saber o grau de um determinado nó.*/
        
        
        return 0;
    }

    @Override
    public int profundidadeNo(T elemento) {
        /*Método responsável para saber a profundidade de um determinado nó.*/
        
        
        return 0;
    }

    @Override
    public int alturaNo(T elemento) {
        /*Método responsável por saber a altura de um determinado nó.*/
        
        
        return 0;
    }

    @Override
    public int nivelNo(T elemento) {
        /*Método responsável por saber a nível de um determinado nó.*/
        
        
        return 0;
    }

    @Override
    public int quantidadeNoArvore() {
        /*Método recursivo para saber a quantidade de nós na árvore.*/
        
        
        return 0;
    }

    @Override
    public boolean removerNo(T elemento) {
        /*Método para remover nó. Baseado nas seguintes regras:
        1- O nó é folha: seu pai aponta para o vazio.
        2- O nó tem um filho: seu pai agora aponta para seu filho.
        3- O nó tem dois filhos: */
        
        
        return false;
    }

    @Override
    public void navegarPelaArvore() {
        /*Método que percorre a árvore baseado no LRN, LNR, NLR.*/
        
        
        
    }

    @Override
    public void inverterSubArvores() {
        /*Método que permite a troca de sub-árvores de uma árvore. Imprimindo a árvore original e a árvore atualizada.*/
        
        
        
    }

    @Override
    public Iterator<T> iterator() {
        /*Método para fazer o Iterator para percorrer a árvore.*/
        
        
        return null;
    }
    
}
