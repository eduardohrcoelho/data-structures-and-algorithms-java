package lista01.exercicio01;

import java.util.Random;

public class ListaTeste {
    public static void main(String[] args) {
        Random random = new Random();
        int n = 5000;
        Object [] vetor = new Object[n];

        for(int i = 0; i < vetor.length; i++){
            vetor[i] = random.nextInt(n * 10);
        }

        long inicioSelecao = System.currentTimeMillis();
        Lista.sortSelection(vetor, n);
        long fimSelecao = System.currentTimeMillis();
        long tempoSelecao = fimSelecao - inicioSelecao;
        System.out.println("Tempo de execução (Seleção): " + tempoSelecao + " ms");

        for(int i = 0; i < vetor.length; i++){
            vetor[i] = random.nextInt(n * 10);
        }

        long inicioInsercao = System.currentTimeMillis();
        Lista.sortInsertion(vetor, n);
        long fimInsercao = System.currentTimeMillis();

        long tempoInsercao = fimInsercao - inicioInsercao;
        System.out.println("Tempo de execução (Inserção): " + tempoInsercao + " ms");
    }
}
