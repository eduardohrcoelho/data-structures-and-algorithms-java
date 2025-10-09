package exercise02;

import java.util.Scanner;

public class testePilha {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int op;

        System.out.print("Informe o número de tarefas: ");
        Pilha.criaPilhaVazia(scanner.nextInt());
        scanner.nextLine();
        do{
            menu();
            op = scanner.nextInt();
            scanner.nextLine();
            switch(op){
                case 1:
                    System.out.print("Informe a tarefa a ser adicionada: ");
                    Pilha.empilha(scanner.nextLine());
                    break;

                case 2:
                    System.out.println("Tarefa no topo: " + Pilha.espiar());
                    break;

                case 3:
                    Pilha.imprime();
                    break;

                case 4:
                    Pilha.desempilha();
                    break;

                case 5:
                    System.out.println("Número de tarefas: " + Pilha.numeroDeTarefas());
                    break;

                case 6:
                    System.out.println("Encerrando programa.");
                    break;

                default:
                    System.out.println("Opção invalida.");
            }

        }while(op != 6);


        scanner.close();
    }

    public static void menu(){
        System.out.println("--- Escolha uma opção --- \n1. Empilhar tarefa \n2. Mostrar a tarefa no topo da pilha \n3. Imprimir pilha de tarefas \n4. Desempilhar uma tarefa \n5. Retornar o número de tarefas na Pilha \n6. Sair");
    }
}
