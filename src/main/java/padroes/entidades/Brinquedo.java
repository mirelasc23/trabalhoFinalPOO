package padroes.entidades;

public class Brinquedo extends Produto{
    public Brinquedo(String nome, double preco, int quantidade) {
        super(nome, preco, quantidade);
    }
    
    
    @Override
    public double aplicarPromocao(int quantidade){
        if(quantidade >= 3)
            return getPreco() * quantidade* 0.8;
        else
            return getPreco() * quantidade;
    }

}
