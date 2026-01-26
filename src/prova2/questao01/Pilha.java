package prova2.questao01;

public class Pilha {
    private Celula topo;
    private int tam;

    private class Celula{
        public Object item;
        public Celula prox;
    }

    public Pilha(){
        this.topo = null;
        this.tam = 0;
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

    public boolean vazia(){
        return (this.topo == null);
    }

    public void imprime(){
        Celula aux = this.topo;
        while(aux != null){
            System.out.println(aux.item);
            aux = aux.prox;
        }
    }

    public Object getTopo(){
        if(vazia()){
            return null;
        }
        return this.topo.item;
    }

    public void inverte(){
        if (vazia() || topo.prox == null) return;

        Celula anterior = null;
        Celula atual = topo;
        Celula proximo = null;

        while (atual != null) {
            proximo = atual.prox; // Salva o próximo
            atual.prox = anterior; // Inverte a seta (aponta pra trás)
            anterior = atual;      // Avança o anterior
            atual = proximo;       // Avança o atual
        }
        topo = anterior; // O último virou o topo
    }

    public int tamanho(){
        return this.tam;
    }
}