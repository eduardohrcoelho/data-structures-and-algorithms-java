package EstruturasDinamicas.ListaEncadeada;

public class ListaEncadeada <T> {
    private Celula<T> inicio;

    public void adiciona(T elemento){
        Celula<T> celula = new Celula<T>(elemento);
        this.inicio = celula;
    }

    @Override
    public String toString() {
        return "ListaEncadeada{" +
                "inicio=" + inicio +
                '}';
    }
}
