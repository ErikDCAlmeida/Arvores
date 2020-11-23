package Arvores.ArvoreAVL;

import Exceptions.NoNaoExiste;
import InterfaceTrees.IArvoreAVL;

/**
 *
 * @author ErikDCAlmeida
 */
public class AVL<T extends Comparable<T>> implements IArvoreAVL<T> {

    private NoAVL<T> raizDaArvore;

    public AVL() {
        this.raizDaArvore = null;
    }
    
    @Override
    public void adicionarNo(T elemento) {
        if (this.raizDaArvore == null) {
            this.raizDaArvore = new NoAVL<>(elemento);
        } else {
            this.addAux(this.raizDaArvore, elemento);
        }
    }

    private void addAux(NoAVL<T> raizAtual, T elemento){
        if (elemento.compareTo(raizAtual.getElemento()) < 0) {
            if (raizAtual.possuiFilhoEsquerdo() == false) {
                NoAVL<T> noAux = new NoAVL<>(elemento, raizAtual);
                raizAtual.setFilhoEsquerdo(noAux);
            }else{
                this.addAux(raizAtual.getFilhoEsquerdo(), elemento);
            }
        } else if (elemento.compareTo(raizAtual.getElemento()) > 0) {
            if (raizAtual.possuiFilhoDireito() == false) {
                NoAVL<T> noAux = new NoAVL<>(elemento, raizAtual);
                raizAtual.setFilhoDireito(noAux);
            } else {
                this.addAux(raizAtual.getFilhoDireito(), elemento);
            }
        } else {
            System.out.println("Ja existe na arvore um elemento adicionado como esse!");
        }
        this.reAddBalancoNo(this.raizDaArvore);
        this.contemBalancoIrregular(elemento);
    }

    private boolean contemBalancoIrregular(T elemento){
        NoAVL<T> noInserido = this.pegarNo(elemento, this.raizDaArvore);
        if (noInserido != null) {
            NoAVL<T> noPai = noInserido.getPai();
            for (int i = 0; i < 1;) {
                if (noPai != null) {
                    if (noPai.getBalancoNo() == -2) {
                        if (noPai.getFilhoDireito().getBalancoNo() == 1) {
                            this.rotacaoDuplaEsquerda(noPai);
                        } else {
                            this.rotacaoSimplesEsquerda(noPai);
                        }
                        return true;
                    } else if (noPai.getBalancoNo() == 2) {
                        if (noPai.getFilhoEsquerdo().getBalancoNo() == -1) {
                            this.rotacaoDuplaDireita(noPai);
                        } else {
                            this.rotacaoSimplesDireita(noPai);
                        }
                        return true;
                    } else if (noPai.getBalancoNo() > -2 && noPai.getBalancoNo() < 2) {
                        noPai = noPai.getPai();
                    } 
                } else {
                    break;
                }
            }
        }
        return false;
    }

    private void reAddBalancoNo(NoAVL<T> raizAtual){
        int balancoEsquerdo = 0;
        int balancoDireito = 0;
        if (raizAtual.possuiFilhoEsquerdo()) {
            balancoEsquerdo = this.alturaNo(raizAtual.getFilhoEsquerdo().getElemento()) + 1;
            this.reAddBalancoNo(raizAtual.getFilhoEsquerdo()); 
        }
        if (raizAtual.possuiFilhoDireito()) {
            balancoDireito = this.alturaNo(raizAtual.getFilhoDireito().getElemento()) + 1;
            this.reAddBalancoNo(raizAtual.getFilhoDireito()); 
        }
        raizAtual.setBalancoNo(balancoEsquerdo - balancoDireito);
    }

