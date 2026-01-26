package prova2.questao01;

public class Fila {
    private Celula frente;
    private Celula tras;

    private class Celula{
        public Object item;
        public Celula prox;
    }

    public Fila(){
        this.frente = new Celula();
        this.tras = this.frente;
    }

    public boolean vazia(){
        return (this.frente == this.tras);
    }

    public void enfileira(Object item){
        Celula nova = new Celula();
        nova.item = item;
        nova.prox = null;
        this.tras.prox = nova;
        this.tras = nova;
    }

    public Object desenfileira(){
        if(vazia()){
            return null;
        }

        this.frente = this.frente.prox;
        Object item = this.frente.item;
        return item;
    }

    public void imprime(){
        Celula aux = this.frente.prox;
        while(aux != null){
            System.out.println(aux.item);
            aux = aux.prox;
        }
    }

    public Object getPrimeiro() {
        if (vazia()) return null;

        // O primeiro da fila é o vizinho da frente
        return this.frente.prox.item;
    }

    public void furaFila(Object item){
        Celula nova = new Celula();
        nova.item = item;

        // Engata entre a Frente e o Vizinho
        nova.prox = this.frente.prox;
        this.frente.prox = nova;

        // Se a fila estava vazia, o furão também é o último
        if (this.tras == this.frente) {
            this.tras = nova;
        }
    }
}
