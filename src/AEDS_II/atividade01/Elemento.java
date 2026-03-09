package AEDS_II.atividade01;

public class Elemento {
    private String nome;
    private int prioridade;

    public Elemento(String nome, int prioridade){
        this.nome = nome;
        this.prioridade = prioridade;
    }

    public String getNome(){
        return this.nome;
    }

    public int getPrioridade(){
        return this.prioridade;
    }

    @Override
    public String toString() {
        return "[" + nome + " | Nível: " + prioridade + "]";
    }
}
