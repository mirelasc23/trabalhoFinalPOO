package mirela.ifsc.first.SegundoSemestre.POO.trabalhoFinal.alt2.aplicacao;

import mirela.ifsc.first.SegundoSemestre.POO.trabalhoFinal.alt2.entidades.Agendamento;
import mirela.ifsc.first.SegundoSemestre.POO.trabalhoFinal.alt2.entidades.Brinquedo;
import mirela.ifsc.first.SegundoSemestre.POO.trabalhoFinal.alt2.entidades.Estoque;
import mirela.ifsc.first.SegundoSemestre.POO.trabalhoFinal.alt2.entidades.Medicamento;
import mirela.ifsc.first.SegundoSemestre.POO.trabalhoFinal.alt2.entidades.Produto;
import mirela.ifsc.first.SegundoSemestre.POO.trabalhoFinal.alt2.entidades.Racao;
import mirela.ifsc.first.SegundoSemestre.POO.trabalhoFinal.alt2.entidades.Servico;
import mirela.ifsc.first.SegundoSemestre.POO.trabalhoFinal.alt2.entidades.Venda;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class PetShop {
	private static Produto medicamento = null;
	private static Produto racao = null;
	private static Produto brinquedo = null;
	private static Servico banho = null;
	private static Servico tosa = null;
	private static Servico consulta = null;

	public static List<Venda> listaVenda = new ArrayList<>();
	static Venda maiorVenda = new Venda(0);
    static Venda menorVenda = new Venda(00);
    
	static Scanner ler = new Scanner(System.in);
	static double somaTotal = 0.0d, qtdeVenda = 0.0d;
    static int comando;
    
	
	public static void main(String[] args) throws ParseException {
		Date validade;

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat sdh = new SimpleDateFormat("HH:mm");

        //LISTAS
        List<Produto> listaProduto = new ArrayList<>();
        List<Servico> listaServico = new ArrayList<>();
        List<Agendamento> listaAgendamento = new ArrayList<>();

        //VENDAS
        Venda v1 = new Venda(1);
        Venda v2 = new Venda(2);
        Venda v3 = new Venda(3);
        
        //PRODUTOS
        brinquedo = new Brinquedo("Bola de Borracha", 30.0, 5);
        listaProduto.add(brinquedo);
        racao = new Racao("Ração Premium", 50.0,5);
        listaProduto.add(racao);
        medicamento = new Medicamento("Vermífugo", 25.0, 3);
        listaProduto.add(medicamento);
        
        //SERVICOS
        tosa = new Servico("Tosa", 30.0);
        listaServico.add(tosa);
        banho = new Servico("Banho", 50.0);
        listaServico.add(banho);
        consulta = new Servico("Consulta", 100.0);
        listaServico.add(consulta);

        //ESTOQUE
        Estoque estoqueBrinquedo = new Estoque(brinquedo);
        Estoque estoqueRacao = new Estoque(racao);
        Estoque estoqueMedicamento = new Estoque(medicamento);

        Agendamento a1 = new Agendamento(banho, sdf.parse("07/02/2025"), sdh.parse("16:00"));
        listaAgendamento.add(a1);
        Agendamento a2 = new Agendamento(consulta, sdf.parse("07/03/2025"), sdh.parse("16:30"));
        listaAgendamento.add(a2);
        Agendamento a3 = new Agendamento(consulta, sdf.parse("15/02/2025"), sdh.parse("16:00"));
        listaAgendamento.add(a3);
        
        System.out.println("Atualizar Vencimento:");
        try {
            System.out.println("Vencimento da Ração: [dd/mm/aaaa]");
            validade = sdf.parse(ler.next());
            racao.atualizarValidade(validade);
            
            Date hoje = new Date();
            if(validade.before(hoje)){
            	System.out.println("Produto Vencido!");
            }
            
            System.out.println("Vencimento do Medicamento: [dd/mm/aaaa]");
            validade = sdf.parse(ler.next());
            medicamento.atualizarValidade(validade);

            if(validade.before(hoje)){
                System.out.println("Produto Vencido!");
            }
            
        } catch (ParseException e) {
            System.out.println("Formato de Data Inválida");
        }catch (RuntimeException e){
            System.out.println("Data Inválida!");
        }

        System.out.println("\nVenda 1:");
        v1.adicionarProduto(racao, 3, estoqueRacao);
        v1.adicionarServico(consulta, 1);
        System.out.println(v1.getValor());
        listaVenda.add(v1);

        System.out.println("\nVenda 2:");
        v2.adicionarProduto(medicamento, 4, estoqueMedicamento);
        v2.adicionarServico(tosa, 1);
        v2.adicionarServico(banho, 1);
        System.out.println(v2.getValor());
        listaVenda.add(v2);

        System.out.println("\nVenda 3:");
        v3.adicionarProduto(brinquedo, 10, estoqueBrinquedo);
        v3.adicionarProduto(racao, 2, estoqueRacao);
        v3.adicionarServico(banho, 1);
        v3.adicionarServico(tosa, 1);
        System.out.println(v3.getValor());
        listaVenda.add(v3);

        do {
			Menu();
			
			switch (comando) {
			case 0:
				break;
				
			case 1:
				System.out.println("\nLista de Produtos:");
		        System.out.println(listaProduto);
		        
				break;
				
			case 2:
				System.out.println("\nLista de Serviços:");
		        System.out.println(listaServico);
		        
				break;
				
			case 3:
				System.out.println("\nLista de Agemdamentos:");
		        System.out.println(listaAgendamento);
		        
				break;
				
			case 4:
		        System.out.println("\nLista de Vendas:");
		        System.out.println(listaVenda);
		        
				break;

			case 5:
				System.out.println("\nTotal em Estoque:");
		        System.out.println(brinquedo.getNome() + ": " + estoqueBrinquedo.mostrarEstoque() + " itens.");
		        System.out.println(racao.getNome() + ": " + estoqueRacao.mostrarEstoque() + " itens.");
		        System.out.println(medicamento.getNome() + ": " + estoqueMedicamento.mostrarEstoque() + " itens.");

		        break;
		    
			case 6:
		        System.out.println("\nLista de Produtos com Desconto:");
		        System.out.println("Produto: " + medicamento.getNome() + " | Preço com desconto: " + medicamento.calcularDesconto());
		        System.out.println("Produto: " + racao.getNome() + " | Preço com desconto: " + racao.calcularDesconto());
		        System.out.println("Produto: " + brinquedo.getNome() + " | Preço promocional [80% | qtde >= 3 itens]: " + brinquedo.aplicarPromocao(3));

				break;
				
			case 7:
		        System.out.print("\nMaior Venda:");
		        System.out.println(maiorVenda());

		        System.out.print("\nMenor Venda:");
		        System.out.println(menorVenda());

		        System.out.println("\nMédia de Vendas:");
		        System.out.println("R$ " + mediaVenda());
		        
				break;
				
			case 8:
				System.out.print("\nProduto Mais Vendido: " + encontrarProdutoMaisVendido(listaVenda, listaProduto));				
				System.out.println("\nServiço Menos Vendido: " + encontrarServicoMenosVendido(listaVenda, listaServico));
				
				break;
				
			case 9:
		        System.out.println("Atualizar Vencimento:");
		        try {
		            System.out.println("Vencimento da Ração: [dd/mm/aaaa]");
		            validade = sdf.parse(ler.next());
		            racao.atualizarValidade(validade);
		            Date hoje = new Date();
		            if(validade.before(hoje)){
		            	System.out.println("Produto Vencido!");
		            }
		            System.out.println("Vencimento do Medicamento: [dd/mm/aaaa]");
		            validade = sdf.parse(ler.next());
		            medicamento.atualizarValidade(validade);
		            if(validade.before(hoje)){
		            	System.out.println("Produto Vencido!");
		            }

		        } catch (ParseException e) {
		            System.out.println("Formato de Data Inválida");
		        }catch (RuntimeException e){
		            System.out.println("Data Inválida!");
		        }

		        break;
			
			case 10:
				System.out.println("Escolha o produto que será adicionado:");
				System.out.println("\n");
			default:
				System.out.println("Comando não encontrado. Digite-o novamente.");
				break;
			}
			
		} while (comando != 0);
        

        
        System.out.println("\nTotal em Estoque:");
        System.out.println(brinquedo.getNome() + ": " + estoqueBrinquedo.mostrarEstoque() + " itens.");
        System.out.println(racao.getNome() + ": " + estoqueRacao.mostrarEstoque() + " itens.");
        System.out.println(medicamento.getNome() + ": " + estoqueMedicamento.mostrarEstoque() + " itens.");

        estoqueBrinquedo.adicionarProduto(4);
        estoqueMedicamento.adicionarProduto(3);
        estoqueRacao.removerProduto(2);

        System.out.println("\nTotal em Estoque:");
        System.out.println(brinquedo.getNome() + ": " + estoqueBrinquedo.mostrarEstoque() + " itens.");
        System.out.println(racao.getNome() + ": " + estoqueRacao.mostrarEstoque() + " itens.");
        System.out.println(medicamento.getNome() + ": " + estoqueMedicamento.mostrarEstoque() + " itens.");

        estoqueMedicamento.removerProduto(4);
        
        
        ler.close();
        System.out.println("\nPrograma finalizado.");
	}
	
	public static int Menu() {
		System.out.println("\nMenu:"
				+ "\n 0- Sair"
				+ "\n 1- Lista de Produtos"
				+ "\n 2- Lista de Serviços"
				+ "\n 3- Lista de Agendamentos"				
				+ "\n 4- Lista de Vendas"
				+ "\n 5- Ver Estoque"
				+ "\n 6- Lista de Produtos com Descontos"
				+ "\n 7- Ver Estatísticas Venda"
				+ "\n 8- Ver Estatísticas Produto/Serviço"
				+ "\n 9- Atualizar Validade"
				+ "\n 10- Adicionar Produto em Estoque"
				+ "\n 11- Remover Produto em Estoque");
		System.out.println("\nInforme sua escolha: ");
		comando = ler.nextInt();
		
		return comando;
	}

	public static Venda maiorVenda() {
		for(Venda venda: listaVenda) {
        	if(venda.getValor() > maiorVenda.getValor())
        		maiorVenda = venda;
        } 
		return maiorVenda;
	}
	
	public static Venda menorVenda() {
        menorVenda.adicionarProduto(medicamento, Integer.MAX_VALUE);
        menorVenda.adicionarProduto(racao, Integer.MAX_VALUE);
        menorVenda.adicionarProduto(brinquedo, Integer.MAX_VALUE);
        menorVenda.adicionarServico(banho, Integer.MAX_VALUE);
        menorVenda.adicionarServico(tosa, Integer.MAX_VALUE);
        menorVenda.adicionarServico(consulta, Integer.MAX_VALUE);

		for(Venda venda: listaVenda) {
        	if(venda.getValor() < menorVenda.getValor())
        		menorVenda = venda;
        }
		return menorVenda;
	}
	
	public static double mediaVenda() {
		for(Venda venda: listaVenda) {
        	somaTotal += venda.getValor();
        	qtdeVenda++;
        }
		return somaTotal/qtdeVenda;
	}
	
	public static String encontrarServicoMenosVendido(List<Venda> listaVenda, List<Servico> listaServico) {
		Servico servicoMenosVendido = null;
		int menorQuantidade = Integer.MAX_VALUE;

		for (Servico servico : listaServico) {
			int quantidadeTotal = 0;
			for (Venda venda : listaVenda) {
				quantidadeTotal += venda.getQuantidadeServico(servico);;
			}
			if (quantidadeTotal < menorQuantidade) {
				menorQuantidade = quantidadeTotal;
				servicoMenosVendido = servico;
			}
		}
		return servicoMenosVendido.getNome() + ": " + menorQuantidade+ " itens vendidos.";
	}

	public static String encontrarProdutoMaisVendido(List<Venda> listaVenda, List<Produto> listaProduto) {
		Produto produtoMaisVendido = null;
		int maiorQuantidade = 0;

		for (Produto produto : listaProduto) {
			int quantidadeTotal = 0;
			for (Venda venda : listaVenda) {
				quantidadeTotal += venda.getQuantidadeProduto(produto);
			}
			if (quantidadeTotal > maiorQuantidade) {
				maiorQuantidade = quantidadeTotal;
				produtoMaisVendido = produto;
			}
		}
		return produtoMaisVendido.getNome() + ": " + maiorQuantidade + " itens vendidos.\n";
	}
}
