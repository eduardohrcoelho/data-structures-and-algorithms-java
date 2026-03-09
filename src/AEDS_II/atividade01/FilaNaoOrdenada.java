package AEDS_II.atividade01;

public class FilaNaoOrdenada {
    private Elemento[] fila;
    private int tamanho;

    public FilaNaoOrdenada(int capacidade){
        this.fila = new Elemento[capacidade];
        this.tamanho = 0;
    }

    public void inserir(String nome, int prioridade){
        if(tamanho == fila.length){
            System.out.println("Fila cheia!");
            return;
        }
        fila[tamanho] = new Elemento(nome, prioridade);
        tamanho++;
    }

    public Elemento remover(){
        if(tamanho == 0){
            System.out.println("Fila está vazia!");
            return null;
        }

        int indiceMaior = 0;
        for(int i = 1; i < tamanho; i++){
            if(fila[i].getPrioridade() > fila[indiceMaior].getPrioridade()){
                indiceMaior = i;
            }
        }

        Elemento pacienteAtendido = fila[indiceMaior];
        fila[indiceMaior] = fila[tamanho - 1];
        fila[tamanho - 1] = null;
        tamanho--;

        return pacienteAtendido;
    }
}
