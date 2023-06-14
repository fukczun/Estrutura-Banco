package projetoMikas2;

public class Pessoa {
	protected String nome;
	private String cpf;
	private String senha;
	
	public Pessoa(String nome, String cpf, String senha) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.senha = senha;
	}
	
	public String getCpf() {
		return cpf;
	}
	
	public String getCpfMascarado() {
		String cpfMascara = cpf.substring(0, 3);
        cpfMascara = cpfMascara + ".***.***-**";
        return cpfMascara;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
}