    private void rotacaoSimplesEsquerda(NoAVL<T> noAtual){
        if (noAtual.equals(this.raizDaArvore)) {
            if (noAtual.getFilhoDireito().possuiFilhoEsquerdo()) {
                NoAVL<T> noAux = noAtual.getFilhoDireito().getFilhoEsquerdo();
                NoAVL<T> noFilhoPrincipal = noAtual.getFilhoDireito();
                noFilhoPrincipal.setFilhoEsquerdo(noAtual);
                noAtual.setPai(noFilhoPrincipal);
                noAtual.setFilhoDireito(noAux);
                noAux.setPai(noAtual);
                noFilhoPrincipal.setPai(null);
                this.raizDaArvore = noFilhoPrincipal;
            } else {
                NoAVL<T> noFilhoPrincipal = noAtual.getFilhoDireito();
                noFilhoPrincipal.setPai(null);
                noAtual.setPai(noFilhoPrincipal);
                noFilhoPrincipal.setFilhoEsquerdo(noAtual);
                noAtual.setFilhoDireito(null);
                this.raizDaArvore = noFilhoPrincipal;
            }
        } else {
            if (noAtual.getFilhoDireito().possuiFilhoEsquerdo()) {
                NoAVL<T> noAux = noAtual.getFilhoDireito().getFilhoEsquerdo();
                NoAVL<T> noFilhoPrincipal = noAtual.getFilhoDireito();
                NoAVL<T> noPaiAtual = noAtual.getPai();
                noFilhoPrincipal.setFilhoEsquerdo(noAtual);
                noFilhoPrincipal.setPai(noPaiAtual);
                noAtual.setPai(noFilhoPrincipal);
                if (noAtual.equals(noPaiAtual.getFilhoEsquerdo())) {
                    noPaiAtual.setFilhoEsquerdo(noFilhoPrincipal);
                }else{
                    noPaiAtual.setFilhoDireito(noFilhoPrincipal);
                }
                noAtual.setFilhoDireito(noAux);
                noAux.setPai(noAtual);
            } else {
                NoAVL<T> noFilhoPrincipal = noAtual.getFilhoDireito();
                NoAVL<T> noPaiAtual = noAtual.getPai();
                noFilhoPrincipal.setPai(noPaiAtual);
                noFilhoPrincipal.setFilhoEsquerdo(noAtual);
                noAtual.setPai(noFilhoPrincipal);
                noAtual.setFilhoDireito(null);
                if (noAtual.equals(noPaiAtual.getFilhoEsquerdo())) {
                    noPaiAtual.setFilhoEsquerdo(noFilhoPrincipal);
                }else{
                    noPaiAtual.setFilhoDireito(noFilhoPrincipal);
                }
            }
        } 
    }

    private void rotacaoSimplesDireita(NoAVL<T> noAtual){
        if (noAtual.equals(this.raizDaArvore)) {
            if (noAtual.getFilhoEsquerdo().possuiFilhoDireito()) {
                NoAVL<T> noAux = noAtual.getFilhoEsquerdo().getFilhoDireito();
                NoAVL<T> noFilhoPrincipal = noAtual.getFilhoEsquerdo();
                noFilhoPrincipal.setFilhoDireito(noAtual);
                noAtual.setPai(noFilhoPrincipal);
                noAtual.setFilhoEsquerdo(noAux);
                noAux.setPai(noAtual);
                noFilhoPrincipal.setPai(null);
                this.raizDaArvore = noFilhoPrincipal;
            } else {
                NoAVL<T> noFilhoPrincipal = noAtual.getFilhoEsquerdo();
                noFilhoPrincipal.setPai(null);
                noAtual.setPai(noFilhoPrincipal);
                noFilhoPrincipal.setFilhoDireito(noAtual);
                noAtual.setFilhoEsquerdo(null);
                this.raizDaArvore = noFilhoPrincipal;
            }
        } else {
            if (noAtual.getFilhoEsquerdo().possuiFilhoDireito()) {
                NoAVL<T> noAux = noAtual.getFilhoEsquerdo().getFilhoDireito();
                NoAVL<T> noFilhoPrincipal = noAtual.getFilhoEsquerdo();
                NoAVL<T> noPaiAtual = noAtual.getPai();
                noFilhoPrincipal.setFilhoDireito(noAtual);
                noFilhoPrincipal.setPai(noPaiAtual);
                noAtual.setPai(noFilhoPrincipal);
                if (noAtual.equals(noPaiAtual.getFilhoEsquerdo())) {
                    noPaiAtual.setFilhoEsquerdo(noFilhoPrincipal);
                }else{
                    noPaiAtual.setFilhoDireito(noFilhoPrincipal);
                }
                noAtual.setFilhoEsquerdo(noAux);
                noAux.setPai(noAtual);
            } else {
                NoAVL<T> noFilhoPrincipal = noAtual.getFilhoEsquerdo();
                NoAVL<T> noPaiAtual = noAtual.getPai();
                noFilhoPrincipal.setPai(noPaiAtual);
                noFilhoPrincipal.setFilhoDireito(noAtual);
                noAtual.setPai(noFilhoPrincipal);
                noAtual.setFilhoEsquerdo(null);
                if (noAtual.equals(noPaiAtual.getFilhoEsquerdo())) {
                    noPaiAtual.setFilhoEsquerdo(noFilhoPrincipal);
                }else{
                    noPaiAtual.setFilhoDireito(noFilhoPrincipal);
                }
            }
        } 
    }

