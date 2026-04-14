package AEDS_II.heapsort;

public class MeuItem implements Item {
    private int chave; // A prioridade

    public MeuItem(int chave) {
        this.chave = chave;
    }

    @Override
    public int compara(Item it) {
        MeuItem item = (MeuItem) it;
        if (this.chave < item.chave) return -1;
        else if (this.chave > item.chave) return 1;
        return 0;
    }

    @Override
    public void alteraChave(Object chave) {
        this.chave = (Integer) chave;
    }

    @Override
    public Object recuperaChave() {
        return this.chave;
    }

    @Override
    public String toString() {
        return String.valueOf(this.chave);
    }
}
