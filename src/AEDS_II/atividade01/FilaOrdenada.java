package AEDS_II.atividade01;

public class FilaOrdenada {
    private Elemento[] fila;
    private int tamanho;

    public FilaOrdenada(int capacidade){
        this.fila = new Elemento[capacidade];
        this.tamanho = 0;
    }

    public void inserir(String nome, int prioridade){
        if(tamanho == fila.length){
            System.out.println("Fila cheia!");
            return;
        }

        Elemento novo = new Elemento(nome, prioridade);
        int i = tamanho - 1;

        while(i >= 0 && fila[i].getPrioridade() > novo.getPrioridade()){
            fila[i + 1] = fila[i];
            i--;
        }

        fila[i + 1] = novo;
        tamanho++;
    }

    public Elemento remover(){
        if(tamanho == 0){
            System.out.println("Fila vazia!");
            return null;
        }

        Elemento pacienteAtendido = fila[tamanho - 1];

        fila[tamanho - 1] = null;
        tamanho--;

        return pacienteAtendido;
    }
}
