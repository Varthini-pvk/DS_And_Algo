package Learnings;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

//2 arrays, can have duplicates, find the intersection of both arrays(only unique values)
public class L008_InterSectionOfTwoArrays 
{
	
	@Test
	public void dataSetOne()
	{
		int[] arrayOne= {1,2,4};
		int[] arrayTwo= {5,6,7};
		intersection(arrayOne,arrayTwo);
	}
	@Test
	public void dataSetTwo()
	{
		int[] arrayOne= {1,2,4};
		int[] arrayTwo= {1,3,5};
		intersection(arrayOne,arrayTwo);
	}
	@Test
	public void dataSetThree()
	{
		int[] arrayOne= {1,2,4,4};
		int[] arrayTwo= {4,5};
		intersection(arrayOne,arrayTwo);
	}
	
	@Test
	public void dataSetFour()
	{
		int[] arrayOne= {1,2,4,4};
		int[] arrayTwo= {4,2,2};
		intersection(arrayOne,arrayTwo);
	}
	
	//Add first array to a set
	//Add second array to same set and if add returns false, add that element to result set
	
	private void intersection1(int[] arrayOne,int[] arrayTwo)
	{
		Set<Integer> refSet=new HashSet<Integer>();
		Set<Integer> result=new HashSet<Integer>();
		
		for(int i=0;i<arrayOne.length;i++)
		{
			refSet.add(arrayOne[i]);
		}
		for(int i=0;i<arrayTwo.length;i++)
		{
			if(!refSet.add(arrayTwo[i])) result.add(arrayTwo[i]);
		}
		System.out.println(result);
		
	}
	
	//Sort Two Arrays
	//Declare Two Pointer one and two = zero, to traverse array one and two
	//if the element at pointer one is less than the element at pointer Two, increment pointer one
	//if the element at pointer one is equal to the element at pointer Two, 
	//add the element to result and increment pointer one and two
	//else increment pointer two
	//Continue till length of smallest Array
	
	private void intersection(int[] arrayOne,int[] arrayTwo)
	{
		Arrays.sort(arrayOne);
		Arrays.sort(arrayTwo);
		Set<Integer> result=new HashSet<Integer>();
		int pointerOne=0;int pointerTwo=0;
		while(pointerOne<arrayOne.length&&pointerTwo<arrayTwo.length)
		{
			if(arrayOne[pointerOne]<arrayTwo[pointerTwo]) pointerOne++;
			else if(arrayOne[pointerOne]==arrayTwo[pointerTwo]) 
			{
			result.add(arrayOne[pointerOne]);
			pointerOne++;pointerTwo++;
			}
			else pointerTwo++;
		}
		System.out.println(result);
	}

}
