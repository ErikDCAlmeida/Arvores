package Execucao;

import java.util.Scanner;

import Arvores.ArvoreAVL.AVL;
import Arvores.ArvoreAVL.MenuAVL;
import Arvores.Binaria.MenuBinaria;
import Arvores.BinariaBusca.MenuBinariaBusca;
import Exceptions.PossuiFilhoNaDireita;
import Exceptions.PossuiFilhoNaEsquerda;

/**
 *
 * @author ErikDCAlmeida
 */
public class Main {

    /**
     * @param args the command line arguments
     * @throws PossuiFilhoNaEsquerda
     * @throws PossuiFilhoNaDireita
     */
    public static void main(String[] args) throws PossuiFilhoNaDireita, PossuiFilhoNaEsquerda {
        // Scanner scan = new Scanner(System.in);
        
        // System.out.print("Das opções abaixo, escolha a opção da árvore que deseja testar:"
        // + "\n1 - Árvore Binária.\n2 - Árvore Binária de Busca.\n3 - Árvore AVL." + "\nEsolha: ");
        // int escolhaMenu = scan.nextInt();
        // if (escolhaMenu == 1) {
        //     MenuBinaria menu = new MenuBinaria();
        //     menu.start();
        // } else if (escolhaMenu == 2) {
        //     MenuBinariaBusca menu = new MenuBinariaBusca();
        //     menu.start();
        // } else if (escolhaMenu == 3) {
        //     MenuAVL menu = new MenuAVL();
        //     menu.start();
        // }
        // scan.close();
        

        // System.out.println("AVL SENDO O PRIMEIRO NÚMERO RAIZ E O QUE MUDA:\n"
        // + "=========================================================");
        // AVL<Integer> arvAVL = new AVL<>();
        // arvAVL.adicionarNo(10);
        // arvAVL.adicionarNo(5);
        // arvAVL.adicionarNo(12);
        // arvAVL.adicionarNo(11);
        // arvAVL.adicionarNo(14);
        // arvAVL.adicionarNo(15);
        // System.out.println("AVL RSE:" + arvAVL.navegarPelaArvore());

        // AVL<Integer> arvAVL2 = new AVL<>();
        // arvAVL2.adicionarNo(10);
        // arvAVL2.adicionarNo(5);
        // arvAVL2.adicionarNo(11);
        // arvAVL2.adicionarNo(3);
        // arvAVL2.adicionarNo(6);
        // arvAVL2.adicionarNo(4);
        // System.out.println("\nAVL RSD:" + arvAVL2.navegarPelaArvore());
    
        // AVL<Integer> arvAVL3 = new AVL<>();
        // arvAVL3.adicionarNo(10);
        // arvAVL3.adicionarNo(5);
        // arvAVL3.adicionarNo(15);
        // arvAVL3.adicionarNo(2);
        // arvAVL3.adicionarNo(7);
        // arvAVL3.adicionarNo(6);
        // System.out.println("\nAVL RDD:" + arvAVL3.navegarPelaArvore());

        // AVL<Integer> arvAVL4 = new AVL<>();
        // arvAVL4.adicionarNo(10);
        // arvAVL4.adicionarNo(5);
        // arvAVL4.adicionarNo(20);
        // arvAVL4.adicionarNo(22);
        // arvAVL4.adicionarNo(12);
        // arvAVL4.adicionarNo(11);
        // System.out.println("\nAVL RDE:" + arvAVL4.navegarPelaArvore());

        // System.out.println("\nAVL SENDO O PRIMEIRO NÚMERO NÃO RAIZ E O QUE MUDA:\n"
        // + "=========================================================");
        // AVL<Integer> arvAVL5 = new AVL<>();
        // arvAVL5.adicionarNo(8);
        // arvAVL5.adicionarNo(6);
        // arvAVL5.adicionarNo(10);
        // arvAVL5.adicionarNo(4);
        // arvAVL5.adicionarNo(7);
        // arvAVL5.adicionarNo(9);
        // arvAVL5.adicionarNo(12);
        // arvAVL5.adicionarNo(3);
        // arvAVL5.adicionarNo(11);
        // arvAVL5.adicionarNo(14);
        // arvAVL5.adicionarNo(15);
        // System.out.println("AVL RSE:" + arvAVL5.navegarPelaArvore());

        // AVL<Integer> arvAVL6 = new AVL<>();
        // arvAVL6.adicionarNo(20);
        // arvAVL6.adicionarNo(10);
        // arvAVL6.adicionarNo(25);
        // arvAVL6.adicionarNo(5);
        // arvAVL6.adicionarNo(11);
        // arvAVL6.adicionarNo(24);
        // arvAVL6.adicionarNo(29);
        // arvAVL6.adicionarNo(3);
        // arvAVL6.adicionarNo(6);
        // arvAVL6.adicionarNo(30);
        // arvAVL6.adicionarNo(4);
        // System.out.println("\nAVL RSD:" + arvAVL6.navegarPelaArvore());
    
        AVL<Integer> arvAVL7 = new AVL<>();
        arvAVL7.adicionarNo(20);
        arvAVL7.adicionarNo(10);
        arvAVL7.adicionarNo(25);
        arvAVL7.adicionarNo(5);
        arvAVL7.adicionarNo(15);
        arvAVL7.adicionarNo(24);
        arvAVL7.adicionarNo(29);
        arvAVL7.adicionarNo(2);
        arvAVL7.adicionarNo(7);
        arvAVL7.adicionarNo(30);
        arvAVL7.adicionarNo(6);
        System.out.println("\nAVL RDD:" + arvAVL7.navegarPelaArvore());

        arvAVL7.removerNo(25);
        System.out.println("\n2 filhos - AVL RDD:" + arvAVL7.navegarPelaArvore());

        arvAVL7.removerNo(7);
        System.out.println("\n2 filhos - AVL RDD:" + arvAVL7.navegarPelaArvore());
        
        arvAVL7.removerNo(30);
        System.out.println("\nnenhum filho - AVL RDD:" + arvAVL7.navegarPelaArvore());

        arvAVL7.removerNo(29);
        System.out.println("\n1 filho - AVL RDD:" + arvAVL7.navegarPelaArvore());

        // AVL<Integer> arvAVL8 = new AVL<>();
        // arvAVL8.adicionarNo(8);
        // arvAVL8.adicionarNo(6);
        // arvAVL8.adicionarNo(10);
        // arvAVL8.adicionarNo(4);
        // arvAVL8.adicionarNo(7);
        // arvAVL8.adicionarNo(9);
        // arvAVL8.adicionarNo(20);
        // arvAVL8.adicionarNo(3);
        // arvAVL8.adicionarNo(12);
        // arvAVL8.adicionarNo(22);
        // arvAVL8.adicionarNo(11);
        // System.out.println(arvAVL8.consultarExistenciaNo(29));
        // System.out.println(arvAVL8.consultarExistenciaNo(22));
        // System.out.println("\nAVL RDE:" + arvAVL8.navegarPelaArvore());

        // arvAVL8.removerNo(20);
        // System.out.println("\nAVL RDE:" + arvAVL8.navegarPelaArvore());
    }

}
