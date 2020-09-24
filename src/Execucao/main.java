/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Execucao;

import Arvores.ArvoreBinaria;

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
        
        tree.adicionarNo(0, null, 'e');
        tree.adicionarNo(1, 0, 'e');
        tree.adicionarNo(2, 1, 'e');
        tree.adicionarNo(3, 1, 'd');
        tree.adicionarNo(4, 2, 'e');
        tree.adicionarNo(5, 2, 'd');
        tree.adicionarNo(6, 3, 'e');
        tree.adicionarNo(7, 3, 'd');
        tree.adicionarNo(8, 6, 'd');
        tree.adicionarNo(9, 0, 'd');
        tree.adicionarNo(10, 9, 'e');
        tree.adicionarNo(11, 9, 'd');
        
        System.out.println("Consular exist�ncia: " + tree.consultarExistenciaNo(4));
        System.out.println("Grau de um n�: " + tree.grauNo(4));
        System.out.println("Profundidade de um n�: " + tree.profundidadeNo(4));
        System.out.println("Altura de um n�: " + tree.alturaNo(1));
        System.out.println("N�vel de um n�: " + tree.nivelNo(4));
        System.out.println("Quantidade de n�s na �rvore: " + tree.quantidadeNoArvore(tree.getRaiz()));
        System.out.println("Ordens de navega��o: " + tree.navegarPelaArvore() + "\n");
        
        System.out.println("Removendo n�..." + tree.removerNo(9));
        System.out.println("Quantidade de n�s na �rvore: " + tree.quantidadeNoArvore(tree.getRaiz()));
        System.out.println("Ordens de navega��o: " + tree.navegarPelaArvore() + "\n");
        
        
        ArvoreBinaria<Integer> arvoreAux = tree.inverterSubArvores();
        System.out.println("Quantidade de n�s na �rvore: " + arvoreAux.quantidadeNoArvore(tree.getRaiz()));
        System.out.println("Ordens de navega��o: " + arvoreAux.navegarPelaArvore());
        
        
        
    }

}
