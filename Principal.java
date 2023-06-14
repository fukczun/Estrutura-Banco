package projetoMikas2;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.InputMismatchException;

public class Principal {

	public static void main(String[] args) {
		Chefe chefe = new Chefe("paqueta", "123", "321", 1000000.0, "456");
		BancoDeDados bd = new BancoDeDados(chefe);
		Scanner scanTxt = new Scanner(System.in);
		Scanner scanGeral = new Scanner(System.in);
		boolean ficar = true;
		
		while (ficar) {
			limpaTela();
			System.out.println("𝙋𝙧𝙤𝘾𝙧𝙚𝙙𝙞𝙩 \n");
			System.out.print("𝐉𝐚́ 𝐭𝐞𝐦 𝐮𝐦𝐚 𝐜𝐨𝐧𝐭𝐚 (𝐂𝐚𝐬𝐨 𝐭𝐞𝐧𝐡𝐚 𝐮𝐦 𝐢𝐝 𝐝𝐢𝐠𝐢𝐭𝐞 ❜𝐧𝐚𝐨❜)? ");
			int resposta = resposta(scanTxt.nextLine());
			if (resposta == 1) {
				limpaTela();
				System.out.print("𝐍𝐨𝐦𝐞: ");
				String nome = scanTxt.nextLine();
				System.out.print("𝐒𝐞𝐧𝐡𝐚: ");
				String senha = scanTxt.nextLine();
				
				limpaTela();
				int tipoConta = bd.tipoConta(nome, senha);
				if(tipoConta >= 0) {
					switch (tipoConta) {
					case 0:
						Cliente cliente = bd.getCliente(nome, senha);
						int opcao = 0;
						while (opcao != 3) {
							System.out.printf("𝐍𝐨𝐦𝐞: %s   𝐂𝐩𝐟: %s   𝐒𝐚𝐥𝐝𝐨: 𝐑$ %.2f \n", cliente.nome, cliente.getCpfMascarado(), cliente.verSaldo());
							cliente.gerarTela();
							opcao = scanGeral.nextInt();
							limpaTela();
							
							switch(opcao) {
							case 1:
								System.out.print("𝐕𝐚𝐥𝐨𝐫 𝐚 𝐝𝐞𝐩𝐨𝐬𝐢𝐭𝐚𝐫: 𝐑$");
								cliente.depositar(scanGeral.nextDouble());
								limpaTela();
								System.out.println("𝐃𝐞𝐩𝐨𝐬𝐢𝐭𝐨 𝐜𝐨𝐧𝐜𝐥𝐮𝐢𝐝𝐨!");
								scanTxt.nextLine();
								break;
								
							case 2:
								System.out.print("𝐕𝐚𝐥𝐨𝐫 𝐚 𝐬𝐚𝐜𝐚𝐫: 𝐑$");
								if (cliente.sacar(scanGeral.nextDouble())) {
									limpaTela();
									System.out.println("𝐒𝐚𝐪𝐮𝐞 𝐜𝐨𝐧𝐜𝐥𝐮𝐢𝐝𝐨!");
								}else {
									limpaTela();
									System.out.println("𝐒𝐚𝐥𝐝𝐨 𝐢𝐧𝐬𝐮𝐟𝐢𝐜𝐢𝐞𝐧𝐭𝐞!");
								}
								scanTxt.nextLine();
								break;
								
							case 3:
								break;
								
							default:
								System.out.println("𝐎𝐩𝐜𝐚𝐨 𝐢𝐧𝐯𝐚́𝐥𝐢𝐝𝐚!");
								break;
							}	
							limpaTela();
						}
						break;
						
					case 1:
						Funcionario funcionario = bd.getFuncionario(nome, senha);
						opcao = 0;
						while (opcao != 5) {
							System.out.printf("𝐍𝐨𝐦𝐞: %s   𝐂𝐩𝐟: %s   𝐒𝐚𝐥𝐚𝐫𝐢𝐨: 𝐑$ %.2f   𝐏𝐨𝐧𝐭𝐨: %b \n", funcionario.nome, funcionario.getCpfMascarado(), funcionario.getSalario(), funcionario.ponto);
							funcionario.gerarTela();
							opcao = scanGeral.nextInt();
							limpaTela();
							
							switch(opcao) {
							case 1:
								if (funcionario.tarefas.size() == 0) {
									System.out.println("𝐍𝐚𝐨 𝐡𝐚́ 𝐭𝐚𝐫𝐞𝐟𝐚𝐬 𝐫𝐞𝐠𝐢𝐬𝐭𝐫𝐚𝐝𝐚𝐬!");
									scanTxt.nextLine();
								}else {
									for (int i=0; i<funcionario.tarefas.size(); i++) {
										System.out.printf("%d- %s \n", (i+1), funcionario.tarefas.get(i));
									}
									scanTxt.nextLine();
								}
								break;
							
							case 2:
								System.out.print("𝐈𝐧𝐬𝐢𝐫𝐚 𝐚 𝐭𝐚𝐫𝐞𝐟𝐚 𝐪𝐮𝐞 𝐯𝐨𝐜𝐞 𝐝𝐞𝐬𝐞𝐣𝐚 𝐚𝐝𝐢𝐜𝐢𝐨𝐧𝐚𝐫: ");
								funcionario.addTarefa(scanTxt.nextLine());
								limpaTela();
								System.out.println("𝐓𝐚𝐫𝐞𝐟𝐚 𝐚𝐝𝐢𝐜𝐢𝐨𝐧𝐚𝐝𝐚!");
								scanTxt.nextLine();
								break;
								
							case 3:
								System.out.print("𝐈𝐧𝐬𝐢𝐫𝐚 𝐚 𝐭𝐚𝐫𝐞𝐟𝐚 𝐪𝐮𝐞 𝐯𝐨𝐜𝐞 𝐝𝐞𝐬𝐞𝐣𝐚 𝐫𝐞𝐦𝐨𝐯𝐞𝐫: ");
								if (funcionario.removeTarefa(scanTxt.nextLine())) {
									limpaTela();
									System.out.println("𝐓𝐚𝐫𝐞𝐟𝐚 𝐫𝐞𝐦𝐨𝐯𝐢𝐝𝐚!");
								}else {
									limpaTela();
									System.out.println("𝐓𝐚𝐫𝐞𝐟𝐚 𝐧𝐚𝐨 𝐞𝐱𝐢𝐬𝐭𝐞𝐧𝐭𝐞!");
								}
								scanTxt.nextLine();
								break;
								
							case 4:
								if (funcionario.ponto) {
									System.out.println("𝐏𝐨𝐧𝐭𝐨 𝐣𝐚 𝐟𝐨𝐢 𝐛𝐚𝐭𝐢𝐝𝐨!");
									scanTxt.nextLine();
								}else {
									funcionario.ponto = true;
									System.out.println("𝐏𝐨𝐧𝐭𝐨 𝐛𝐚𝐭𝐢𝐝𝐨!");
									scanTxt.nextLine();
								}
								break;
							
							case 5:
								break;
							
							default:
								System.out.println("𝐎𝐩𝐜𝐚𝐨 𝐢𝐧𝐯𝐚́𝐥𝐢𝐝𝐚!");
								break;
							}
							limpaTela();
						}
						break;
						
					case 2:
						Gerente gerente = bd.getGerente(nome, senha);
						opcao = 0;
						while (opcao != 8) {
							System.out.printf("𝐍𝐨𝐦𝐞: %s   𝐂𝐩𝐟: %s   𝐒𝐚𝐥𝐚𝐫𝐢𝐨: 𝐑$ %.2f   𝐏𝐨𝐧𝐭𝐨: %b \n", gerente.nome, gerente.getCpfMascarado(), gerente.getSalario(), gerente.ponto);
							gerente.gerarTela();
							opcao = scanGeral.nextInt();
							limpaTela();
							
							switch(opcao) {
							case 1:
								if (gerente.tarefas.size() == 0) {
									System.out.println("𝐍𝐚𝐨 𝐡𝐚́ 𝐭𝐚𝐫𝐞𝐟𝐚𝐬 𝐫𝐞𝐠𝐢𝐬𝐭𝐫𝐚𝐝𝐚𝐬!");
									scanTxt.nextLine();
								}else {
									for (int i=0; i<gerente.tarefas.size(); i++) {
										System.out.printf("%d- %s \n", (i+1), gerente.tarefas.get(i));
									}
									scanTxt.nextLine();
								}
								break;
							
							case 2:
								System.out.print("𝐈𝐧𝐬𝐢𝐫𝐚 𝐚 𝐭𝐚𝐫𝐞𝐟𝐚 𝐪𝐮𝐞 𝐯𝐨𝐜𝐞 𝐝𝐞𝐬𝐞𝐣𝐚 𝐚𝐝𝐢𝐜𝐢𝐨𝐧𝐚𝐫: ");
								gerente.addTarefa(scanTxt.nextLine());
								limpaTela();
								System.out.println("𝐓𝐚𝐫𝐞𝐟𝐚 𝐚𝐝𝐢𝐜𝐢𝐨𝐧𝐚𝐝𝐚!");
								scanTxt.nextLine();
								break;
								
							case 3:
								System.out.print("𝐈𝐧𝐬𝐢𝐫𝐚 𝐚 𝐭𝐚𝐫𝐞𝐟𝐚 𝐪𝐮𝐞 𝐯𝐨𝐜𝐞 𝐝𝐞𝐬𝐞𝐣𝐚 𝐫𝐞𝐦𝐨𝐯𝐞𝐫: ");
								if (gerente.removeTarefa(scanTxt.nextLine())) {
									limpaTela();
									System.out.println("𝐓𝐚𝐫𝐞𝐟𝐚 𝐫𝐞𝐦𝐨𝐯𝐢𝐝𝐚!");
								}else {
									limpaTela();
									System.out.println("𝐓𝐚𝐫𝐞𝐟𝐚 𝐧𝐚𝐨 𝐞𝐱𝐢𝐬𝐭𝐞𝐧𝐭𝐞!");
								}
								scanTxt.nextLine();
								break;
								
							case 4:
								if (gerente.ponto) {
									System.out.println("𝐏𝐨𝐧𝐭𝐨 𝐣𝐚 𝐟𝐨𝐢 𝐛𝐚𝐭𝐢𝐝𝐨!");
									scanTxt.nextLine();
								}else {
									gerente.ponto = true;
									System.out.println("𝐏𝐨𝐧𝐭𝐨 𝐛𝐚𝐭𝐢𝐝𝐨!");
									scanTxt.nextLine();
								}
								break;
								
							case 5:
								if (gerente.getDesempenhoFuncionarios().size() == 0) {
									System.out.println("𝐍𝐚𝐨 𝐡𝐚́ 𝐟𝐮𝐧𝐜𝐢𝐨𝐧𝐚𝐫𝐢𝐨𝐬 𝐫𝐞𝐠𝐢𝐬𝐭𝐫𝐚𝐝𝐨𝐬!");
									scanTxt.nextLine();
								}else {
									ArrayList<Desempenho> desempenhoFuncionarios = gerente.getDesempenhoFuncionarios();
									for (int i=0; i<desempenhoFuncionarios.size(); i++) {
										System.out.printf("%d- %s \n",(i+1) ,desempenhoFuncionarios.get(i));
									}
									scanTxt.nextLine();
								}
								break;
								
							case 6:
								if (gerente.getDesempenhoFuncionarios().size() == 0) {
									System.out.println("𝐍𝐚𝐨 𝐡𝐚́ 𝐟𝐮𝐧𝐜𝐢𝐨𝐧𝐚𝐫𝐢𝐨𝐬 𝐫𝐞𝐠𝐢𝐬𝐭𝐫𝐚𝐝𝐨𝐬!");
									scanTxt.nextLine();
								}else {
									ArrayList<Desempenho> desempenhoFuncionarios = gerente.getDesempenhoFuncionarios();
									for (int i=0; i<desempenhoFuncionarios.size(); i++) {
										System.out.printf("%d- %s \n",(i+1) ,desempenhoFuncionarios.get(i));
									}
									System.out.print("𝐃𝐞 𝐪𝐮𝐚𝐥 𝐟𝐮𝐧𝐜𝐢𝐨𝐧𝐚𝐫𝐢𝐨? ");
									int index = scanGeral.nextInt();
									if (index <= bd.getFuncionarios().size() && index > 0) {
										Funcionario funcionarioAlvo = bd.getFuncionario(index-1);
										Desempenho desempenho = funcionarioAlvo.desempenho;
										
										limpaTela();
										desempenho.gerarModificadores();
										int nivel = gerente.desempenho.getNivel();
										
										switch(scanGeral.nextInt()) {
										case 1:
											limpaTela();
											desempenho.setRendimento(-3, nivel);
											scanTxt.nextLine();
											break;
											
										case 2:
											limpaTela();
											desempenho.setRendimento(-7, nivel);
											scanTxt.nextLine();
											break;
											
										case 3:
											limpaTela();
											desempenho.setRendimento(-12, nivel);
											scanTxt.nextLine();
											break;
											
										case 4:
											limpaTela();
											desempenho.setRendimento(3, nivel);
											scanTxt.nextLine();
											break;
											
										case 5:
											limpaTela();
											desempenho.setRendimento(7, nivel);
											scanTxt.nextLine();
											break;
											
										case 6:
											limpaTela();
											desempenho.setRendimento(12, nivel);
											scanTxt.nextLine();
											break;
										
										default:
											limpaTela();
											System.out.println("𝐎𝐩𝐜𝐚𝐨 𝐢𝐧𝐯𝐚́𝐥𝐢𝐝𝐚!");
											scanTxt.nextLine();
											break;
										}
										
									}else {
										limpaTela();
										System.out.print("𝐅𝐮𝐧𝐜𝐢𝐨𝐧𝐚𝐫𝐢𝐨 𝐧𝐚𝐨 𝐫𝐞𝐠𝐢𝐬𝐭𝐫𝐚𝐝𝐨");
										scanTxt.nextLine();
									}
								}
								break;
								
							case 7:
								if (chefe.getDesempenhoFuncionarios().size() == 0) {
									System.out.println("𝐍𝐚𝐨 𝐡𝐚́ 𝐟𝐮𝐧𝐜𝐢𝐨𝐧𝐚𝐫𝐢𝐨𝐬 𝐫𝐞𝐠𝐢𝐬𝐭𝐫𝐚𝐝𝐨𝐬!");
									scanTxt.nextLine();
								}else {
									ArrayList<Desempenho> desempenhoFuncionarios = chefe.getDesempenhoFuncionarios();
									for (int i=0; i<desempenhoFuncionarios.size(); i++) {
										System.out.printf("%d- %s \n",(i+1) ,desempenhoFuncionarios.get(i));
									}
									System.out.print("𝐐𝐮𝐚𝐥𝐥 𝐟𝐮𝐧𝐜𝐢𝐨𝐧𝐚𝐫𝐢𝐨? ");
									int index = scanGeral.nextInt();
									if (index <= bd.getFuncionarios().size() && index > 0) {
										Desempenho funcionarioAlvo = bd.getFuncionario(index-1).desempenho;
										bd.removeFuncionario(index-1);
										chefe.removeDesempenhoFuncionario(funcionarioAlvo);
										for (Gerente leitorGerentes: bd.getGerentes()) {
											leitorGerentes.removeDesempenho(funcionarioAlvo);
										}
									}else {
										limpaTela();
										System.out.print("𝐎𝐩𝐜𝐚𝐨 𝐢𝐧𝐯𝐚́𝐥𝐢𝐝𝐚");
										scanTxt.nextLine();
									}
								}
								break;
								
							case 8:
								break;
							
							default:
								System.out.println("𝐎𝐩𝐜𝐚𝐨 𝐢𝐧𝐯𝐚́𝐥𝐢𝐝𝐚!");
								break;
							}
							limpaTela();
						}
						break;
						
					case 3:
						opcao = 0;
						while (opcao != 9) {
							System.out.printf("𝐍𝐨𝐦𝐞: %s   𝐂𝐩𝐟: %s   𝐑𝐞𝐧𝐝𝐚: 𝐑$ %.2f   𝐂𝐧𝐩𝐣: %s \n", chefe.nome, chefe.getCpfMascarado(), chefe.getRenda(), chefe.getCnpjMascarado());
							chefe.gerarTela();
							opcao = scanGeral.nextInt();
							limpaTela();
							
							switch(opcao) {
							case 1:
								if (chefe.getDesempenhoFuncionarios().size() == 0) {
									System.out.println("𝐍𝐚𝐨 𝐡𝐚́ 𝐟𝐮𝐧𝐜𝐢𝐨𝐧𝐚𝐫𝐢𝐨𝐬 𝐫𝐞𝐠𝐢𝐬𝐭𝐫𝐚𝐝𝐨𝐬!");
									scanTxt.nextLine();
								}else {
									ArrayList<Desempenho> desempenhoFuncionarios = chefe.getDesempenhoFuncionarios();
									for (int i=0; i<desempenhoFuncionarios.size(); i++) {
										System.out.printf("%d- %s \n",(i+1) ,desempenhoFuncionarios.get(i));
									}
									scanTxt.nextLine();
								}
								break;
								
							case 2:
								if (chefe.getDesempenhoGerentes().size() == 0) {
									System.out.println("𝐍𝐚𝐨 𝐡𝐚́ 𝐠𝐞𝐫𝐞𝐧𝐭𝐞𝐬 𝐫𝐞𝐠𝐢𝐬𝐭𝐫𝐚𝐝𝐨𝐬!");
									scanTxt.nextLine();
								}else {
									ArrayList<Desempenho> desempenhoGerentes = chefe.getDesempenhoGerentes();
									for (int i=0; i<desempenhoGerentes.size(); i++) {
										System.out.printf("%d- %s \n",(i+1) ,desempenhoGerentes.get(i));
									}
									scanTxt.nextLine();
								}
								break;
							
							case 3:
								System.out.println("𝐆𝐞𝐫𝐚𝐫 𝐢𝐝 𝐩𝐚𝐫𝐚 𝐪𝐮𝐞 𝐭𝐢𝐩𝐨 𝐝𝐞 𝐜𝐨𝐧𝐭𝐚 \n"
										+ "𝟏- 𝐅𝐮𝐧𝐜𝐢𝐨𝐧𝐚́𝐫𝐢𝐨 \n"
										+ "𝟐- 𝐆𝐞𝐫𝐞𝐧𝐭𝐞");
								int tipoContaId = scanGeral.nextInt();
								
								if (tipoContaId != 1 && tipoContaId != 2) {
									limpaTela();
									System.out.println("𝐓𝐢𝐩𝐨 𝐝𝐞 𝐜𝐨𝐧𝐭𝐚 𝐢𝐧𝐯𝐚́𝐥𝐢𝐝𝐚!");
									scanTxt.nextLine();
								}else {
									chefe.getId().gerarId(tipoContaId);
									limpaTela();
									
									System.out.printf("𝐈𝐝 𝐠𝐞𝐫𝐚𝐝𝐨: %s \n", chefe.getId().getId());
									scanTxt.nextLine();
								}
								break;
								
							case 4:
								if (chefe.getId().getId() == null) {
									System.out.printf("𝐍𝐚𝐨 𝐡𝐨𝐮𝐯𝐞 𝐢𝐝 𝐠𝐞𝐫𝐚𝐝𝐨! \n");
									scanTxt.nextLine();
								}else {
									System.out.printf("𝐈𝐝 𝐠𝐞𝐫𝐚𝐝𝐨: %s   𝐔𝐭𝐢𝐥𝐢𝐳𝐚𝐝𝐨: %b \n", chefe.getId().getId(), chefe.getId().isUsado());
									scanTxt.nextLine();
								}
								
								break;
								
							case 5:
								if (chefe.getDesempenhoFuncionarios().size() == 0) {
									System.out.println("𝐍𝐚𝐨 𝐡𝐚́ 𝐟𝐮𝐧𝐜𝐢𝐨𝐧𝐚𝐫𝐢𝐨𝐬 𝐫𝐞𝐠𝐢𝐬𝐭𝐫𝐚𝐝𝐨𝐬!");
									scanTxt.nextLine();
								}else {
									ArrayList<Desempenho> desempenhoFuncionarios = chefe.getDesempenhoFuncionarios();
									for (int i=0; i<desempenhoFuncionarios.size(); i++) {
										System.out.printf("%d- %s \n",(i+1) ,desempenhoFuncionarios.get(i));
									}
									System.out.print("𝐃𝐞 𝐪𝐮𝐚𝐥 𝐟𝐮𝐧𝐜𝐢𝐨𝐧𝐚𝐫𝐢𝐨? ");
									int index = scanGeral.nextInt();
									if (index <= bd.getFuncionarios().size() && index > 0) {
										Funcionario funcionarioAlvo = bd.getFuncionario(index-1);
										Desempenho desempenho = funcionarioAlvo.desempenho;
										
										limpaTela();
										desempenho.gerarModificadores();
										switch(scanGeral.nextInt()) {
										case 1:
											limpaTela();
											desempenho.setRendimento(-3, chefe.getNivel());
											scanTxt.nextLine();
											break;
											
										case 2:
											limpaTela();
											desempenho.setRendimento(-7, chefe.getNivel());
											scanTxt.nextLine();
											break;
											
										case 3:
											limpaTela();
											desempenho.setRendimento(-12, chefe.getNivel());
											scanTxt.nextLine();
											break;
											
										case 4:
											limpaTela();
											desempenho.setRendimento(3, chefe.getNivel());
											scanTxt.nextLine();
											break;
											
										case 5:
											limpaTela();
											desempenho.setRendimento(7, chefe.getNivel());
											scanTxt.nextLine();
											break;
											
										case 6:
											limpaTela();
											desempenho.setRendimento(12, chefe.getNivel());
											scanTxt.nextLine();
											break;
										
										default:
											limpaTela();
											System.out.println("𝐎𝐩𝐜𝐚𝐨 𝐢𝐧𝐯𝐚́𝐥𝐢𝐝𝐚!");
											scanTxt.nextLine();
											break;
										}
										
									}else {
										limpaTela();
										System.out.print("𝐎𝐩𝐜𝐚𝐨 𝐢𝐧𝐯𝐚́𝐥𝐢𝐝𝐚!");
										scanTxt.nextLine();
									}
								}
								break;
								
							case 6:
								if (chefe.getDesempenhoGerentes().size() == 0) {
									System.out.println("𝐍𝐚𝐨 𝐡𝐚́ 𝐠𝐞𝐫𝐞𝐧𝐭𝐞𝐬 𝐫𝐞𝐠𝐢𝐬𝐭𝐫𝐚𝐝𝐨𝐬!");
									scanTxt.nextLine();
								}else {
									ArrayList<Desempenho> desempenhoGerentes = chefe.getDesempenhoGerentes();
									for (int i=0; i<desempenhoGerentes.size(); i++) {
										System.out.printf("%d- %s \n",(i+1) ,desempenhoGerentes.get(i));
									}
									System.out.print("𝐃𝐞 𝐪𝐮𝐚𝐥 𝐠𝐞𝐫𝐞𝐧𝐭𝐞? ");
									int index = scanGeral.nextInt();
									if (index <= bd.getGerentes().size() && index > 0) {
										Gerente gerenteAlvo = bd.getGerente(index-1); // Valores com incremento na tela
										Desempenho desempenho = gerenteAlvo.desempenho;
										
										limpaTela();
										desempenho.gerarModificadores();
										switch(scanGeral.nextInt()) {
										case 1:
											limpaTela();
											desempenho.setRendimento(-3, chefe.getNivel());
											scanTxt.nextLine();
											break;
											
										case 2:
											limpaTela();
											desempenho.setRendimento(-7, chefe.getNivel());
											scanTxt.nextLine();
											break;
											
										case 3:
											limpaTela();
											desempenho.setRendimento(-12, chefe.getNivel());
											scanTxt.nextLine();
											break;
											
										case 4:
											limpaTela();
											desempenho.setRendimento(3, chefe.getNivel());
											scanTxt.nextLine();
											break;
											
										case 5:
											limpaTela();
											desempenho.setRendimento(7, chefe.getNivel());
											scanTxt.nextLine();
											break;
											
										case 6:
											limpaTela();
											desempenho.setRendimento(12, chefe.getNivel());
											scanTxt.nextLine();
											break;
										
										default:
											limpaTela();
											System.out.println("𝐎𝐩𝐜𝐚𝐨 𝐢𝐧𝐯𝐚́𝐥𝐢𝐝𝐚!");
											scanTxt.nextLine();
											break;
										}
										
									}else {
										limpaTela();
										System.out.print("𝐎𝐩𝐜𝐚𝐨 𝐢𝐧𝐯𝐚́𝐥𝐢𝐝𝐚");
										scanTxt.nextLine();
									}
								}
								break;
								
							case 7:
								if (chefe.getDesempenhoFuncionarios().size() == 0) {
									System.out.println("𝐍𝐚𝐨 𝐡𝐚́ 𝐟𝐮𝐧𝐜𝐢𝐨𝐧𝐚𝐫𝐢𝐨𝐬 𝐫𝐞𝐠𝐢𝐬𝐭𝐫𝐚𝐝𝐨𝐬!");
									scanTxt.nextLine();
								}else {
									ArrayList<Desempenho> desempenhoFuncionarios = chefe.getDesempenhoFuncionarios();
									for (int i=0; i<desempenhoFuncionarios.size(); i++) {
										System.out.printf("%d- %s \n",(i+1) ,desempenhoFuncionarios.get(i));
									}
									System.out.print("𝐐𝐮𝐚𝐥 𝐟𝐮𝐧𝐜𝐢𝐨𝐧𝐚𝐫𝐢𝐨? ");
									int index = scanGeral.nextInt();
									if (index <= bd.getFuncionarios().size() && index > 0) {
										Desempenho funcionarioAlvo = bd.getFuncionario(index-1).desempenho;
										bd.removeFuncionario(index-1);
										chefe.removeDesempenhoFuncionario(funcionarioAlvo);
										for (Gerente leitorGerentes: bd.getGerentes()) {
											leitorGerentes.removeDesempenho(funcionarioAlvo);
										}
									}else {
										limpaTela();
										System.out.print("𝐎𝐩𝐜𝐚𝐨 𝐢𝐧𝐯𝐚́𝐥𝐢𝐝𝐚");
										scanTxt.nextLine();
									}
								}
								break;
								
							case 8:
								if (chefe.getDesempenhoGerentes().size() == 0) {
									System.out.println("𝐍𝐚𝐨 𝐡𝐚́ 𝐠𝐞𝐫𝐞𝐧𝐭𝐞𝐬 𝐫𝐞𝐠𝐢𝐬𝐭𝐫𝐚𝐝𝐨𝐬!");
									scanTxt.nextLine();
								}else {
									ArrayList<Desempenho> desempenhoGerentes = chefe.getDesempenhoGerentes();
									for (int i=0; i<desempenhoGerentes.size(); i++) {
										System.out.printf("%d- %s \n",(i+1) ,desempenhoGerentes.get(i));
									}
									System.out.print("𝐐𝐮𝐚𝐥 𝐠𝐞𝐫𝐞𝐧𝐭𝐞? ");
									int index = scanGeral.nextInt();
									if (index <= bd.getGerentes().size() && index > 0) {
										Desempenho gerenteAlvo = bd.getGerente(index-1).desempenho;
										bd.removeGerente(index-1);
										chefe.removeDesempenhoGerente(gerenteAlvo);
									}else {
										limpaTela();
										System.out.print("𝐎𝐩𝐜𝐚𝐨 𝐢𝐧𝐯𝐚́𝐥𝐢𝐝𝐚");
										scanTxt.nextLine();
									}
								}
								break;
								
							case 9:
								break;
								
							case 69:
								bd.explodirEmpresa();
								chefe.demitirEmpregados();
								System.out.println("\r\n"
										+ "██████╗░░█████╗░░█████╗░███╗░░░███╗\r\n"
										+ "██╔══██╗██╔══██╗██╔══██╗████╗░████║\r\n"
										+ "██████╦╝██║░░██║██║░░██║██╔████╔██║\r\n"
										+ "██╔══██╗██║░░██║██║░░██║██║╚██╔╝██║\r\n"
										+ "██████╦╝╚█████╔╝╚█████╔╝██║░╚═╝░██║\r\n"
										+ "╚═════╝░░╚════╝░░╚════╝░╚═╝░░░░░╚═╝");
								try {
									Thread.sleep(900);
								} catch (Exception erro) {
								}
								System.out.println("𝐀 𝐞𝐦𝐩𝐫𝐞𝐬𝐚 𝐞𝐱𝐩𝐥𝐨𝐝𝐞 𝐚𝐜𝐢𝐝𝐞𝐧𝐭𝐚𝐥𝐦𝐞𝐧𝐭𝐞 𝐞 𝐭𝐨𝐝𝐨𝐬 𝐨𝐬 𝐞𝐦𝐩𝐫𝐞𝐠𝐚𝐝𝐨𝐬 𝐦𝐨𝐫𝐫𝐞𝐫𝐚𝐦...");
								try {
									Thread.sleep(2000);
								} catch (Exception erro) {
								}
								System.out.println("(𝐒𝐨𝐫𝐭𝐞 𝐪𝐮𝐞 𝐯𝐨𝐜𝐞 𝐞𝐬𝐭𝐚𝐯𝐚 𝐥𝐨𝐧𝐠𝐞 𝐝𝐞𝐥𝐞𝐬)");
								scanTxt.nextLine();
								break;
							
							default:
								System.out.println("𝐎𝐩𝐜𝐚𝐨 𝐢𝐧𝐯𝐚́𝐥𝐢𝐝𝐚!");
								break;
							}
							limpaTela();
						}
						break;
						
					default:
						System.out.println("𝐄𝐫𝐫𝐨 𝐧𝐚 𝐯𝐚𝐥𝐢𝐝𝐚𝐜𝐚𝐨 𝐝𝐚 𝐜𝐨𝐧𝐭𝐚!");
						break;
					}
				}else {
					System.out.println("𝐒𝐞𝐦 𝐜𝐨𝐧𝐭𝐚 𝐜𝐚𝐝𝐚𝐬𝐭𝐫𝐚𝐝𝐚!");
					scanTxt.nextLine();
					
					//
				}
			}else if (resposta == 0){
				limpaTela();
				System.out.print("𝐈𝐧𝐬𝐢𝐫𝐚 𝐨 𝐢𝐝 𝐩𝐚𝐫𝐚 𝐨 𝐜𝐚𝐝𝐚𝐬𝐭𝐫𝐨 (𝐂𝐚𝐬𝐨 𝐬𝐞𝐣𝐚 𝐜𝐥𝐢𝐞𝐧𝐭𝐞 𝐩𝐫𝐞𝐬𝐬𝐢𝐨𝐧𝐞 ❜𝐞𝐧𝐭𝐞𝐫❜): ");
				String id = scanTxt.nextLine();
				if(verificaId(id, chefe)) {
					chefe.getId().usarId();
					limpaTela();
					System.out.println("𝐈𝐝 𝐯𝐚́𝐥𝐢𝐝𝐨!");
					scanTxt.nextLine();
					
					limpaTela();
					System.out.print("𝐍𝐨𝐦𝐞: ");
					String nome = scanTxt.nextLine();
					System.out.print("𝐂𝐩𝐟: ");
					String cpf = scanTxt.nextLine();
					while (!bd.validarCpf(cpf)) {
						System.out.println("𝐂𝐩𝐟 𝐢𝐧𝐯𝐚𝐥𝐢𝐝𝐨");
						System.out.print("𝐂𝐩𝐟: ");
						cpf = scanTxt.nextLine();
					}
					System.out.print("𝐒𝐞𝐧𝐡𝐚: ");
					String senha = scanTxt.nextLine();
					System.out.print("𝐑𝐞𝐩𝐞𝐭𝐢𝐫 𝐚 𝐬𝐞𝐧𝐡𝐚: ");
					String senhaRepetida = scanTxt.nextLine();
						
					while(!verificaSenha(senha, senhaRepetida)){
						limpaTela();
						System.out.print("𝐒𝐞𝐧𝐡𝐚𝐬 𝐧𝐚𝐨 𝐜𝐨𝐦𝐩𝐚𝐭𝐢́𝐯𝐞𝐢𝐬!");
						scanTxt.nextLine();
						
						limpaTela();
						System.out.print("𝐒𝐞𝐧𝐡𝐚: ");
						senha = scanTxt.nextLine();
						System.out.print("𝐑𝐞𝐩𝐞𝐭𝐢𝐫 𝐚 𝐬𝐞𝐧𝐡𝐚: ");
						senhaRepetida = scanTxt.nextLine();
					}
					
					Pessoa pessoa = new Pessoa(nome, cpf, senha);
					int tipoConta = tipoConta(id);
					cadastrarConta(bd, tipoConta, pessoa, chefe);
					
					
					limpaTela();
					System.out.println("𝐂𝐚𝐝𝐚𝐬𝐭𝐫𝐨 𝐜𝐨𝐧𝐜𝐥𝐮𝐢́𝐝𝐨!");
					scanTxt.nextLine();
				}else if(id.equals("")) {
					limpaTela();
					System.out.print("𝐍𝐨𝐦𝐞: ");
					String nome = scanTxt.nextLine();
					System.out.print("𝐂𝐩𝐟: ");
					String cpf = scanTxt.nextLine();
					while (!bd.validarCpf(cpf)) {
						System.out.println("𝐂𝐩𝐟 𝐢𝐧𝐯𝐚𝐥𝐢𝐝𝐨");
						System.out.print("𝐂𝐩𝐟: ");
						cpf = scanTxt.nextLine();
					}
					System.out.print("𝐒𝐞𝐧𝐡𝐚: ");
					String senha = scanTxt.nextLine();
					System.out.print("𝐑𝐞𝐩𝐞𝐭𝐢𝐫 𝐚 𝐬𝐞𝐧𝐡𝐚: ");
					String senhaRepetida = scanTxt.nextLine();
						
					while(!verificaSenha(senha, senhaRepetida)){
						limpaTela();
						System.out.print("𝐒𝐞𝐧𝐡𝐚𝐬 𝐧𝐚𝐨 𝐜𝐨𝐦𝐩𝐚𝐭𝐢́𝐯𝐞𝐢𝐬!");
						scanTxt.nextLine();
						
						limpaTela();
						System.out.print("𝐒𝐞𝐧𝐡𝐚: ");
						senha = scanTxt.nextLine();
						System.out.print("𝐑𝐞𝐩𝐞𝐭𝐢𝐫 𝐚 𝐬𝐞𝐧𝐡𝐚: ");
						senhaRepetida = scanTxt.nextLine();
					}
					
					Cliente cliente = new Cliente(nome, cpf, senha, 0);
					bd.addCliente(cliente);
					
					limpaTela();
					
					System.out.println("𝐂𝐚𝐝𝐚𝐬𝐭𝐫𝐨 𝐜𝐨𝐧𝐜𝐥𝐮𝐢́𝐝𝐨!"); 
					scanTxt.nextLine();
				}else {
					limpaTela();
					System.out.println("𝐈𝐝 𝐢𝐧𝐯𝐚́𝐥𝐢𝐝𝐨!");
					scanTxt.nextLine();
					
					//
				}
			}else {
				limpaTela();
				System.out.println("𝐕𝐚𝐥𝐨𝐫 𝐢𝐧𝐯𝐚́𝐥𝐢𝐝𝐨!");
				scanTxt.nextLine();
			}
			
			limpaTela();
			System.out.print("𝐃𝐞𝐬𝐞𝐣𝐚 𝐜𝐨𝐧𝐭𝐢𝐧𝐮𝐚𝐫 𝐨 𝐚𝐜𝐞𝐬𝐬𝐨? ");
			int continuar = resposta(scanTxt.nextLine());
			while(continuar == -1) {
				limpaTela();
				System.out.println("𝐕𝐚𝐥𝐨𝐫 𝐢𝐧𝐯𝐚́𝐥𝐢𝐝𝐨!");
				scanTxt.nextLine();
				
				limpaTela();
				System.out.print("𝐃𝐞𝐬𝐞𝐣𝐚 𝐜𝐨𝐧𝐭𝐢𝐧𝐮𝐚𝐫 𝐨 𝐚𝐜𝐞𝐬𝐬𝐨? ");
				continuar = resposta(scanTxt.nextLine());
			}
			if (continuar == 0) {
				ficar = false;
				limpaTela();
				System.out.println("𝐏𝐫𝐨𝐠𝐫𝐚𝐦𝐚 𝐟𝐢𝐧𝐚𝐥𝐢𝐳𝐚𝐝𝐨...");
			}
		}
	}
	
