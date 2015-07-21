package me.pstakoun.storecredit;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class StoreCredit
{
	private BufferedReader in;
	private BufferedWriter out;
	
	private int numCases;
	private int[] credit;
	private int[] numItems;
	private int[][] items;
	
	public StoreCredit()
	{
		// Create reader
		try {
			in = new BufferedReader(new FileReader("A-large-practice.in"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		// Create writer
		try {
			out = new BufferedWriter(new FileWriter("A-large-practice-output.txt"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// Get case values
		try {
			getCases();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// Find correct items
		findItemPair();
	}
	
	public static void main(String[] args)
	{
		new StoreCredit();
	}
	
	private void getCases() throws IOException
	{
		// Get number of cases
		numCases = Integer.parseInt(in.readLine());
		// Create array to store credit
		credit = new int[numCases];
		// Create array to store number of items
		numItems = new int[numCases];
		// Create array to store items
		items = new int[numCases][];
		// Read each case
		for (int i = 0; i < numCases; i++)
		{
			// Add case values to arrays
			credit[i] = Integer.parseInt(in.readLine());
			numItems[i] = Integer.parseInt(in.readLine());
			items[i] = new int[numItems[i]];
			// Get raw item list
			String[] strItems = in.readLine().split("\\s+");
			
			// Add items to item array
			for (int j = 0; j < numItems[i]; j++)
			{
				items[i][j] = Integer.parseInt(strItems[j]);
			}
		}
	}

	private void findItemPair()
	{
		// Create found flag
		boolean found = false;
		// Find items in each case
		for (int i = 0; i < numCases; i++) {
			// Get number of items in case
			int n = numItems[i];
			// Get credit in case
			int c = credit[i];
			
			// Search for adding items
			for (int j = 0; j < n-1; j++)
			{
				if (found) { break; }
				if (items[i][j] >= c) { continue; }
				for (int k = j+1; k < n; k++)
				{
					if (items[i][j] + items[i][k] == c)
					{
						try {
							out.append("Case #" + (i+1) + ": " + (j+1) + " " + (k+1));
							out.newLine();
							out.flush();
						} catch (IOException e) {
							e.printStackTrace();
						}
						
						found = true;
						break;
					}
				}
			}
			found = false;
		}
	}
	
}
