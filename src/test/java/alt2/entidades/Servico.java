
package mirela.ifsc.first.SegundoSemestre.POO.trabalhoFinal.alt2.entidades;

public class Servico {
    private String nome;
    private double preco;

    public Servico(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    @Override
    public String toString() {
        return "\n" + nome + ", R$" + preco;
    }
    
}