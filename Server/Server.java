package Server;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {

	public static void main(String[] args) {
		final int PORT = 9876;
		ServerSocket serverSocket;
		Socket socketClient;
		InputStream in;
		Scanner scanner;
		String auxValue;
		PrintStream printStream;
		OutputStream out;

		// bind
		try {
			serverSocket = new ServerSocket(PORT);
		} catch (Exception e) {
			System.out.println("A porta " + PORT + " não está disponível.");
			return;
		}

		// accept: conexão com o cliente
		try {
			System.out.println("Aguardando o cliente...");
			socketClient = serverSocket.accept();
		} catch (Exception e) {
			System.out.println("Erro ao conectar com o cliente.");
			return;
		}

		// comunicação
		try {
			boolean flagEscolhaCorreta = false;

			// Receber
			in = socketClient.getInputStream();
			scanner = new Scanner(in);

			// Enviar
			out = socketClient.getOutputStream();
			printStream = new PrintStream(out);

			while (flagEscolhaCorreta == false) {

				// Receber Linha 1 - Client
				auxValue = scanner.nextLine();
				System.out.println("Recebido Modo Selecionado " + auxValue);

				switch (auxValue) {
				case "1":
					flagEscolhaCorreta = true;

					// Enviar linha 1 - Servidor
					String modo = "Jogador vs CPU Selecionado";
					printStream.println(modo);

					jogadorVsCPU(in, scanner, printStream);

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

		// fechar
		try {
			socketClient.close();
			serverSocket.close();
		} catch (Exception e) {
			System.out.println("Erro ao fechar a conexão.");
		}
	}

	public static void jogadorVsCPU(InputStream in, Scanner scanner, PrintStream printStream) {

		int winPlayer = 0;
		int winCPU = 0;
		boolean endGame = false;

		while (endGame == false) {

			// Impar/Par - Receber Linha 2 - Client
			String parImpar = scanner.nextLine();
			System.out.println("PAR/IMPAR: " + parImpar);

			// Numero Jogador - Receber Linha 3 - Client
			String numeroJogador = scanner.nextLine();
			System.out.println("Numero Jogador: " + numeroJogador);

			// Numero CPU - Enviar linha 2 - Server
			int escolhaCPU = 0;
			escolhaCPU = (int) (Math.random() * (5 - 0)) + 0;
			printStream.println("Jogador Numero - " + numeroJogador + " | CPU Numero - " + escolhaCPU);

			// Enviar linha 3 - Server
			int somaNumeros = escolhaCPU + Integer.parseInt(numeroJogador);
			printStream.println("Soma dos numeros escolhidos -> " + somaNumeros);

			// Resultado Enviar linha 4 e 5 - Server
			printStream.println("======Resultado====="); // linha 4
			if (parImpar.equalsIgnoreCase("par")) {
				if (somaNumeros % 2 == 0) {
					printStream.println("Jogador venceu!"); // linha 5
					winPlayer++;
				} else {
					printStream.println("CPU venceu!"); // linha 5
					winCPU++;
				}
			} else if (parImpar.equalsIgnoreCase("impar")) { // IMPAR
				if (somaNumeros % 2 == 0) {
					printStream.println("CPU venceu!"); // linha 5
					winCPU++;
				} else {
					printStream.println("Jogador venceu!"); // linha 5
					winPlayer++;
				}
			} else {
				printStream.println("Opcao Invalida"); // linha 5
			}
			
			// Placar Enviar linha 6 e 7 - Server
			printStream.println("======Placar======"); // linha 6
			printStream.println("Jogador " + winPlayer + " | CPU " + winCPU);// linha 7
			
			// Jogar Novamente - Receber Linha 4 - Client
			String jogarNovamente = scanner.nextLine();
			System.out.println(jogarNovamente);
			
			if(jogarNovamente.contains("fim")) {
				endGame = true;
			}
		}
		
	}
}
