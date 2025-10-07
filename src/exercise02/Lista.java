package exercise02;

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

}