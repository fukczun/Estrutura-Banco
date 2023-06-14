package projetoMikas2;
import java.util.ArrayList;
import java.util.Random;

public class Chefe extends Pessoa {
	private double renda;
	private int nivel;
	private ArrayList<Desempenho> desempenhoFuncionarios = new ArrayList<>();;
	private ArrayList<Desempenho> desempenhoGerentes = new ArrayList<>();
	private Id id;
	private String cnpj; 
	
	public Chefe(String nome, String cpf, String senha, double renda, String cnpj) {
		super(nome, cpf, senha);
		this.renda = renda;
		nivel = 3;
		id = new Id(null);
		this.cnpj = cnpj;
	}
	
	public void addDesempenhoFuncionario(Desempenho desempenho) {
		if (nivel > (desempenho.getNivel() + 1)) {
			desempenhoFuncionarios.add(desempenho);
		}else {
			System.out.println("𝐍𝐚𝐨 𝐞́ 𝐮𝐦 𝐟𝐮𝐧𝐜𝐢𝐨𝐧𝐚́𝐫𝐢𝐨 𝐜𝐨𝐦𝐮𝐦!");
		}
	}
	
	public void removeDesempenhoFuncionario(Desempenho desempenho) {
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
	
	public void addDesempenhoGerente(Desempenho desempenho) {
		if (nivel == (desempenho.getNivel() + 1)) {
			desempenhoGerentes.add(desempenho);
		}else {
			System.out.println("𝐍𝐚𝐨 𝐞́ 𝐮𝐦 𝐠𝐞𝐫𝐞𝐧𝐭𝐞!");  //?
		}
	}
	
	public void removeDesempenhoGerente(Desempenho desempenho) {
		if (desempenhoGerentes.contains(desempenho)) {
			desempenhoGerentes.remove(desempenho);
		}else {
			System.out.println("𝐆𝐞𝐫𝐞𝐧𝐭𝐞 𝐧𝐚𝐨 𝐜𝐚𝐝𝐚𝐬𝐭𝐫𝐚𝐝𝐨!");
		}
	}
	
	public boolean setDesempenhoGerentes(String nome, int rendimento) {
		for (Desempenho desempenho: desempenhoGerentes) {
			if (desempenho.getNome().equalsIgnoreCase(nome)) {
				desempenho.setRendimento(rendimento, desempenho.getNivel());
				return true; // Jeito para não aparecer msg de em todos os casos
			}
		}
		System.out.println("𝐅𝐮𝐧𝐜𝐢𝐨𝐧𝐚𝐫𝐢𝐨 𝐧𝐚𝐨 𝐜𝐚𝐝𝐚𝐬𝐭𝐫𝐚𝐝𝐨!");
		return false;
	}

	public ArrayList<Desempenho> getDesempenhoGerentes() {
		return desempenhoGerentes;
	}
	
	public double getRenda() {
		return renda;
	}

	public void setRenda(double renda) {
		this.renda = renda;
	}

	public int getNivel() {
		return nivel;
	}
	
	public Id getId() {
		return id;
	}
	
	public void gerarTela() {
		System.out.println("𝟏- 𝐕𝐞𝐫 𝐝𝐞𝐬𝐞𝐦𝐩𝐞𝐧𝐡𝐨 𝐝𝐨𝐬 𝐟𝐮𝐧𝐜𝐢𝐨𝐧𝐚́𝐫𝐢𝐨𝐬 \n"
				+ "𝟐- 𝐕𝐞𝐫 𝐝𝐞𝐬𝐞𝐦𝐩𝐞𝐧𝐡𝐨 𝐝𝐨𝐬 𝐠𝐞𝐫𝐞𝐧𝐭𝐞𝐬 \n"
				+ "𝟑- 𝐆𝐞𝐫𝐚𝐫 𝐢𝐝 𝐩𝐚𝐫𝐚 𝐚 𝐠𝐞𝐫𝐚𝐜𝐚𝐨 𝐝𝐞 𝐮𝐬𝐮𝐚́𝐫𝐢𝐨𝐬 \n"
				+ "𝟒- 𝐌𝐨𝐬𝐭𝐫𝐚𝐫 𝐮́𝐥𝐭𝐢𝐦𝐨 𝐢𝐝 𝐠𝐞𝐫𝐚𝐝𝐨 \n"
				+ "𝟓- 𝐀𝐥𝐭𝐞𝐫𝐚𝐫 𝐫𝐞𝐧𝐝𝐢𝐦𝐞𝐧𝐭𝐨 𝐝𝐞 𝐟𝐮𝐧𝐜𝐢𝐨𝐧𝐚𝐫𝐢𝐨 \n"
				+ "𝟔- 𝐀𝐥𝐭𝐞𝐫𝐚𝐫 𝐫𝐞𝐧𝐝𝐢𝐦𝐞𝐧𝐭𝐨 𝐝𝐞 𝐠𝐞𝐫𝐞𝐧𝐭𝐞 \n"
				+ "𝟕- 𝐃𝐞𝐦𝐢𝐭𝐢𝐫 𝐟𝐮𝐧𝐜𝐢𝐨𝐧𝐚𝐫𝐢𝐨 \n"
				+ "𝟖- 𝐃𝐞𝐦𝐢𝐭𝐢𝐫 𝐠𝐞𝐫𝐞𝐧𝐭𝐞 \n"
				+ "𝟗－ 𝐒𝐚𝐢𝐫 𝐝𝐚 𝐜𝐨𝐧𝐭𝐚");
		// 69- Explode
	}
	
	public void demitirEmpregados() {
		if (desempenhoFuncionarios.size() != 0) {
			for (int i=desempenhoFuncionarios.size()-1; i>=0; i--) {
				desempenhoFuncionarios.remove(i);
			}
		}
		
		if (desempenhoGerentes.size() != 0) {
			for (int i=desempenhoGerentes.size()-1; i>=0; i--) {
				desempenhoGerentes.remove(i);
			}
		}
	}

	public String getCnpj() {
		return cnpj;
	}
	
	public String getCnpjMascarado() {
		String cnpjMascara = cnpj.substring(0, 3);
		cnpjMascara = cnpjMascara + ".***.***/****-**";
        return cnpjMascara;
	}

}
