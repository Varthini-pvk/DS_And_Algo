package Learnings;

import org.junit.Test;

public class L010_formPalindrome 
{
	//Loop through the string 
	//add the mark the occurance in a array
	//if the occurance is 1, decrement it to zero
	//else increment to 1
	
	//Loop through the array
	//Count the occurences=1
	//if the string length is even and count is even return true
	//if the string length is odd and count is odd return true

	@Test
	public void dataSetOne()
	{
		String input="abby";
		System.out.println(formPalindrome(input));
	}
	
	@Test
	public void dataSetTwo()
	{
		String input="abb";
		System.out.println(formPalindrome(input));
	}
	
	
	@Test
	public void dataSetThree()
	{
		String input="abbse";
		System.out.println(formPalindrome(input));
	}
	
	public Boolean formPalindrome(String s)
	{
		int[] refArray=new int[26];
		for(int i=0;i<s.length();i++)
		{
			if(refArray[s.charAt(i)-'a']>0)
				refArray[s.charAt(i)-'a']--;
			else
				refArray[s.charAt(i)-'a']++;
		}
		int count=0;
		for(int i=0;i<refArray.length;i++)
		{
			if(refArray[i]==1)
				count++;
		}
		
		if(s.length()%2==0&&count==2||(s.length()%2!=0&&count==1))
			return true;
		return false;
	}
}
