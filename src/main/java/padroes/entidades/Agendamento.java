package padroes.entidades;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Agendamento {
    private Servico servico;
    private Date agendamento;
    private Date hora;
    
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    SimpleDateFormat sdh = new SimpleDateFormat("HH:mm");
        

    public Agendamento(Servico servico, Date agendamento, Date hora) {
        this.servico = servico;
        this.agendamento = agendamento;
        this.hora = hora;
    }

    public Servico getServico() {
        return servico;
    }

    public Date getAgendamento() {
        return agendamento;
    }
    
    public Date getHora() {
    	return hora;
    }

    @Override
    public String toString() {
        return "\nDia: " + sdf.format(agendamento) + ", " + sdh.format(hora)+ ": " + servico.getNome() ;
    }    
}
