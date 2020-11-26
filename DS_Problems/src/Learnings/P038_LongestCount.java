package Learnings;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.junit.Test;

public class P038_LongestCount {
	
	
	//bbbbbbaaaaaafffff
	@Test
	public void dataSetOne()
	{
		String input="malayalammadam";
		System.out.println("One:"+findPlaindromeCount(input));
	}
	@Test
	public void dataSetTwo()
	{
		String input="effeeee";
		System.out.println("Two:"+findPlaindromeCount(input));
	}
	@Test
	public void dataSetThree()
	{
		String input="ababaab";
		System.out.println("Three:"+findPlaindromeCount(input));
	}
	
	@Test
	public void dataSetFour()
	{
		String input="unique";
		System.out.println("Four:"+findPlaindromeCount(input));
	}
	
	
	@Test
	public void dataSetFive()
	{
		String input="bbbbbbaaaaaaafffff";
		System.out.println("Five:"+findPlaindromeCount(input));
	}
	
	private int findPlaindromeCount(String input)
	{
		Map<Character,Integer>count=new HashMap<>();
		for(int i=0;i<input.length();i++)
		{
			count.put(input.charAt(i), count.getOrDefault(input.charAt(i), 0)+1);
		}
		int maxOdd=0;int maxLength=0;
		for (Character i : count.keySet())
		{
			Integer current = count.get(i);
			if(current%2==0)
			{
				maxLength=maxLength+current;
			}
			else
			{
				if(maxOdd<current)
				{
					maxOdd=current;
				}
			}
		}
		maxLength=maxLength+maxOdd;
		return maxLength;
		
	}

}
