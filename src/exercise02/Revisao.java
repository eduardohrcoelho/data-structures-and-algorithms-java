package exercise02;

public class Revisao {
    private static Object[] lista;
    private static int ultimo;

    public static void insereNoInicio(Object elemento){
        if(ultimo == lista.length){
            System.out.println("Lista vazia");
            return;
        }

        for(int i = ultimo; i > 0; i--){
            lista[i] = lista[i - 1];
        }
        lista[0] = elemento;
        ultimo++;
    }

    public static void insereFinal(Object elemento){
        if(ultimo == lista.length){
            System.out.println("Erro, lista cheia");
            return;
        }

        lista[ultimo] = elemento;
        ultimo++;
    }

    public static void inserePosicao(Object elemento, int pos){
        if(ultimo == lista.length){
            System.out.println("Erro, lista cheia");
            return;
        }

        for(int i = ultimo; i > pos; i--){
            lista[i] = lista[i - 1];
        }
        lista[pos] = elemento;
        ultimo++;
    }

    public static Object pesquisa(Object elemento){
        if(ultimo == 0){
            System.out.println("Lista vazia");
            return null;
        }

        for(int i = 0; i < lista.length; i++){
            if(lista[i].equals(elemento)){
                return lista[i];
            }
        }
        return null;
    }

    public static Object consulta(int pos){
        return lista[pos];
    }

    public static void cria(int n){
        lista = new Object[n];
        ultimo = 0;
    }

    public static void imprime(){
        for(int i = 0; i < ultimo; i++){
            System.out.println(lista[i]);
        }
    }


}
