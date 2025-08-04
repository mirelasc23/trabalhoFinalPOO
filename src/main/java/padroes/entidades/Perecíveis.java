package padroes.entidades;

import java.util.Date;

public interface Perecíveis {
    boolean estaVencido();
    void atualizarValidade(Date validade);
    public String mostraValidade();
    
}

