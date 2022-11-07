package br.com.engenharia;

import java.util.Scanner;

public class Jogo {

	public static void main(String[] args) {
		JogoController jogoController = new JogoController();
		boolean flagEscolhaCorreta = false;
	
		while (flagEscolhaCorreta == false) {

			@SuppressWarnings("resource")
			Scanner firstQuestion = new Scanner(System.in);
			System.out.println("------Escolha o modo------\nJogador vs CPU - 1\nJogador vs Jogador - 2");

			String answerOne = firstQuestion.nextLine();

			switch (answerOne) {
			case "1":
				flagEscolhaCorreta = true;

				jogoController.jogadorVsCPU();

				break;
			case "2":
				flagEscolhaCorreta = true;
				
				jogoController.jogadorVsJogador();
				
				break;
			default:
				System.out.println("Opção invalida, tente novamente!");
			}
		}
	}
}
