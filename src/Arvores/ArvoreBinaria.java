/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Arvores;

import java.util.Iterator;
import Exceptions.PossuiFilhoNaDireita;
import Exceptions.PossuiFilhoNaEsquerda;
import Exceptions.NoNaoExiste;
import InterfaceTrees.IArvoreBinaria;

/**
 *
 * @author EriikD
 */
public class ArvoreBinaria<T> implements IArvoreBinaria<T> {

    private No<T> raizDaArvore;

    public ArvoreBinaria() {
        this.raizDaArvore = null;
    }

    @Override
    public void adicionarNo(T nome, T elementoNoPai, char posicao) throws PossuiFilhoNaDireita, PossuiFilhoNaEsquerda {
        /*Método responsável por adicionar um nó na árvore.*/
        if (this.raizDaArvore == null) {
            this.raizDaArvore = new No<>(nome, null);
        } else {
            No<T> noPai = this.pegarNo(elementoNoPai, this.raizDaArvore);
            No<T> noAux = new No<>(nome, noPai);
            if (posicao == 'e' && noPai.possuiFilhoEsquerdo() == true) {
                throw new PossuiFilhoNaEsquerda();
            } else if (posicao == 'd' && noPai.possuiFilhoDireito() == true) {
                throw new PossuiFilhoNaDireita();
            } else {
                if (posicao == 'E' || posicao == 'e') {
                    noPai.setFilhoEsquerdo(noAux);
                } else if (posicao == 'D' || posicao == 'd') {
                    noPai.setFilhoDireito(noAux);
                } else {
                    System.out.println("Não foi possível adicionar esse filho!");
                }
            }
        }
    }

    private No<T> pegarNo(T elemento, No<T> noRaiz) {
        /*Método private que retorna um nó.*/
        No<T> filhoEsquerdo;
        No<T> filhoDireito;
        if (noRaiz != null) {
            if (noRaiz.getElemento().equals(elemento)) {
                return noRaiz;
            }

            filhoEsquerdo = pegarNo(elemento, noRaiz.getFilhoEsquerdo());
            if (filhoEsquerdo != null) {
                return filhoEsquerdo;
            }

            filhoDireito = pegarNo(elemento, noRaiz.getFilhoDireito());
            if (filhoDireito != null) {
                return filhoDireito;
            }
        }
        return null;
    }

    @Override
    public boolean consultarExistenciaNo(T elemento) {
        /*Método responsável para consultar um elemento dentro da árvore. Verificar se ele existe.*/
        if (this.raizDaArvore == null) {
            return false;
        } else {
            if (this.raizDaArvore.getElemento().equals(elemento)) {
                return true;
            } else {
                No<T> raizAux = this.raizDaArvore;
                No<T> filhoAux = this.pegarNo(elemento, raizAux);

                return filhoAux != null;
            }
        }
    }

    @Override
    public int grauNo(T elemento) throws NoNaoExiste{
        /*Método responsável para saber o grau de um determinado nó.*/
        int contadorGrau = 0;

        No noAux = this.pegarNo(elemento, raizDaArvore);

        if (noAux == null) {
            throw new NoNaoExiste(elemento.toString());
        }
        
        if (noAux.possuiFilhoDireito() == true) {
            contadorGrau += 1;
        }

        if (noAux.possuiFilhoEsquerdo() == true) {
            contadorGrau += 1;
        }

        return contadorGrau;
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

    public No<T> getRaizDaArvore() {
        return raizDaArvore;
    }

    private String String(T elemento) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
