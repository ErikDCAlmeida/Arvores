package Arvores.Binaria;

import java.util.Scanner;

import Exceptions.PossuiFilhoNaDireita;
import Exceptions.PossuiFilhoNaEsquerda;

public class MenuBinaria {

    public MenuBinaria() {
        super();
    }

    public void start() throws PossuiFilhoNaDireita, PossuiFilhoNaEsquerda {
        Scanner scan = new Scanner(System.in);
        ArvoreBinaria<Integer> arv = new ArvoreBinaria<>();
        System.out.print("Esse é o menu da AVL, escolha nas opções abaixo o que desejado fazer:\n"
                            + "1 - Inserir um nó.\n" + "2 - Consultar existência de um nó.\n" 
                            + "3 - Excluir um nó.\n" + "4 - Imprimir a árvore.\n"
                            + "0 - Fechar programa.\n" + "Escolha: ");
        int escolha = scan.nextInt();
        while (true) {
            if (escolha == 1) {
                System.out.print("Digite o elemento que deseja adicionar: ");
                int elemento = scan.nextInt();
                System.out.print("Digite o elemento do pai: ");
                int pai = scan.nextInt();
                System.out.println("Digite '1' para adicionar o elemento na posicao esquerda do pai ou '2' ou qualquer outro para a direita: ");
                int posicao = scan.nextInt();
                if (posicao == 1) {
                    arv.adicionarNo(elemento, pai, 'e');
                } else {
                    arv.adicionarNo(elemento, pai, 'd');
                }
            } else if (escolha == 2) {
                System.out.print("Digite o elemento que deseja consultar existencia: ");
                int elemento = scan.nextInt();
                arv.consultarExistenciaNo(elemento);
            } else if (escolha == 3) {
                System.out.print("Digite o elemento que deseja excluir: ");
                int elemento = scan.nextInt();
                arv.removerNo(elemento);
            } else if (escolha == 4) {
                System.out.println(arv.navegarPelaArvore());
            } else if (escolha == 0) {
                break;
            } else {
                System.out.print("Desculpe, não foi possível encontrar a opção desejada!\n"
                                + "Por favor, digite uma opção válida!\n"
                                + "1 - Inserir um nó.\n" + "2 - Consultar existência de um nó.\n" 
                                + "3 - Excluir um nó.\n" + "4 - Imprimir a árvore.\n"
                                + "0 - Fechar programa.\n" + "Escolha: ");
                escolha = scan.nextInt();
            }
        }
        scan.close();
    }

}
