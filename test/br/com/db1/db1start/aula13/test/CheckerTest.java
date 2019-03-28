package br.com.db1.db1start.aula13.test;

import org.junit.Test;
import org.junit.Assert;
import br.com.db1.db1start.aula13.Checker;


public class CheckerTest {
	
	

	@Test
	public void naoDeveRetornarErroQuandoValorNaoNumero() {
		
		Checker.notNull("Valor", "nome");
		
	}
	
	@Test (expected = RuntimeException.class)
	public void deveRetornarCampoObrigatorio() {
		
		Checker.notNull(null, "nome");
		
		
	}
	
	@Test
	public void deveRetornarMensagemObrigatoria() {
		try {
			Checker.notNull(null, "nome");
		}catch (RuntimeException ex) {
			Assert.assertEquals("Campo obrigatório.", ex.getMessage());
			
		}
		
		
	}
}
