package br.com.db1.db1start.aula13;

public enum ContaBancariaTipo {
	
	POUPANCA ("0013"), CORRENTE ("0001");

		private String numero;
	
		private ContaBancariaTipo(String numero) {
		this.numero = numero;
	}
		
		public String getNumero() {
			return this.numero;
		} 
		
		
}
