package entidades;

class ItemDeVenda {
    private Produto produto;
    private Servico servico;
    private int quantidade;
    
	public ItemDeVenda(Produto produto, int quantidade) {
		super();
		this.produto = produto;
		this.quantidade = quantidade;
	}

	public ItemDeVenda(Servico servico, int quantidade) {
		super();
		this.servico = servico;
		this.quantidade = quantidade;
	}
	
	public int getQuantidade() {
    	 return quantidade;
     }
     
	public Produto getProduto() {
		return produto;
	}

	public Servico getServico() {
		return servico;
	}
	
	public double calculaItemProduto() {
		return quantidade * produto.getPreco();
	}
	
	public double calculaItemServico() {
		return quantidade * servico.getPreco();
	}
	
	public void atualizaEstoque(Estoque estoque, int quantidade) {
		if (estoque.mostrarEstoque() >= quantidade) {
			estoque.removerProduto(quantidade);
		}else
			 System.out.println("Não há produtos suficientes em estoque.");
	}
}
