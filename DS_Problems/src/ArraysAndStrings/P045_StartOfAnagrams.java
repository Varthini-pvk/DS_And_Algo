package ArraysAndStrings;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

//Given a string S and a non empty string P,find all the start indices of P's anagram in S
//String consists of LowerCase English Letters only and length of both Strings S a P will not b longer than 20,100
//The order of output does not matter.
//Example 1:
//Input:
//
//s:
//
//"cbaebabacd" p:
//
//"abc"
//
//Output:
//[0, 6]
//
//Explanation:
//The substring with start index = 0 is
//"cba"
//
//, which is an anagram of "abc"
//.
//
//The substring with start index = 6 is
//"bac"
//
//, which is an anagram of "abc"
//.
public class P045_StartOfAnagrams {
	
	
	@Test
	public void dataSetOne()
	{
		String s="cbaebabacd";
		String p="abc";
		System.out.println("One:"+findStartOfAnangram(s,p));
	}
	
	@Test
	public void dataSetTwo()
	{
		String s="aabcabbccabc";
		String p="abc";
		System.out.println("Two:"+findStartOfAnangram(s,p));
	}
	
	@Test
	public void dataSetThree()
	{
		String s="abcabc";
		String p="abc";
		System.out.println("Three:"+findStartOfAnangram(s,p));
	}

	
	@Test
	public void dataSetFour()
	{
		String s="aabcdcs";
		String p="saabcdc";
		System.out.println("Four:"+findStartOfAnangram(s,p));
	}
	
	@Test
	public void dataSetFive()
	{
		String s="abc";
		String p="abcd";
		System.out.println("Five:"+findStartOfAnangram(s,p));
	}
	
	@Test
	public void dataSetSix()
	{
		String s="abbefaab";
		String p="aab";
		System.out.println("Six:"+findStartOfAnangram(s,p));
	}
	
	
	//Solution 2
	//Window Sliding with a ref array
	
	private List<Integer> findStartOfAnangram1(String s,String p)
	{  List<Integer> output=new ArrayList<>();
	
		if(p.length()<=s.length())
		{
			int[] refArray=new int[26];
			int[] winArray=new int[26];
			for(int i=0;i<p.length();i++)
			{
				refArray[p.charAt(i)-'a']++;
			}
			int j=0;
			for(;j<p.length();j++)
			{
				winArray[s.charAt(j)-'a']++;
			}
			int start=0;
			while(j<=s.length())
			{
				
				if(Arrays.equals(winArray, refArray))
				output.add(start);
				winArray[s.charAt(start)-'a']--;
				start++;
				if(j<s.length())
				{
				winArray[s.charAt(j)-'a']++;
				}
				j++;
				
			}
		}
		return output;
	}

	
	private List<Integer> findStartOfAnangram2(String s,String p)
	{  List<Integer> output=new ArrayList<>();
	
		if(p.length()<=s.length())
		{
			int[] refArray=new int[26];
			int[] winArray=new int[26];
			for(int i=0;i<p.length();i++)
			{
				refArray[p.charAt(i)-'a']++;
			}
			int j=0;
			int start=0;int end=0;int match=0;
			while(start<s.length())
			{
				if(refArray[s.charAt(start)-'a']>0)
				{
					refArray[s.charAt(start)-'a']--;
					start++;
					match++;
				}
				else
				{
					refArray[s.charAt(end)-'a']++;
					end++;
					match--;
				}
				if(match==p.length())
				{
					output.add(end);
				}
			}
					
		}
		return output;
	}

	
	
//Solution 2
	
//Loop through the length of anagram String
	//add the character and occurance to a hashMap
//Declare 2 variables start and end and assign to zero and declare a count varaiable
//loop through the length of the input String using end
	//if the value is present in map, reduce the occurance of the value in map and increment the count value
	//increment the end value
	
	//if the count is equal to length of size of anagram string
	//add the start to output array
	//if the element in start, is in the map then increase the occurance of the start by 1
	//increment the start value
	
//return the output array	

private List<Integer> findStartOfAnangram(String s,String p)
{
	List<Integer> output=new ArrayList<>();
	char[] anagramArray=p.toCharArray();
	char[] inputArray=s.toCharArray();
	if(anagramArray.length<inputArray.length)
	{
		Map<Character,Integer> refMap=new HashMap<Character,Integer>();
		for(char i:anagramArray)
		{
			refMap.put(i, refMap.getOrDefault(i, 0)+1);
		}
		int start=0;int end=0;int count=0;
		while(end<inputArray.length)
		{
			if(refMap.containsKey(inputArray[end]) &&refMap.get(inputArray[end])>0 )
			{
				refMap.put(inputArray[end], refMap.get(inputArray[end])-1);
				count++;
				end++;
			}
			else
			{
				end++;
			}
			if(count==end-start)
			{
				//output.add
			}
		}
		
		
	}
	return output;
}

	
}
