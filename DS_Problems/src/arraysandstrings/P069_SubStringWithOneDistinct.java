package arraysandstrings;

import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

public class P069_SubStringWithOneDistinct {
	

@Test
public  void dataSetOne()
{
	String input="aaaba";
	System.out.println(countSubString(input));
	//System.out.println(OutputCount);
}

@Test
public  void dataSetTwo()
{
	String input="aaaaaaaaaa";
	System.out.println(countSubString(input));
	//System.out.println(OutputCount);
}


//Loop till the length of array and for each value of i,
//find the possible substrings using backtracking 
//
//Recursive Function
//
//1. if the length of the current list is equal to current required value
//	increment the output count
//	
//	else 
//	add the next element to current list, 
//	if the element is same as the last element in the list
//		or if the list is empty
//		
//After the end of the function remove the last element
//	
	
static int   OutputCount=0;
//Solution 1	
private void countSubString1(String input)
{
	char[] inputArray=input.toCharArray();
	for(int i=1;i<=inputArray.length;i++)
	{
	findSubStrings(i, inputArray, 0, new LinkedList<>());
	}
	
}
	
private void findSubStrings(int length, char[] array, int start, List<Character> current)
{
	
	if(current.size()==length)
	{
		OutputCount++;
		System.out.println(current);
		return;
	}
	for(int i=start;i<array.length;i++)
	{
		
		if((current.isEmpty())||current.get(current.size()-1)==array[i])
		{
		current.add(array[i]);
		findSubStrings(length,array,i+1, current);
		current.clear();
		}
		else
		{
			break;
		}
		
	}
}
//Solution 2
public int  countSubString(String input)
{
	int count=1;
	int outputCount=1;
	for(int i=1;i<input.length();i++)
	{
		if(input.charAt(i)!=input.charAt(i-1))
			count=1;
		else
		{
			count++;
		}
		outputCount+=count;
	}
	return outputCount;
}
	

}
