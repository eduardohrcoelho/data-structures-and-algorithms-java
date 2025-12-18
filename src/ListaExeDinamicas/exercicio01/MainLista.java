package ListaExeDinamicas.exercicio01;

public class MainLista {
    public static void main(String[] args) {
        Lista lista = new Lista();

        System.out.println("=== INICIO DOS TESTES ===");

        // a)
        System.out.println("\n--- a) Inserindo elementos ---");
        int[] valores = {1, 2, 4, 6, 7, -9, 0, 22};
        for (int valor : valores) {
            lista.insere(valor);
        }

        // b)
        System.out.println("\n--- b) Imprimindo lista completa ---");
        lista.imprime();

        // c)
        System.out.println("\n--- c) Retirando elementos {3, 4, 5} ---");
        lista.retira(3);
        Object removido4 = lista.retira(4);
        if(removido4 != null) System.out.println("Item 4 removido com sucesso.");
        lista.retira(5);

        System.out.print("Lista após remoções: ");
        lista.imprime();

        // d) (Os métodos first() e next() já foram implementados na classe acima)

        // e)
        System.out.println("\n--- e) Retirando o primeiro elemento ---");
        Object primeiro = lista.first(); // O método first que criamos na letra D
        if (primeiro != null) {
            lista.retira(primeiro);
            System.out.println("Primeiro elemento (" + primeiro + ") foi removido.");
        }

        // f)
        System.out.println("\n--- f) Pesquisando elementos {22, -7} ---");
        Object[] buscas = {22, -7};
        for (Object busca : buscas) {
            Object resultado = lista.pesquisa(busca);
            if (resultado != null) {
                System.out.println("Elemento " + busca + " ENCONTRADO na lista.");
            } else {
                System.out.println("Elemento " + busca + " NAO encontrado.");
            }
        }

        // g)
        System.out.println("\n--- g) Impressão Final ---");
        lista.imprime();
    }
}
