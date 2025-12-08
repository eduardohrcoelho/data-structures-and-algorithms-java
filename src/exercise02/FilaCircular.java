package exercise02;

public class FilaCircular {
    private static Object[] fila;
    private static int fim, inicio;

    public static void criaFilaVazia(int n){
        fila = new Object[n];
        fim = 0;
        inicio = 0;
    }
    public static void enfileira(Object elemento){
        if(fim>=fila.length){
            System.out.println("Erro: Fila Cheia");
            return;
        }
        fila[fim] = elemento;
        fim = (fim+1)%fila.length;
    }
    public static Object desenfileira(){
        if (vazia()){
            System.out.println("Erro: Fila vazia");
            return null;
        }
        Object elemento = fila[inicio];
        inicio = (inicio+1)%fila.length;
        return elemento;
    }
    public static boolean vazia(){
        if(fim == inicio)
            return true;
        return false;
    }

    public static void imprimirFila(){
        for (int i = inicio; i != fim; i=(i+1)%fila.length) {
            System.out.println(fila[i]);
        }

    }
    public static int tamanho(){
        return fim;
    }
    public static void furarFila(Object elemento){
        if(fim>=fila.length){
            System.out.println("Erro: Fila Cheia");
            return;
        }
        fila[inicio-1+fila.length] = elemento;
        inicio = ((inicio-1)+fila.length)%fila.length;

    }
}
