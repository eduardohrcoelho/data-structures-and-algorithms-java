package ListaExeDinamicas.exercicio03;

public class MainLista {
    public static void main(String[] args) {
        Lista lista = new Lista();

        System.out.println("=== TESTE DE REMOÇÃO EM LOTE ===");

        // a)
        lista.insere(9.8);
        lista.insere(7.7);
        lista.insere(6.2);
        lista.insere(4.10);

        // b)
        System.out.print("\nb) Lista original: ");
        lista.imprime();

        // c)
        System.out.println("\n--- c) Chamando retira(7.7, 2) ---");
        int qtdRemovida = lista.retira(7.7, 2);
        System.out.println("Foram removidos " + qtdRemovida + " elementos.");

        // d)
        System.out.print("d) Lista após primeira remoção: ");
        lista.imprime();

        System.out.println("\n--- e) Chamando retira(9.8, 3) ---");
        qtdRemovida = lista.retira(9.8, 3);
        System.out.println("Foram removidos " + qtdRemovida + " elementos.");

        // f)
        System.out.print("f) Lista final: ");
        lista.imprime();

        if (lista.vazia()) {
            System.out.println("(A lista está vazia)");
        }
    }
}
