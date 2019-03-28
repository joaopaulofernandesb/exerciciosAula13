package br.com.db1.db1start.aula13;

import java.util.ArrayList;
import java.util.List;

public class ContaBancaria {

	private String numero;
	private String agencia;
	private Double saldo = 0.0;

	private ContaBancariaTipo tipo = ContaBancariaTipo.CORRENTE;
	private List<ContaBancariaHistorico> historicos   = new ArrayList<>();
	private Cliente  cliente ;
	
	//construtor
	public ContaBancaria(String numero, String agencia, Double saldo, ContaBancariaTipo tipo, Cliente cliente) {
		
		this.numero = numero;
		this.agencia = agencia;
		this.saldo = saldo; 
		this.tipo = tipo;
		this.cliente = cliente;
	}
	
	
	//metodos
	 
	//verifica se te, saldo para saque 
	public void sacar(Double valor) {
		
		if(valor >= saldo) {
			throw new RuntimeException("Você não possui saldo sufuciente"+ saldo);

			}else if(valor <= 0) {
		
		throw new RuntimeException("Operação Não Realizada");
	}
		
		this.saldo = this.saldo - valor;
		
		ContaBancariaHistorico historico = new ContaBancariaHistorico(ContaBancariatipoOperacao.SAIDA,valor);
		 
		this.historicos.add(historico);
		
		
	} 
	
	
	//Depositar
		public  void depositar(Double valor) {
			
			if(valor <= 0) {
				throw new RuntimeException("Valor Não Permitido para Depósito ");
			}
			
			this.saldo = this.saldo += valor;
			
			
			 
			this.novoHistorico(ContaBancariatipoOperacao.ENTRADA,valor);
			
			
		}
		
		
		private void novoHistorico(ContaBancariatipoOperacao tipo, Double valor) {
			
			ContaBancariaHistorico historico = new ContaBancariaHistorico(ContaBancariatipoOperacao.ENTRADA,valor);
			 
			this.historicos.add(historico);
			 
		}
		
		
		//TRANSFERE meu metodo
		
		public  Double transferenciaSaida(Double valor){
			
			if(valor > saldo) {
				throw new RuntimeException("Você não possui saldo sufuciente para esta  operação" + saldo);
			}else if(valor <= 0) {
				
				throw new RuntimeException("Operação Não Realizada");
			}
			
			this.saldo = this.saldo - valor;
			
			this.transferenciaSaida(ContaBancariatipoOperacao.SAIDA,valor);
			
			return saldo;
			
		} 
		
		public void transferenciaSaida(ContaBancariatipoOperacao tipo, Double valor) {
			
			ContaBancariaHistorico historico = new ContaBancariaHistorico(ContaBancariatipoOperacao.SAIDA,valor);
			
			this.historicos.add(historico);
			
		}
		
		
		
		public void transferenciaEntrada(Double valor) {
			
			if(valor <= 0) {
				throw new RuntimeException("Transferencia Não Pode Ser Recebida");
			}
			
			this.saldo = this.saldo += valor;  
			this.transferenciaEn(ContaBancariatipoOperacao.ENTRADA,valor);
			
		}
		
		public void transferenciaEn(ContaBancariatipoOperacao tipo, Double valor) {
			
			ContaBancariaHistorico historico = new ContaBancariaHistorico(ContaBancariatipoOperacao.ENTRADA,valor);
			
			this.historicos.add(historico);
			
		}
		
		
		
		
		public void transferencia(Double valor, ContaBancaria contaAlvo) {
			
			if(valor <=0) {
				
				throw new RuntimeException("Operação Não Realizada");
			}
			
			if(contaAlvo == null) {
				
				throw new RuntimeException("Conta do destinatário é obrigatorio");
			}
			
			this.sacar(valor);
			contaAlvo.depositar(valor);
			
			
		}
		
	
	public Double getSaldo() {
		
		return this.saldo;
	}
	
	
	
	public List<ContaBancariaHistorico>getHistorico(){
		return this.historicos;
	}


	
	
	
	
	
	
	

}
