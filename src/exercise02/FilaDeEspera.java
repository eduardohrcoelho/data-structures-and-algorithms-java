package exercise02;

import java.util.Scanner;

public class FilaDeEspera {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int op;
        do{
            menu();
            op = scanner.nextInt();
            scanner.nextLine();
            switch(op){
                case 1:
                    System.out.print("Informe o nome do paciente para ser inserido na fila: ");
                    Fila.enfileira(scanner.nextLine());
                    break;

                case 2:
                    Object elemento = Fila.desenfileira();
                    System.out.println("Chamando: " + elemento);
                    break;

                case 3:
                    Fila.imprime();
                    break;

                case 4:
                    System.out.println("Número de pacientes aguardando: ");
                    break;

                case 5:
                    System.out.println("Encerrando programa.");
                    break;

                default:
                    System.out.println("Opção invalida.");

            }
        }while(op !=5);
        

        scanner.close();
    }

    public static void menu(){
        System.out.println("--- Escolha uma opção --- \n1. Incluir na lista de espera \n2. Chamar paciente \n3. Imprimir lista de espera \n4. Retornar o número de pacientes em espera \n5. Sair");
    }
}
