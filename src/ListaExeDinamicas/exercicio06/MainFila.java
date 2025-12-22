package ListaExeDinamicas.exercicio06;

public class MainFila {
    public static void main(String[] args) {
        Fila filaOriginal = new Fila();

        filaOriginal.enfileira(3);
        filaOriginal.enfileira(17);
        filaOriginal.enfileira(5);
        filaOriginal.enfileira(12);
        filaOriginal.enfileira(1);

        System.out.println("--- Fila Antes da Divisão ---");
        filaOriginal.imprime();

        System.out.println("\n--- Dividindo na chave 5 ---");
        Fila segundaFila = filaOriginal.divide(5);

        if (segundaFila != null) {
            System.out.println("Divisão realizada com sucesso!");

            System.out.print("Fila 1: ");
            filaOriginal.imprime();

            System.out.print("Fila 2:     ");
            segundaFila.imprime();
        } else {
            System.out.println("Chave não encontrada ou erro na divisão.");
        }
    }
}