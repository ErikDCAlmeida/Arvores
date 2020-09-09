/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Arvores;
import java.util.ArrayList;
import java.util.Iterator;
import Exceptions.PossuiFilhoNaDireita;
import Exceptions.PossuiFilhoNaEsquerda;
import InterfaceTrees.IArvoreBinaria;
/**
 *
 * @author EriikD
 */
public class ArvoreBinaria<T> implements IArvoreBinaria<T>{

    private ArrayList<No> arrayNos;
    private No raizDaArvore;

    public ArvoreBinaria() {
        this.arrayNos = new ArrayList<>();
        this.raizDaArvore = null;
    }
    
    @Override
    public void adicionarNo(T nome, No noPai, char posicao) throws PossuiFilhoNaDireita, PossuiFilhoNaEsquerda{
        No noAux = new No(nome, noPai);
        if (noAux.possuiPai() == false) {
            this.raizDaArvore = noAux;
            this.arrayNos.add(noAux);
        }else{
            if ( (posicao == 'E' || posicao == 'e') && noPai.possuiFilhoEsquerdo() ) {
                throw new PossuiFilhoNaEsquerda();
            }
            else if ( (posicao == 'D' || posicao == 'd') && noPai.possuiFilhoDireito()) {
                throw new PossuiFilhoNaDireita();
            }
            else{
                if (posicao == 'E' || posicao == 'e') {
                    noPai.setFilhoEsquerdo(noAux);
                }else if (posicao == 'D' || posicao == 'd') {
                    noPai.setFilhoDireito(noAux);
                }
            }
        }
    }

    @Override
    public boolean consultarNo(String nome) {
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

    public ArrayList<No> getArrayNos() {
        return arrayNos;
    }

    public No getRaizDaArvore() {
        return raizDaArvore;
    }
    
}
