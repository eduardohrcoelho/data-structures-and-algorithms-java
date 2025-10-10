package exercise02;

public class ListaUnificada {

    private static Object[] vetor;
    private static int ultimo;

    public static void criaListaVazia(int n) {
        vetor = new Object[n];
        ultimo = 0;
    }

    public static boolean estaVazia() {
        return ultimo == 0;
    }

    public static boolean estaCheia() {
        return ultimo >= vetor.length;
    }

    public static int tamanho() {
        return ultimo;
    }

    public static void imprime() {
        if (estaVazia()) {
            System.out.println("Erro: A estrutura está vazia.");
            return;
        }
        System.out.println("--- Conteúdo da Estrutura ---");
        for (int i = 0; i < ultimo; i++) {
            System.out.println("[" + i + "] -> " + vetor[i]);
        }
        System.out.println("---------------------------");
    }

    public static void empilha(Object elemento) {
        if (estaCheia()) {
            System.out.println("Erro: A estrutura está cheia.");
            return;
        }
        vetor[ultimo] = elemento;
        ultimo++;
    }

    public static Object desempilha() {
        if (estaVazia()) {
            System.out.println("Erro: A estrutura está vazia.");
            return null;
        }
        ultimo--;
        Object elemento = vetor[ultimo];
        vetor[ultimo] = null;
        return elemento;
    }

    public static void enfileira(Object elemento) {
        empilha(elemento);
    }

    public static Object desenfileira() {
        if (estaVazia()) {
            System.out.println("Erro: A estrutura está vazia.");
            return null;
        }
        Object elemento = vetor[0];
        for (int i = 0; i < ultimo - 1; i++) {
            vetor[i] = vetor[i + 1];
        }
        ultimo--;
        vetor[ultimo] = null;
        return elemento;
    }

    public static void insere(Object elemento, int posicao) {
        if (estaCheia()) {
            System.out.println("Erro: A estrutura está cheia.");
            return;
        }
        if (posicao < 0 || posicao > ultimo) {
            System.out.println("Erro: Posição de inserção inválida.");
            return;
        }
        for (int i = ultimo; i > posicao; i--) {
            vetor[i] = vetor[i - 1];
        }
        vetor[posicao] = elemento;
        ultimo++;
    }

    public static Object retira(int posicao) {
        if (estaVazia() || posicao < 0 || posicao >= ultimo) {
            System.out.println("Erro: Posição de remoção inválida.");
            return null;
        }
        Object elemento = vetor[posicao];
        for (int i = posicao; i < ultimo - 1; i++) {
            vetor[i] = vetor[i + 1];
        }
        ultimo--;
        vetor[ultimo] = null;
        return elemento;
    }
}
