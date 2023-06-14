package projetoMikas2;

import java.util.Random;

public class Id {
	private String id;
	private boolean usado;
	
	public Id(String id) {
		super();
		this.id = id;
		usado = false;
	}
	
	public String gerarId(int tipoConta) {
		Random gerador = new Random();
		
		zerarUso();
		id = gerador.nextInt(10) + "" + gerador.nextInt(10) + "" + gerador.nextInt(10) + "" + tipoConta;
		return id;
	}
	
	public String getId() {
		return id;
	}
	
	public void zerarUso() {
		if (id != null) {
			usado = false;
		}
	}
	
	public void usarId() {
		usado = true;
	}
	
	public boolean isUsado() {
		return usado;
	}
}
