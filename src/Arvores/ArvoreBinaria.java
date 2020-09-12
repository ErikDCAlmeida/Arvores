/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Arvores;

import Exceptions.PossuiFilhoNaDireita;
import Exceptions.PossuiFilhoNaEsquerda;
import Exceptions.NoNaoExiste;
import InterfaceTrees.IArvoreBinaria;
import java.util.logging.Level;
import java.util.logging.Logger;

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
        /*M�todo respons�vel por adicionar um n� na �rvore.*/
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
                    System.out.println("N�o foi poss�vel adicionar esse filho!");
                }
            }
        }
    }

    @Override
    public boolean consultarExistenciaNo(T elemento) {
        /*M�todo respons�vel para consultar um elemento dentro da �rvore. Verificar se ele existe.*/
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
    public int grauNo(T elemento) throws NoNaoExiste {
        /*M�todo respons�vel para saber o grau de um determinado n�.*/
        int contadorGrau = 0;

        No<T> noAux = this.pegarNo(elemento, raizDaArvore);

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
    public int profundidadeNo(T elemento) throws NoNaoExiste {
        /*M�todo respons�vel para saber a profundidade de um determinado n�.*/
        int profundidade = 0;

        No<T> noAux = this.pegarNo(elemento, raizDaArvore);

        if (noAux == null) {
            throw new NoNaoExiste(elemento.toString());
        } else {
            if (noAux.equals(this.raizDaArvore)) {
                return profundidade;
            } else {
                for (int i = 0; i < 1;) {
                    if (noAux.possuiPai() == true) {
                        profundidade += 1;
                        noAux = noAux.getPai();
                    } else {
                        return profundidade;
                    }
                }
            }
        }
        return 0;
    }

    @Override
    public int alturaNo(T elemento) throws NoNaoExiste {
        /*M�todo respons�vel por saber a altura de um determinado n�.*/
        int altura = 0;

        No<T> noAux = this.pegarNo(elemento, raizDaArvore);

        if (noAux == null) {
            throw new NoNaoExiste(elemento.toString());
        } else {
            if (noAux.equals(this.raizDaArvore)) {
                if (noAux.possuiFilhoDireito() == false && noAux.possuiFilhoEsquerdo() == false) {
                    return altura;
                } else {
                    return this.pegarAltura(noAux);
                }
            } else {
                return this.pegarAltura(noAux);
            }
        }
    }

    @Override
    public int nivelNo(T elemento) throws NoNaoExiste {
        /*M�todo respons�vel por saber a n�vel de um determinado n�.*/
        int nivel = 0;

        No<T> noAux = this.pegarNo(elemento, raizDaArvore);

        if (noAux == null) {
            throw new NoNaoExiste(elemento.toString());
        } else if (noAux.equals(this.raizDaArvore)) {
            return nivel + 1;
        } else {
            for (int i = 0; i < 1;) {
                if (noAux.possuiPai() == true) {
                    nivel += 1;
                    noAux = noAux.getPai();
                } else {
                    break;
                }
            }
            return nivel + 1;
        }
    }

    @Override
    public int quantidadeNoArvore() {
        /*M�todo recursivo para saber a quantidade de n�s na �rvore.*/
        if (this.raizDaArvore.possuiFilhoDireito() == false
                && this.raizDaArvore.possuiFilhoEsquerdo() == false) {
            return 0;
        } else {
            return contAux(this.raizDaArvore);
        }
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
    public StringBuilder navegarPelaArvore() throws NoNaoExiste {
        /*M�todo que percorre a �rvore baseado no LRN, LNR, NLR.*/
        StringBuilder string = new StringBuilder();
        StringBuilder stringLRN = new StringBuilder();
        StringBuilder stringLNR = new StringBuilder();
        StringBuilder stringNLR = new StringBuilder();
        stringLRN.append("\nLRN: ");
        stringLNR.append("\nLNR: ");
        stringNLR.append("\nNLR: ");
        if (this.raizDaArvore != null) {
            int filhosRaiz;
            filhosRaiz = this.grauNo(this.raizDaArvore.getElemento());
            if (filhosRaiz > 0) {
                stringLRN.append(this.LRN(this.raizDaArvore));
                stringLNR.append(this.LNR(this.raizDaArvore));
                stringNLR.append(this.NLR(this.raizDaArvore));
            }
        }else{
            throw new NoNaoExiste(this.raizDaArvore.getElemento().toString());
        }
        string.append(stringLRN).append(stringLNR).append(stringNLR);
        return string;
    }    

    @Override
    public void inverterSubArvores() {
        /*M�todo que permite a troca de sub-�rvores de uma �rvore. Imprimindo a �rvore original e a �rvore atualizada.*/

    }

    public No<T> getRaizDaArvore() {
        return raizDaArvore;
    }

    //=============================Private Methods==============================
    //==========================================================================
    private No<T> pegarNo(T elemento, No<T> noRaiz) {
        /*M�todo private que retorna um n�.
        Necess�rio passar o elemento do n� desejado e a raiz atual da �rvore.*/
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

    private int pegarAltura(No<T> raiz) {
        /*M�todo que permite pegar a altura de um n�.*/
        int alturaRaizEsquerda = 0;
        int alturaRaizDireita = 0;

        if (raiz.possuiFilhoDireito() == true) {
            alturaRaizEsquerda = this.pegarAltura(raiz.getFilhoDireito());
            alturaRaizEsquerda += 1;
        }

        if (raiz.possuiFilhoEsquerdo() == true) {
            alturaRaizDireita = this.pegarAltura(raiz.getFilhoEsquerdo());
            alturaRaizDireita += 1;
        }

        if (alturaRaizDireita > alturaRaizEsquerda) {
            return alturaRaizDireita;
        } else if (alturaRaizDireita < alturaRaizEsquerda) {
            return alturaRaizEsquerda;
        }
        return 0;
    }

    private int contAux(No<T> raiz) {
        /*M�todo auxiliar para retornar a quantidade de n�s de uma �rvore.*/
        int contador = 0;
        if (raiz != null) {
            contador += 1;
            if (raiz.possuiFilhoDireito() == true) {
                contador += this.contAux(raiz.getFilhoDireito());
            }

            if (raiz.possuiFilhoEsquerdo() == true) {
                contador += this.contAux(raiz.getFilhoEsquerdo());
            }
        }
        return contador;
    }
    
    private StringBuilder LRN(No<T> raizAtual){
        /*M�todo que faz a busca dos n�s seguindo a ordem LRN e 
        retornando um StringBuilder contendo os n�s nessa ordem.*/
        StringBuilder string = new StringBuilder();
        if (raizAtual != null) {
            if (raizAtual.possuiFilhoEsquerdo() == true) {
                string.append(this.LRN(raizAtual.getFilhoEsquerdo()));
            }
            if (raizAtual.possuiFilhoDireito() == true) {
                string.append(this.LRN(raizAtual.getFilhoDireito()));
            }
            string.append(raizAtual.getElemento()).append(" ");
        }
        return string;
    }
    
    private StringBuilder LNR(No<T> raizAtual){
        /*M�todo que faz a busca dos n�s seguindo a ordem LNR e 
        retornando um StringBuilder contendo os n�s nessa ordem.*/
        StringBuilder string = new StringBuilder();
        if (raizAtual != null) {
            if (raizAtual.possuiFilhoEsquerdo() == true) {
                string.append(this.LNR(raizAtual.getFilhoEsquerdo()));
            }
            string.append(raizAtual.getElemento()).append(" ");
            if (raizAtual.possuiFilhoDireito() == true) {
                string.append(this.LNR(raizAtual.getFilhoDireito()));
            }
        }
        return string;
    }
    
    private StringBuilder NLR(No<T> raizAtual){
        /*M�todo que faz a busca dos n�s seguindo a ordem NLR e 
        retornando um StringBuilder contendo os n�s nessa ordem.*/
        StringBuilder string = new StringBuilder();
        if (raizAtual != null) {
            string.append(raizAtual.getElemento()).append(" ");
            if (raizAtual.possuiFilhoEsquerdo() == true) {
                string.append(this.NLR(raizAtual.getFilhoEsquerdo()));
            }
            if (raizAtual.possuiFilhoDireito() == true) {
                string.append(this.NLR(raizAtual.getFilhoDireito()));
            }
        }
        return string;
    }
}
