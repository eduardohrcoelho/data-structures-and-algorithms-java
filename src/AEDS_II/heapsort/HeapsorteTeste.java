package AEDS_II.heapsort;

import java.util.Random;

public class HeapsorteTeste {
    public static void refaz(int[] v, int esq, int dir) {
        int j = esq * 2;
        int x = v[esq];
        while (j <= dir) {
            if ((j < dir) && (v[j] < v[j + 1])) {
                j++;
            }
            if (x >= v[j]) {
                break;
            }

            v[esq] = v[j];
            esq = j;
            j = esq * 2;
        }
        v[esq] = x;
    }

    public static void heapsort(int[] v, int n) {
        int esq = n / 2 + 1;
        while (esq > 1) {
            esq--;
            refaz(v, esq, n);
        }

        int dir = n;
        while (dir > 1) {
            int x = v[1];
            v[1] = v[dir];
            v[dir] = x;
            dir--;
            refaz(v, 1, dir);
        }
    }

    public static int[] gerarVetorAleatorio(int tamanho) {
        Random random = new Random();
        int[] vetor = new int[tamanho + 1];
        for (int i = 1; i <= tamanho; i++) {
            vetor[i] = random.nextInt(1000000); // Números aleatórios de 0 a 999.999
        }
        return vetor;
    }


    public static void main(String[] args) {

        int[] tamanhos = {1000, 10000, 100000};

        for (int tamanho : tamanhos) {
            System.out.println("\nGerando vetor aleatorio de " + tamanho + " posicoes...");
            int[] vetor = gerarVetorAleatorio(tamanho);

            long tempoInicio = System.nanoTime();

            heapsort(vetor, tamanho);

            long tempoFim = System.nanoTime();

            long duracaoNanos = tempoFim - tempoInicio;
            double duracaoMilis = duracaoNanos / 1_000_000.0;

            System.out.println(">> Tempo de execucao: " + duracaoNanos + " nanossegundos (" + duracaoMilis + " ms)");

            System.out.println("   (Verificacao: Primeiro=" + vetor[1] + ", Ultimo=" + vetor[tamanho] + ")");
        }
        System.out.println("\nExperimento concluido!");
    }
}
