package exercise02;

import java.util.Scanner;

public class FilaDeEspera {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int op;
        do{
            menu();
            op = scanner.nextInt();
        }while(op !=5);





        scanner.close();
    }

    public static void menu(){
        System.out.println("--- Escolha uma opção --- \n1. Incluir na lista de espera \n2. Chamar paciente \n3. Imprimir lista de espera \n4. Retornar o número de pacientes em espera \n5. Sair");
    }
}
