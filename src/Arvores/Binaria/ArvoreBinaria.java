package Arvores.Binaria;

import Exceptions.PossuiFilhoNaDireita;
import Exceptions.PossuiFilhoNaEsquerda;
import Exceptions.NoNaoExiste;
import java.util.logging.Level;
import java.util.logging.Logger;

import Arvores.No;
import Arvores.BinariaBusca.ArvoreBinariaBusca;
import InterfaceTrees.IArvoreBinaria;
import java.util.ArrayList;

/**
 *
 * @author ErikDCAlmeida
 */
public class ArvoreBinaria<T extends Comparable<T>> implements IArvoreBinaria<T> {

    private No<T> raizDaArvore;

    public ArvoreBinaria() {
        this.raizDaArvore = null;
    }

    /**
     * M�todo respons�vel por adicionar um n� na �rvore.<br/>
     * No caso de n�o existir uma raiz, criar� a raiz e em seguida os n�s.
     *
     * @param elemento
     * @param elementoNoPai
     * @param posicao
     * @throws PossuiFilhoNaDireita
     * @throws PossuiFilhoNaEsquerda
     */
    @Override
    public void adicionarNo(T elemento, T elementoNoPai, char posicao)
            throws PossuiFilhoNaDireita, PossuiFilhoNaEsquerda {
        if (this.raizDaArvore == null) {
            this.raizDaArvore = new No<>(elemento, null);
        } else {
            No<T> noPai = this.pegarNo(elementoNoPai, this.raizDaArvore);
            No<T> noAux = new No<>(elemento, noPai);
            if (noPai != null){
                if (posicao == 'E' || posicao == 'e' && noPai.possuiFilhoEsquerdo() == true) {
                    throw new PossuiFilhoNaEsquerda();
                } else if (posicao == 'D' || posicao == 'd' && noPai.possuiFilhoDireito() == true) {
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
    }

    /**
     * M�todo respons�vel para consultar um elemento dentro da �rvore e verificar se
     * ele existe.
     *
     * @param elemento
     * @return Retorna um <b>boolean</b> indicando a exist�ncia do n�.
     */
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

    /**
     * M�todo respons�vel para saber o grau de um determinado n�.
     *
     * @param elemento
     * @return Retorna um <b>int</b> indicando o grau do n�.
     * @throws NoNaoExiste
     */
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

    /**
     * M�todo respons�vel para saber a profundidade de um determinado n�.
     *
     * @param elemento
     * @return Retorna um <b>int</b> indicando a profundidade do n�.
     * @throws NoNaoExiste
     */
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

    /**
     * M�todo respons�vel por saber a altura de um determinado n�.
     *
     * @param elemento
     * @return Retorna um <b>int</b> indicando a altura do n�.
     * @throws NoNaoExiste
     */
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

    /**
     * M�todo respons�vel por saber a n�vel de um determinado n�.
     *
     * @param elemento
     * @return Retorna um <b>int</b> indicando o n�vel do n�.
     * @throws NoNaoExiste
     */
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

    /**
     * M�todo recursivo para saber a quantidade de n�s na �rvore.
     *
     * @return Retorna um <b>int</b> indicando a quantidade de n�s na �rvore.
     */
    @Override
    public int quantidadeNoArvore(No<T> raizAtual) {
        if (this.raizDaArvore.possuiFilhoDireito() == false && this.raizDaArvore.possuiFilhoEsquerdo() == false) {
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

    /**
     * <b>M�todo para remover n�. Baseado nas seguintes regras:</b><br/>
     * 1- O n� � folha: seu pai aponta para o vazio. <br/>
     * 2- O n� tem um filho: seu pai agora aponta para seu filho. E o filho para o
     * pai.<br/>
     * 3- O n� tem dois filhos: usar a regra de dois filhos da <b>�rvore Bin�ria de
     * Busca.</b>
     *
     * @param elemento do tipo T.
     * @return Retorna um <b>boolean</b> indicando se o n� foi removido ou n�o.
     */
    @Override
    public void removerNo(T elemento) {
        No<T> noAux = pegarNo(elemento, this.raizDaArvore);
        No<T> noPaiAux;
        No<T> noFilhoAux;
        if (noAux != null) {
            if (noAux.possuiPai() == true) {
                noPaiAux = noAux.getPai();
                /* If para se caso o n� n�o tenha nenhum filho. */
                if (noAux.qntDeFilhosNo() == 0) {
                    if (noPaiAux.getFilhoDireito() == noAux) {
                        noPaiAux.setFilhoDireito(null);
                        noAux.setPai(null);
                    } else if (noPaiAux.getFilhoEsquerdo() == noAux) {
                        noPaiAux.setFilhoEsquerdo(null);
                        noAux.setPai(null);
                    }
                    /* Else para que se o n� tenha um filho. */
                } else if (noAux.qntDeFilhosNo() == 1) {
                    if (noAux.equals(noPaiAux.getFilhoDireito())) {
                        if (noAux.possuiFilhoDireito() == true && noAux.possuiFilhoEsquerdo() == false) {
                            noFilhoAux = noAux.getFilhoDireito();
                            noPaiAux.setFilhoDireito(noFilhoAux);
                            noFilhoAux.setPai(noPaiAux);
                            noAux.setFilhoDireito(null);
                            noAux.setPai(null);
                        } else if (noAux.possuiFilhoEsquerdo() == true && noAux.possuiFilhoDireito() == false) {
                            noFilhoAux = noAux.getFilhoEsquerdo();
                            noPaiAux.setFilhoDireito(noFilhoAux);
                            noFilhoAux.setPai(noPaiAux);
                            noAux.setFilhoEsquerdo(null);
                            noAux.setPai(null);
                        }
                    } else if (noAux.equals(noPaiAux.getFilhoEsquerdo())) {
                        if (noAux.possuiFilhoDireito() == true && noAux.possuiFilhoEsquerdo() == false) {
                            noFilhoAux = noAux.getFilhoDireito();
                            noPaiAux.setFilhoEsquerdo(noFilhoAux);
                            noFilhoAux.setPai(noPaiAux);
                            noAux.setFilhoDireito(null);
                            noAux.setPai(null);
                        } else if (noAux.possuiFilhoEsquerdo() == true && noAux.possuiFilhoDireito() == false) {
                            noFilhoAux = noAux.getFilhoEsquerdo();
                            noPaiAux.setFilhoEsquerdo(noFilhoAux);
                            noFilhoAux.setPai(noPaiAux);
                            noAux.setFilhoEsquerdo(null);
                            noAux.setPai(null);
                        }
                    }
                    /* Else if para que se o n� tenha 2 filhos. */
                } else if (noAux.qntDeFilhosNo() == 2) {
                    this.doisFilhos(noAux);
                }
            } else {
                this.doisFilhos(noAux);
            }
        }
    }

    /**
     * M�todo que percorre a �rvore baseado no LRN, LNR, NLR.
     *
     * @return Retorna um <b>StringBuilder</b> contendo ordem de navega��o<br/>
     *         da �rvore de acordo com as regras <b>LRN, LNR, NLR</b>.
     */
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
            stringLRN.append(this.navegacaoLRN(this.raizDaArvore));
            stringLNR.append(this.navegacaoLNR(this.raizDaArvore));
            stringNLR.append(this.navegacaoNLR(this.raizDaArvore));
        }
        string.append(stringLRN).append(stringLNR).append(stringNLR);
        return string;
    }

    /**
     * M�todo que permite a troca de sub-�rvores de uma �rvore. <br/>
     * Imprimindo a �rvore original e a �rvore atualizada.
     *
     * @return Retorna uma nova <b>ArvoreBin�ria do tipo T</b>.
     */
    @Override
    public ArvoreBinaria<T> inverterSubArvores() {
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
            System.out.println("Imposs�vel inverter �rvore!");
            return null;
        }
    }

    public No<T> getRaiz() {
        return this.raizDaArvore;
    }

    @Override
    public ArvoreBinariaBusca<T> transformarEmBinariaBusca() {
        ArvoreBinariaBusca<T> treeAux = new ArvoreBinariaBusca<>();
        ArrayList<T> listaNos = new ArrayList<>();
        No<T> noAux = this.raizDaArvore;
        if (noAux != null) {
            this.adicaoNosAL(noAux, listaNos);
        }
        if (!listaNos.isEmpty()) {
            listaNos.forEach((listaNo) -> {
                treeAux.adicionarNo(listaNo);
            });
        }
        return treeAux;
    }

    public boolean verificarSimilaridade(ArvoreBinaria<T> secon) {
        if (this.raizDaArvore == null && secon.getRaiz() == null) {
            return true;
        } else {
            if (this.auxVerificarSimilaridade(this.raizDaArvore, secon.getRaiz()) == 1) {
                return true;
            }
        }
        return false;
    }

    private int auxVerificarSimilaridade(No<T> noArvorePrincipal, No<T> noArvoreSecundaria) {
        int valor;
        if (noArvorePrincipal != null && noArvoreSecundaria != null) {
            // Esquerdo========
            if (noArvorePrincipal.possuiFilhoEsquerdo() == true && noArvoreSecundaria.possuiFilhoEsquerdo() == true) {
                valor = this.auxVerificarSimilaridade(noArvorePrincipal.getFilhoEsquerdo(),
                        noArvoreSecundaria.getFilhoEsquerdo());
                if (valor == 0) {
                    return 0;
                }
            } else if (noArvorePrincipal.possuiFilhoEsquerdo() == false
                    && noArvoreSecundaria.possuiFilhoEsquerdo() == false) {
                return 1;
            } else {
                return 0;
            }
            // Direito=========
            if (noArvorePrincipal.possuiFilhoDireito() == true && noArvoreSecundaria.possuiFilhoDireito() == true) {
                valor = this.auxVerificarSimilaridade(noArvorePrincipal.getFilhoDireito(),
                        noArvoreSecundaria.getFilhoDireito());
                if (valor == 0) {
                    return 0;
                }
            } else if (noArvorePrincipal.possuiFilhoDireito() == false
                    && noArvoreSecundaria.possuiFilhoDireito() == false) {
                return 1;
            } else {
                return 0;
            }

        } else if (noArvorePrincipal == null && noArvoreSecundaria == null) {
            valor = 1;
        } else {
            valor = 0;
        }
        return valor;
    }

    public T menorValorArvore(No<T> raizAtual) {
        if (raizAtual == null) {
            return null;
        }
        T menorValor = raizAtual.getElemento();
        if (raizAtual.possuiFilhoEsquerdo() == true) {
            T valor = this.menorValorArvore(raizAtual.getFilhoEsquerdo());
            if (menorValor.compareTo(valor) > 0) {
                menorValor = valor;
            }
        }
        if (raizAtual.possuiFilhoDireito() == true) {
            T valor = this.menorValorArvore(raizAtual.getFilhoDireito());
            if (menorValor.compareTo(valor) > 0) {
                menorValor = valor;
            }
        }
        return menorValor;
    }

    private int mediaDosValores(No<T> raizAtual) {
        if (raizAtual == null) {
            return 0;
        }
        int menorValor = raizAtual.getElemento().hashCode();
        if (raizAtual.possuiFilhoDireito() == true) {
            menorValor += this.mediaDosValores(raizAtual.getFilhoDireito());
        }
        if (raizAtual.possuiFilhoEsquerdo() == true) {
            menorValor += this.mediaDosValores(raizAtual.getFilhoEsquerdo());
        }
        return menorValor;
    }

    public int mediaDosValoresNaArvore() {
        return this.mediaDosValores(this.raizDaArvore) / this.quantidadeNoArvore(this.raizDaArvore);
    }

    public int somaDosNosPares(No<T> raizAtual) {
        if (raizAtual == null) {
            return 0;
        }
        int soma = 0;
        if (raizAtual.getElemento().hashCode() % 2 == 0) {
            soma += raizAtual.getElemento().hashCode();
        } else {
            soma += 0;
        }
        if (raizAtual.possuiFilhoDireito() == true) {
            soma += this.somaDosNosPares(raizAtual.getFilhoDireito());
        }
        if (raizAtual.possuiFilhoEsquerdo() == true) {
            soma += this.somaDosNosPares(raizAtual.getFilhoEsquerdo());
        }
        return soma;
    }

    // =============================Private Methods==============================
    // ==========================================================================
    private void adicaoNosAL(No<T> raizAtual, ArrayList<T> lista) {
        if (raizAtual != null) {
            lista.add(raizAtual.getElemento());
            this.adicaoNosAL(raizAtual.getFilhoEsquerdo(), lista);
            this.adicaoNosAL(raizAtual.getFilhoDireito(), lista);
        }
    }

    private void doisFilhos(No<T> noParaSerApagado) {
        No<T> paiNoApagado = noParaSerApagado.getPai();
        No<T> paiNoAux = null;
        No<T> noAux = noParaSerApagado.getFilhoDireito();
        No<T> filhoDireitoNoAux = null;
        No<T> noEsquerdo;

        /*
         * Ap�s pegar o primeiro n� a direita, fica repetindo at� que encontre um n� a
         * qual n�o possua um filho na esquerda, com isso esse n� ser� pego para
         * substituir o removido.
         */
        for (int i = 0; i < 1;) {
            if (noAux.possuiFilhoEsquerdo()) {
                noAux = noAux.getFilhoEsquerdo();
            } else {
                break;
            }
        }

        /*
         * Verificando se n� a qual est� sendo escolhido pra ser o substituto possui ou
         * n�o um filho na direita.
         */
        if (noAux.possuiFilhoDireito()) {
            filhoDireitoNoAux = noAux.getFilhoDireito();
        }

        /*
         * Verificando se o pai do n� que foi escolhido pra ser o substituto � igual ao
         * n� que est� sendo apagado.
         */
        if (!noAux.getPai().equals(noParaSerApagado)) {
            paiNoAux = noAux.getPai();
        }
        // Iniciando a troca por baixo para n�o destruir a �rvore:
        /* Verificando se o existe um filho na direita do n� substituto. */
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
            }
        } else if (filhoDireitoNoAux != null) {
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
            } else {
                noEsquerdo = noParaSerApagado.getFilhoEsquerdo();
                noAux.setFilhoEsquerdo(noEsquerdo);
                noEsquerdo.setPai(noAux);
                noAux.setPai(null);
                noParaSerApagado.setFilhoDireito(null);
                noParaSerApagado.setFilhoEsquerdo(null);
                this.raizDaArvore = noAux;
            }
        } else if (paiNoAux != null) {
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
            }
        } else {
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
            } else {
                noEsquerdo = noParaSerApagado.getFilhoEsquerdo();
                noAux.setFilhoEsquerdo(noEsquerdo);
                noEsquerdo.setPai(noAux);
                noAux.setPai(null);
                this.raizDaArvore = noAux;
                noParaSerApagado.setFilhoDireito(null);
                noParaSerApagado.setFilhoEsquerdo(null);
            }
        }
    }

    private No<T> pegarNo(T elemento, No<T> noRaiz) {
        /*
         * M�todo private que retorna um n�. Necess�rio passar o elemento do n� desejado
         * e a raiz atual da �rvore.
         */
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
        /* M�todo que permite pegar a altura de um n�. */
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

    private StringBuilder navegacaoLRN(No<T> raizAtual) {
        /*
         * M�todo que faz a busca dos n�s seguindo a ordem LRN e retornando um
         * StringBuilder contendo os n�s nessa ordem.
         */
        StringBuilder string = new StringBuilder();
        if (raizAtual != null) {
            if (raizAtual.possuiFilhoEsquerdo() == true) {
                string.append(this.navegacaoLRN(raizAtual.getFilhoEsquerdo()));
            }
            if (raizAtual.possuiFilhoDireito() == true) {
                string.append(this.navegacaoLRN(raizAtual.getFilhoDireito()));
            }
            string.append(raizAtual.getElemento()).append(" ");
        }
        return string;
    }

    private StringBuilder navegacaoLNR(No<T> raizAtual) {
        /*
         * M�todo que faz a busca dos n�s seguindo a ordem LNR e retornando um
         * StringBuilder contendo os n�s nessa ordem.
         */
        StringBuilder string = new StringBuilder();
        if (raizAtual != null) {
            if (raizAtual.possuiFilhoEsquerdo() == true) {
                string.append(this.navegacaoLNR(raizAtual.getFilhoEsquerdo()));
            }
            string.append(raizAtual.getElemento()).append(" ");
            if (raizAtual.possuiFilhoDireito() == true) {
                string.append(this.navegacaoLNR(raizAtual.getFilhoDireito()));
            }
        }
        return string;
    }

    private StringBuilder navegacaoNLR(No<T> raizAtual) {
        /*
         * M�todo que faz a busca dos n�s seguindo a ordem NLR e retornando um
         * StringBuilder contendo os n�s nessa ordem.
         */
        StringBuilder string = new StringBuilder();
        if (raizAtual != null) {
            string.append(raizAtual.getElemento()).append(" ");
            if (raizAtual.possuiFilhoEsquerdo() == true) {
                string.append(this.navegacaoNLR(raizAtual.getFilhoEsquerdo()));
            }
            if (raizAtual.possuiFilhoDireito() == true) {
                string.append(this.navegacaoNLR(raizAtual.getFilhoDireito()));
            }
        }
        return string;
    }

    private void arvoreEspelhada(ArvoreBinaria<T> arvoreAux, No<T> noRaiz)
            throws PossuiFilhoNaDireita, PossuiFilhoNaEsquerda {
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
