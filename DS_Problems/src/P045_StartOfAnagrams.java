import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

	
	private List<Integer> findStartOfAnangram(String s,String p)
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

}
