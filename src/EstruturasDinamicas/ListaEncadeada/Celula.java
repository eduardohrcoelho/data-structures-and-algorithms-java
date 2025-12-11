package EstruturasDinamicas.ListaEncadeada;

public class Celula <T> {
    private T elemento;
    private Celula<T> proximo;

    public Celula(){
    }

    public Celula(T elemento){
        this.elemento = elemento;
        this.proximo = null;
    }

    public Celula(T elemento, Celula<T> proximo){
        this.elemento = elemento;
        this.proximo = proximo;
    }

    public T getElemento() {
        return elemento;
    }

    public void setElemento(T elemento) {
        this.elemento = elemento;
    }

    public Celula<T> getProximo() {
        return proximo;
    }

    public void setProximo(Celula<T> proximo) {
        this.proximo = proximo;
    }

    @Override
    public String toString() {
        return "Celula{" +
                "elemento=" + elemento +
                ", proximo=" + proximo +
                '}';
    }
}
