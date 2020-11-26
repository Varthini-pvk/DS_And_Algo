package ArraysAndStrings;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;
//
//Given two strings s1 and s2, write a function to return true if s2 contains the permutation of s1. In other words, one of the first string's permutations is the substring of the second string.
//
//Example 1:
//
//Input: s1 = "ab" s2 = "eidbaooo"
//Output: True
//Explanation: s2 contains one permutation of s1 ("ba").
//Example 2:
//
//Input:s1= "ab" s2 = "eidboaoo"
//Output: False


public class P030_PermutationsOfaString {

	@Test
	public void datsSetOne()
	{
		String one="eidbaooo";
		String two="abcd";
		System.out.println("1."+detectAnagrams(one,two));
	}

	@Test
	public void datsSetTwo()
	{
		String one="eidbaooo";
		String two="ab";
		System.out.println("2."+detectAnagrams(one,two));
	}
	@Test
	public void datsSetThree()
	{
		String one="abc";
		String two="ooo";
		System.out.println("3."+detectAnagrams(one,two));
	}
	
	@Test
	public void datsSetFour()
	{
		String one="eidbaooo";
		String two="aberrtttvvbb";
		System.out.println("4."+detectAnagrams(one,two));
	}
	
	@Test
	public void datsSetFive()
	{
		String one="eidbaooo";
		String two="eidbaooo";
		System.out.println("5."+detectAnagrams(one,two));
	}
	//Solution 1
	//Find Permutation of the string two
	//Add it to a list
	// Iterate over the list and check if the first String contains any entry of the list.
	//if Yes, break the loop and return true
	List<String> permutations=new LinkedList<>();
	public Boolean detectAnagrams(String inputOne,String inputTwo)
	{
		Boolean flag=false;
		
		if(inputOne.length()>inputTwo.length())
		{
		generatePermutations(inputTwo.toCharArray(),0,inputTwo.toCharArray().length);
		Collections.sort(permutations);
		for(String i:permutations)//0[N!]
		{
			if(inputOne.contains(i))
			{
				flag=true;
				break;
			}
		}
		}
		return flag;


	}
	private void generatePermutations(char[] array,int startPosition,int arrayLength)//?
	{
		char temp;

		//Base Case of Recursion
		if(startPosition==arrayLength)
		{
			permutations.add(String.valueOf(array));
		}
		//Recursive case
		else
		{
			for(int i=startPosition;i<arrayLength;i++)
			{
				//if(i>startPosition)
				{
					temp=array[i];
					array[i]=array[startPosition];
					array[startPosition]=temp;
				}
				generatePermutations(array,startPosition+1,arrayLength);
				//if(i>startPosition)
				{
					temp=array[i];
					array[i]=array[startPosition];
					array[startPosition]=temp;
				}
			}
		}

	}

	//Wont Work if Has Special Characters/Numbers

	//Solution 2

	//Initialize an 2 Arrays of length-->52
	//Add the frequency of all elements  the Array as starting from A-->0
	//Slide through the Larger String in windows of length equal to length of second String
	//Add the frequency of the elements in the second Array
	//compare 2 Array 
	//if yes , return true and break the loop

	private Boolean detectAnagrams2(String inputOne,String inputTwo)
	{
		Boolean result=false;
		if(inputOne.length()>inputTwo.length())
		{
		int[] referenceArray=new int[26];
		int[] currentArray=new int[26];
		inputTwo = inputTwo.toLowerCase();
		int length = inputTwo.length();
		
		for(int i=0;i<length;i++)//O[M]
		{
			referenceArray[inputTwo.charAt(i)-'a']++;
		}
		
		//Initial Window
		for(int i=0;i<length;i++)//O[M]
		{
			currentArray[inputOne.charAt(i)-'a']++;
		}
		
		if(Arrays.equals(referenceArray, currentArray))
		{
			result=true;
			
		}
		
		//Other Windows
		int i=length;
		do
		{
			
			currentArray[inputOne.charAt(i-length)-'a']--;
			currentArray[inputOne.charAt(i)-'a']++;
			if(Arrays.equals(referenceArray, currentArray))//O[M]
			{
				result=true;
				break;
			}
			i++;
			
			
		}while(i<inputOne.length());//O[N-M]
		}

		return result;


	}
	
	
	//Solution 3
	
		//Add the frequency of all elements  in a map
		//Slide through the Larger String in windows of length equal to length of second String
		//Add the frequency of the elements in the second map
		//compare 2 maps 
		//if yes , return true and break the loop
}
