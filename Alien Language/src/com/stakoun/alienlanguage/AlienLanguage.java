package me.pstakoun.alienlanguage;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AlienLanguage
{
	private BufferedReader in;
	private BufferedWriter out;
	
	private int numCases;
	private int numWords;
	private int wordLength;
	private String[] words;
	private String[] cases;
	
	public AlienLanguage()
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
		
		getMatches();
	}
	
	public static void main(String[] args)
	{
		new AlienLanguage();
	}
	
	private void getCases() throws IOException
	{
		// Get initial values
		String[] arr = in.readLine().split("\\s+");
		wordLength = Integer.parseInt(arr[0]);
		numWords = Integer.parseInt(arr[1]);
		numCases = Integer.parseInt(arr[2]);
		
		// Store each word
		words = new String[numWords];
		for (int i = 0; i < numWords; i++)
		{
			words[i] = in.readLine();
		}
		
		// Read each case
		cases = new String[numCases];
		for (int i = 0; i < numCases; i++)
		{
			cases[i] = in.readLine();
		}
	}
	
	private void getMatches()
	{
		// Find matches for each case
		for (int i = 0; i < numCases; i++)
		{
			// Create array to store possible letters
			char letters[][] = new char[wordLength][];
			// Get all characters in case (including brackets)
			char[] chars = cases[i].toCharArray();
			// Create counter to go back to correct character
			int k = 0;
			
			// Iterate through letter slots
			for (int j = 0; j < wordLength; j++)
			{
				// Check for unknown character
				if (chars[k] == '(')
				{
					// Get all characters until closing bracket
					ArrayList<Character> temp = new ArrayList<Character>();
					k++;
					while (chars[k] != ')')
					{
						temp.add(chars[k]);
						k++;
					}
					// Add potential characters to letters
					letters[j] = new char[temp.size()];
					for (int l = 0; l < letters[j].length; l++)
					{
						letters[j][l] = temp.get(l);
					}
					k++;
				}
				// Add character to letters
				else
				{
					// Add character
					letters[j] = new char[] {chars[k]};
					// Increment counter
					k++;
				}
			}
			
			// Initialize number of matches
			int matches = 0;
			
			// Find matching words
			for (k = 0; k < numWords; k++)
			{
				// Get characters in word
				char[] word = words[k].toCharArray();
				if (matches(letters, word))
				{
					matches++;
				}
			}
			
			// Output number of matches for case
			try {
				out.append("Case #" + (i+1) + ": " + matches);
				out.newLine();
				out.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	private boolean matches(char[][] letters, char[] word)
	{
		// Iterate through letters checking for matches
		for (int i = 0; i < wordLength; i++)
		{
			for (int j = 0; j < letters[i].length; j++)
			{
				if (letters[i][j] == word[i]) { break; }
				else if (j == letters[i].length-1) { return false; }
			}
		}
		return true;
	}
	
}
