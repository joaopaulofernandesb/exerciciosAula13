package br.com.db1.db1start.aula13.test;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;

import br.com.db1.db1start.aula13.App;
import br.com.db1.db1start.aula13.Cliente;
import br.com.db1.db1start.aula13.ContaBancaria;
import br.com.db1.db1start.aula13.ContaBancariaTipo;


public class ContaBancariaTest {
	
	private ContaBancaria conta;
	private ContaBancaria contaNova;
	
	
	@Before
	public void init() {
		Cliente cliente = new Cliente("Maiko Cunha", "99999999999");
		conta = new ContaBancaria(
						"1234", 
						"0004", 
						1000.00, ContaBancariaTipo.CORRENTE, 
						cliente);
	}
	
	
	@Before
	public void init2() {
		Cliente cliente = new Cliente("João Paulo", "05041799167");
		contaNova = new ContaBancaria(
						"12345", 
						"0004", 
						2000.00, ContaBancariaTipo.CORRENTE, 
						cliente);
	}
	
	

	
	@Test//(expected=RuntimeException.class)
	public void deveReceberATransferencia() {
		
	
	double transferencia = conta.transferenciaSaida(500.0); // Transfere para ContaNova = //Cliente ("João Paulo", "05041799167");
	
	
	contaNova.transferenciaEntrada(transferencia); // Receboa a Transferencia de //Cliente ("Maiko Cunha", "99999999999");
	
	contaNova.depositar(50.00);//Deposito Mais Valor 
	//contaNova.depositar(-500.0); // tento depositar um valor menor que 0
	//contaNova.sacar(20.0); // Sacar 
	//contaNova.sacar(-500.0);// tento fazer um saque menor que 0
	
	Assert.assertEquals(2550.00,contaNova.getSaldo(),0);
	Assert.assertEquals(2, contaNova.getHistorico().size());
	
	
	
	conta.sacar(20.0); // Saque do Cliente ("Maiko Cunha", "99999999999");
	
	
	Assert.assertEquals(480.00,conta.getSaldo(),0);
	Assert.assertEquals(2, conta.getHistorico().size());
	
	
	}

	
	
	
	
	
	//metodo do professor 
	@Test
	public void deveTransferirValorDeUmaContaParaOutra() {
		
		conta.transferencia(500.00,contaNova);
		
		Assert.assertEquals(500.0,conta.getSaldo(),0);
		Assert.assertEquals(2500.0,contaNova.getSaldo(),0);
		
	}
	


//	@Test
//	public void deveSacarDinheiroDaConta() {
//		conta.sacar(500.0);
//		Assert.assertEquals(500.0, conta.getSaldo(), 0);
//		Assert.assertEquals(1, conta.getHistorico().size());
//	}
	
//	
//	
//	@Test(expected=RuntimeException.class)
//	public void deveDepositarValor() {
//		conta.depositar(0.0);
//	Assert.assertEquals(500.0, conta.getSaldo(),0);
//		Assert.assertEquals(1, conta.getHistorico().size());
//	}
//	
//	
//	
//	@Test(expected=RuntimeException.class)
//	public void deveDepositarValorIgualaZero() {
//		conta.depisitar(00.0);
//		
//	}
//	
//	@Test(expected=RuntimeException.class)
//	public void deveDepositarValorMenorQueZero() {
//		conta.depisitar(-500.0);
//		
//	}
	
//	@ Teste {
//	    public static void main(String[] args) {
//	        Conta minhaConta = new Conta();
//	        minhaConta.titular.nome = "Bruno";
//
//	        Conta contaJose= new Conta();
//	        minhaConta.titular.nome = "José Antônio";
//
//	    minhaConta.transfere(contaJose, 55.75); // Sempre cuidado com a ordem dos parâmetros, se pedi primeiro Conta e depois double, tenho que passar assim pro método
//	    }
	
	
	
		
	}
	
	
	
	
	
