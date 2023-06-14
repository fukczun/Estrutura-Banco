package projetoMikas2;

public class Cliente extends Pessoa {
	private double saldo;

	public Cliente(String nome, String cpf, String senha, double saldo) {
		super(nome, cpf, senha);
		this.saldo = saldo;
	}
	
	public void depositar(double deposito) {
		saldo += deposito;
	}
	public boolean sacar(double saque) {
		if (saque>saldo) {
			return false;
		}
		saldo -= saque;
		return true;
	}
	public double verSaldo() {
		return saldo;
	}
	
	public void gerarTela() {
		System.out.println("𝟏- 𝐃𝐞𝐩𝐨𝐬𝐢𝐭𝐚𝐫 \n"
				+ "𝟐- 𝐒𝐚𝐜𝐚𝐫 \n"
				+ "𝟑- 𝐒𝐚𝐢𝐫 𝐝𝐚 𝐜𝐨𝐧𝐭𝐚");
	}
}
