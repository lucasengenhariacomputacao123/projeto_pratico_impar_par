package br.com.engenharia;

import java.util.Scanner;

public class JogoController {
	boolean flagEndGame = false;
	String playerOneAnswerParImpar;
	String playerTwoAnswerParImpar;
	String numberPlayerOne;
	String numberPlayerTwo;
	String jogarNovamente;
	int escolhaCPU;
	int winPlayerOne = 0;
	int winPlayerTwo = 0;
	int winCPU = 0;

	public void jogadorVsCPU() {
		while (flagEndGame == false) {
			boolean flagAnswer1 = false;
			boolean flagAnswer2 = false;

			try {

				System.out.println("======Jogador vs CPU======");
				
				while (flagAnswer1 == false) {
					System.out.println("Jogador escolha entre PAR ou IMPAR:");

					Scanner answerTwo = new Scanner(System.in);
					playerOneAnswerParImpar = answerTwo.nextLine();

					if (!playerOneAnswerParImpar.equalsIgnoreCase("par")
							&& !playerOneAnswerParImpar.equalsIgnoreCase("impar")) {
						System.out.println("Opção Invalida!");
					} else {
						flagAnswer1 = true;			
					}
				}

				while (flagAnswer2 == false) {

					System.out.println("======Escolha um numero de 0 - 5======");

					Scanner answerThree = new Scanner(System.in);
					numberPlayerOne = answerThree.nextLine();

					if (Integer.parseInt(numberPlayerOne) >= 0 && Integer.parseInt(numberPlayerOne) < 6) {
						flagAnswer2 = true;
					}

				}

				escolhaCPU = (int) (Math.random() * (5 - 0)) + 0;

				System.out.println("Jogador Numero - " + numberPlayerOne + " | CPU Numero - " + escolhaCPU);

				int somaNumeros = escolhaCPU + Integer.parseInt(numberPlayerOne);

				System.out.println("Soma dos numeros escolhidos -> " + somaNumeros);

				System.out.println("======Resultado=====");
				if (playerOneAnswerParImpar.equalsIgnoreCase("par")) {
					if (somaNumeros % 2 == 0) {
						System.out.println("Jogador venceu!");
						winPlayerOne++;
					} else {
						System.out.println("CPU venceu!");
						winCPU++;
					}
				} else if (playerOneAnswerParImpar.equalsIgnoreCase("impar")) {
					if (somaNumeros % 2 == 0) {
						System.out.println("CPU venceu!");
						winCPU++;
					} else {
						System.out.println("Jogador Venceu!");
						winPlayerOne++;
					}
				} else {
					System.out.println("Opção Invalida!");
				}

				System.out.println("======Placar======");
				System.out.println("Jogador " + winPlayerOne + " | CPU " + winCPU);

				System.out.println("======Jogar Novamente?=======\nSim - 1 | Não - 2");

				Scanner playAgain = new Scanner(System.in);
				jogarNovamente = playAgain.nextLine();

				if (jogarNovamente.equals("2")) {
					flagEndGame = true;
					System.out.println("======Fim de Jogo======");
				}
			} catch (Exception e) {
				System.out.println("Ops algo deu errado! Tentar novamente");
			}
		}
	}

	public void jogadorVsJogador() {
		while (flagEndGame == false) {
			boolean flagAnswer1 = false;
			boolean flagAnswer2 = false;

			try {

				System.out.println("======Jogador vs Jogador=====");
				
				while (flagAnswer1 == false) {
					System.out.println("Jogador 1 escolha entre PAR ou IMPAR:");

					Scanner answerTwoOne = new Scanner(System.in);
					playerOneAnswerParImpar = answerTwoOne.nextLine();

					if (!playerOneAnswerParImpar.equalsIgnoreCase("par")
							&& !playerOneAnswerParImpar.equalsIgnoreCase("impar")) {
						System.out.println("Opção Invalida!");
					} else {
						flagAnswer1 = true;
					}
				}

				while (flagAnswer2 == false) {

					System.out.println("======Jogador 1 escolha um numero de 0 - 5======");

					Scanner answerThree = new Scanner(System.in);
					numberPlayerOne = answerThree.nextLine();

					if (Integer.parseInt(numberPlayerOne) >= 0 && Integer.parseInt(numberPlayerOne) < 6) {
						flagAnswer2 = true;
					}

				}
				
				flagAnswer2 = false;
				
				while (flagAnswer2 == false) {

					System.out.println("======Jogador 2 escolha um numero de 0 - 5======");

					Scanner answerThree = new Scanner(System.in);
					numberPlayerTwo = answerThree.nextLine();

					if (Integer.parseInt(numberPlayerTwo) >= 0 && Integer.parseInt(numberPlayerTwo) < 6) {
						flagAnswer2 = true;
					}
				}

				System.out.println("Jogador1 Numero - " + numberPlayerOne + " | Jogador2 Numero - " + numberPlayerTwo);

				int somaNumeros = Integer.parseInt(numberPlayerOne) + Integer.parseInt(numberPlayerTwo);

				System.out.println("Soma dos numeros escolhidos -> " + somaNumeros);

				System.out.println("======Resultado=====");
				if (playerOneAnswerParImpar.equalsIgnoreCase("par")) {
					if (somaNumeros % 2 == 0) {
						System.out.println("Jogador 1 venceu!");
						winPlayerOne++;
					} else {
						System.out.println("Jogador 2 venceu!");
						winPlayerTwo++;
					}
				} else if (playerOneAnswerParImpar.equalsIgnoreCase("impar")) {
					if (somaNumeros % 2 == 0) {
						System.out.println("Jogador 2 venceu!");
						winPlayerTwo++;
					} else {
						System.out.println("Jogador 1 Venceu!");
						winPlayerOne++;
					}
				} else {
					System.out.println("Opção Invalida!");
				}

				System.out.println("======Placar======");
				System.out.println("Jogador1 - " + winPlayerOne + " | Jogador2 - " + winPlayerTwo);

				System.out.println("======Jogar Novamente?=======\nSim - 1 | Não - 2");

				Scanner playAgain = new Scanner(System.in);
				jogarNovamente = playAgain.nextLine();

				if (jogarNovamente.equals("2")) {
					flagEndGame = true;
					System.out.println("======Fim de Jogo======");
				}
			} catch (Exception e) {
				System.out.println("Ops algo deu errado! Tentar novamente");
			}
		}
	}
}
