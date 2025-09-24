package exercise01_specific_list;

public class ClasseTeste {
    public static void main(String[] args) {
        Lista.criaListaVazia(10);
        Lista.insere("Banana");
        Lista.insere("Abacate");
        Lista.insere("Abacaxi");

        System.out.println("\n--- Pesquisa ---");
        String pesquisa = Lista.pesquisaSimilar("Ab");
        System.out.println(pesquisa);
        Lista.insereNaPosicao(0, "Uva");
        Lista.imprime();
        System.out.println("-----------");
        Lista.retiraNaPosicao(2);
        Lista.imprime();

        String elemento = Lista.insereNaPosicao(2, "Limão");
        if(elemento != null){
            System.out.println(elemento + " inserido com sucesso!");
        }
        Lista.imprime();
    }
}
