package AEDS_II.lista3.questao10;

import AEDS_II.lista3.questao03.Item;

import java.util.LinkedList;
import java.util.Queue;

public class ArvoreBinaria {
    private static class No {
        Item reg;
        No esq, dir;
        int N;
    }

    private No anterior = null;
    private No raiz;

    public ArvoreBinaria () {
        this.raiz = null;
    }

    public void insere (Item reg) {
        this.raiz = this.insere (reg, this.raiz);
    }

    private No insere(Item reg, No p) {
        if (p == null) {
            p = new No();
            p.reg = reg;
            p.esq = null;
            p.dir = null;
            p.N = 1;
            return p;
        }

        if (reg.compara(p.reg) < 0) {
            p.esq = insere(reg, p.esq);
        } else if (reg.compara(p.reg) > 0) {
            p.dir = insere(reg, p.dir);
        } else {
            System.out.println("Erro: Registro ja existente");
        }

        p.N = size(p.esq) + size(p.dir) + 1;

        return p;
    }

    public Item pesquisa (Item reg) {
        return this.pesquisa (reg, this.raiz);
    }

    private Item pesquisa (Item reg, No p) {
        if (p == null) return null;
        else if (reg.compara (p.reg) < 0) return pesquisa (reg, p.esq);
        else if (reg.compara (p.reg) > 0) return pesquisa (reg, p.dir);
        else return p.reg;
    }

    public void imprime () {
        this.central (this.raiz);
    }

    private void central (No p) {
        if (p != null) {
            central (p.esq);
            System.out.println (p.reg.toString());
            central (p.dir);
        }
    }

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

    public boolean checkBST() {
        this.anterior = null;
        return checkBST(this.raiz);
    }

    private boolean checkBST(No p) {
        if (p == null) return true;

        if (!checkBST(p.esq)) return false;

        if (anterior != null && p.reg.compara(anterior.reg) <= 0) {
            return false;
        }
        anterior = p;

        return checkBST(p.dir);
    }

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

    public int size() {
        return size(this.raiz);
    }

    public int size(No p) {
        if (p == null) {
            return 0;
        }
        return p.N;
    }
}
