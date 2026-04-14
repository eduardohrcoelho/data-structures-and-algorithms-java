package AEDS_II.heapsort;

public class Paciente implements Item{
    private String nome;
    private int prioridade;     // Quanto maior, mais urgente
    private int horarioChegada; // Usaremos um número inteiro simples (ex: 1, 2, 3...) Menor = chegou primeiro

    public Paciente(String nome, int prioridade, int horarioChegada) {
        this.nome = nome;
        this.prioridade = prioridade;
        this.horarioChegada = horarioChegada;
    }

    // --- O CORAÇÃO DA QUESTÃO: A REGRA DE NEGÓCIO ---
    @Override
    public int compara(Item it) {
        Paciente outro = (Paciente) it;

        // 1º Critério: Avalia a Urgência (Prioridade)
        if (this.prioridade > outro.prioridade) return 1;  // Eu sou mais urgente
        if (this.prioridade < outro.prioridade) return -1; // Ele é mais urgente

        // 2º Critério (Desempate): Avalia o Horário de Chegada
        // ATENÇÃO NA INVERSÃO: Quem chegou CEDO (número menor) tem que ganhar (retornar 1)
        if (this.horarioChegada < outro.horarioChegada) return 1;  // Eu cheguei primeiro, eu ganho
        if (this.horarioChegada > outro.horarioChegada) return -1; // Ele chegou primeiro, ele ganha

        return 0; // Exatamente iguais
    }

    // Métodos obrigatórios da interface Item
    @Override
    public void alteraChave(Object chave) {
        this.prioridade = (Integer) chave;
    }

    @Override
    public Object recuperaChave() {
        return this.prioridade;
    }

    // Para imprimir bonito na tela
    @Override
    public String toString() {
        return String.format("[Triagem: %d | Chegada: %d] Paciente: %s", prioridade, horarioChegada, nome);
    }
}
