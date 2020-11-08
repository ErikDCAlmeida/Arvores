/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Arvores;

import Exceptions.NoNaoExiste;
import InterfaceTrees.IArvoreBinariaBusca;
/**
 *
 * @author EriikD
 */
public class ArvoreBinariaBusca<T extends Comparable<T>> implements IArvoreBinariaBusca<T>{
    
    private No<T> raizDaArvore;

    public ArvoreBinariaBusca() {
        this.raizDaArvore = null;
    }

    @Override
    public void adicionarNo(T elemento) {
        if (this.raizDaArvore == null) {
            this.raizDaArvore = new No<>(elemento);
        } else {
            this.addAux(this.raizDaArvore, elemento);
        }
    }
    
    private void addAux(No<T> raizAtual, T element){
        if (element.compareTo(raizAtual.getElemento()) < 0) {
            if (raizAtual.possuiFilhoEsquerdo() == false) {
                raizAtual.setFilhoEsquerdo(new No(element, raizAtual));
            }else{
                this.addAux(raizAtual.getFilhoEsquerdo(), element);
            }
        } else if (element.compareTo(raizAtual.getElemento()) > 0) {
            if (raizAtual.possuiFilhoDireito() == false) {
                raizAtual.setFilhoDireito(new No(element, raizAtual));
            } else {
                this.addAux(raizAtual.getFilhoDireito(), element);
            }
        } else {
            System.out.println("Já existe na árvore um elemento adicionado como esse!");
        }
    }
    
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

    @Override
    public boolean consultarExistenciaNo(T elemento) {
        if (this.raizDaArvore == null) {
            return false;
        } else {
            if (this.raizDaArvore.getElemento().equals(elemento)) {
                return true;
            } else {
                No<T> filhoAux = this.pegarNo(elemento, this.raizDaArvore);

                return filhoAux != null;
            }
        }
    }

