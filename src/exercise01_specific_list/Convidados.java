package exercise01_specific_list;

import java.util.*;

public class Convidados {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char op;
        int cont = 0;

        System.out.println("Bem-vindo!");
        do{
            menu();
            op = scanner.next().toLowerCase().charAt(0);
            switch(op){
                case 'a':
                    System.out.println("Por favor, informe o numero de convidados da lista: ");
                    int n = scanner.nextInt();
                    Lista.criaListaVazia(n);
                    break;

                case 'b':
                    scanner.nextLine();
                    System.out.println("Informe o nome do convidado: ");
                    String convidado = scanner.nextLine();
                    Lista.insere(convidado);
                    break;

                case 'c':
                    System.out.println("Informe a posição do convidado que deseja retirar: ");
                    int indice = scanner.nextInt();
                    Lista.retiraNaPosicao(indice);
                    break;

                case 'd':
                    System.out.println("Digite as primeiras letras do nome do convidado: ");
                    String parte = scanner.nextLine();
                    Lista.pesquisaSimilar(parte);
                    break;

                case 'e':
                    Lista.imprime();
                    break;

                case 'f':
                    System.out.println("Saindo.");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }
        }while(op != 'f');

        scanner.close();
    }

    public static void menu(){
        System.out.println("a) Inicializa a lista de convidados \nb) Inserir convidados \nc) Excluir convidados \nd) Pesquisar convidados \ne) Imprimir a lista de convidados \nf) SAIR");
    }
}
