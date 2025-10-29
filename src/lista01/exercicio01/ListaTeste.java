package lista01.exercicio01;

public class ListaTeste {
    public static void main(String[] args) {
        Object [] vetor = new Object[10];

        for(int i = 0; i < vetor.length; i++){
            vetor[i] = (int)(Math.random() * vetor.length);
        }

        System.out.println("Desordenado: ");
        for(int i = 0; i < vetor.length; i++){
            System.out.println(vetor[i]);
        }
        System.out.println("=================");
        System.out.println("Ordenado: ");
        Lista.sortSelection(vetor, 10);
        for(int i = 0; i < vetor.length; i++){
            System.out.println(vetor[i]);
        }

    }
}
