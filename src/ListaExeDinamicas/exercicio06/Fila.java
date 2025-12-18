package ListaExeDinamicas.exercicio06;

public class Fila {
    private Celula frente;
    private Celula tras;

    private class Celula {
        public Object item;
        public Celula prox;
    }

    public Fila() {
        this.frente = new Celula();
        this.tras = this.frente;
    }

    public boolean vazia() {
        return (this.frente == this.tras);
    }

    public void enfileira(Object item) {
        Celula nova = new Celula();
        nova.item = item;
        nova.prox = null;
        this.tras.prox = nova;
        this.tras = nova;
    }

    public Object desenfileira() {
        if (vazia()) {
            return null;
        }
        this.frente = this.frente.prox;
        Object item = this.frente.item;
        return item;
    }

    public void imprime() {
        Celula aux = this.frente.prox;
        while (aux != null) {
            System.out.print(aux.item);
            aux = aux.prox;
        }
        System.out.println();
    }

    public void concatena(Fila f2) {
        if (f2 == null || f2.vazia()) {
            return;
        }

       Celula aux = f2.frente.prox;

        while (aux != null) {
            this.enfileira(aux.item);
            aux = aux.prox;
        }
    }

    public Fila divide(Object chave) {
        if (vazia() || chave == null) {
            return null;
        }

        Celula pivo = this.frente.prox;
        while (pivo != null && !pivo.item.equals(chave)) {
            pivo = pivo.prox;
        }

        if (pivo == null) {
            return null;
        }
        Fila novaFila = new Fila();


        if (pivo.prox != null) {
            novaFila.frente.prox = pivo.prox;
            novaFila.tras = this.tras;

            this.tras = pivo;
            this.tras.prox = null;
        }

        return novaFila;
    }
}