	public static int resposta(String resposta) {
		Scanner sc = new Scanner(System.in);
		String[] positivas = {"Afirmativo", "Sim", "Com certeza", "Tenho", "Tenho sim", "Positivo", "S", "Ss", "Si", "Sm", "Sin", "Sn"};
		String[] negativas = {"Negativo", "Não", "Nn", "Não tenho", "Tenho não", "Nã", "Nao", "Na", "N"};
		
		for (String positiva: positivas) {
			if (resposta.equalsIgnoreCase(positiva)) {
				return 1;
			}
		}
		
		for (String negativa: negativas) {
			if (resposta.equalsIgnoreCase(negativa)) {
				return 0;
			}
		}
		return -1;
	}
	
	public static void limpaTela() {
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
	}

	public static boolean hasConta() {
		//if 
		return false;
	}

	public static boolean verificaSenha(String senha1, String senha2) {
		if(senha1.equals(senha2)) {
			return true;
		}
		return false;
	}
	
	public static boolean verificaId(String id, Chefe chefe) {
		if (id.equalsIgnoreCase(chefe.getId().getId())) {
			if (!chefe.getId().isUsado()) {
				return true;
			}
		}
		return false;
	}

	public static int tipoConta(String id) {
		String[] partesDoId = id.split("");
		int tipoConta = Integer.parseInt(partesDoId[partesDoId.length-1]);
		return tipoConta;
	}
	
	public static void cadastrarDesempenhoGerentes(BancoDeDados bd, Desempenho desempenho) {
		for (Gerente g: bd.getGerentes()) {
			g.addDesempenho(desempenho);
		}
	}
	
	public static void cadastrarConta(BancoDeDados bd, int tipoConta, Pessoa pessoa, Chefe chefe) {
		if (tipoConta == 1) {
			Desempenho desempenho = new Desempenho(pessoa.nome, 100, 1);
			Funcionario funcionario = new Funcionario(pessoa.nome, pessoa.getCpf(), pessoa.getSenha(), desempenho, 1000.0);
			bd.addFuncionario(funcionario);
			chefe.addDesempenhoFuncionario(desempenho);
			cadastrarDesempenhoGerentes(bd, desempenho);
		}else {
			Desempenho desempenho = new Desempenho(pessoa.nome, 100, 2);
			Gerente gerente = new Gerente(pessoa.nome, pessoa.getCpf(), pessoa.getSenha(), desempenho, 4000.0);
			bd.addGerente(gerente);
			chefe.addDesempenhoGerente(desempenho);
		}
	}
}