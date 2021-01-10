package Learnings;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import org.junit.Test;

//
//Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', 
//determine if the input string is valid.
public class L_012_Braces
{

	@Test
	public void dataSetOne()
	{
		String input="(())";
		System.out.println("One:"+verifyBraces(input));
	}
	
	@Test
	public void dataSetTwo()
	{
		String input="({})";
		System.out.println("two: "+verifyBraces(input));
	}
	
	@Test
	public void dataSetThree()
	{
		String input="({})[";
		System.out.println("Three :"+verifyBraces(input));
	}
	
	@Test
	public void dataSetFour()
	{
		String input="]({})[";
		System.out.println("Four: "+verifyBraces(input));
	}
	@Test
	public void dataSetFive()
	{
		String input="[({})";
		System.out.println("Five: "+verifyBraces(input));
	}
	
	@Test
	public void dataSetSix()
	{
		String input="[({})";
		System.out.println("Five: "+verifyBraces(input));
	}
	
	
	
	// add the brace pairs to Map
	//Declare a stack 
	//Loop through the string and add the character to stack, if it is not available in map
	//else
	//pop from stack and check if it is the value of the character in Map
	//else return false
	//After the  loop if the stack is not empty return false
	//Else return true
	private Boolean verifyBraces(String input)
	{
		Map<Character,Character> refMap=new HashMap<Character,Character>();
		refMap.put(')','(');
		refMap.put('}','{');
		refMap.put(']','[');
		Character temp=' ';
		Stack<Character> refStack=new Stack<Character>();
		for(int i=0;i<input.length();i++)
		{
			temp=input.charAt(i);
			if(!refMap.containsKey(temp))
				refStack.push(temp);
			else			
				if(refStack.isEmpty()||refStack.pop()!=refMap.get(temp))
				return false;	
		}
		if(refStack.isEmpty())
			return true;
		else
			return false;
	}
}
