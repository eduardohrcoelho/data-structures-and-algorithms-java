package AEDS_II.arvores;

public class ArvoreBinariaBusca {
    private static class No{
        Item reg;
        No esq, dir;
    }

    private No raiz;

    public ArvoreBinariaBusca(){
        this.raiz = null;
    }
}
