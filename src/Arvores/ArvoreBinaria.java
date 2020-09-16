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
    public int grauNo(T elemento) throws NoNaoExiste {
        /*Método responsável para saber o grau de um determinado nó.*/
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
        /*Método responsável para saber a profundidade de um determinado nó.*/
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
        /*Método responsável por saber a altura de um determinado nó.*/
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
        /*Método responsável por saber a nível de um determinado nó.*/
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
        /*Método recursivo para saber a quantidade de nós na árvore.*/
        if (this.raizDaArvore.possuiFilhoDireito() == false
                && this.raizDaArvore.possuiFilhoEsquerdo() == false) {
            return 0;
        } else {
            return contAux(this.raizDaArvore);
        }
    }

    @Override
    public boolean removerNo(T elemento) {
        /*Método para remover nó. Baseado nas seguintes regras:
        1- O nó é folha: seu pai aponta para o vazio.
        2- O nó tem um filho: seu pai agora aponta para seu filho.
        3- O nó tem dois filhos: ???????*/
        if (this.raizDaArvore != null) {
            No<T> noAux = pegarNo(elemento, this.raizDaArvore);
            No<T> noPaiAux;
            No<T> noFilhoAux;

            if (noAux.possuiPai() == true) {
                noPaiAux = noAux.getPai();
                /*If para se caso o nó não tenha nenhum filho.*/
                if (noAux.qntDeFilhosNo() == 0) {
                    if (noPaiAux.getFilhoDireito() == noAux) {
                        noPaiAux.setFilhoDireito(null);
                        noAux.setPai(null);
                        return true;
                    } else if (noPaiAux.getFilhoEsquerdo() == noAux) {
                        noPaiAux.setFilhoEsquerdo(null);
                        noAux.setPai(null);
                        return true;
                    }
                    /*Else para que se o nó tenha um filho.*/
                } else if (noAux.qntDeFilhosNo() == 1) {
                    if (noAux.equals(noPaiAux.getFilhoDireito())) {
                        if (noAux.possuiFilhoDireito() == true && noAux.possuiFilhoEsquerdo() == false) {
                            noFilhoAux = noAux.getFilhoDireito();
                            noPaiAux.setFilhoDireito(noFilhoAux);
                            noFilhoAux.setPai(noPaiAux);
                            noAux.setFilhoDireito(null);
                            noAux.setPai(null);
                            return true;
                        } else if (noAux.possuiFilhoEsquerdo() == true && noAux.possuiFilhoDireito() == false) {
                            noFilhoAux = noAux.getFilhoEsquerdo();
                            noPaiAux.setFilhoDireito(noFilhoAux);
                            noFilhoAux.setPai(noPaiAux);
                            noAux.setFilhoEsquerdo(null);
                            noAux.setPai(null);
                            return true;
                        }
                    } else if (noAux.equals(noPaiAux.getFilhoEsquerdo())) {
                        if (noAux.possuiFilhoDireito() == true && noAux.possuiFilhoEsquerdo() == false) {
                            noFilhoAux = noAux.getFilhoDireito();
                            noPaiAux.setFilhoEsquerdo(noFilhoAux);
                            noFilhoAux.setPai(noPaiAux);
                            noAux.setFilhoDireito(null);
                            noAux.setPai(null);
                            return true;
                        } else if (noAux.possuiFilhoEsquerdo() == true && noAux.possuiFilhoDireito() == false) {
                            noFilhoAux = noAux.getFilhoEsquerdo();
                            noPaiAux.setFilhoEsquerdo(noFilhoAux);
                            noFilhoAux.setPai(noPaiAux);
                            noAux.setFilhoEsquerdo(null);
                            noAux.setPai(null);
                            return true;
                        }
                    }
                    /*Else if para que se o nó tenha 2 filhos.*/
                } else if (noAux.qntDeFilhosNo() == 2) {
                    System.out.println("Pra fazer!");
                    return false;
                }
            } else {
                noAux.setFilhoDireito(null);
                noAux.setFilhoEsquerdo(null);
                return true;
            }
        }
        return false;
    }

    @Override
    public StringBuilder navegarPelaArvore() {
        /*Método que percorre a árvore baseado no LRN, LNR, NLR.*/
        StringBuilder string = new StringBuilder();
        StringBuilder stringLRN = new StringBuilder();
        StringBuilder stringLNR = new StringBuilder();
        StringBuilder stringNLR = new StringBuilder();
        stringLRN.append("\nLRN: ");
        stringLNR.append("\nLNR: ");
        stringNLR.append("\nNLR: ");
        if (this.raizDaArvore != null) {
            stringLRN.append(this.LRN(this.raizDaArvore));
            stringLNR.append(this.LNR(this.raizDaArvore));
            stringNLR.append(this.NLR(this.raizDaArvore));
        }
        string.append(stringLRN).append(stringLNR).append(stringNLR);
        return string;
    }

    @Override
    public ArvoreBinaria<T> inverterSubArvores() {
        /*Método que permite a troca de sub-árvores de uma árvore. Imprimindo a árvore original e a árvore atualizada.*/
        if (this.raizDaArvore != null) {
            ArvoreBinaria<T> arvoreAux = new ArvoreBinaria<>();
            try {
                arvoreAux.adicionarNo(this.raizDaArvore.getElemento(), null, 'e');
            } catch (PossuiFilhoNaDireita | PossuiFilhoNaEsquerda ex) {
                Logger.getLogger(ArvoreBinaria.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            try {
                this.arvoreEspelhada(arvoreAux, this.raizDaArvore);
            } catch (PossuiFilhoNaDireita | PossuiFilhoNaEsquerda ex) {
                Logger.getLogger(ArvoreBinaria.class.getName()).log(Level.SEVERE, null, ex);
            }
            return arvoreAux;
        } else {
            System.out.println("Impossível inverter árvore!");
            return null;
        }
    }

    public No<T> getRaizDaArvore() {
        return raizDaArvore;
    }

    //=============================Private Methods==============================
    //==========================================================================
    private No<T> pegarNo(T elemento, No<T> noRaiz) {
        /*Método private que retorna um nó.
        Necessário passar o elemento do nó desejado e a raiz atual da árvore.*/
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
        /*Método que permite pegar a altura de um nó.*/
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
        /*Método auxiliar para retornar a quantidade de nós de uma árvore.*/
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

    private StringBuilder LRN(No<T> raizAtual) {
        /*Método que faz a busca dos nós seguindo a ordem LRN e 
        retornando um StringBuilder contendo os nós nessa ordem.*/
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

    private StringBuilder LNR(No<T> raizAtual) {
        /*Método que faz a busca dos nós seguindo a ordem LNR e 
        retornando um StringBuilder contendo os nós nessa ordem.*/
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

    private StringBuilder NLR(No<T> raizAtual) {
        /*Método que faz a busca dos nós seguindo a ordem NLR e 
        retornando um StringBuilder contendo os nós nessa ordem.*/
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

    private void arvoreEspelhada(ArvoreBinaria<T> arvoreAux, No<T> noRaiz) throws PossuiFilhoNaDireita, PossuiFilhoNaEsquerda {
        if (noRaiz.possuiFilhoEsquerdo() == true) {
            No<T> filhoEsquerdo = noRaiz.getFilhoEsquerdo();
            arvoreAux.adicionarNo(filhoEsquerdo.getElemento(), filhoEsquerdo.getPai().getElemento(), 'd');
            this.arvoreEspelhada(arvoreAux, noRaiz.getFilhoEsquerdo());
        }
        if (noRaiz.possuiFilhoDireito() == true) {
            No<T> filhoDireito = noRaiz.getFilhoDireito();
            arvoreAux.adicionarNo(filhoDireito.getElemento(), filhoDireito.getPai().getElemento(), 'e');
            this.arvoreEspelhada(arvoreAux, noRaiz.getFilhoDireito());
        }
    }
    
}
