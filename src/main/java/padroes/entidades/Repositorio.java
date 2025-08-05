package padroes.entidades;

import java.util.ArrayList;
import java.util.List;

public class Repositorio {
    public static final Repositorio INSTANCE = new Repositorio();
    private List<Produto> produtos = new ArrayList<>();
    private List<Servico> servicos = new ArrayList<>();

    public Repositorio() {
        iniciaProdutos();
        iniciaServicos();
    }

    private void iniciaProdutos() {
        Produto medicamento = new Medicamento("medimento", 10, 2);
        Produto brinquedo = new Brinquedo("medimento", 10, 2);
        Produto racao = new Racao("medimento", 10, 2);
    }

    private void iniciaServicos() {
        Servico banho = new Servico("banho", 35.00);
        Servico tosa = new Servico("tosa", 15.00);
        Servico consulta = new Servico("consulta", 75.00);
        
    }

    public List<Produto> produtos() {
        return produtos;
    }

    public List<Servico> servicos() {
        return servicos;
    }
    
    public StringBuilder exibirServicos(){
        StringBuilder exibirServicos = new StringBuilder("\n-----| Serviços |------\n");
        for (Servico servico : servicos) {
            exibirServicos.append(servicos.indexOf(servico) + 1);
            exibirServicos.append(" - ");
            exibirServicos.append(servico.getNome());
            exibirServicos.append("\n");
            
        }
        return exibirServicos;
    }
    
    public StringBuilder exibirProdutos(){
        StringBuilder exibirProdutos = new StringBuilder("\n-----| Produtos |------\n");
        for (Produto produto : produtos) {
            exibirProdutos.append(produtos.indexOf(produto) + 1);
            exibirProdutos.append(" - ");
            exibirProdutos.append(produto.getNome());
            exibirProdutos.append("\n");
            
        }
        return exibirProdutos;
    }
}