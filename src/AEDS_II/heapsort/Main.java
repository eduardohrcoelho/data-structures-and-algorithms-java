package AEDS_II.heapsort;

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("=== TESTE DA FILA DE PRIORIDADE (ZIVIANI) ===");

        // Usando o novo construtor para iniciar vazio com capacidade 10
        FPHeapMax fila = new FPHeapMax(10);

        System.out.println("\n--- Realizando Inserções ---");
        fila.insere(new MeuItem(20));
        fila.imprimeEstado(); // [ 20 ]

        fila.insere(new MeuItem(50));
        fila.imprimeEstado(); // [ 50 20 ] (O 50 flutuou para a raiz)

        fila.insere(new MeuItem(30));
        fila.imprimeEstado(); // [ 50 20 30 ]

        fila.insere(new MeuItem(90));
        fila.imprimeEstado(); // [ 90 50 30 20 ] (O 90 subiu até a raiz)

        System.out.println("\nConsultando o Maximo (sem retirar): " + fila.consultaMax());

        System.out.println("\n--- Realizando Retiradas ---");
        System.out.println("Retirou: " + fila.retiraMax()); // Retira o 90
        fila.imprimeEstado(); // [ 50 20 30 ]

        System.out.println("Retirou: " + fila.retiraMax()); // Retira o 50
        fila.imprimeEstado(); // [ 30 20 ]

        System.out.println("\n--- Aumentando Chave ---");
        System.out.println("Aumentando a chave do item no indice 2 (que e 20) para 80:");
        fila.aumentaChave(2, 80);
        fila.imprimeEstado(); // [ 80 30 ] (O 80 subiu para a raiz)
    }
}
