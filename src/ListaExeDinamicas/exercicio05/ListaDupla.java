package ListaExeDinamicas.exercicio05;

public class ListaDupla {
    private Celula primeiro, ultimo;

    private class Celula {
        Object item;
        Celula ant;
        Celula prox;
    }

    public ListaDupla() {
        this.primeiro = new Celula(); // Cria a célula cabeça
        this.ultimo = this.primeiro;
        this.primeiro.prox = null;
        this.primeiro.ant = null;
    }

    public boolean vazia() {
        return (this.primeiro == this.ultimo);
    }

    public void insere(Object item) {
        Celula nova = new Celula();
        nova.item = item;
        nova.prox = null;
        nova.ant = this.ultimo;
        this.ultimo.prox = nova;

        this.ultimo = nova;
    }

    public void insereInicio(Object item) {
        Celula nova = new Celula();
        nova.item = item;

        nova.ant = this.primeiro;
        nova.prox = this.primeiro.prox;

        if (this.primeiro.prox != null) {
            this.primeiro.prox.ant = nova;
        }

        this.primeiro.prox = nova;

        if (this.ultimo == this.primeiro) {
            this.ultimo = nova;
        }
    }

    public Object retira(Object chave) {
        if (vazia() || chave == null) return null;

        Celula aux = this.primeiro.prox;
        while (aux != null && !aux.item.equals(chave)) {
            aux = aux.prox;
        }

        if (aux == null) return null;

        Object itemRemovido = aux.item;


        aux.ant.prox = aux.prox;

        if (aux.prox != null) {
            aux.prox.ant = aux.ant;
        } else {
            this.ultimo = aux.ant;
        }

        return itemRemovido;
    }

    public void imprime() {
        Celula aux = this.primeiro.prox;
        System.out.print("Sentido Início -> Fim: ");
        while (aux != null) {
            System.out.print(aux.item + " ");
            aux = aux.prox;
        }
        System.out.println();
    }

    public void imprimeReverso() {
        Celula aux = this.ultimo;
        System.out.print("Sentido Fim -> Início: ");
        while (aux != this.primeiro) {
            System.out.print(aux.item + " ");
            aux = aux.ant;
        }
        System.out.println();
    }
}