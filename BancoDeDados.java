package projetoMikas2;
import java.util.ArrayList;

public class BancoDeDados {
	private ArrayList<Cliente> clientes = new ArrayList<>();
	private ArrayList<Funcionario> funcionarios = new ArrayList<>();
	private ArrayList<Gerente> gerentes = new ArrayList<>();
	private Chefe chefe;
	
	public BancoDeDados(Chefe chefe) {
		this.chefe = chefe;
	}
	
	public void addCliente(Cliente cliente) {
		clientes.add(cliente);
	}
	
	public void removeCliente(Cliente cliente) {
		if (clientes.contains(cliente)) {
			clientes.remove(cliente);
		}else {
			System.out.println("𝐂𝐥𝐢𝐞𝐧𝐭𝐞 𝐧𝐚𝐨 𝐜𝐚𝐝𝐚𝐬𝐭𝐫𝐚𝐝𝐨!");
		}
	}
	
	public ArrayList<Cliente> getClientes() {
		return clientes;
	}
	
	public void addFuncionario(Funcionario funcionario) {
		funcionarios.add(funcionario);
	}
	
	public void removeFuncionario(Funcionario funcionario) {
		if (funcionarios.contains(funcionario)) {
			funcionarios.remove(funcionario);
		}else {
			System.out.println("𝐅𝐮𝐧𝐜𝐢𝐨𝐧𝐚𝐫𝐢𝐨 𝐧𝐚𝐨 𝐜𝐚𝐝𝐚𝐬𝐭𝐫𝐚𝐝𝐨!");
		}
	}
	
	public ArrayList<Funcionario> getFuncionarios() {
		return funcionarios;
	}
	
	public void addGerente(Gerente gerente) {
		gerentes.add(gerente);
	}
	
	public void removeGerente(Gerente gerente) {
		if (gerentes.contains(gerente)) {
			gerentes.remove(gerente);
		}else {
			System.out.println("𝐅𝐮𝐧𝐜𝐢𝐨𝐧𝐚𝐫𝐢𝐨 𝐧𝐚𝐨 𝐜𝐚𝐝𝐚𝐬𝐭𝐫𝐚𝐝𝐨!");
		}
	}
	
	public ArrayList<Gerente> getGerentes() {
		return gerentes;
	}
	
	public int tipoConta(String nome, String senha) {
		for (int i=0; i<clientes.size(); i++) {
			if (clientes.get(i).nome.equals(nome)) {
				if (clientes.get(i).getSenha().equals(senha)) {
					return 0;
				}
			}
		}
		
		for (int i=0; i<funcionarios.size(); i++) {
			if (funcionarios.get(i).nome.equals(nome)) {
				if (funcionarios.get(i).getSenha().equals(senha)) {
					return 1;
				}
			}
		}
		
		for (int i=0; i<gerentes.size(); i++) {
			if (gerentes.get(i).nome.equals(nome)) {
				if (gerentes.get(i).getSenha().equals(senha)) {
					return 2;
				}
			}
		}
		
		if (chefe.nome.equals(nome)) {
			if (chefe.getSenha().equals(senha)) {
				return 3;
			}
		}
		return -1;
	}
	
	public Cliente getCliente(String nome, String senha) {
		for (Cliente cliente: clientes) {
			if (cliente.nome.equals(nome)) {
				if (cliente.getSenha().equals(senha)) {
					return cliente;
				}
			}
		}
		return null;
	}
	
	public Funcionario getFuncionario(String nome, String senha) {
		for (Funcionario funcionario: funcionarios) {
			if (funcionario.nome.equals(nome)) {
				if (funcionario.getSenha().equals(senha)) {
					return funcionario;
				}
			}
		}
		return null;
	}
	
	public Funcionario getFuncionario(String nome) {
		for (Funcionario funcionario: funcionarios) {
			if (funcionario.nome.equals(nome)) {
				return funcionario;
			}
		}
		return null;
	}
	
	public Funcionario getFuncionario(int index) {
		return funcionarios.get(index);
	}
	
	public Gerente getGerente(String nome, String senha) {
		for (Gerente gerente: gerentes) {
			if (gerente.nome.equals(nome)) {
				if (gerente.getSenha().equals(senha)) {
					return gerente;
				}
			}
		}
		return null;
	}
	
	public Gerente getGerente(String nome) {
		for (Gerente gerente: gerentes) {
			if (gerente.nome.equals(nome)) {
				return gerente;
			}
		}
		return null;
	}
	
	public Gerente getGerente(int index) {
		return gerentes.get(index);
	}
	
	public boolean validarCpf(String cpf) {
		if (cpf.length() < 3) {
			return false;
		}
		
		for (Cliente cliente: clientes) {
			if (cliente.getCpf().equals(cpf)) {
				return false;
			}
		}
		
		for (Funcionario funcionario: funcionarios) {
			if (funcionario.getCpf().equals(cpf)) {
				return false;
			}
		}
		
		for (Gerente gerente: gerentes) {
			if (gerente.getCpf().equals(cpf)) {
				return false;
			}
		}
		
		if (chefe.getCpf().equals(cpf)) {
			return false;
		}
		
		return true;
	}
	
	public void explodirEmpresa() {
		if (clientes.size() != 0) {
			for (int i=clientes.size()-1; i>=0; i--) {
				clientes.remove(i);
			}
		}
		
		if (funcionarios.size() != 0) {
			for (int i=funcionarios.size()-1; i>=0; i--) {
				funcionarios.remove(i);
			}
		}
		
		if (gerentes.size() != 0) {
			for (int i=gerentes.size()-1; i>=0; i--) {
				gerentes.remove(i);
			}
		}
	}
	
	public void removeFuncionario(int index) {
		funcionarios.remove(index);
	}
	
	public void removeGerente(int index) {
		gerentes.remove(index);
	}
}
 