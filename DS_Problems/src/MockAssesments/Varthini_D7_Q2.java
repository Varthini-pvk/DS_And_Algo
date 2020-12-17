package MockAssesments;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

//Find the most Frequent Element in the Array

public class Varthini_D7_Q2 {

	
	@Test
	public void dataSetOne()
	{
		int[] array= {4,5,2,1,5,4,2,1,0,1}	;
		findMostFrequent(array);
		
	}
	
	@Test
	public void dataSetTwo()
	{
		int[] array= {1,2,3,4,2,3,4};	
		findMostFrequent(array);
	}
	
	//Solution 1(BruteForce)
	//Loop Through The length of array
		//For each element count its occurrence in a variable
		//If the occurrence is maximum store that in max value and add the element to result set
		//When the max value changes, clear the result set
	//Print the result set
	
	//Solution 2(Using HashMap)
	//Declare a hash map 
	//Loop Through the Length of the array
	// For each element add the element as key and its occurence as value in the map
	//Get the values of the map in collection and sort it
	//Print the keys with the value which is maximum
	
	
	private void findMostFrequent(int[] input)
	
	{
		int max=0;
		Map<Integer,Integer> refMap=new HashMap<>();
		for(int i=0;i<input.length;i++)
		{
			refMap.put(input[i], refMap.getOrDefault(input[i], 0)+1);
			max=Math.max(refMap.get(input[i]),max);
		}
		System.out.println("Max Value: "+max);
		
		for(Map.Entry<Integer, Integer> eachEntry:refMap.entrySet())
		{
			if(eachEntry.getValue()==max) System.out.println(eachEntry.getKey());
		}
	}
	
}
