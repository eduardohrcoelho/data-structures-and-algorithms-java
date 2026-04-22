package AEDS_II.lista3.questao09;

import AEDS_II.lista3.questao03.Item;

import java.util.LinkedList;
import java.util.Queue;

public class ArvoreBinaria {
    private static class No {
        Item reg;
        No esq, dir;
    }

    private No anterior = null;
    private No raiz;

    public ArvoreBinaria () {
        this.raiz = null;
    }

    // --- MÉTODOS ORIGINAIS ---
    public void insere (Item reg) {
        this.raiz = this.insere (reg, this.raiz);
    }

    private No insere (Item reg, No p) {
        if (p == null) {
            p = new No (); p.reg = reg;
            p.esq = null; p.dir = null;
        }
        else if (reg.compara (p.reg) < 0) p.esq = insere (reg, p.esq);
        else if (reg.compara (p.reg) > 0) p.dir = insere (reg, p.dir);
        else System.out.println ("Erro: Registro ja existente");
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

    // --- QUESTÃO 3: Ordem Decrescente ---
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

    // --- QUESTÃO 4: Verificar se é BST ---
    public boolean checkBST() {
        this.anterior = null; // Muito importante resetar aqui!
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

    // --- QUESTÃO 5: Percurso em Largura (Níveis) ---
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

    public int numeroDeFilhos(Item reg) {

        No encontrado = buscarNo(this.raiz, reg);

        if (encontrado == null) {
            return -1;
        }

        int quantidadeFilhos = 0;

        if (encontrado.esq != null) {
            quantidadeFilhos++;
        }

        if (encontrado.dir != null) {
            quantidadeFilhos++;
        }

        return quantidadeFilhos;
    }

    private No buscarNo(No p, Item reg) {
        if (p == null) {
            return null;
        }
        if (reg.compara(p.reg) == 0) {
            return p;
        }
        if (reg.compara(p.reg) < 0) {
            return buscarNo(p.esq, reg);
        } else {
            return buscarNo(p.dir, reg);
        }
    }
}
