package br.com.db1.db1start.aula13;

public class Cliente {
	
	private String nome;
	
	private String cpf; 
 
public Cliente(String nome, String cpf) { 
	
	Checker.notNull(nome, "nome");
	Checker.notNull(cpf,"cpf");
	
if(nome == null) {
	
	throw new RuntimeException("Nome é Obrigatório");
}
	 
if(nome.length() <5) {
	throw new RuntimeException("Nome deve ser maior igual a 5");
}


if(cpf == null) {
	
	throw new RuntimeException("CPF é Obrigatório");
}
	
if(cpf.length() != 11) {
	throw new RuntimeException("CPF Invalido");
}



	
	this.nome = nome;
	this.cpf = cpf;
}
 
public String getNome() {
	
	return this.nome;
	
}

public String getCpf(){
	
	return this.cpf;
}

}
