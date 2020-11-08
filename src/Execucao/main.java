/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Execucao;

import Arvores.ArvoreBinaria;
import Arvores.ArvoreBinariaBusca;

/**
 *
 * @author EriikD
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {

        ArvoreBinaria<Integer> tree = new ArvoreBinaria<>();

        ArvoreBinaria<Integer> treeSec = new ArvoreBinaria<>();

//        tree.adicionarNo(0, null, 'e');
//        tree.adicionarNo(1, 0, 'e');
//        tree.adicionarNo(2, 1, 'e');
//        tree.adicionarNo(3, 1, 'd');
//        tree.adicionarNo(4, 2, 'e');
//        tree.adicionarNo(5, 2, 'd');
//        tree.adicionarNo(6, 3, 'e');
//        tree.adicionarNo(7, 3, 'd');
//        tree.adicionarNo(8, 6, 'd');
//        tree.adicionarNo(9, 0, 'd');
//        tree.adicionarNo(10, 9, 'e');
//        tree.adicionarNo(11, 9, 'd');
        
        tree.adicionarNo(80, null, 'e');
        tree.adicionarNo(90, 80, 'e');
        tree.adicionarNo(10, 80, 'd');
        tree.adicionarNo(5, 90, 'e');
        tree.adicionarNo(15, 90, 'd');
        tree.adicionarNo(20, 10, 'e');
        tree.adicionarNo(2, 10, 'd');
        tree.adicionarNo(30, 20, 'e');
        tree.adicionarNo(7, 20, 'd');

        treeSec.adicionarNo(80, null, 'e');
        treeSec.adicionarNo(90, 80, 'e');
        treeSec.adicionarNo(10, 80, 'd');
        treeSec.adicionarNo(5, 90, 'e');
        treeSec.adicionarNo(15, 90, 'd');
        treeSec.adicionarNo(20, 10, 'e');
        treeSec.adicionarNo(2, 10, 'd');
        treeSec.adicionarNo(30, 20, 'e');
        //treeSec.adicionarNo(7, 20, 'd');

//        System.out.println("Consular exist�ncia: " + tree.consultarExistenciaNo(4));
//        System.out.println("Grau de um n�: " + tree.grauNo(1));
//        System.out.println("Profundidade de um n�: " + tree.profundidadeNo(4));
//        System.out.println("Altura de um n�: " + tree.alturaNo(1));
//        System.out.println("N�vel de um n�: " + tree.nivelNo(4));
        System.out.println("Quantidade de nos na arvore: " + tree.quantidadeNoArvore(tree.getRaiz()));
        System.out.println("Ordens de navegacao: " + tree.navegarPelaArvore() + "\n");
        System.out.println("Verificar se árvores são iguais: " + tree.verificarSimilaridade(treeSec));
        System.out.println("Menor valor da árvore: " + tree.menorValorArvore(tree.getRaiz()));
        System.out.println("Media dos valores da árvore: " + tree.mediaDosValoresNaArvore());
        System.out.println("Soma dos nós pares: " + tree.somaDosNosPares(tree.getRaiz()));
//        
        /*System.out.println("Removendo no..." + tree.removerNo(20));
        System.out.println("Quantidade de nos na arvore: " + tree.quantidadeNoArvore(tree.getRaiz()));
        System.out.println("Ordens de navegacao: " + tree.navegarPelaArvore() + "\n");*/

        /*ArvoreBinariaBusca<Integer> treeSearch = tree.transformarEmBinariaBusca();
        System.out.println(treeSearch.navegarPelaArvore());*/
        System.out.println();
        ArvoreBinaria<Integer> arvoreAux = tree.inverterSubArvores();
        System.out.println("Quantidade de nos na arvore: " + arvoreAux.quantidadeNoArvore(tree.getRaiz()));
        System.out.println("Ordens de navegacao: " + arvoreAux.navegarPelaArvore());
        System.out.println();
        System.out.println("Removendo no..." + arvoreAux.removerNo(20));
        System.out.println("Quantidade de nos na arvore: " + arvoreAux.quantidadeNoArvore(arvoreAux.getRaiz()));
        System.out.println("Ordens de navegacao: " + arvoreAux.navegarPelaArvore() + "\n");

//       ArvoreBinariaBusca<Integer> treeSearch = new ArvoreBinariaBusca<>();
//        
//        treeSearch.adicionarNo(50);
//        treeSearch.adicionarNo(20);
//        treeSearch.adicionarNo(80);
//        treeSearch.adicionarNo(10);
//        treeSearch.adicionarNo(25);
//        treeSearch.adicionarNo(60);
//        /*treeSearch.adicionarNo(90);
//        treeSearch.adicionarNo(5);
//        treeSearch.adicionarNo(7);
//        treeSearch.adicionarNo(22);
//        treeSearch.adicionarNo(27);
//        treeSearch.adicionarNo(82);
//        treeSearch.adicionarNo(95);
//        treeSearch.adicionarNo(21);
//        treeSearch.adicionarNo(81);
//        treeSearch.adicionarNo(85);
//        treeSearch.adicionarNo(93);
//        treeSearch.adicionarNo(100);*/
//        
//        System.out.println("No existe? " + treeSearch.consultarExistenciaNo(10));
//        System.out.println("Grau do n�: " + treeSearch.grauNo(80));
//        System.out.println("Profundidade de um n�: " + treeSearch.profundidadeNo(20));
//        System.out.println("Altura de um n�: " + treeSearch.alturaNo(20));
//        System.out.println("N�vel de um n�: " + treeSearch.nivelNo(20));
//        System.out.println("Quantidade de n�s na �rvore: " + treeSearch.quantidadeNoArvore(treeSearch.getRaizDaArvore()));
//        System.out.println("Ordens de navega��o: " + treeSearch.navegarPelaArvore() + "\n");
//        System.out.println("");
//        System.out.println(treeSearch.removerNo(20));
//        System.out.println("Ordens de navega��o: " + treeSearch.navegarPelaArvore() + "\n");
    }

}
