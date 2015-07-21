package me.pstakoun.speakingintongues;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

public class SpeakingInTongues
{
	private BufferedReader in;
	private BufferedWriter out;
	
	private int numCases;
	private String[] input;
	private HashMap<Character, Character> letterMap = new HashMap<Character, Character>();
	
	public SpeakingInTongues()
	{
		// Create reader
		try {
			in = new BufferedReader(new FileReader("A-small-practice.in"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		// Create writer
		try {
			out = new BufferedWriter(new FileWriter("A-small-practice-output.txt"));
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
		
		initLetterMap();
		
		translate();
	}
	
	public static void main(String[] args)
	{
		new SpeakingInTongues();
	}
	
	private void getCases() throws IOException
	{
		// Get number of cases
		numCases = Integer.parseInt(in.readLine());
		// Read each case
		input = new String[numCases];
		for (int i = 0; i < numCases; i++)
		{
			// Get Googlerese text
			input[i] = in.readLine();
		}
	}
	
	private void initLetterMap()
	{
		letterMap.put(' ', ' ');
		letterMap.put('a', 'y');
		letterMap.put('b', 'h');
		letterMap.put('c', 'e');
		letterMap.put('d', 's');
		letterMap.put('e', 'o');
		letterMap.put('f', 'c');
		letterMap.put('g', 'v');
		letterMap.put('h', 'x');
		letterMap.put('i', 'd');
		letterMap.put('j', 'u');
		letterMap.put('k', 'i');
		letterMap.put('l', 'g');
		letterMap.put('m', 'l');
		letterMap.put('n', 'b');
		letterMap.put('o', 'k');
		letterMap.put('p', 'r');
		letterMap.put('q', 'z');
		letterMap.put('r', 't');
		letterMap.put('s', 'n');
		letterMap.put('t', 'w');
		letterMap.put('u', 'j');
		letterMap.put('v', 'p');
		letterMap.put('w', 'f');
		letterMap.put('x', 'm');
		letterMap.put('y', 'a');
		letterMap.put('z', 'q');
	}
	
	private void translate()
	{
		for (int i = 0; i < numCases; i++)
		{
			String output = "";
			
			for (char c : input[i].toCharArray())
			{
				output += letterMap.get(c);
			}
			
			try {
				out.append("Case #" + (i+1) + ": " + output);
				out.newLine();
				out.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
}
