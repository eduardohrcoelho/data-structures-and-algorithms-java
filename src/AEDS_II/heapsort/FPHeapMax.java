package AEDS_II.heapsort;

public class FPHeapMax {
    private Item v[];
    private int n;

    public FPHeapMax(Item v[]){
        this.v = v; this.n = this.v.length - 1;
    }

    public FPHeapMax(int capacidade){
        this.v = new Item[capacidade + 1];
        this.n = 0; // Inicia vazio!
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

    public void constroi(){
        int esq = n/2 + 1;
        while(esq > 1){
            esq--;
            this.refaz(esq, this.n);
        }
    }

    public Item retiraMax()throws Exception{
        Item maximo;
        if(this.n < 1) throw new Exception("Heap vazio");
        else{
            maximo = this.v[1];
            this.v[1] = this.v[this.n--];
            refaz(1, this.n);
        }
        return maximo;
    }

    public void aumentaChave ( int i , Object chaveNova)
            throws Exception {
        Item x = this .v[ i ] ;
        if (chaveNova == null)
            throw new Exception ( "Erro : chaveNova com valor null " );
        x.alteraChave (chaveNova);
        while (( i > 1) && (x.compara (this .v[ i / 2]) >= 0)) {
            this .v[ i ] = this .v[ i / 2 ] ; i /= 2;
        }
        this .v[ i ] = x;
    }

    public void insere (Item x) throws Exception {
        this .n++;
        if (this .n == this .v.length ) throw new Exception
                ( "Erro : heap cheio" );
        Object chaveNova = x.recuperaChave ( ) ;
        this .v[this .n] = x;
        this .aumentaChave (this .n, chaveNova);
    }

    public Item consultaMax() {
        if (this.n < 1) throw new RuntimeException("Erro: Heap vazio!");
        return this.v[1];
    }

    public void imprimeEstado() {
        System.out.print("Estado do Heap: [ ");
        for(int i = 1; i <= this.n; i++) {
            System.out.print(this.v[i] + " ");
        }
        System.out.println("]");
    }
}
