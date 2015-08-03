package me.pstakoun.reversewords;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ReverseWords
{
	private BufferedReader in;
	private BufferedWriter out;
	
	private int numCases;
	private String[][] words;
	
	public ReverseWords()
	{
		// Create reader
		try {
			in = new BufferedReader(new FileReader("B-large-practice.in"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		// Create writer
		try {
			out = new BufferedWriter(new FileWriter("B-large-practice-output.txt"));
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
		
		// Reverse words
		reverse();
	}

	public static void main(String[] args)
	{
		new ReverseWords();
	}
	
	private void getCases() throws IOException
	{
		// Get number of cases
		numCases = Integer.parseInt(in.readLine());
		// Create array to store words
		words = new String[numCases][];
		// Read each case
		for (int i = 0; i < numCases; i++)
		{
			// Get words
			words[i] = in.readLine().split("\\s+");
		}
	}

	private void reverse()
	{
		for (int i = 0; i < numCases; i++)
		{
			String[] original = words[i];
			int l = original.length;
			String[] reversed = new String[l];
			
			for (int j = 0; j < l; j++)
			{
				reversed[j] = original[l-j-1];
			}
			
			String sentance = String.join(" ", reversed);
			
			try {
				out.append("Case #" + (i+1) + ": " + sentance);
				out.newLine();
				out.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
	}
	
}
