package studio2;

import java.util.Scanner;

public class Ruin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		System.out.println("What is your start money? ");
		int startAmount = in.nextInt();
		int startTemp = startAmount;
		System.out.println("What is the win probability? (0.XX)%");
		double winChance = in.nextDouble();
		System.out.println("What is the win limit you want to set? ");
		int winLimit = in.nextInt();
		double expectedRuin;
		if(winChance == 0.5) {
			expectedRuin = 1.0-(startAmount/(double)winLimit);
		}
		else {
			double a = (1-winChance)/(winChance);
			expectedRuin = (Math.pow(a, startAmount)-Math.pow(a, winLimit))/(1-Math.pow(a, winLimit));
		}
		int totalSimulations = 5000000;
		int losses = 0;
		
		for(int i = 0; i < totalSimulations; i++) {
			int count = 0;
			startAmount = startTemp;
			while(startAmount!=0&&startAmount!=winLimit) {
				if(Math.random()<winChance) {
					count++;
					startAmount++;
				}
				else {
					count++;
					startAmount--;
				}
			}
			if(startAmount==0) {
				System.out.println("Day: " + (i+1) + " Plays: " + count + " Result: Lose");
				losses++;
			}
			else {
				System.out.println("Day: " + (i+1) + " Plays: " + count + " Result: Win");
			}
		}
		System.out.println("Losses: " + losses + " Simulations: " + totalSimulations);
		System.out.println("Ruin Rate from Simulation: " + losses/(double)totalSimulations + " Expected Ruin Rate: " + expectedRuin);
	}

}
