package br.com.db1.db1start.aula13;

public class App {
	
	public static void main(String[]...args) {
		 
		
		
		Cliente cliente = new Cliente("João Paulo","99999999999");
		

		ContaBancaria conta = new ContaBancaria(
				"1234",
				"0004",
				1000.0,
				ContaBancariaTipo.CORRENTE,
				cliente);
		
		
		Cliente clientePaulo = new Cliente("Paulo Silva","05041799867");

		ContaBancaria contaNova = new ContaBancaria(
				"12345",
				"0004",
				2000.0,
				ContaBancariaTipo.CORRENTE,
				clientePaulo);


		
				 
		
	}  

 
	

	

}
 