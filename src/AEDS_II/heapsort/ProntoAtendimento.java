package AEDS_II.heapsort;

import java.util.Scanner;

public class ProntoAtendimento {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        // Usando o construtor vazio que adicionamos na classe FPHeapMax na Questão 1
        FPHeapMax painelHospital = new FPHeapMax(20);

        System.out.println("=== RECEPÇÃO DO PRONTO ATENDIMENTO ===");
        System.out.println("Registrando pacientes...\n");

        // Vamos criar um cenário propício para testar o desempate
        // Formato: Nome, Prioridade, Ordem de Chegada
        painelHospital.insere(new Paciente("Joao (Pé quebrado)", 3, 1));
        painelHospital.insere(new Paciente("Maria (Parada Cardiaca)", 5, 2)); // Mais grave até agora
        painelHospital.insere(new Paciente("Pedro (Corte leve)", 1, 3));
        painelHospital.insere(new Paciente("Ana (Infarto)", 5, 4)); // Empata com a Maria, mas chegou DEPOIS
        painelHospital.insere(new Paciente("Carlos (Febre)", 3, 5)); // Empata com o Joao, mas chegou DEPOIS

        System.out.println("=== INICIANDO CHAMADAS MÉDICAS ===");

        // Sabemos que colocamos 5 pacientes, então vamos fazer um laço de 5 chamadas
        for (int i = 0; i < 5; i++) {
            // Apenas olha quem é o próximo, sem tirar da fila ainda (consultaMax)
            Paciente proximo = (Paciente) painelHospital.consultaMax();

            System.out.println("\n--------------------------------------------------");
            System.out.println(">> PROXIMO DA FILA: " + proximo.toString());
            System.out.print("Medica(o), digite 'ok' para chamar para o consultorio: ");

            String comando = scanner.nextLine();

            if (comando.equalsIgnoreCase("ok")) {
                // Agora sim, tira o paciente da fila e reorganiza o Heap (retiraMax)
                Paciente atendido = (Paciente) painelHospital.retiraMax();
                System.out.println(">> ATENDIMENTO INICIADO: " + atendido.toString() + " entrou na sala.");
            } else {
                System.out.println("Comando invalido. O paciente continua aguardando.");
                i--; // Volta o contador para repetir a mesma chamada
            }
        }

        System.out.println("\n--------------------------------------------------");
        System.out.println("Nao ha mais pacientes na fila. Fim do expediente!");
        scanner.close();
    }
}
