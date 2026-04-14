package AEDS_II.heapsort;

import java.util.Random;

public class MergesortTeste {
    public static void mergeSort(int[] v, int esq, int dir) {
        if (esq < dir) {
            int meio = (esq + dir) / 2;
            mergeSort(v, esq, meio);
            mergeSort(v, meio + 1, dir);
            intercala(v, esq, meio, dir);
        }
    }

    public static void intercala(int[] v, int esq, int meio, int dir) {
        int[] aux = new int[dir - esq + 1];
        int i = esq;
        int j = meio + 1;
        int k = 0;

        while (i <= meio && j <= dir) {
            if (v[i] <= v[j]) {
                aux[k] = v[i];
                i++;
            } else {
                aux[k] = v[j];
                j++;
            }
            k++;
        }

        while (i <= meio) {
            aux[k] = v[i];
            i++;
            k++;
        }

        while (j <= dir) {
            aux[k] = v[j];
            j++;
            k++;
        }

        for (i = esq, k = 0; i <= dir; i++, k++) {
            v[i] = aux[k];
        }
    }

    public static int[] gerarVetorAleatorio(int tamanho) {
        Random random = new Random();
        int[] vetor = new int[tamanho];
        for (int i = 0; i < tamanho; i++) {
            vetor[i] = random.nextInt(1000000);
        }
        return vetor;
    }

    public static void main(String[] args) {
        int[] tamanhos = {1000, 10000, 100000};

        for (int tamanho : tamanhos) {
            int[] vetor = gerarVetorAleatorio(tamanho);

            long tempoInicio = System.nanoTime();
            mergeSort(vetor, 0, tamanho - 1);
            long tempoFim = System.nanoTime();

            long duracaoNanos = tempoFim - tempoInicio;
            double duracaoMilis = duracaoNanos / 1_000_000.0;

            System.out.println(duracaoNanos + " ns (" + duracaoMilis + " ms)");
        }
    }
}