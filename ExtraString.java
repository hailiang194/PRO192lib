import java.util.StringTokenizer;
import java.util.HashMap;
import java.util.ArrayList;

public class ExtraString 
{

	/**
	 * get all words in string
	 * string: string that store words
	 * return list of string that are words
	 */
	public static ArrayList<String> getWords(String string)
	{
		ArrayList<String> words = new ArrayList<String>();

		StringTokenizer token = new StringTokenizer(string, " \t\n\f\r");

		while(token.hasMoreTokens())
		{
			words.add(token.nextToken());
		}

		return words;
	}	

	/**
	 * reverse string
	 * string: string you want to reverse
	 * return reverse string
	 */
	public static String reverseString(String string)	
	{
		String reverse = new String();

		for(int i = string.length() - 1; i >= 0; i--)
		{
			reverse += string.charAt(i);
		}

		return reverse;
	}

	/**
	 * get the frequencies of all characters in string
	 * string: string you want to get the frequencies
	 * return hash map which is keys are characters appear in string, values are the frequencies of  their corresponding character
	 */
	public static HashMap<Character, Integer> getFrequenciesOfCharacters(String string)
	{
		HashMap<Character, Integer> freq = new HashMap<Character, Integer>();

		for(int i = 0; i < string.length(); i++)
		{
			Character chr = string.charAt(i);
			if(freq.containsKey(chr))
			{
				Integer timeAppear = freq.get(chr);
				freq.put(chr, timeAppear + 1);
			}
			else
			{
				freq.put(chr, 1);
			}
		}

		return freq;	
	}
}
