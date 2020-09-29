import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.junit.Test;

//Given 2 Strings with length n and (n+1) respectively. The second String contains all the characters of first but with an extra char. Write the code to find the extra char
//
//Example 1:
//
//Input:
//
//A1 = "Test"
//A2 = "Test$"
//
//Output: '$'
//
//Example 2:
//
//Input:
//
//A1 = "Hello"
//A2 = "lloreH"
//
//Output: 'r'
//	
public class P028_FindTheMismatchString
{

	@Test
	public void setOne()
	{
		String inputOne="Test";
		String inputTwo="Test$";
		findTheExtra(inputOne,inputTwo);

	}

	@Test
	public void setTwo()
	{
		String inputOne="Hello";
		String inputTwo="lloreH";
		findTheExtra(inputOne,inputTwo);

	}

	@Test
	public void setThree()
	{
		String inputOne="Hello";
		String inputTwo="lloleH";
		findTheExtra(inputOne,inputTwo);

	}

//Solution 1( Not works if the extra string is a repeated string of first String)
	
	//Loop through the length of first array and add to list
	//Loop through the length of second array and add to list
	//remove first from second list
	//return the second list
	private void findTheExtra1(String inputOne,String inputTwo)
	{
		List<Character> tempListOne = new LinkedList<>();
		List<Character> tempListTwo= new LinkedList<>();
		for(int i=0;i<inputTwo.length();i++)
		{
			tempListTwo.add(inputTwo.charAt(i));//O[N]
		}
		for(int i=0;i<inputOne.length();i++)//O[N]
		{
			tempListOne.add(inputOne.charAt(i));
		}
		
		
		 tempListTwo.removeAll(tempListOne);
		System.out.println(tempListTwo);
	}	

//Solution 2
	//Added charactes of two strings in seperate maps
	//iterate over the entry set of larger string
	//compare the value of each key with the value of that key in the another map
	//if values are not equal, return that key from the larger map
	//[if the element is not present in may, null is return as value]
	private void findTheExtra2(String inputOne,String inputTwo)
	{
		Map<Character,Integer> tempListOne = new HashMap<Character,Integer>();
		Map<Character,Integer> tempListTwo= new HashMap<Character,Integer>();
		for(int i=0;i<inputTwo.length();i++)//O[N]
		{
			tempListTwo.put(inputTwo.charAt(i),tempListTwo.getOrDefault(inputTwo.charAt(i), 0)+1);//O[N]
		}
		for(int i=0;i<inputOne.length();i++)//O[N]
		{
			tempListOne.put(inputOne.charAt(i),tempListOne.getOrDefault(inputOne.charAt(i), 0)+1);
		}
		
		
		for(Entry<Character, Integer> i:tempListTwo.entrySet())//O[N]
		{
			if(tempListOne.get(i.getKey())!=i.getValue())
			{
				System.out.println(i.getKey());
				break;
			}
		}
		
	}	
	//Total time complexity==>O[N]
	
//Solution 3
	//Add all the ASCll value of string one and two
	//Subtract the smaller string's sum from the larger sum
	//print the difference after converting to character
	private void findTheExtra(String inputOne,String inputTwo)
	{
		int sumLarger=0;int sumSmaller=0;
		for(int i =0;i<inputTwo.length();i++)//O[N]
		{
			sumLarger=sumLarger+(inputTwo.charAt(i));
		}
		for(int i =0;i<inputOne.length();i++)//O[N]
		{
			sumSmaller=sumSmaller+(inputOne.charAt(i));
		}
		int difference=sumLarger-sumSmaller;//O[1]
		
		System.out.println((char)difference);
	}
	//Total time complexity==>O[N]
}
