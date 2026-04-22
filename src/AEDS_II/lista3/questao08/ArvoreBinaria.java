package AEDS_II.lista3.questao08;

import AEDS_II.lista3.questao03.Item;

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

    public int profundidadeDoNo(Item reg) {

        return calcularProfundidade(this.raiz, reg, 0);
    }

    private int calcularProfundidade(No p, Item reg, int profAtual) {
        if (p == null) {
            return -1;
        }

        if (reg.compara(p.reg) == 0) {
            return profAtual;
        }

        if (reg.compara(p.reg) < 0) {
            return calcularProfundidade(p.esq, reg, profAtual + 1);
        }

        else {
            return calcularProfundidade(p.dir, reg, profAtual + 1);
        }
    }
}
