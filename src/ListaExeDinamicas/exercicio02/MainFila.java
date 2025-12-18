package ListaExeDinamicas.exercicio02;

public class MainFila {
    public static void main(String[] args) {

        // a)
        Fila filaA = new Fila();
        Object[] itensA = {'a', 'o', ' ', 'f', 'i', 'n', 'a', 'l'};
        for (Object i : itensA) filaA.enfileira(i);

        // b)
        Fila filaB = new Fila();
        Object[] itensB = {' ', 'v', 'e', 'n', 'c', 'e', ' '};
        for (Object i : itensB) filaB.enfileira(i);

        // c)
        Fila filaC = new Fila();
        Object[] itensC = {'o', ' ', 'm', 'a', 'i', 's', ' '};
        for (Object i : itensC) filaC.enfileira(i);

        // d)
        Fila filaD = new Fila();
        Object[] itensD = {'m', 'o', 't', 'i', 'v', 'a', 'd', 'o'};
        for (Object i : itensD) filaD.enfileira(i);

        System.out.println("--- Filas Originais ---");
        System.out.print("A: "); filaA.imprime();
        System.out.print("B: "); filaB.imprime();
        System.out.print("C: "); filaC.imprime();
        System.out.print("D: "); filaD.imprime();
        System.out.println("-----------------------");

        // e)
        filaA.concatena(filaB);

        // f)
        filaC.concatena(filaD);

        // g)
        filaA.concatena(filaC);

        // h)
        System.out.println("\n--- h) Resultado Final (Fila A) ---");
        filaA.imprime();
    }
}
