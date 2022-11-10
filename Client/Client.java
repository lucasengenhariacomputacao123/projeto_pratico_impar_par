package Client;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
	public static void main(String[] args) {
		final String IP = "127.0.0.1";
		final int PORT = 9876;
		Socket socket;
		OutputStream out;
		PrintStream printStream;
		Scanner scanner;
		Scanner scannerServer;
		InputStream in;

		// conectar com o servidor
		try {
			socket = new Socket(IP, PORT);
		} catch (Exception e) {
			System.out.println("Erro ao conectar com o servidor.");
			return;
		}

		// enviar uma mensagem(comunicação)
		try {
			boolean flagEscolhaCorreta = false;

			// Enviar
			out = socket.getOutputStream();
			printStream = new PrintStream(out);

			// Recebido
			in = socket.getInputStream();
			scannerServer = new Scanner(in);

			// scanner
			scannerServer = new Scanner(in);

			while (flagEscolhaCorreta == false) {

				// Enviar Linha 1 - Client
				System.out.println("------Escolha o modo------\nJogador vs CPU - 1\nJogador vs Jogador - 2");
				scanner = new Scanner(System.in);
				String answerOne = scanner.nextLine();
				printStream.println(answerOne);

				switch (answerOne) {
				case "1":
					flagEscolhaCorreta = true;

					// Receber Linha 1 - Server (Jogador vs CPU Selecionado)
					System.out.println(scannerServer.nextLine());

					jogadorVsCPU(printStream, scanner, scannerServer);

					break;
				case "2":
					flagEscolhaCorreta = true;

					//jogadorVsJogador();

					break;
				default:
					System.out.println("Opção invalida, tente novamente!");
				}
			}

		} catch (Exception e) {
			System.out.println("Erro na comunicação.");
		}

		// desconectar
		try {
			socket.close();
		} catch (Exception e) {
			System.out.println("Erro ao desconectar.");
		}

	}

	public static void jogadorVsCPU(PrintStream printStream, Scanner scanner, Scanner scannerServer) {

		boolean flagEndGame = false;

		while (flagEndGame == false) {
			boolean flagAnswer1 = false;
			boolean flagAnswer2 = false;
			boolean flagAnswer3 = false;

			try {

				// Impar/Par - Enviar Linha 2 - Client
				while (flagAnswer1 == false) {
					System.out.println("======Jogador vs CPU======");
					System.out.println("Jogador escolha entre PAR ou IMPAR:");
					Scanner answerTwo = new Scanner(System.in);
					String parImpar = answerTwo.nextLine();
					if (parImpar.equalsIgnoreCase("par") || parImpar.equalsIgnoreCase("impar")) {
						printStream.println(parImpar);
						flagAnswer1 = true;
					} else {
						System.out.println("Opcao Invalida -> " + parImpar);
					}
				}

				// Numero Jogador - Enviar Linha 3 - Client
				while (flagAnswer2 == false) {
					System.out.println("======Escolha um numero de 0 - 5======");
					Scanner answerThree = new Scanner(System.in);
					String numero = answerThree.nextLine();
					if (Integer.parseInt(numero) >= 0 && Integer.parseInt(numero) < 6) {
						flagAnswer2 = true;
						printStream.println(numero);
					} else {
						System.out.println("Numero Invalido -> " + numero);
					}
				}

				// Receber Linha 2 - Server
				System.out.println(scannerServer.nextLine());

				// Receber Linha 3 - Server
				System.out.println(scannerServer.nextLine());

				// Receber Linha 4 - Server
				System.out.println(scannerServer.nextLine());

				// Receber Linha 5 - Server
				System.out.println(scannerServer.nextLine());

				// Receber Linha 6 - Server
				System.out.println(scannerServer.nextLine());

				// Receber Linha 7 - Server
				System.out.println(scannerServer.nextLine());

				// Jogar Novamente - Enviar Linha 4 - Client
				while (flagAnswer3 == false) {
					System.out.println("======Jogar Novamente?=======\nSim - 1 | Não - 2");
					Scanner answerFour = new Scanner(System.in);
					String jogarNovamente = answerFour.nextLine();
					if (jogarNovamente.equals("2")) {
						flagAnswer3 = true;
						flagEndGame = true;
						printStream.println("Fim de Jogo");
					} else if(jogarNovamente.equals("1")){
						flagAnswer3 = true;
						printStream.println("Jogar Novamente");
					} else {
						System.out.println("Opcao Invalida -> " + jogarNovamente);
					}
				}
				

			} catch (Exception e) {
				System.out.println("Ops algo deu errado! Tentar novamente");
			}
		}
	}
}
