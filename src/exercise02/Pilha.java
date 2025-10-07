package exercise02;

public class Pilha {
    private static int topo;
    private static Object[] pilha;

    public static void criaPilhaVazia(int n){
        pilha = new Object[n];
        topo = 0;
    }

    public static void empilha(Object elemento){
        if (topo >= pilha.length){
            System.out.println("Erro! Pilha cheia!");
            return;
        }
        pilha[topo] = elemento;
        topo++;
    }

    public static Object desempilha(){
        if (vazia()){
            System.out.println("Erro: pilha vazia!");
            return null;
        }
        Object elemento = pilha[--topo];
        return elemento;
    }

    public static Object espiar(){ // peek em Inglês
        if (vazia()){
            System.out.println("Erro: pilha vazia!");
            return null;
        }
        return pilha[(topo - 1)];
    }

    public static boolean vazia(){
        if (pilha == null || topo ==0){
            return true;
        }
        return false;
    }

    public static void imprime(){
        if (vazia()){
            System.out.println("Pilha vazia!");
            return;
        }
        for(int i= (topo -1); i >=0; i--){
            System.out.println(pilha[i]);
        }
    }

}
