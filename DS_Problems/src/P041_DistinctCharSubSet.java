import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

//Given a string s , find the length of the longest substring t  that contains at most 2 distinct characters.
//
//Example 1:
//
//Input: "eceba"
//Output: 3
//Explanation: t is "ece" which its length is 3.
//Example 2:
//
//Input: "ccaabbb"
//Output: 5
//Explanation: t is "aabbb" which its length is 5.

public class P041_DistinctCharSubSet {
	
	
@Test
public void dataSetOne()
{
	String input="ccaabbb";
	System.out.println("One: "+findSubString(input));
}

@Test
public void dataSetTwo()
{
	String input="ccccccc";
	System.out.println("Two: "+findSubString(input));
}

@Test
public void dataSetThree()
{
	String input="eceba";
	System.out.println("Three: "+findSubString(input));
}

@Test
public void dataSetFour()
{
	String input="aaaaaaebcccccc";
	System.out.println("Four: "+findSubString(input));
}

@Test
public void dataSetFive()
{
	String input="abcdefghij";
	System.out.println("Five: "+findSubString(input));
}

//Solution 1
private int findSubString(String input)
{
	Map<Character,Integer> ref=new HashMap<>();
	char[] array=input.toCharArray();
	int i=0;int maxLength=0;int start=0;int prevStart=0;
	while (i<array.length)
	{
		while(ref.size()<=2&&i<array.length)
		{
		ref.put(array[i], ref.getOrDefault(array[i], 0)+1);
		i++;
		}
		
		if(i==array.length)
		maxLength=Math.max(maxLength, i-start);	
		else
		maxLength=Math.max(maxLength, i-start-1);
		
		while(start<array.length&&ref.size()>2)
		{
			ref.put(array[start], ref.get(array[start])-1);
			if(ref.get(array[start])==0)
			ref.remove(array[start]);
			start++;
		}
	}
	return maxLength;
			
}

}
