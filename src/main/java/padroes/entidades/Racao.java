package padroes.entidades;

import padroes.entidades.Perecíveis;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Racao extends Produto implements Perecíveis{
    private Date validade;
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    
    public Racao(String nome, double preco, int quantidade) {
        super(nome, preco, quantidade);
    }

    @Override
    public void atualizarValidade(Date validade) {
        this.validade = validade;
    }    
    
  @Override
    public double calcularDesconto() {
        return getPreco() * 0.9; 
    }   

    @Override
    public boolean estaVencido() {
        return new Date().after(validade);
    }

	@Override
	public String mostraValidade() {
		return super.getNome() + ", validade: " + sdf.format(validade);
	}
}
