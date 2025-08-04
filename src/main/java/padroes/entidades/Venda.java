package padroes.entidades;

import java.util.ArrayList;
import java.util.List;

public class Venda {
    private int codigo;
    private double valor = 0.0d;
    List<ItemDeVenda> listaItemDeVendas = new ArrayList<>();

    public Venda(int codigo) {
    	this.codigo = codigo;
	}

	public double getValor() {
        return valor;
    }
    
	public int getCodigo() {
		return codigo;
	}
	
        
    public void adicionarProduto(Produto produto, int quantidade) {
    	ItemDeVenda itemDeProduto = new ItemDeVenda(produto, quantidade);
    	listaItemDeVendas.add(itemDeProduto);
    	this.valor += itemDeProduto.calculaItemProduto();
    }
    
    public void adicionarProduto(Produto produto, int quantidade, Estoque estoque) {
    	ItemDeVenda itemDeProduto = new ItemDeVenda(produto, quantidade);
    	itemDeProduto.atualizaEstoque(estoque, quantidade);
    	listaItemDeVendas.add(itemDeProduto);
    	this.valor += itemDeProduto.calculaItemProduto();
    }
    
    public void atualizaEstoque(Estoque estoque) {
    }
    
    public void adicionarServico(Servico servico, int quantidade) {
    	ItemDeVenda itemDeServico = new ItemDeVenda(servico, quantidade);
    	listaItemDeVendas.add(itemDeServico);
    	this.valor += itemDeServico.calculaItemServico() ;
    }
   
   public int getQuantidadeProduto(Produto produto) {
	   for(ItemDeVenda itemDeVenda: listaItemDeVendas) {
		   if (produto.equals(itemDeVenda.getProduto())) {
			   return itemDeVenda.getQuantidade();
		   }
	   }
	   return 0;
   }
   
   public int getQuantidadeServico(Servico servico) {
	   for(ItemDeVenda itemDeVenda: listaItemDeVendas) {
		   if (servico.equals(itemDeVenda.getServico())) {
			   return itemDeVenda.getQuantidade();
		   }
	   }
	   return 0;
   }
    
	@Override
	public String toString() {
		return "\nVenda " + codigo + ": R$" + valor ;
	}
}