    private void rotacaoDuplaEsquerda(NoAVL<T> noAtual){
        this.rotacaoSimplesDireita(noAtual.getFilhoDireito());
        this.rotacaoSimplesEsquerda(noAtual);
    }
    private void rotacaoDuplaDireita(NoAVL<T> noAtual){
        this.rotacaoSimplesEsquerda(noAtual.getFilhoEsquerdo());
        this.rotacaoSimplesDireita(noAtual);
    }

    private NoAVL<T> pegarNo(T elemento, NoAVL<T> noRaiz) {
        NoAVL<T> filhoEsquerdo;
        NoAVL<T> filhoDireito;
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
                NoAVL<T> filhoAux = this.pegarNo(elemento, this.raizDaArvore);
                return filhoAux != null;
            }
        }
    }

    @Override
    public int balancoNo(T elemento) {
        NoAVL<T> noAux = this.pegarNo(elemento, this.raizDaArvore);
        if (noAux != null) {
            return noAux.getBalancoNo();
        }
        return 0;
    }

    @Override
    public int grauNo(T elemento) {
        int contadorGrau = 0;

        NoAVL<T> noAux = this.pegarNo(elemento, this.raizDaArvore);

        if (noAux == null) {
            return 0;
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

        NoAVL<T> noAux = this.pegarNo(elemento, this.raizDaArvore);

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
    public int alturaNo(T elemento) {
        int altura = 0;

        NoAVL<T> noAux = this.pegarNo(elemento, raizDaArvore);

        if (noAux == null) {
            return altura;
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

    private int pegarAltura(NoAVL<T> raiz) {
        int alturaRaizEsquerda = 0;
        int alturaRaizDireita = 0;

        if (raiz.possuiFilhoDireito() == true) {
            alturaRaizDireita = this.pegarAltura(raiz.getFilhoDireito());
            alturaRaizDireita += 1;
        }

        if (raiz.possuiFilhoEsquerdo() == true) {
            alturaRaizEsquerda = this.pegarAltura(raiz.getFilhoEsquerdo());
            alturaRaizEsquerda += 1;
        }
        if (alturaRaizDireita > alturaRaizEsquerda) {
            return alturaRaizDireita;
        } else if (alturaRaizDireita < alturaRaizEsquerda) {
            return alturaRaizEsquerda;
        } else {
            return alturaRaizDireita;
        }
    }

    @Override
    public int nivelNo(T elemento) throws NoNaoExiste {
        int nivel = 0;

        NoAVL<T> noAux = this.pegarNo(elemento, raizDaArvore);

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
    public int quantidadeNoArvore(NoAVL<T> raizAtual) {
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
    public void removerNo(T elemento) {
        NoAVL<T> noAux = pegarNo(elemento, this.raizDaArvore);
        NoAVL<T> noPaiAux;
        NoAVL<T> noFilhoAux;
        if (noAux != null) {
            if (noAux.possuiPai() == true) {
                noPaiAux = noAux.getPai();
                /*If para se caso o n� n�o tenha nenhum filho.*/
                if (noAux.qntDeFilhosNo() == 0) {
                    if (noPaiAux.getFilhoDireito() == noAux) {
                        noPaiAux.setFilhoDireito(null);
                        noAux.setPai(null);
                    } else if (noPaiAux.getFilhoEsquerdo() == noAux) {
                        noPaiAux.setFilhoEsquerdo(null);
                        noAux.setPai(null);
                    }
                    this.reAddBalancoNo(this.raizDaArvore);
                    this.contemBalancoIrregular(noPaiAux.getElemento());
                /*Else para que se o n� tenha um filho.*/
                } else if (noAux.qntDeFilhosNo() == 1) {
                    if (noAux.equals(noPaiAux.getFilhoDireito())) {
                        if (noAux.possuiFilhoDireito() == true && noAux.possuiFilhoEsquerdo() == false) {
                            noFilhoAux = noAux.getFilhoDireito();
                            noPaiAux.setFilhoDireito(noFilhoAux);
                            noFilhoAux.setPai(noPaiAux);
                            noAux.setFilhoDireito(null);
                            noAux.setPai(null);
                            this.reAddBalancoNo(this.raizDaArvore);
                            this.contemBalancoIrregular(noFilhoAux.getElemento());
                        } else if (noAux.possuiFilhoEsquerdo() == true && noAux.possuiFilhoDireito() == false) {
                            noFilhoAux = noAux.getFilhoEsquerdo();
                            noPaiAux.setFilhoDireito(noFilhoAux);
                            noFilhoAux.setPai(noPaiAux);
                            noAux.setFilhoEsquerdo(null);
                            noAux.setPai(null);
                            this.reAddBalancoNo(this.raizDaArvore);
                            this.contemBalancoIrregular(noFilhoAux.getElemento());
                        }
                    } else if (noAux.equals(noPaiAux.getFilhoEsquerdo())) {
                        if (noAux.possuiFilhoDireito() == true && noAux.possuiFilhoEsquerdo() == false) {
                            noFilhoAux = noAux.getFilhoDireito();
                            noPaiAux.setFilhoEsquerdo(noFilhoAux);
                            noFilhoAux.setPai(noPaiAux);
                            noAux.setFilhoDireito(null);
                            noAux.setPai(null);
                            this.reAddBalancoNo(this.raizDaArvore);
                            this.contemBalancoIrregular(noFilhoAux.getElemento());
                        } else if (noAux.possuiFilhoEsquerdo() == true && noAux.possuiFilhoDireito() == false) {
                            noFilhoAux = noAux.getFilhoEsquerdo();
                            noPaiAux.setFilhoEsquerdo(noFilhoAux);
                            noFilhoAux.setPai(noPaiAux);
                            noAux.setFilhoEsquerdo(null);
                            noAux.setPai(null);
                            this.reAddBalancoNo(this.raizDaArvore);
                            this.contemBalancoIrregular(noFilhoAux.getElemento());
                        }
                    }
                /*Else if para que se o n� tenha 2 filhos.*/
                } else if (noAux.qntDeFilhosNo() == 2) {
                    this.doisFilhos(noAux);
                }
            } else {
                this.doisFilhos(noAux);
            }
        }
    }

    private void doisFilhos(NoAVL<T> noParaSerApagado) {
        NoAVL<T> paiNoApagado = noParaSerApagado.getPai();
        NoAVL<T> paiNoAux = null;
        NoAVL<T> noAux = noParaSerApagado.getFilhoDireito();
        NoAVL<T> filhoDireitoNoAux = null;
        NoAVL<T> noEsquerdo;

        /*Ap�s pegar o primeiro n� a direita, fica repetindo at�
        que encontre um n� a qual n�o possua um filho na esquerda,
        com isso esse n� ser� pego para substituir o removido.*/
        for (int i = 0; i < 1;) {
            if (noAux.possuiFilhoEsquerdo()) {
                noAux = noAux.getFilhoEsquerdo();
            } else {
                break;
            }
        }

        /*Verificando se n� a qual est� sendo escolhido pra ser o
        substituto possui ou n�o um filho na direita.*/
        if (noAux.possuiFilhoDireito()) {
            filhoDireitoNoAux = noAux.getFilhoDireito();
        }

        /*Verificando se o pai do n� que foi escolhido pra ser o
        substituto � igual ao n� que est� sendo apagado.*/
        if (!noAux.getPai().equals(noParaSerApagado)) {
            paiNoAux = noAux.getPai();
        }
        //Iniciando a troca por baixo para n�o destruir a �rvore:
        /*Verificando se o existe um filho na direita do n� substituto.*/
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
                this.reAddBalancoNo(this.raizDaArvore);
                this.contemBalancoIrregular(filhoDireitoNoAux.getElemento());
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
                this.reAddBalancoNo(this.raizDaArvore);
                this.contemBalancoIrregular(filhoDireitoNoAux.getElemento());
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
                this.reAddBalancoNo(this.raizDaArvore);
                this.contemBalancoIrregular(filhoDireitoNoAux.getElemento());
            } else {
                noEsquerdo = noParaSerApagado.getFilhoEsquerdo();
                noAux.setFilhoEsquerdo(noEsquerdo);
                noEsquerdo.setPai(noAux);
                noAux.setPai(null);
                noParaSerApagado.setFilhoDireito(null);
                noParaSerApagado.setFilhoEsquerdo(null);
                this.raizDaArvore = noAux;
                this.reAddBalancoNo(this.raizDaArvore);
                this.contemBalancoIrregular(filhoDireitoNoAux.getElemento());
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
                this.reAddBalancoNo(this.raizDaArvore);
                this.contemBalancoIrregular(noEsquerdo.getElemento());
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
                this.reAddBalancoNo(this.raizDaArvore);
                this.contemBalancoIrregular(noEsquerdo.getElemento());
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
                this.reAddBalancoNo(this.raizDaArvore);
                this.contemBalancoIrregular(noEsquerdo.getElemento());
            } else {
                noEsquerdo = noParaSerApagado.getFilhoEsquerdo();
                noAux.setFilhoEsquerdo(noEsquerdo);
                noEsquerdo.setPai(noAux);
                noAux.setPai(null);
                this.raizDaArvore = noAux;
                noParaSerApagado.setFilhoDireito(null);
                noParaSerApagado.setFilhoEsquerdo(null);
                this.reAddBalancoNo(this.raizDaArvore);
                this.contemBalancoIrregular(noEsquerdo.getElemento());
            }
        }
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
            stringLRN.append(this.leituraLRN(this.raizDaArvore));
            stringLNR.append(this.leituraLNR(this.raizDaArvore));
            stringNLR.append(this.leituraNLR(this.raizDaArvore));
        }
        string.append(stringLRN).append(stringLNR).append(stringNLR);
        return string;
    }

    @Override
    public StringBuilder especificaLRN(){
        StringBuilder string = new StringBuilder();
        StringBuilder stringLRN = new StringBuilder();
        stringLRN.append("\nLRN: ");
        if (this.raizDaArvore != null) {
            stringLRN.append(this.leituraLRN(this.raizDaArvore));
        }
        string.append(stringLRN);
        return string;
    }

    @Override
    public StringBuilder especificaLNR(){
        StringBuilder string = new StringBuilder();
        StringBuilder stringLNR = new StringBuilder();
        stringLNR.append("\nLNR: ");
        if (this.raizDaArvore != null) {
            stringLNR.append(this.leituraLNR(this.raizDaArvore));
        }
        string.append(stringLNR);
        return string;
    }

    @Override
    public StringBuilder especificaNLR(){
        StringBuilder string = new StringBuilder();
        StringBuilder stringNLR = new StringBuilder();
        stringNLR.append("\nNLR: ");
        if (this.raizDaArvore != null) {
            stringNLR.append(this.leituraNLR(this.raizDaArvore));
        }
        string.append(stringNLR);
        return string;
    }

    private StringBuilder leituraLRN(NoAVL<T> raizAtual) {
        /*Metodo que faz a busca dos nos seguindo a ordem LRN e 
        retornando um StringBuilder contendo os nos nessa ordem.*/
        StringBuilder string = new StringBuilder();
        if (raizAtual != null) {
            if (raizAtual.possuiFilhoEsquerdo() == true) {
                string.append(this.leituraLRN(raizAtual.getFilhoEsquerdo()));
            }
            if (raizAtual.possuiFilhoDireito() == true) {
                string.append(this.leituraLRN(raizAtual.getFilhoDireito()));
            }
            string.append(raizAtual.getElemento()).append("(").append(raizAtual.getBalancoNo()).append(") ");
        }
        return string;
    }

    private StringBuilder leituraLNR(NoAVL<T> raizAtual) {
        /*Metodo que faz a busca dos nos seguindo a ordem LNR e 
        retornando um StringBuilder contendo os nos nessa ordem.*/
        StringBuilder string = new StringBuilder();
        if (raizAtual != null) {
            if (raizAtual.possuiFilhoEsquerdo() == true) {
                string.append(this.leituraLNR(raizAtual.getFilhoEsquerdo()));
            }
            string.append(raizAtual.getElemento()).append("(").append(raizAtual.getBalancoNo()).append(") ");
            if (raizAtual.possuiFilhoDireito() == true) {
                string.append(this.leituraLNR(raizAtual.getFilhoDireito()));
            }
        }
        return string;
    }

    private StringBuilder leituraNLR(NoAVL<T> raizAtual) {
        /*Metodo que faz a busca dos nos seguindo a ordem NLR e 
        retornando um StringBuilder contendo os nos nessa ordem.*/
        StringBuilder string = new StringBuilder();
        if (raizAtual != null) {
            string.append(raizAtual.getElemento()).append("(").append(raizAtual.getBalancoNo()).append(") ");
            if (raizAtual.possuiFilhoEsquerdo() == true) {
                string.append(this.leituraNLR(raizAtual.getFilhoEsquerdo()));
            }
            if (raizAtual.possuiFilhoDireito() == true) {
                string.append(this.leituraNLR(raizAtual.getFilhoDireito()));
            }
        }
        return string;
    }

      


}
