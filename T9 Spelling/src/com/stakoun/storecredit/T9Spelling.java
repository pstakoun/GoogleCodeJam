package me.pstakoun.storecredit;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

public class T9Spelling
{
	private BufferedReader in;
	private BufferedWriter out;
	
	private int numCases;
	private String[] message;
	
	private HashMap<Character, String> keyMap = new HashMap<Character, String>();
	
	public T9Spelling()
	{
		// Create reader
		try {
			in = new BufferedReader(new FileReader("C-large-practice.in"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		// Create writer
		try {
			out = new BufferedWriter(new FileWriter("C-large-practice-output.txt"));
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
		
		// Create key mappings
		initKeyMap();
		
		// Output messages
		sendMessages();
	}
	
	public static void main(String[] args)
	{
		new T9Spelling();
	}
	
	private void getCases() throws IOException
	{
		// Get number of cases
		numCases = Integer.parseInt(in.readLine());
		// Create array to store messages
		message = new String[numCases];
		// Read each case
		for (int i = 0; i < numCases; i++)
		{
			// Add messages to array
			message[i] = in.readLine();
		}
	}

	private void initKeyMap()
	{
		keyMap.put(' ', "0");
		keyMap.put('a', "2");
		keyMap.put('b', "22");
		keyMap.put('c', "222");
		keyMap.put('d', "3");
		keyMap.put('e', "33");
		keyMap.put('f', "333");
		keyMap.put('g', "4");
		keyMap.put('h', "44");
		keyMap.put('i', "444");
		keyMap.put('j', "5");
		keyMap.put('k', "55");
		keyMap.put('l', "555");
		keyMap.put('m', "6");
		keyMap.put('n', "66");
		keyMap.put('o', "666");
		keyMap.put('p', "7");
		keyMap.put('q', "77");
		keyMap.put('r', "777");
		keyMap.put('s', "7777");
		keyMap.put('t', "8");
		keyMap.put('u', "88");
		keyMap.put('v', "888");
		keyMap.put('w', "9");
		keyMap.put('x', "99");
		keyMap.put('y', "999");
		keyMap.put('z', "9999");
	}
	
	private void sendMessages()
	{
		// Output messages
		for (int i = 0; i < numCases; i++) {
			String converted = "";
			for (char c : message[i].toCharArray())
			{
				String val = keyMap.get(c);
				if (converted != "" && converted.toCharArray()[converted.length()-1] == val.toCharArray()[0]) {
					converted += " ";
				}
				converted += val;
			}
			
			try {
				out.append("Case #" + (i+1) + ": " + converted);
				out.newLine();
				out.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
}
