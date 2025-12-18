package ListaExeDinamicas.exercicio05;

public class MainListaDupla {
    public static void main(String[] args) {
        ListaDupla lista = new ListaDupla();

        System.out.println("=== TESTE LISTA DUPLAMENTE ENCADEADA ===");

        lista.insere("A");
        lista.insere("B");
        lista.insere("C");
        lista.insere("D");

        lista.insereInicio("Inicio");

        lista.imprime();

        lista.imprimeReverso();

        System.out.println("\n--- Removendo o item 'B' ---");
        lista.retira("B");

        lista.imprime();
        lista.imprimeReverso();
        System.out.println("\n--- Removendo o item 'D' (Último) ---");
        lista.retira("D");

        lista.imprime();
        System.out.println("Ultimo elemento atual: " + lista.retira("C"));
    }
}
