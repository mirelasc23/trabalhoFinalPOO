package padroes.entidades;

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
                if (this.quantidade >= quantidade) {
			this.quantidade -= quantidade;
		}else
			 System.out.println("Não há produtos suficientes em estoque.");
	}
	
	public int mostrarEstoque() {
		return quantidade;
	}
    
}
