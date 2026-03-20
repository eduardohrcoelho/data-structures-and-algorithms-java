package AEDS_II.heapsort;

public class FPHeapMax {
    private Item v[];
    private int n;

    public FPHeapMax(Item v[]){
        this.v = v; this.n = this.v.length - 1;
    }

    public void refaz(int esq, int dir){
        int j = esq * 2;
        Item x = this.v[esq];
        while(j <= dir){
            if((j < dir) && (this.v[j].compara(this.v[j+1]) < 0)){
                j++;
            }
            if(x.compara(this.v[j])>= 0){
                break;
            }
            this.v[esq] = this.v[j];
            esq = j;
            j = esq*2;
        }
        this.v[esq] = x;
    }
}
