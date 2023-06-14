package projetoMikas2;

public class Desempenho {
	private String nome;
	private int rendimento;
	private int nivel;
	
	public Desempenho(String nome, int rendimento, int nivel) {
		super();
		this.nome = nome;
		this.rendimento = rendimento;
		this.nivel = nivel;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome, int nivelAlvo) {
		if (nivel > nivelAlvo) {
			this.nome = nome;
		}else {
			System.out.println("𝐕𝐨𝐜𝐞 𝐧𝐚𝐨 𝐭𝐞𝐦 𝐩𝐞𝐫𝐦𝐢𝐬𝐬𝐚𝐨 𝐩𝐚𝐫𝐚 𝐢𝐬𝐬!");
		}
	}
	public int getRendimento() {
		return rendimento;
	}
	public void setRendimento(int rendimento, int nivelSuperior) {
		if (nivelSuperior > this.nivel) {
			if (this.rendimento + rendimento > 100){
				this.rendimento = 100;
				System.out.println("𝐑𝐞𝐧𝐝𝐢𝐦𝐞𝐧𝐭𝐨 𝐦𝐚́𝐱𝐢𝐦𝐨 𝐚𝐭𝐢𝐧𝐠𝐢𝐝𝐨!");
			}else if (this.rendimento + rendimento < 0) {
				this.rendimento = 0;
				System.out.println("𝐑𝐞𝐧𝐝𝐢𝐦𝐞𝐧𝐭𝐨 𝐦𝐢́𝐧𝐢𝐦𝐨 𝐚𝐭𝐢𝐧𝐠𝐢𝐝𝐨!");
			}else {
				this.rendimento += rendimento;
				if (rendimento>0) {
					System.out.println("𝐑𝐞𝐧𝐝𝐢𝐦𝐞𝐧𝐭𝐨 𝐚𝐜𝐫𝐞𝐬𝐜𝐢𝐝𝐨 𝐞𝐦 " + rendimento + "%!");
				}else {
					System.out.println("𝐑𝐞𝐧𝐝𝐢𝐦𝐞𝐧𝐭𝐨 𝐝𝐞𝐜𝐫𝐞𝐬𝐜𝐢𝐝𝐨 𝐞𝐦 " + rendimento + "%!");
				}
			}
			
		}else {
			System.out.println("𝐕𝐨𝐜𝐞 𝐧𝐚𝐨 𝐭𝐞𝐦 𝐩𝐞𝐫𝐦𝐢𝐬𝐬𝐚𝐨 𝐩𝐚𝐫𝐚 𝐢𝐬𝐬𝐨!");
		}
	}
	public int getNivel() {
		return nivel;
	}
	
	public void gerarModificadores() {
		System.out.printf("𝐎 𝐪𝐮𝐞 %s 𝐜𝐨𝐦𝐞𝐭𝐞𝐮? \n\n"
				+ "𝟏- 𝐏𝐞𝐪𝐮𝐞𝐧𝐚 𝐢𝐧𝐟𝐫𝐚𝐜𝐚𝐨 \n"
				+ "𝟐- 𝐌𝐞́𝐝𝐢𝐚 𝐢𝐧𝐟𝐫𝐚𝐜𝐚𝐨 \n"
				+ "𝟑- 𝐆𝐫𝐚𝐧𝐝𝐞 𝐢𝐧𝐟𝐫𝐚𝐜𝐚𝐨 \n"
				+ "𝟒- 𝐏𝐞𝐪𝐮𝐞𝐧𝐚 𝐜𝐨𝐧𝐪𝐮𝐢𝐬𝐭𝐚 \n"
				+ "𝟓- 𝐌𝐞́𝐝𝐢𝐚 𝐜𝐨𝐧𝐪𝐮𝐢𝐬𝐭𝐚  \n"
				+ "𝟔- 𝐆𝐫𝐚𝐧𝐝𝐞 𝐜𝐨𝐧𝐪𝐮𝐢𝐬𝐭𝐚 \n", nome);
	}

	@Override
	public String toString() {
		return "𝐍𝐨𝐦𝐞: " + nome + "   𝐑𝐞𝐧𝐝𝐢𝐦𝐞𝐧𝐭𝐨: " + rendimento + "%";
	}
}
