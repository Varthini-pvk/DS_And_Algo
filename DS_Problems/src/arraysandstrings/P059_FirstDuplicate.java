package arraysandstrings;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

//Write a function to print the first duplicate number in the array
//Example: [4,1,2,9,1]
//Output: 1




public class P059_FirstDuplicate {
	
	@Test
	public void dataSetOne()
	{
		int[] input= {4,1,2,9,1};
		System.out.println("One "+findFirstDuplicate(input));
		
	}
	
	@Test
	public void dataSetTwo()
	{
		int[] input= {4,1,2,9,13};
		System.out.println("Two "+findFirstDuplicate(input));
		
	}
	
	@Test
	public void dataSetThree()
	{
		int[] input= {4,1,2,9,2,1,9};
		System.out.println("Three "+findFirstDuplicate(input));
		
	}
	
	
	
	//Solution 1
	//Loop through the array
	//Add the elements to a set
	//if the add returns false, return that element

	private int findFirstDuplicate(int[] array)
	{
		Set<Integer> refSet=new HashSet<>();
		for(int i=0;i<array.length;i++)
		{
			if(!refSet.add(array[i]))
			return array[i];
			
		}
		throw new RuntimeException ("No Duplicates");
	}
	
	
	//Solution 2
	//Add the elements to map(Linked hash Map) with its occurance
	//if the already contains, return the fi
	

}
