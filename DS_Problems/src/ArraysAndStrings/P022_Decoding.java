package ArraysAndStrings;

import java.util.Arrays;
import java.util.Stack;

import org.junit.Test;

public class P022_Decoding 
{
	//	
	//	Given an encoded string, return its decoded string.
	//
	//			Input: s = "3[a]2[bc]"
	//			Output: "aaabcbc"
	//
	//			Input: s = "3[a2[c]]"
	//			Output: "accaccacc"
	//	
//	@Test
//	public void dataSetOne()
//	{
//		String input="3[a]2[bc]";
//		
//		System.out.println(decode(input));
//	}
	@Test
	public void dataSetTwo()
	{
		String input="3[a2[c]]";
		System.out.println(decode(input));
	}
//	@Test
//	public void dataSetThree()
//	{
//		String input="3[a2[c3[fff]]]";
//		System.out.println(decode(input));
//	}

	//Solution 1

	public String decode(String input)
	{
		String output="";String local="";
		Stack<Character> check=new Stack<>();
		
		if(input==null)
		{
			return "";
		}
		String current="";char pop;
		for(char i:input.toCharArray())
		{
			check.push(i);
		}
		
		while(!check.isEmpty())
		{
			pop=check.pop();
			while((pop!='['))
			{
				
				if(pop!=']')
				{
					current=pop+current;
				}
				pop=check.pop();
				
			}
			pop=check.pop();
			if(Character.isDigit(pop))
			{
				int frequency=Integer.parseInt(String.valueOf(pop));
				while(frequency>0)
				{
					local=local+current;
					frequency--;
				}
			}
			output=local+output;
			
			if(!check.isEmpty())
				pop=check.pop();
			if(pop==']')
			current="";
			else
			{
				current=pop+local;
				local="";
			}
		}
	
		return output;
	}
	//Solution 2
	
	

}
