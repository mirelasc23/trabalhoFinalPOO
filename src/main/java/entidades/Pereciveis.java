package entidades;

import java.util.Date;

public interface Pereciveis {
    boolean estaVencido();
    void atualizarValidade(Date validade);
    public String mostraValidade();
    
}