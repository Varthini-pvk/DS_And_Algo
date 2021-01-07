package Learnings;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

//1. Given aInteger Array (positive), there is one number which is duplicate
//find that duplicate number

public class L009_FindTheSingleDuplicate 
{

	@Test
	public void dataSetOne() 
	{
		int[] array= {1, 3,5,8,9,9,10,9};
		System.out.println(findTheDuplicate(array));
		
	}
	
	

	@Test
	public void dataSetTwo() 
	{
		int[] array= {8,9,7,6,8};
		System.out.println(findTheDuplicate(array));
		
	}
	
	//Solution 1
	//Add the numbers to set
	//When add returns false, return the number
	
	private int findTheDuplicate1(int[] input)
	{
		Set<Integer> refSet=new HashSet<Integer>();
		for(int i=0;i<input.length;i++)
		{
			if(!refSet.add(input[i])) return input[i];
		}
	throw new RuntimeException("no match");
	}
	
	//Solution 2
	//Sort the array
	//Loop through array and find the difference between adjacent elements
	//if diff=0, return the element
	
	private int findTheDuplicate(int[] input)
	{
		Arrays.sort(input);
		for(int i=0;i<input.length-1;i++)
		{
			if(input[i]-input[i+1]==0) return input[i];
		}
		throw new RuntimeException("no match");
	}
}
