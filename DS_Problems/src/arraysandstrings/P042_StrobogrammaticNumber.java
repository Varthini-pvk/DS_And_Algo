package arraysandstrings;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

//2) A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).
//
//Write a function to determine if a number is strobogrammatic. The number is represented as a string.
//
//Example 1:
//
//Input: num = "69"
//Output: true
//Example 2:
//
//Input: num = "88"
//Output: true

public class P042_StrobogrammaticNumber 
{
	@Test
	public void dataSetOne()
	{
		int input=69;
		System.out.println("One: "+checkIfStrobogrammatic(input));
	}
	
	@Test
	public void dataSetTwo()
	{
		int input=6119;
		checkIfStrobogrammatic(input);
		System.out.println("Two: "+checkIfStrobogrammatic(input));
	}
	
	@Test
	public void dataSetThree()
	{
		int input=6809;
		checkIfStrobogrammatic(input);
		System.out.println("Three: "+checkIfStrobogrammatic(input));
	}
	
	@Test
	public void dataSetFour()
	{
		int input=1601091;
		checkIfStrobogrammatic(input);
		System.out.println("Four: "+checkIfStrobogrammatic(input));
	}
	
	private Boolean checkIfStrobogrammatic(int input)
	{
		Map<Character,Character> refMap=new HashMap<>();
		refMap.put('6','9');
		refMap.put('9','6');
		refMap.put('8','8');
		refMap.put('1','1');
		refMap.put('0','0');
		
		char[] temp=String.valueOf(input).toCharArray();
		int j = temp.length-1;int i=0;
		while(i<j)
		{
	
			if(!(refMap.containsKey(temp[j])&&temp[i]==refMap.get(temp[j])))
			return false;
			i++;j--;
		}
		if(i==j)
		{
			
			if(!(refMap.containsKey(temp[j])&&temp[i]==refMap.get(temp[j])))
			return false;
		}
		return true;
		
	}

}
