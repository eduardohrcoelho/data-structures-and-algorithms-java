package ListaExeDinamicas.exercicio01;

public class Lista {
    private Celula primeiro, ultimo;
    // Atributo adicionado para controlar a iteração (first/next)
    private Celula atual;

    private class Celula {
        Object item;
        Celula prox;
    }

    public Lista() {
        this.primeiro = new Celula(); // cabeçalho
        this.ultimo = this.primeiro;
        this.primeiro.prox = null;
        this.atual = null; // Inicializa o cursor
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
            // Mantive o print de erro conforme seu código original
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
            System.out.print(aux.item + " "); // Imprime na mesma linha para facilitar leitura
            aux = aux.prox;
        }
        System.out.println(); // Quebra de linha ao final
    }

    public boolean vazia() {
        return (this.primeiro == this.ultimo);
    }

    // --- MÉTODOS ADICIONADOS PARA A LETRA D ---

    /**
     * d.i: Retorna o primeiro elemento e posiciona o cursor nele.
     */
    public Object first() {
        if (vazia()) return null;
        this.atual = this.primeiro.prox; // Aponta para o primeiro item válido
        return this.atual.item;
    }

    /**
     * d.ii: Avança o cursor e retorna o próximo elemento.
     */
    public Object next() {
        if (this.atual == null || this.atual.prox == null) {
            return null;
        }
        this.atual = this.atual.prox;
        return this.atual.item;
    }

    // --- MÉTODO ADICIONAL PARA AUXILIAR A LETRA F ---

    /**
     * Pesquisa se um elemento existe sem retirá-lo.
     */
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
}

