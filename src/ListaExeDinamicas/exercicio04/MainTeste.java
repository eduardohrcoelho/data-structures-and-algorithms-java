package ListaExeDinamicas.exercicio04;

public class MainTeste {
    public static void main(String[] args) {
        Lista lista = new Lista();

        lista.insere(10);
        lista.insere(20);
        lista.insere(30);

        System.out.print("Lista Original: ");
        lista.imprime();

        System.out.println("\n--- Teste 1: Inserir {21, 22, 23} após 20 ---");
        Object[] novosItens = {21, 22, 23};
        boolean resultado = lista.insere(novosItens, 20);

        if (resultado) System.out.println("Sucesso: Vetor inserido.");
        else System.out.println("Falha: Chave não encontrada.");

        lista.imprime();

        System.out.println("\n--- Teste 2: Inserir {40, 50} após 30 (Fim) ---");
        Object[] itensFim = {40, 50};
        lista.insere(itensFim, 30);

        lista.imprime();
        lista.insere(60);
        System.out.println("(Verificação extra: inserindo 60 normalmente no final)");
        lista.imprime();

        System.out.println("\n--- Teste 3: Tentar inserir após 99 (Não existe) ---");
        boolean resErro = lista.insere(new Object[]{999}, 99);
        System.out.println("Resultado do retorno: " + resErro);
        lista.imprime();
    }
}
