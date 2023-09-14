package studio2;

import java.util.Scanner;

public class Ruin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		System.out.println("The amount of money you start with: ");
		int startAmount = in.nextInt();
		System.out.println("Win probability: ");
		double winChance = in.nextDouble();
		System.out.println("Win limit: ");
		int winLimit = in.nextInt();
		System.out.println("How many hands do you want to play? ");
		int totalSimulations = in.nextInt();
		int numberLosses= 0;
		int numberWins = 0;
		int realStart = startAmount;

		for (int x=0; x < totalSimulations; x++) {
			while ((startAmount > 0) && (startAmount < winLimit)) {
				double newRoll = Math.random();
				if (newRoll < winChance) {
					startAmount += 1;
					System.out.println("You now have $" + startAmount + "(win)");
				}

				else {
					startAmount -= 1;
					System.out.println("You now have $" + startAmount + "(lose)");
				}
			}
			if (startAmount >= winLimit) {
				//System.out.print("WIN");
				numberWins += 1;
				startAmount = realStart;
				
			}
			if (startAmount <= 0) {
				//System.out.print("LOSE");
				numberLosses += 1;
				startAmount = realStart;
			}

		}
		double expectedRuin = 0;
		double alpha = (((1-winChance)/winChance));
		if (winChance == 0.5) {
			expectedRuin = 1-(startAmount/winLimit);
		}
		else {
			expectedRuin = ((Math.pow(alpha, startAmount)) - (Math.pow(alpha, winLimit))) / ((1-(Math.pow(alpha, winLimit))));
		}
		double roundedexpectedRuin = (Math.round(expectedRuin * 100.0) / 100.0);
		
		System.out.println("Wins: " + numberWins + ", Losses: " + numberLosses + ", Simulations: " + totalSimulations);
		System.out.println("Ruin Rate from Simulation: " + roundedexpectedRuin);
		System.out.println("Expected Ruin Rate: " + expectedRuin );

	}
}


