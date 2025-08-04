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
        Produto medicaento = new Produto("medimento", 10, 2);
    }

    private void iniciaServicos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