    @Override
    public int grauNo(T elemento) throws NoNaoExiste {
        int contadorGrau = 0;

        No<T> noAux = this.pegarNo(elemento, this.raizDaArvore);

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
        int profundidade = 0;

        No<T> noAux = this.pegarNo(elemento, this.raizDaArvore);

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

    @Override
    public int nivelNo(T elemento) throws NoNaoExiste {
        int nivel = 0;

        No<T> noAux = this.pegarNo(elemento, raizDaArvore);

        if (noAux == null) {
            throw new NoNaoExiste(elemento.toString());
        } else if (noAux.equals(this.raizDaArvore)) {
            return nivel;
        } else {
            for (int i = 0; i < 1;) {
                if (noAux.possuiPai() == true) {
                    nivel += 1;
                    noAux = noAux.getPai();
                } else {
                    break;
                }
            }
            return nivel;
        }
    }

    @Override
    public int quantidadeNoArvore(No<T> raizAtual) {
        if (this.raizDaArvore.possuiFilhoDireito() == false
                && this.raizDaArvore.possuiFilhoEsquerdo() == false) {
            return 1;
        } else {
            int contador = 0;
            if (raizAtual != null) {
                contador += 1;
                if (raizAtual.possuiFilhoDireito() == true) {
                    contador += this.quantidadeNoArvore(raizAtual.getFilhoDireito());
                }

                if (raizAtual.possuiFilhoEsquerdo() == true) {
                    contador += this.quantidadeNoArvore(raizAtual.getFilhoEsquerdo());
                }
            }
            return contador;
        }
    }

    @Override
    public boolean removerNo(T elemento) {
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
                return this.doisFilhos(noAux);
            }
        } else {
            return this.doisFilhos(noAux);
        }
        return false;
    }

    @Override
    public StringBuilder navegarPelaArvore() {
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

    public No<T> getRaizDaArvore() {
        return raizDaArvore;
    }
    
    /*=============================PRIVATE METHODS============================*/
    private boolean doisFilhos(No<T> noParaSerApagado) {
        No<T> paiNoApagado = noParaSerApagado.getPai();
        No<T> paiNoAux = null;
        No<T> noAux = noParaSerApagado.getFilhoDireito();
        No<T> filhoDireitoNoAux = null;
        No<T> noEsquerdo;

        /*Após pegar o primeiro nó a direita, fica repetindo até
        que encontre um nó a qual não possua um filho na esquerda,
        com isso esse nó será pego para substituir o removido.*/
        for (int i = 0; i < 1;) {
            if (noAux.possuiFilhoEsquerdo()) {
                noAux = noAux.getFilhoEsquerdo();
            } else {
                break;
            }
        }

        /*Verificando se nó a qual está sendo escolhido pra ser o
        substituto possui ou não um filho na direita.*/
        if (noAux.possuiFilhoDireito()) {
            filhoDireitoNoAux = noAux.getFilhoDireito();
        }

        /*Verificando se o pai do nó que foi escolhido pra ser o
        substituto é igual ao nó que está sendo apagado.*/
        if (!noAux.getPai().equals(noParaSerApagado)) {
            paiNoAux = noAux.getPai();
        }
        //Iniciando a troca por baixo para não destruir a árvore:
        /*Verificando se o existe um filho na direita do nó substituto.*/
        if (filhoDireitoNoAux != null && paiNoAux != null) {

            if (paiNoApagado != null) {
                noEsquerdo = noParaSerApagado.getFilhoEsquerdo();
                filhoDireitoNoAux.setPai(paiNoAux);
                paiNoAux.setFilhoEsquerdo(filhoDireitoNoAux);
                paiNoAux.setPai(noAux);
                noAux.setPai(paiNoApagado);
                noEsquerdo.setPai(noAux);
                noAux.setFilhoDireito(paiNoAux);
                noAux.setFilhoEsquerdo(noEsquerdo);
                if (noParaSerApagado.equals(paiNoApagado.getFilhoDireito())) {
                    paiNoApagado.setFilhoDireito(noAux);
                } else {
                    paiNoApagado.setFilhoEsquerdo(noAux);
                }
                noParaSerApagado.setPai(null);
                noParaSerApagado.setFilhoDireito(null);
                noParaSerApagado.setFilhoEsquerdo(null);
                return true;
            } else {
                noEsquerdo = noParaSerApagado.getFilhoEsquerdo();
                filhoDireitoNoAux.setPai(paiNoAux);
                paiNoAux.setFilhoEsquerdo(filhoDireitoNoAux);
                paiNoAux.setPai(noAux);
                noEsquerdo.setPai(noAux);
                noAux.setFilhoDireito(paiNoAux);
                noAux.setFilhoEsquerdo(noEsquerdo);
                noAux.setPai(null);
                this.raizDaArvore = noAux;
                noParaSerApagado.setFilhoDireito(null);
                noParaSerApagado.setFilhoEsquerdo(null);
                return true;
            }

        } else if (filhoDireitoNoAux != null && paiNoAux == null) {

            if (paiNoApagado != null) {
                noEsquerdo = noParaSerApagado.getFilhoEsquerdo();
                noAux.setPai(paiNoApagado);
                noEsquerdo.setPai(noAux);
                if (noParaSerApagado.equals(paiNoApagado.getFilhoDireito())) {
                    paiNoApagado.setFilhoDireito(noAux);
                } else {
                    paiNoApagado.setFilhoEsquerdo(noAux);
                }
                noAux.setFilhoEsquerdo(noEsquerdo);
                noParaSerApagado.setFilhoDireito(null);
                noParaSerApagado.setFilhoEsquerdo(null);
                noParaSerApagado.setPai(null);
                return true;
            } else {
                noEsquerdo = noParaSerApagado.getFilhoEsquerdo();
                noAux.setFilhoEsquerdo(noEsquerdo);
                noEsquerdo.setPai(noAux);
                noAux.setPai(null);
                noParaSerApagado.setFilhoDireito(null);
                noParaSerApagado.setFilhoEsquerdo(null);
                this.raizDaArvore = noAux;
                return true;
            }

        } else if (filhoDireitoNoAux == null && paiNoAux != null) {

            if (paiNoApagado != null) {
                noEsquerdo = noParaSerApagado.getFilhoEsquerdo();
                noAux.setPai(paiNoApagado);
                if (noParaSerApagado.equals(paiNoApagado.getFilhoDireito())) {
                    paiNoApagado.setFilhoDireito(noAux);
                } else {
                    paiNoApagado.setFilhoEsquerdo(noAux);
                }
                paiNoAux.setPai(noAux);
                noAux.setFilhoDireito(paiNoAux);
                noAux.setFilhoEsquerdo(noEsquerdo);
                noEsquerdo.setPai(noAux);
                paiNoAux.setFilhoEsquerdo(null);
                noParaSerApagado.setFilhoDireito(null);
                noParaSerApagado.setFilhoEsquerdo(null);
                noParaSerApagado.setPai(null);
                return true;
            } else {
                noEsquerdo = noParaSerApagado.getFilhoEsquerdo();
                noAux.setFilhoEsquerdo(noEsquerdo);
                noEsquerdo.setPai(noAux);
                noAux.setFilhoDireito(paiNoAux);
                paiNoAux.setPai(noAux);
                paiNoAux.setFilhoEsquerdo(null);
                noAux.setPai(null);
                this.raizDaArvore = noAux;
                noParaSerApagado.setFilhoDireito(null);
                noParaSerApagado.setFilhoEsquerdo(null);
                return true;
            }

        } else if (filhoDireitoNoAux == null & paiNoAux == null) {

            if (paiNoApagado != null) {
                noEsquerdo = noParaSerApagado.getFilhoEsquerdo();
                noAux.setFilhoEsquerdo(noEsquerdo);
                noEsquerdo.setPai(noAux);
                noAux.setPai(paiNoApagado);
                if (noParaSerApagado.equals(paiNoApagado.getFilhoDireito())) {
                    paiNoApagado.setFilhoDireito(noAux);
                } else {
                    paiNoApagado.setFilhoEsquerdo(noAux);
                }
                noParaSerApagado.setFilhoDireito(null);
                noParaSerApagado.setFilhoEsquerdo(null);
                noParaSerApagado.setPai(null);
                return true;
            } else {
                noEsquerdo = noParaSerApagado.getFilhoEsquerdo();
                noAux.setFilhoEsquerdo(noEsquerdo);
                noEsquerdo.setPai(noAux);
                noAux.setPai(null);
                this.raizDaArvore = noAux;
                noParaSerApagado.setFilhoDireito(null);
                noParaSerApagado.setFilhoEsquerdo(null);
                return true;
            }

        }
        return false;
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
    
}
