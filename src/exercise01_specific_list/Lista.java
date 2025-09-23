package exercise01_specific_list;

public class Lista {
    private static String[] lista;
    private static int ultimo;

    public static void criaListaVazia(int n){
        lista = new String[n];
        ultimo = 0;
    }

    //Insere no final
    public static void insere(String elemento){
        if((lista == null) || (ultimo >= lista.length)){
            System.out.println("Erro: lista cheia");
            return; //termina a exec do metodo
        }
        lista[ultimo] = elemento;
        ultimo++;
    }

    //Exclui o primeiro elemento
    public static String retira(){
        if (lista == null || ultimo == 0){
            System.out.println("Erro: lista vazia");
            return null;
        }
        String elemento = lista[0];
        ultimo--;
        //reorganiza os elementos no vetor lista
        for(int i=0;i< ultimo; i++){
            lista[i] = lista[i+1];
        }
        return elemento;
    }

    public static int tamanho(){
        return ultimo;
    }

    public static void imprime(){
        if((lista == null) || ultimo==0){
            System.out.println("Erro: lista vazia");
            return;
        }
        for(int i=0; i < ultimo; i++){
            System.out.println(lista[i]);
        }
    }

    public static String insereNaPosicao(int indice, String elemento){
        if(indice < 0 || indice > ultimo){
            System.out.println("Posição invalida para inserir!");
            return null;
        }

        for(int i = ultimo; i >= indice; i--){
            lista[i + 1] = lista[i];

        }
        lista[indice] = elemento;
        ultimo++;
        return elemento;
    }

    public static boolean retiraNaPosicao(int indice){
        if(indice < 0 || indice > ultimo){
            System.out.println("Posição invalida para inserir!");
            return false;
        }

        for(int i = indice; i < ultimo; i++){
            lista[i] = lista[i + 1];
        }
        ultimo--;
        return true;
    }

    public static int pesquisaPosicao(String elemento){
        for(int i = 0; i < ultimo; i++){
            if(lista[i].equalsIgnoreCase(elemento)){
                return i;
            }
        }

        return -1;
    }

    public static String pesquisaSimilar(String parte){
        for(int i = 0; i < ultimo; i++){
            if(lista[i].contains(parte)){
                return lista[i];
            }
        }
        return null;
    }
}
