package AEDS_II.atividade01;

public class Teste {
    public static void main(String[] args) {

        System.out.println("=========================================");
        System.out.println("1. TESTANDO A FILA NÃO ORDENADA");
        System.out.println("=========================================");
        FilaNaoOrdenada f1 = new FilaNaoOrdenada(5);

        // Inserções bagunçadas
        f1.inserir("João (Corte no dedo)", 2);
        f1.inserir("Maria (Parada Cardíaca)", 10); // Mais urgente
        f1.inserir("Ana (Febre leve)", 1);
        f1.inserir("Pedro (Fratura exposta)", 8);

        // Tem que sair a Maria primeiro, depois Pedro, João, Ana.
        System.out.println("Atendendo: " + f1.remover());
        System.out.println("Atendendo: " + f1.remover());
        System.out.println("Atendendo: " + f1.remover());
        System.out.println("Atendendo: " + f1.remover());

        System.out.println("\n=========================================");
        System.out.println("2. TESTANDO A FILA ORDENADA");
        System.out.println("=========================================");
        FilaOrdenada f2 = new FilaOrdenada(5);

        // Inserções bagunçadas
        f2.inserir("João (Corte no dedo)", 2);
        f2.inserir("Maria (Parada Cardíaca)", 10);
        f2.inserir("Ana (Febre leve)", 1);
        f2.inserir("Pedro (Fratura exposta)", 8);

        // A ordem de saída TEM que ser idêntica à da fila anterior
        System.out.println("Atendendo: " + f2.remover());
        System.out.println("Atendendo: " + f2.remover());
        System.out.println("Atendendo: " + f2.remover());
        System.out.println("Atendendo: " + f2.remover());
    }
}
