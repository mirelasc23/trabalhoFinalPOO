package mirela.ifsc.first.SegundoSemestre.POO.trabalhoFinal.alt2.entidades;

public class Estoque {
	private Produto produto;
	private int quantidade;
	
	public Estoque(Produto produto) {
		super();
		this.produto = produto;
		this.quantidade = produto.getQuantidade();
	}
	
	public Estoque(Produto produto, int quantidade) {
		super();
		this.produto = produto;
		this.quantidade = quantidade;
	}

	public Produto getProduto() {
		return produto;
	}
	
	public void adicionarProduto(int quantidade) {
		this.quantidade += quantidade;
	}
	
	public void removerProduto(int quantidade) {
		this.quantidade -= quantidade;
	}
	
	public int mostrarEstoque() {
		return quantidade;
	}
    
}
