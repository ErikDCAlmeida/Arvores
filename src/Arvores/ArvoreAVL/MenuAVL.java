package Arvores.ArvoreAVL;

import java.util.Scanner;

/**
 *
 * @author ErikDCAlmeida
 */
public class MenuAVL {
    
    public MenuAVL() {
        super();
    }

    public void start(){
        Scanner scan = new Scanner(System.in);
        AVL<Integer> arvAVL = new AVL<>();
        System.out.print("Esse é o menu da AVL, escolha nas opções abaixo o que desejado fazer:\n"
                            + "1 - Inserir um nó.\n" + "2 - Consultar existência de um nó.\n" 
                            + "3 - Excluir um nó.\n" + "4 - Imprimir a árvore.\n"
                            + "0 - Fechar programa.\n" + "Escolha: ");
        int escolha = scan.nextInt();
        while (true) {
            if (escolha == 1) {
                System.out.print("Digite o elemento que deseja adicionar: ");
                int elemento = scan.nextInt();
                arvAVL.adicionarNo(elemento);
            } else if (escolha == 2) {
                System.out.print("Digite o elemento que deseja consultar existencia: ");
                int elemento = scan.nextInt();
                arvAVL.consultarExistenciaNo(elemento);
            } else if (escolha == 3) {
                System.out.print("Digite o elemento que deseja excluir: ");
                int elemento = scan.nextInt();
                arvAVL.removerNo(elemento);
            } else if (escolha == 4) {
                System.out.print("Digite '1' para imprimir todas as rotas ou '2', '3' ou '4' para alguma especifica, no qual:\n"
                + "2 - Rota LRN.\n3 - Rota LNR.\n4 - Rota NLR.\nEscolha: ");
                int escolhaRota = scan.nextInt();
                if (escolhaRota == 1){
                    System.out.println(arvAVL.navegarPelaArvore());
                } else if (escolhaRota == 2){
                    System.out.println(arvAVL.especificaLRN());
                } else if (escolhaRota == 3){
                    System.out.println(arvAVL.especificaLNR());
                } else if (escolhaRota == 4) {
                    System.out.println(arvAVL.especificaNLR());
                }
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
