package AEDS_II.lista3.questao05;
import java.util.LinkedList;
import java.util.Queue;

public class ArvoreBinaria {
    private static class No {
        Item reg;
        No esq, dir, pai;
    }

    private No raiz;
    private No anterior = null; // Auxiliar para a Questão 4 (checkBST)

    public ArvoreBinaria() {
        this.raiz = null;
    }

    // --- MÉTODOS ORIGINAIS DO SEU CÓDIGO ---

    public void insere(Item reg) {
        this.raiz = this.insere(reg, this.raiz, null); // Ajustado para salvar o pai
    }

    private No insere(Item reg, No p, No pai) {
        if (p == null) {
            p = new No();
            p.reg = reg;
            p.esq = null;
            p.dir = null;
            p.pai = pai; // Questão 6
        } else if (reg.compara(p.reg) < 0) {
            p.esq = insere(reg, p.esq, p);
        } else if (reg.compara(p.reg) > 0) {
            p.dir = insere(reg, p.dir, p);
        } else {
            System.out.println("Erro: Registro ja existente");
        }
        return p;
    }

    public Item pesquisa(Item reg) {
        return this.pesquisa(reg, this.raiz);
    }

    private Item pesquisa(Item reg, No p) {
        if (p == null) return null;
        else if (reg.compara(p.reg) < 0) return pesquisa(reg, p.esq);
        else if (reg.compara(p.reg) > 0) return pesquisa(reg, p.dir);
        else return p.reg;
    }

    // --- QUESTÃO 3: ORDEM DECRESCENTE ---
    public void imprimeDecrescente() {
        this.imprimeDecrescente(this.raiz);
    }

    private void imprimeDecrescente(No p) {
        if (p != null) {
            imprimeDecrescente(p.dir);
            System.out.println(p.reg.toString());
            imprimeDecrescente(p.esq);
        }
    }

    // --- QUESTÃO 4: VERIFICAR SE É BST (EM-ORDEM) ---
    public boolean checkBST() {
        this.anterior = null; // Reseta a variável antes de validar
        return checkBST(this.raiz);
    }

    private boolean checkBST(No p) {
        if (p == null) return true;
        if (!checkBST(p.esq)) return false;
        if (anterior != null && p.reg.compara(anterior.reg) <= 0) return false;
        anterior = p;
        return checkBST(p.dir);
    }

    // --- QUESTÃO 5: PERCURSO EM LARGURA (FILA) ---
    public void percursoEmLargura() {
        if (this.raiz == null) return;
        Queue<No> fila = new LinkedList<>();
        fila.add(this.raiz);
        while (!fila.isEmpty()) {
            No atual = fila.poll();
            System.out.print(atual.reg.toString() + " ");
            if (atual.esq != null) fila.add(atual.esq);
            if (atual.dir != null) fila.add(atual.dir);
        }
        System.out.println();
    }

    // --- QUESTÃO 7: ALTURA DE UM NÓ ESPECÍFICO ---
    public int alturaDoNo(Item reg) {
        No encontrado = buscarNo(this.raiz, reg);
        if (encontrado == null) return -1;
        return calcularAltura(encontrado);
    }

    private int calcularAltura(No p) {
        if (p == null) return -1;
        return Math.max(calcularAltura(p.esq), calcularAltura(p.dir)) + 1;
    }

    // --- QUESTÃO 8: PROFUNDIDADE DE UM NÓ ESPECÍFICO ---
    public int profundidadeDoNo(Item reg) {
        return calcularProfundidade(this.raiz, reg, 0);
    }

    private int calcularProfundidade(No p, Item reg, int prof) {
        if (p == null) return -1;
        if (reg.compara(p.reg) == 0) return prof;
        if (reg.compara(p.reg) < 0) return calcularProfundidade(p.esq, reg, prof + 1);
        return calcularProfundidade(p.dir, reg, prof + 1);
    }

    private No buscarNo(No p, Item reg) {
        if (p == null || reg.compara(p.reg) == 0) return p;
        if (reg.compara(p.reg) < 0) return buscarNo(p.esq, reg);
        return buscarNo(p.dir, reg);
    }

    // --- MÉTODOS DE IMPRESSÃO E TESTE ORIGINAIS ---
    public void imprime() {
        this.central(this.raiz);
    }

    private void central(No p) {
        if (p != null) {
            central(p.esq);
            System.out.println(p.reg.toString());
            central(p.dir);
        }
    }
}
