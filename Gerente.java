package projetoMikas2;
import java.util.ArrayList;

public class Gerente extends Funcionario {
	private ArrayList<Desempenho> desempenhoFuncionarios = new ArrayList<>();

	public Gerente(String nome, String cpf, String senha, Desempenho desempenho, double salario) {
		super(nome, cpf, senha, desempenho, salario);
	}
	
	public void addDesempenho(Desempenho desempenho) {
		if (this.desempenho.getNivel() > desempenho.getNivel()) {
			desempenhoFuncionarios.add(desempenho);
		}else {
			System.out.println("𝐕𝐨𝐜𝐞 𝐧𝐚𝐨 𝐭𝐞𝐦 𝐩𝐞𝐫𝐦𝐢𝐬𝐬𝐚𝐨 𝐩𝐚𝐫𝐚 𝐢𝐬𝐬𝐨!");
		}
	}
	
	public void removeDesempenho(Desempenho desempenho) {
		if (desempenhoFuncionarios.contains(desempenho)) {
			desempenhoFuncionarios.remove(desempenho);
		}else {
			System.out.println("𝐅𝐮𝐧𝐜𝐢𝐨𝐧𝐚𝐫𝐢𝐨 𝐧𝐚𝐨 𝐜𝐚𝐝𝐚𝐬𝐭𝐫𝐚𝐝𝐨!");
		}
	}
	
	public boolean setDesempenhoFuncionario(String nome, int rendimento) {
		for (Desempenho desempenho: desempenhoFuncionarios) {
			if (desempenho.getNome().equalsIgnoreCase(nome)) {
				desempenho.setRendimento(rendimento, desempenho.getNivel());
				return true; // Jeito para não aparecer msg de em todos os casos
			}
		}
		System.out.println("𝐅𝐮𝐧𝐜𝐢𝐨𝐧𝐚𝐫𝐢𝐨 𝐧𝐚𝐨 𝐜𝐚𝐝𝐚𝐬𝐭𝐫𝐚𝐝𝐨!");
		return false;
	}

	public ArrayList<Desempenho> getDesempenhoFuncionarios() {
		return desempenhoFuncionarios;
	}
	
	@Override
	public void gerarTela() {
				System.out.println("𝟏- 𝐕𝐞𝐫 𝐭𝐚𝐫𝐞𝐟𝐚𝐬 \n"
				+ "𝟐- 𝐀𝐝𝐢𝐜𝐢𝐨𝐧𝐚𝐫 𝐭𝐚𝐫𝐞𝐟𝐚 \n"
				+ "𝟑- 𝐑𝐞𝐦𝐨𝐯𝐞𝐫 𝐭𝐚𝐫𝐞𝐟𝐚 \n"
				+ "𝟒- 𝐁𝐚𝐭𝐞𝐫 𝐨 𝐩𝐨𝐧𝐭𝐨 \n"
				+ "𝟓- 𝐕𝐞𝐫 𝐝𝐞𝐬𝐞𝐦𝐩𝐞𝐧𝐡𝐨 𝐝𝐨𝐬 𝐟𝐮𝐧𝐜𝐢𝐨𝐧𝐚́𝐫𝐢𝐨𝐬 \n"
				+ "𝟔- 𝐀𝐥𝐭𝐞𝐫𝐚𝐫 𝐫𝐞𝐧𝐝𝐢𝐦𝐞𝐧𝐭𝐨 𝐝𝐞 𝐟𝐮𝐧𝐜𝐢𝐨𝐧𝐚𝐫𝐢𝐨 \n"
				+ "𝟕- 𝐃𝐞𝐦𝐢𝐭𝐢𝐫 𝐟𝐮𝐧𝐜𝐢𝐨𝐧𝐚𝐫𝐢𝐨 \n"
				+ "𝟖－ 𝐒𝐚𝐢𝐫 𝐝𝐚 𝐜𝐨𝐧𝐭𝐚");
	}
}
