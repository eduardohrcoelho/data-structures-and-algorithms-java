package ListaExeDinamicas.exercicio03;

public class Lista {
    private Celula primeiro, ultimo;
    private Celula atual;

    private class Celula {
        Object item;
        Celula prox;
    }

    public Lista() {
        this.primeiro = new Celula(); // cabeçalho
        this.ultimo = this.primeiro;
        this.primeiro.prox = null;
        this.atual = null;
    }

    public Lista concatena(Lista l1) {
        if (l1.vazia())
            return this;
        Lista laux = this;
        laux.ultimo.prox = l1.primeiro.prox;
        laux.ultimo = l1.ultimo;
        return laux;
    }

    public boolean insere(Object item) {
        if (item == null)
            return false;
        Celula aux = new Celula();
        aux.prox = null;
        aux.item = item;
        this.ultimo.prox = aux;
        this.ultimo = aux;
        return true;
    }

    public Object retira(Object chave) {
        if (vazia() || chave == null)
            return null;
        Celula aux = this.primeiro;
        while (aux.prox != null && !aux.prox.item.equals(chave))
            aux = aux.prox;
        if (aux.prox == null) {
            System.out.println("Erro: chave nao encontrada (" + chave + ")");
            return null;
        }
        Celula q = aux.prox;
        Object item = q.item;
        aux.prox = q.prox;
        if (q.prox == null)
            this.ultimo = aux;
        return item;
    }

    public void imprime() {
        Celula aux = this.primeiro.prox;
        System.out.print("Lista: ");
        while (aux != null) {
            System.out.print(aux.item + " ");
            aux = aux.prox;
        }
        System.out.println();
    }

    public boolean vazia() {
        return (this.primeiro == this.ultimo);
    }

    public Object first() {
        if (vazia()) return null;
        this.atual = this.primeiro.prox;
        return this.atual.item;
    }

    public Object next() {
        if (this.atual == null || this.atual.prox == null) {
            return null;
        }
        this.atual = this.atual.prox;
        return this.atual.item;
    }

    public Object pesquisa(Object chave) {
        if (vazia() || chave == null) return null;
        Celula aux = this.primeiro.prox;
        while (aux != null) {
            if (aux.item.equals(chave)) {
                return aux.item;
            }
            aux = aux.prox;
        }
        return null;
    }

    public int retira(Object chave, int qtde) {
        if (vazia() || chave == null || qtde <= 0) {
            return 0;
        }

        Celula aux = this.primeiro;
        while (aux.prox != null && !aux.prox.item.equals(chave)) {
            aux = aux.prox;
        }

        if (aux.prox == null) {
            return 0;
        }

        int removidos = 0;
        while (aux.prox != null && removidos < qtde) {
            Celula q = aux.prox; // Célula a ser removida
            aux.prox = q.prox;
            if (aux.prox == null) {
                this.ultimo = aux;
            }
            q.prox = null;

            removidos++;
        }
        return removidos;
    }
}
