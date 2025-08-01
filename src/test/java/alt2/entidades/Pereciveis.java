package mirela.ifsc.first.SegundoSemestre.POO.trabalhoFinal.alt2.entidades;

import java.util.Date;

public interface Pereciveis {
    boolean estaVencido();
    void atualizarValidade(Date validade);
    public String mostraValidade();
    
}