package projetoMikas2;
import java.util.ArrayList;

public class Funcionario extends Pessoa {
	protected ArrayList<String> tarefas = new ArrayList<>();;
	protected Desempenho desempenho;
	private double salario;
	protected boolean ponto;
	
	
	public Funcionario(String nome, String cpf, String senha, Desempenho desempenho, double salario) {
		super(nome, cpf, senha);
		this.desempenho = desempenho;
		this.salario = salario;
		ponto = false;
	}
	
	public void addTarefa(String tarefa) {
		tarefas.add(tarefa);
	}
	
	public boolean removeTarefa(String tarefa) {
		if (tarefas.contains(tarefa)) {
			tarefas.remove(tarefa);
			return true;
		}
		return false;
	}

	public double getSalario() {
		return salario;
	}
	
	public void gerarTela() {
		System.out.println("𝟏- 𝐕𝐞𝐫 𝐭𝐚𝐫𝐞𝐟𝐚𝐬 \n"
				+ "𝟐- 𝐀𝐝𝐢𝐜𝐢𝐨𝐧𝐚𝐫 𝐭𝐚𝐫𝐞𝐟𝐚 \n"
				+ "𝟑- 𝐑𝐞𝐦𝐨𝐯𝐞𝐫 𝐭𝐚𝐫𝐞𝐟𝐚 \n"
				+ "𝟒- 𝐁𝐚𝐭𝐞𝐫 𝐨 𝐩𝐨𝐧𝐭𝐨 \n"
				+ "𝟓- 𝐒𝐚𝐢𝐫 𝐝𝐚 𝐜𝐨𝐧𝐭𝐚");
	}
	
}
