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
        /*M�todo respons�vel para adicionar um n� na �rvore.*/
        
        
    }

    @Override
    public boolean consultarNo(T elemento) {
        /*M�todo respons�vel para consultar um elemento dentro da �rvore. Verificar se ele existe.*/
        
        
        return false;
    }

    @Override
    public int grauNo(T elemento) {
        /*M�todo respons�vel para saber o grau de um determinado n�.*/
        
        
        return 0;
    }

    @Override
    public int profundidadeNo(T elemento) {
        /*M�todo respons�vel para saber a profundidade de um determinado n�.*/
        
        
        return 0;
    }

    @Override
    public int alturaNo(T elemento) {
        /*M�todo respons�vel por saber a altura de um determinado n�.*/
        
        
        return 0;
    }

    @Override
    public int nivelNo(T elemento) {
        /*M�todo respons�vel por saber a n�vel de um determinado n�.*/
        
        
        return 0;
    }

    @Override
    public int quantidadeNoArvore() {
        /*M�todo recursivo para saber a quantidade de n�s na �rvore.*/
        
        
        return 0;
    }

    @Override
    public boolean removerNo(T elemento) {
        /*M�todo para remover n�. Baseado nas seguintes regras:
        1- O n� � folha: seu pai aponta para o vazio.
        2- O n� tem um filho: seu pai agora aponta para seu filho.
        3- O n� tem dois filhos: */
        
        
        return false;
    }

    @Override
    public void navegarPelaArvore() {
        /*M�todo que percorre a �rvore baseado no LRN, LNR, NLR.*/
        
        
        
    }

    @Override
    public void inverterSubArvores() {
        /*M�todo que permite a troca de sub-�rvores de uma �rvore. Imprimindo a �rvore original e a �rvore atualizada.*/
        
        
        
    }

    @Override
    public Iterator<T> iterator() {
        /*M�todo para fazer o Iterator para percorrer a �rvore.*/
        
        
        return null;
    }
    
}
