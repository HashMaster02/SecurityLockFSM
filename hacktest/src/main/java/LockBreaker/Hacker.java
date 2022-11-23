package LockBreaker;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Hacker {
	
	private int digitCount;
	
	Hacker()
	{
		this.digitCount = 0;
	}
	
	private int generateDigit(int range)
	{
		Random rand = new Random();
		return rand.nextInt(range);
	}
	
	public int getDigitCount()
	{
		return this.digitCount;
	}
	
	private void hackAttempt() {
		String out;
		int in;
		FSM fsm = new FSM();
		fsm.lockDevice();
		
		while (true) {
			in = generateDigit(10);
			this.digitCount++;
			fsm.input(in);
			out = fsm.output();
			if (out.equals("UNLOCKED")) {
				return;
			}
		}
	}
	
	public void completeHackAnalysis()
	{
		int min = 0, max = 0, totalDigitsUsed = 0, totalHackAttempts = 0;
		boolean end = false;
		
		System.out.println("How many times would you like to run the hack attempt? (Note that large values will have significant runtime): ");
		
		while(!end)
		{
			try {
				Scanner sc = new Scanner(System.in);
				totalHackAttempts = sc.nextInt();
				sc.close();
				
				System.out.println("Testing...");
				for(int i = 0; i < totalHackAttempts; i++)
				{
					hackAttempt();
					
					totalDigitsUsed += getDigitCount();
					
					if (i == 0)
					{
						min = max = getDigitCount();
					}
					
					else if(getDigitCount() > max)
					{
						max = getDigitCount();
					}
					
					else if(i != 0 && getDigitCount() < min)
					{
						min = getDigitCount();
					}
					
					this.digitCount = 0;
				}
				
				System.out.println("Total 6-digit combinations tried over " + totalHackAttempts + " hack attempts: " + totalDigitsUsed/6);
				System.out.println("max digits: " + max);
				System.out.println("min digits: " + min);
				System.out.println("On average, it takes " + totalDigitsUsed/totalHackAttempts + " digits to break the lock.");
				end = true;
			}
			catch(InputMismatchException e)
			{
				System.out.println("Integers only!");
			}
		}
		
	}
	
	public static void main(String[] args)
	{
		Hacker eve = new Hacker();
		eve.completeHackAnalysis();
	}

}
