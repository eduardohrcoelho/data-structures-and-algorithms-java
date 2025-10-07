package exercise02;

public class Fila {
    private static Object[] fila;
    private static int frente, tras;

    public static void criaFilaVazia(int n){
        fila = new Object[n];
        frente = tras = 0;
    }


    public static void enfileira(Object elemento){
        if((tras+1)%fila.length == frente){
            System.out.println("Erro: fila cheia");
            return;
        }
        fila[tras] = elemento;
        tras = (tras + 1) % fila.length;
    }

    public static Object desenfileira(){
        if(vazia()){
            System.out.println("Erro: fila vazia");
            return null;
        }
        Object elemento = fila[frente];
        frente = (frente + 1) % fila.length;
        return elemento;
    }

    public static boolean vazia(){
        if(frente == tras)
            return true;
        return false;
    }

    public static void imprime(){
        for(int i=frente; (i != tras);
            i=(i+1)%fila.length)
            System.out.println(fila[i]);
    }

}