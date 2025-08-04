package padroes.entidades;

import entidades.Pereciveis;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Medicamento extends entidades.Produto implements Pereciveis{
    private Date validade;
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    
    public Medicamento(String nome, double preco, int quantidade) {
        super(nome, preco, quantidade);
    }
    
    @Override
    public void atualizarValidade(Date validade) {
        this.validade = validade;
    }
    
     @Override
    public double calcularDesconto() {
        return getPreco() * 0.95;
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
