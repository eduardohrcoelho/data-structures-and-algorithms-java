package prova2.questao01;

public class Lista {
    private class Celula{
        Object item;
        Celula prox;
    }
    private Celula primeiro, ultimo;

    public Lista(){
        this.primeiro = new Celula();
        this.ultimo = this.primeiro;
        this.primeiro.prox = null;
    }

    public boolean insere(Object item){
        if(item == null){
            return false;
        }
        Celula aux = new Celula();
        aux.prox = null;
        aux.item = item;
        this.ultimo.prox = aux;
        this.ultimo = aux;
        return true;
    }

    public void imprime(){
        Celula aux = this.primeiro.prox;
        while(aux != null){
            System.out.println(aux.item);
            aux = aux.prox;
        }
    }

    public boolean vazia(){
        return (this.primeiro == this.ultimo);
    }

    public Object retira(Object chave){
        if(vazia() || chave == null){
            return null;
        }
        Celula aux = this.primeiro;
        while(aux.prox != null && !aux.prox.item.equals(chave)){
            aux = aux.prox;
        }
        if(aux.prox == null){
            System.out.println("Chave não encontrada!");
            return null;
        }
        Celula q = aux.prox;
        Object item = q.item;
        aux.prox = q.prox;
        if(q.prox == null){
            this.ultimo = aux;
        }
        return item;
    }

    public Object retiraPrimeiro(){
        if(vazia()){
            return null;
        }

        Celula aux = this.primeiro;
        Celula q = this.primeiro.prox;
        aux.prox = q.prox;
        if (aux.prox == null) {
            this.ultimo = aux;
        }
        return q.item;
    }

    public Object retiraUltimo(){
        if(vazia()){
            return null;
        }
        Celula aux = this.primeiro;
        while(aux.prox != this.ultimo){
            aux = aux.prox;
        }

        Celula q = aux.prox;
        aux.prox = null;
        this.ultimo = aux;

        return q.item;
    }

    public Object busca(Object chave){
        if(vazia() || chave == null){ return null;}
        Celula aux = this.primeiro;
        while(aux.prox != null && !aux.prox.item.equals(chave)){
            aux = aux.prox;
        }
        if(aux.prox == null){
            System.out.println("Chave não encontrada!");
            return null;
        }
        return aux.prox.item;
    }

    public Lista concatena(Lista l1){
        if(l1.vazia()) return  this;
        Lista laux = this;
        laux.ultimo.prox = l1.primeiro.prox;
        laux.ultimo = l1.ultimo;
        return laux;

    }

    public Object getPrimeiro(){
        if(vazia()){return  null;}
        return this.primeiro.prox.item;
    }

    public int tamanho(){
        int cont = 0;
        Celula aux = this.primeiro.prox;
        while(aux != null){
            cont++;
            aux = aux.prox;
        }
        return cont;
    }

    public static void main(String[] args) {
        Lista list = new Lista();
        list.insere("A");
        list.insere("B");
        Lista l1 = new Lista();
        l1.insere("C");
        l1.insere("D");
        list.concatena(l1);
        Object pRetirado = list.retiraUltimo();
        System.out.println("Primeiro elemento retirado: " + pRetirado);
        list.imprime();
    }
}
