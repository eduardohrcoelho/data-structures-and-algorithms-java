package prova2.questao02;


import static exercise02.Pilha.vazia;

public class Pilha {
    private Celula topo;
    private Object[] pilha;
    private int tam;

    private class Celula{
        public Object item;
        public Celula prox;
    }


    public Pilha(int n){
        this.topo = null;
        this.tam = n;
    }

    public void empilha (Object item){
        Celula novo = new Celula();
        novo.item = item;
        novo.prox = this.topo;
        //ajuste do topo:
        this.topo = novo;
        this.tam++;
    }

    public Object desempilha(){
        if (vazia())
            return null; //indica nenhum registro foi desempilhado
        Object item = this.topo.item;
        this.topo = this.topo.prox;
        this.tam--;
        return item;
    }

    public void imprime(){
        Celula aux = this.topo;
        while(aux != null){
            System.out.println(aux.item);
            aux = aux.prox;
        }
    }

    public static void main(String[] args) {
        Pilha pilha = new Pilha(3);
        pilha.empilha(21);
        pilha.empilha(15);
        pilha.empilha(18);
        pilha.empilha(06);
        pilha.desempilha();
        pilha.desempilha();
        pilha.imprime();

    }
}
